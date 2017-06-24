package com.feizi.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.feizi.domain.Picture;
import com.feizi.service.PictureService;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 图片上传Controller控制类
 * Created by feizi on 2017/6/18.
 */
@Controller
public class PictureController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/picture/upload", method = RequestMethod.POST)
    public Map savePicture(@RequestParam("imgData") String imgData,
                           @RequestParam("picDetails") String picDetails,
                           @RequestParam("picTypes") String picTypes){
        Map<String, Object> map = new HashMap<>();
        if(null == imgData){
            map.put("msg", "文件为空...");
        }

        LOGGER.info("===========上传的图片编码流：" + imgData);
        pictureService.savePicture(imgData, picDetails, picTypes);

        map.put("msg", "上传成功...");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "id", required = true) Integer id){
        return "Hello World!" + id;
    }

    @ResponseBody
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public String test(@PathVariable Integer id){
        return "test demo" + id;
    }
}
