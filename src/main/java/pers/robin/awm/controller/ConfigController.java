package pers.robin.awm.controller;

import com.github.javafaker.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Config;
import pers.robin.awm.service.ConfigService;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @GetMapping("/get")
    public ResultBean<String> get(@RequestParam("key") String key) {
        return new ResultBean<String>(configService.get(key));
    }

    @PostMapping("/add")
    public ResultBean<Boolean> add(@RequestBody Config config) {
        return new ResultBean<>(configService.add(config));
    }

    @PostMapping("/update")
    public ResultBean<Boolean> update(@RequestBody Config config) {
        return new ResultBean<>(configService.update(config));
    }

    @GetMapping("/delete")
    public ResultBean<Boolean> delete(@RequestParam("key") String key) {
        return new ResultBean<>(configService.delete(key));
    }
}
