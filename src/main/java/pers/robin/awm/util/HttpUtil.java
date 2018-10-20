package pers.robin.awm.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {

    /**
     * 获取客户端真实IP地址。需考虑客户端是代理上网
     * @param request
     * @return 客户端真实IP地址
     */
    public static String getClientIp(HttpServletRequest request){
        if(StringUtils.isEmpty(request.getHeader("x-forwarded-for"))) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    /**
     *  获取服务器地址  Http://localhost:8080/  类似
     * @param request
     * @return
     */
    public static String serverBasePath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
