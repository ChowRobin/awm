package pers.robin.awm.filter;

import org.springframework.beans.factory.annotation.Autowired;
import pers.robin.awm.bean.JWTToken;
import pers.robin.awm.model.User;
import pers.robin.awm.service.UserService;
import pers.robin.awm.util.CommonUtil;
import pers.robin.awm.util.JWTUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "userFilter", urlPatterns = {"/customer/*", "/shop/*"})
public class UserFilter implements Filter {

    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        System.out.println("cpath is " + req.getServletPath());
        String[] paths = req.getServletPath().split("/");
        String path = null, role = null;
//        for (String p : paths) {
//            System.out.println(p);
//        }
        if (paths.length > 1) {
            role = paths[1];
        }
        if (paths.length > 2) {
            path = paths[2];
        }
        System.out.println("path is " + path);
        // 是否为登录，注册请求
        if ("login".equals(path) || "register".equals(path)) {
            System.out.println("login or register");
        } else if (CommonUtil.isNumeric(path)) {
            System.out.println("req is select");
        } else {
            auth(req, res);
        }
        filterChain.doFilter(req, res);
    }

    private void auth(HttpServletRequest req, HttpServletResponse res) {
        String token = req.getHeader("Authorization");
        if (token == null) {
            responseError("401", req, res);
        } else if (!checkToken(new JWTToken(token))) {
            responseError("500", req, res);
        }
    }

    private boolean checkToken(JWTToken jwt) {
        String token = (String) jwt.getCredentials();

        String tel = JWTUtil.getTel(token);
        User user = userService.findByTel(tel);
        if (tel == null || user == null || !JWTUtil.verify(token, tel, user.getPassword())) {
            System.out.println("check failed");
            return false;
        }
        return true;
    }

    /**
     * 将非法请求跳转到 /
     */
    private void responseError(String code, ServletRequest req, ServletResponse resp) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.sendRedirect("/" + code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
