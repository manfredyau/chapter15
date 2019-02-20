package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.pojo.RoleParams;
import com.ssm.chapter14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/params")
public class ParamsController {
    @Autowired
    RoleService roleService;

    @RequestMapping("commonParams")
    public ModelAndView commonParams(String roleName, String note) {
        System.err.println("roleName => " + roleName);
        System.err.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/commonParamPojo")
    public ModelAndView commonParamPojo(RoleParams roleParams) {
        System.err.println("roleName => " + roleParams.getRoleName());
        System.err.println("note => " + roleParams.getNote());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/requestParam")
    public ModelAndView requestParam(@RequestParam("role_name") String roleName, String note) {
        System.err.println("roleName => " + roleName);
        System.err.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/getRole/{id}")
    public ModelAndView pathVariable(@PathVariable("id") Long id) {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/findRoles")
    public ModelAndView findRoles(@RequestBody RoleParams roleParams) {
        List<Role> roleList = roleService.findRoles(roleParams);
        ModelAndView mv = new ModelAndView();
        mv.addObject(roleList);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/deleteRoles")
    public ModelAndView deleteRoles(@RequestBody Long[] ids) {
        ModelAndView mv = new ModelAndView();
        List<Long> ts = Arrays.asList(ids);
        int total = roleService.deleteRoles(ts);
        mv.addObject("total", total);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/addRoles")
    public ModelAndView addRoles(@RequestBody List<Role> roleList) {
        ModelAndView mv = new ModelAndView();
        int total = roleService.insertRoles(roleList);
        mv.addObject("total", total);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/commonParamPojo2")
    public ModelAndView commonParamPojo2(@RequestParam("role_name") String roleName, String note) {
        System.err.println("roleName => " + roleName);
        System.err.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/showRoleJsonInfo")
    public ModelAndView showRoleJsonInfo(Long id, String roleName, String note) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("id", id);
        mv.addObject("roleName", roleName);
        mv.addObject("note", note);
        return mv;
    }

    @RequestMapping("/addRole")
    public String addRole(Model model,  String roleName, String note) {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);

        roleService.insertRole(role);

        model.addAttribute("roleName", roleName);
        model.addAttribute("note", note);
        model.addAttribute("id", role.getId());
        return "redirect:/params/showRoleJsonInfo.do";
    }

    @RequestMapping("/addRole2")
    public ModelAndView addRole2(ModelAndView mv, @RequestParam("role_name") String roleName, String note) {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);

        roleService.insertRole(role);

        mv.addObject("roleName", roleName);
        mv.addObject("note", note);
        mv.addObject("id", role.getId());
        mv.setViewName("redirect:./showRoleJsonInfo.do");
        return mv;
    }

    @RequestMapping("/showRoleJsonInfo2")
    public ModelAndView showRoleJsonInfo(Role role) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("role", role);
        return mv;
    }

    @RequestMapping("/addRole3")
    public String addRole3(RedirectAttributes redirectAttributes, Role role) {
        roleService.insertRole(role);
        redirectAttributes.addFlashAttribute("role", role);
        return "redirect:./showRoleJsonInfo2.do";
    }
}
