package pers.robin.awm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pers.robin.awm.bean.ResultBean;

@RestController
public class CommonController {

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultBean unauthorized() {
        ResultBean<String> resultBean = new ResultBean<String>();
        resultBean.setMsg("unlogin");
        resultBean.setCode(ResultBean.NO_LOGIN);
        return resultBean;
    }
}
