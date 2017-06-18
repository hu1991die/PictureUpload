package com.feizi.service;

import com.feizi.domain.Picture;

/**
 * 图片上传Service服务接口
 * Created by feizi on 2017/6/18.
 */
public interface PictureService {

    /**
     * 保存上传图片信息
     * @param picture
     */
    void insertPictrue(Picture picture);

    /**
     * 根据id查询图片信息
     * @param id
     * @return
     */
    Picture findPicturebyId(Integer id);
}
