package com.ssm.chapter14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    public ModelAndView upload(HttpServletRequest request) {
        // 進行強轉
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;

        //獲得請求上傳的文件
        MultipartFile file = multipartHttpServletRequest.getFile("file");

        // 設定視圖為json視圖
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());

        // 獲取原始文件名
        String fileName = file.getOriginalFilename();

        // 目標文件
        File dest = new File(fileName);
        try {
            // 保存文件
            file.transferTo(dest);
            mav.addObject("success", true);
            mav.addObject("msg", "上傳文件成功");
        } catch (IllegalStateException | IOException e) {
            mav.addObject("success", false);
            mav.addObject("msg", "上傳文件失敗");
        }
        return mav;
    }

    @RequestMapping("/uploadMultipartFile")
    public ModelAndView uploadMultipartFile(MultipartFile file) {
        // 定義 JSON 視圖
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());

        // 獲取原始文件名
        String fileName = file.getOriginalFilename();
        file.getContentType();

        // 目標文件
        File dest = new File(fileName);

        try {
            // 保存文件
            file.transferTo(dest);
            mav.addObject("success", true);
            mav.addObject("msg", "文件上傳成功");
        } catch (IllegalStateException | IOException e) {
            mav.addObject("success", false);
            mav.addObject("msg", "文件上傳失敗");
        }
        return mav;
    }

    @RequestMapping("/uploadPart")
    public ModelAndView uploadPart(Part file) {
        ModelAndView mav = new ModelAndView();
        mav.setView(new MappingJackson2JsonView());

        String fileName = file.getSubmittedFileName();
        File dest = new File(fileName);
        try {
            file.write("e:/mvc/uploads/" + fileName);
            mav.addObject("success", true);
            mav.addObject("msg", "上傳文件成功");
        } catch (IllegalStateException | IOException e) {
            mav.addObject("success", false);
            mav.addObject("msg", "上傳文件失敗");
        }
        return mav;
    }
}
