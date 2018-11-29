package me.bestsamcn.blog.services;

import me.bestsamcn.blog.enums.PictureType;
import me.bestsamcn.blog.models.Picture;
import me.bestsamcn.blog.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Sam
 * @Date: 2018/11/29 21:38
 */
public interface PictureService extends BaseService<Picture>{

    /**
     * 上传
      * @param articleId
     * @param files
     * @param pictureType
     * @return
     */
    public Response upload(String articleId, MultipartFile[] files, PictureType pictureType);

    /**
     * 下载
     * @param id
     * @return
     * @throws Exception
     */
    public ResponseEntity<byte[]> getById(String id) throws Exception;
}
