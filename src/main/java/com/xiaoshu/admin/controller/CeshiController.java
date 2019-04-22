package com.xiaoshu.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者: liuzhiting
 * 日期: 2019/4/11 16:11
 * 功能:
 */

@Controller

@RequestMapping("zhishi")
public class CeshiController {
    @RequestMapping("ceshi")
    public String ceshi() {

        System.out.println("sfdfsdfs");

        return "admin/ceshi/index";


    }
}
