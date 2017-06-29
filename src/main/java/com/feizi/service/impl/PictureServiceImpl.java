package com.feizi.service.impl;

import com.feizi.dao.PictureDao;
import com.feizi.domain.Picture;
import com.feizi.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

/**
 * 图片上传Service服务接口实现类
 * Created by feizi on 2017/6/18.
 */
@Service
public class PictureServiceImpl implements PictureService{

    private static final Logger LOGGER = LoggerFactory.getLogger(PictureServiceImpl.class);

    //图片上传路径
    @Value("${img.save.path}")
    private String imgSavePath;

    //图片保存格式
    @Value("${img.format.type}")
    private String imgFormatType;

    @Autowired
    private PictureDao pictureDao;

    @Override
    public void savePicture(String imgData, String picDetails, String picTypes) {
        //构造文件名
        String imgName = UUID.randomUUID() + "." + imgFormatType;
        //文件上传成功之后的保存路径
        String imgPath = uploadFile(imgData, imgName);

        Picture picture = new Picture();
        picture.setUserId("");
        picture.setPicDetails(picDetails);
        picture.setPicName(imgName);
        picture.setPicType(picTypes);
        picture.setCreateTime(new Date());
        picture.setPicUrl(imgPath);
        pictureDao.insertPicture(picture);

        LOGGER.info("图片上传路径imgPath：" + imgPath);
    }

    @Override
    public Picture findPicturebyId(Integer id) {
        return pictureDao.findPicturebyId(id);
    }

    /**
     * 上传图片文件操作
     * @param imgData 图片数据
     * @param imgName 图片名称
     * @return 图片上传路径
     */
    private String uploadFile(String imgData, String imgName){
        //文件上传的路径
//        String imgPath = imgSavePath + File.separator + imgName;
        String imgPath = Paths.get(imgSavePath, imgName).toString();
        File file = new File(imgPath);
        if(!file.getParentFile().exists()){
            file.mkdirs();
        }

        //使用BASE64Decoder对图片文件数据进行解码操作
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //通过Base64解码，将图片数据解密成字节数组
            byte[] bytes = decoder.decodeBuffer(imgData);

            //构造字节数组输入流
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

            //读取输入流的数据
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);

            //将数据信息写入图片文件中,不管输出什么格式图片，此处不需改动
            ImageIO.write(bufferedImage, imgFormatType, file);

            //关闭流
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgPath;
    }
}
