package com.servlet3.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/hello/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file") MultipartFile file, RedirectAttributes flash) throws IOException {

        if (!file.isEmpty()) {
            FileCopyUtils.copy(file.getBytes(), new File(file.getOriginalFilename() + ".pdf"));
        } else {
            flash.addFlashAttribute("error", "Error: the file is empty");
        }
        return "redirect:/hello";
    }
}
