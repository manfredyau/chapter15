package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.FormatPojo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/convert")
public class ConvertController {
    @RequestMapping("/format")
    public ModelAndView format(
            @RequestParam("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
            @RequestParam("amount1") @NumberFormat(pattern = "#,###.0000") Double amount1
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("date", date1);
        mav.addObject("amount", amount1);
        return mav;
    }

    @RequestMapping("/formatPojo")
    public ModelAndView formatPojo(FormatPojo pojo) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("date", pojo.getDate1());
        mv.addObject("amount", pojo.getAmount1());
        return mv;
    }
}
