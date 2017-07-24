package com.feizi.controller;

import com.feizi.domain.dto.PictureDTO;
import com.feizi.service.PictureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> savePicture(@RequestBody PictureDTO pictureDTO){
        String result = "上传成功...";
        if(null == pictureDTO ||
                null == pictureDTO.getImgArr() ||
                pictureDTO.getImgArr().size() == 0){
            result = "请选择上传的图片...";
        }

//        LOGGER.info("上传的图片数据为pictureDTO: " + JSON.toJSONString(pictureDTO));

        try {
            pictureService.savePicture(pictureDTO);
        } catch (Exception e) {
            result = "上传失败...";
            LOGGER.error(e.getMessage());
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", result);
        return resultMap;
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
