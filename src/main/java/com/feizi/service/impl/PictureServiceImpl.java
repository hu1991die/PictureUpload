package com.feizi.service.impl;

import com.feizi.dao.PictureDao;
import com.feizi.domain.Picture;
import com.feizi.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 图片上传Service服务接口实现类
 * Created by feizi on 2017/6/18.
 */
@Service
public class PictureServiceImpl implements PictureService{

    @Autowired
    private PictureDao pictureDao;

    @Override
    public void insertPictrue(Picture picture) {
        pictureDao.insertPicture(picture);
    }

    @Override
    public Picture findPicturebyId(Integer id) {
        return pictureDao.findPicturebyId(id);
    }
}
