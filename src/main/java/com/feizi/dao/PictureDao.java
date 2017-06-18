package com.feizi.dao;

import com.feizi.domain.Picture;

/**
 * 上传图片Dao接口类
 * Created by feizi on 2017/6/18.
 */
public interface PictureDao {

    /**
     * 保存上传图片信息到数据库中
     * @param picture
     */
    void insertPicture(Picture picture);

    /**
     * 根据id查询图片信息
     * @param id 图片ID
     * @return
     */
    Picture findPicturebyId(Integer id);
}
