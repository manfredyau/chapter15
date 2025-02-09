package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.Transaction;
import com.ssm.chapter14.validator.TransactionValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/validate")
public class ValidateController {
    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new TransactionValidator());
    }

    @RequestMapping("/annotation")
    public ModelAndView annotationValidate(@Valid Transaction trans, Errors errors) {
        if (errors.hasErrors()) {
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList) {
                System.err.println("field: " + error.getField() + "\tmsg: " + error.getDefaultMessage());
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/validator")
    public ModelAndView validator(@Valid Transaction transaction, Errors errors) {
        if (errors.hasErrors()) {
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList) {
                System.err.println("field: " + error.getField() + "\t" + "msg: " + error.getDefaultMessage());
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
