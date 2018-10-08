package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.robin.awm.util.FakeUtil;

@Controller
@RequestMapping("/faker")
public class FakerController {

    @Autowired
    FakeUtil fakeUtil;

    @GetMapping("/create")
    public void create() {
        fakeUtil.createCustomers(10);
    }
}
