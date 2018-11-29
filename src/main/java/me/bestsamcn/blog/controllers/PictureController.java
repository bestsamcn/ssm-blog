package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.enums.PictureType;
import me.bestsamcn.blog.services.PictureService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Sam
 * @Date: 2018/11/29 22:31
 */
@Controller("pictureController")
@RequestMapping(name="图片", value="/picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    /**
     * 上传
     * @return
     */
    @PostMapping(name="上传", value="upload")
    @ResponseBody
    public Response upload(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam(name="articleId", required = false) String articleId,
            @RequestParam(name="pictureType",required=false, defaultValue = "ALL") PictureType pictureType){
        return pictureService.upload(articleId, files, pictureType);
    }

    /**
     * 下载
     * @return
     */
    @GetMapping(name="下载", value="download/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> download(@PathVariable("id") String id) throws Exception{
        return pictureService.getById(id);
    }

}
