package me.bestsamcn.blog.services.impl;

import me.bestsamcn.blog.dao.PictureMapper;
import me.bestsamcn.blog.enums.PictureType;
import me.bestsamcn.blog.models.Picture;
import me.bestsamcn.blog.services.PictureService;
import me.bestsamcn.blog.utils.Response;
import me.bestsamcn.blog.utils.Tools;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/11/29 21:41
 */
@Service("pictureService")
public class PictureServiceImpl extends BaseServiceImpl<Picture> implements PictureService {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    PictureMapper pictureMapper;

    @Override
    @Transactional
    public Response upload(String articleId, MultipartFile[] files, PictureType pictureType) {

        //不能使用/resouces/picture，因为编译后无resource文件夹
        String dir = httpServletRequest.getServletContext().getRealPath("/pictures/");
        List<String> ids = new ArrayList<String>();
        if(files.length == 0){
            return Response.error("图片不存在");
        }
        if(!Tools.isId(articleId)){
            return Response.error("无此数据");
        }
        try {
            for(MultipartFile file: files){
                String id = Tools.getUUID();
                long size = file.getSize();
                String originName = file.getOriginalFilename();
                String suffix = file.getContentType();
                String path = dir+id+".png";
                File _file = new File(path);
                if(!_file.getParentFile().exists()){
                    _file.getParentFile().mkdir();
                }
                file.transferTo(_file);
                int row = this.add(id, articleId, originName, suffix, path, size, pictureType.getKey());
                if(row != 1){
                    return Response.error("上传失败");
                }
                ids.add(id);
            }
            return Response.build(ids);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error();
        }
    }

    /**
     * 插入数据库
     * @return
     */
    private int add(String id, String articleId, String originName, String suffix, String path, long size, int type){
        Picture picture = new Picture();
        picture.setId(id);
        picture.setArticleId(articleId);
        picture.setOriginName(originName);
        picture.setSuffix(suffix);
        picture.setPath(path);
        picture.setSize(size);
        picture.setType(type);
        picture.setName(id);
        picture.setCreateTime(Tools.getTimestamp());
        return this.getMapper().insert(picture);
    }


    @Override
    public ResponseEntity<byte[]> getById(String id) throws Exception{
        String dir = httpServletRequest.getServletContext().getRealPath("/pictures/");
        File file = new File(dir+id+".png");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", id);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
    }

    @Override
    protected PictureMapper getMapper() {
        return pictureMapper;
    }
}
