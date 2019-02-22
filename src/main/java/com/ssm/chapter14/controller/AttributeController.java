package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/attribute")
@SessionAttributes(names = {"id"}, types = {Role.class})
public class AttributeController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/requestAttribute")
    public ModelAndView reqAttr(@RequestAttribute("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/sessionAttributes")
    public ModelAndView sessionAttributes(Long id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject("role", role);
        mv.addObject("id", id);
        mv.setViewName("sessionAttribute");
        return mv;
    }

    @RequestMapping("/sessionAttribute")
    public ModelAndView sessionAttribute(@SessionAttribute("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/getHeaderAndCookie")
    public String testHeaderAndCookie(@RequestHeader(value = "User-Agent", required = false, defaultValue = "attribute") String userAgent,
                                      @CookieValue(value = "JSESSIONID", defaultValue = "MyJsessionId") String jsessionId) {
        System.err.println("User-Agent: " + userAgent);
        System.err.println("JSESSIONID: " + jsessionId);
        return "index";
    }

}
