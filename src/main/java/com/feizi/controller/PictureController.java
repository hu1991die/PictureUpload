package com.feizi.controller;

import com.feizi.domain.Picture;
import com.feizi.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 图片上传Controller控制类
 * Created by feizi on 2017/6/18.
 */
@Controller
@RequestMapping("/api")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/picture/{id}", method = RequestMethod.GET)
    public Picture findPicturebyId(@PathVariable Integer id){
        return pictureService.findPicturebyId(id);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "id", required = true) Integer id){
        return "Hello World!" + id;
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public String test(@PathVariable Integer id){
        return "test demo" + id;
    }
}
