package com.feizi.domain.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 图片上传数据DTO
 * Created by feizi on 2017/7/23.
 */
public class PictureDTO implements Serializable {
    private static final long serialVersionUID = 9152201451053763861L;
    //图片数据列表
    private List<ImgDTO> imgArr;
    //图片上传描述信息
    private String picDetails;
    //图片分类信息
    private String picTypes;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<ImgDTO> getImgArr() {
        return imgArr;
    }

    public void setImgArr(List<ImgDTO> imgArr) {
        this.imgArr = imgArr;
    }

    public String getPicDetails() {
        return picDetails;
    }

    public void setPicDetails(String picDetails) {
        this.picDetails = picDetails;
    }

    public String getPicTypes() {
        return picTypes;
    }

    public void setPicTypes(String picTypes) {
        this.picTypes = picTypes;
    }
}
