package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.PageParams;
import com.ssm.chapter14.pojo.RoleParams;
import com.ssm.chapter14.view.ExcelExportService;
import com.ssm.chapter14.view.ExcelView;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {
    // 注入角色服务类
    @Autowired
    private RoleService roleService = null;

    @RequestMapping(value = "/getRole", method = RequestMethod.GET)
    public ModelAndView getRole(@RequestParam("id") Long id) {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("roleDetails");
        // 给数据模型添加一个角色对象
        mv.addObject("role", role);
        return mv;
    }

    // 获取角色
    @RequestMapping(value = "/getRole2", method = RequestMethod.GET)
    public ModelAndView getRole2(@RequestParam("id") Long id) {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("roger", role);
        // 指定视图类型
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping(value = "/getRoleByModelMap", method = RequestMethod.GET)
    public ModelAndView getRoleByModelMap(@RequestParam("id") Long id, ModelMap modelMap) {
        System.err.println(modelMap.getClass());
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("roleDetails");
        modelMap.addAttribute("role", role);
        return mv;
    }

    @RequestMapping(value = "/getRoleByModel", method = RequestMethod.GET)
    public ModelAndView getRoleByModel(@RequestParam("id") Long id, Model model) {
        System.err.println(model.getClass());
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("roleDetails");
        model.addAttribute("role", role);
        return mv;
    }

    @RequestMapping(value = "/getRoleByMv", method = RequestMethod.GET)
    public ModelAndView getRoleByMv(@RequestParam("id") Long id, ModelAndView mv) {
        System.out.println(mv.getClass());
        Role role = roleService.getRole(id);
        mv.setViewName("roleDetails");
        mv.addObject("role", role);
        return mv;
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView export() {
        ModelAndView mav = new ModelAndView();
        ExcelView excelView = new ExcelView(exportService());
        excelView.setFileName("所有角色.xlsx");
        RoleParams roleParams = new RoleParams();
        PageParams pageParams = new PageParams();
        pageParams.setStart(0);
        pageParams.setLimit(10000);
        roleParams.setPageParams(pageParams);

        List<Role> roleList = roleService.findRoles(roleParams);

        mav.addObject("roleList", roleList);
        mav.setView(excelView);
        return mav;
    }


    /*-----------------------------------------   16-4   --------------------------------------------------*/
    @RequestMapping(value = "/getRoleToJson")
    @ResponseBody
    public Role getRoleToJson(Long id) {
        return roleService.getRole(id);
    }


    /*------------------------------------------   16-9  -----------------------------------------------------*/
    @RequestMapping("/updateRole")
    @ResponseBody
    public Map<String, Object> updateRole(Role role) {
        Map<String, Object> result = new HashMap<>();

        boolean updateFlag = (roleService.updateRole(role) == 1);
        result.put("success", updateFlag);
        result.put("msg", updateFlag ? "更新成功" : "更新失敗");
        return result;
    }

    @RequestMapping("/updateRoleList")
    @ResponseBody
    public Map<String, Object> updateRoleList(List<Role> roleList) {
        Map<String, Object> result = new HashMap<>();
        boolean updateFlag = (roleService.updateRoleArr(roleList) > 1);
        result.put("success", updateFlag);
        result.put("msg", updateFlag ? "更新成功" : "更新失敗");
        return result;
    }

    @SuppressWarnings({"unchecked"})
    private ExcelExportService exportService() {
        return (model, workBook) -> {
            List<Role> roleList = (List<Role>) model.get("roleList");
            Sheet sheet = workBook.createSheet("所有角色");
            Row title = sheet.createRow(0);
            title.createCell(0).setCellValue("編號");
            title.createCell(1).setCellValue("名稱");
            title.createCell(2).setCellValue("備註");

            for (int i = 0; i < roleList.size(); i++) {
                Role role = roleList.get(i);
                int rowIdx = i + 1;
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(role.getId());
                row.createCell(1).setCellValue(role.getRoleName());
                row.createCell(2).setCellValue(role.getNote());
            }
        };
    }
}