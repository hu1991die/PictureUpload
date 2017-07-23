package com.feizi.domain.dto;

import java.io.Serializable;

/**
 * 图片数据DTO类
 * Created by feizi on 2017/7/23.
 */
public class ImgDTO implements Serializable {

    private static final long serialVersionUID = -5471412221232523615L;
    //图片压缩数据
    private String imgData;
    //图片上传名称
    private String imgName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getImgData() {
        return imgData;
    }

    public void setImgData(String imgData) {
        this.imgData = imgData;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
