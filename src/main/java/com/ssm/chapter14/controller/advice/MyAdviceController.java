package com.ssm.chapter14.controller.advice;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/advice")
public class MyAdviceController {

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> testAdvice(
            Date date,
            @NumberFormat BigDecimal amount,
            Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("project_name", model.asMap().get("projectName"));
        map.put("date", DateUtils.format(date, "dd/MM/yyyy"));
        map.put("amount", amount);
        return map;
    }

    @RequestMapping("/exception")
    public void exception() {
        throw new RuntimeException();
    }
}
