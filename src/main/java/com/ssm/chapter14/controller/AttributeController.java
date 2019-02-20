package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/attribute")
public class AttributeController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("requestAttribute")
    public ModelAndView reqAttr(@RequestAttribute("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}
