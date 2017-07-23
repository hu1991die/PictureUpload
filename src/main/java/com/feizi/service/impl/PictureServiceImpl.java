package com.feizi.service.impl;

import com.feizi.dao.PictureDao;
import com.feizi.domain.Picture;
import com.feizi.domain.dto.ImgDTO;
import com.feizi.domain.dto.PictureDTO;
import com.feizi.service.PictureService;
import com.feizi.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
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

    @Resource
    private PictureDao pictureDao;

    @Override
    public void savePicture(PictureDTO pictureDTO) throws Exception{
        //图片上传描述信息
        String picDetails = pictureDTO.getPicDetails();
        //图片分类信息
        String picTypes = pictureDTO.getPicTypes();
        //图片数据列表
        List<ImgDTO> imgDTOList = pictureDTO.getImgArr();
        if(null != imgDTOList && imgDTOList.size() > 0){
            Picture picture;
            for (ImgDTO imgDTO : imgDTOList){
                //图片压缩数据
                String imgData = imgDTO.getImgData();
                //图片上传名称
                String imgName = imgDTO.getImgName();

                //文件上传成功之后的保存路径
                String imgPath = uploadFile(imgData, imgName);
                LOGGER.info("图片上传路径imgPath：" + imgPath);

                picture = new Picture();
                picture.setUserId("");
                picture.setPicDetails(picDetails);
                picture.setPicName(imgName);
                picture.setPicType(picTypes);
                picture.setCreateTime(new Date());
                picture.setPicUrl(imgPath);
                pictureDao.insertPicture(picture);
            }
        }
    }

    @Override
    public Picture findPicturebyId(Integer id) throws Exception{
        return pictureDao.findPicturebyId(id);
    }

    /**
     * 上传图片文件操作
     * @param imgData 图片数据
     * @param imgName 图片名称
     * @return 图片上传路径
     */
    private String uploadFile(String imgData, String imgName){
        //获取当前日期
        String currentDate = DateUtil.getCurrentDate();
        //构建文件上传的路径目录
        String directory = Paths.get(imgSavePath, currentDate).toString();
        File file = new File(directory);
        if(!file.getParentFile().exists()){
            file.mkdirs();
        }

        //拼接文件名，构建文件全路径
        String imgPath = Paths.get(directory, imgName).toString();
        file = new File(imgPath);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            ImageIO.write(bufferedImage, "jpg", file);

            //关闭流
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgPath;
    }

    public static void main(String[] args) {
        String currentDate = DateUtil.getCurrentDate();
        String directory = Paths.get("D:\\wwwroot\\CsQx\\NQApp\\ZQUPLOAD", currentDate).toString();
        System.out.println(directory);
        File file = new File(directory);
        if(!file.getParentFile().exists()){
            file.mkdirs();
        }

        String fileName = Paths.get(directory, "1.txt").toString();
        file = new File(fileName);
        System.out.println(file.getPath());
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
