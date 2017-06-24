package com.feizi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片实体类Model
 * Created by feizi on 2017/6/18.
 */
public class Picture implements Serializable{

    private static final long serialVersionUID = 747582275376849318L;
    //主键ID
    private Integer id;
    //用户id
    private String userId;
    //上传后的图片名称
    private String picName;
    //图片的分类类型
    private String picType;
    //图片上传路径
    private String picUrl;
    //图片的补充说明
    private String picDetails;
    //图片上传日期
    private Date createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicDetails() {
        return picDetails;
    }

    public void setPicDetails(String picDetails) {
        this.picDetails = picDetails;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
