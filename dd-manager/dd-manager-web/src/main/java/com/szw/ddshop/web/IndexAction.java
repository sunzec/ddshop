package com.szw.ddshop.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
public class IndexAction {

    /**
     * 登录到主页面
     *
     * @return
     */
    @RequestMapping(value = "/")
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String toItemAdd(@PathVariable("page") String page) {
        return page;
    }
}
