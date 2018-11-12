package me.bestsamcn.blog.controllers;

import me.bestsamcn.blog.services.LogitService;
import me.bestsamcn.blog.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Sam
 * @Date: 2018/11/13 0:08
 */
@Controller("logitController")
@RequestMapping(name="日志模块", value="/logit")
public class LogitController {

    @Autowired
    LogitService logitService;

    @GetMapping(name="分页", value="getList")
    @ResponseBody
    public Response getList(@RequestParam(name="pageIndex", defaultValue = "1") int pageIndex,
                            @RequestParam(name="pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(name="keyword", required = false, defaultValue = "") String keyword,
                            @RequestParam(name="type", required = false, defaultValue = "10") Integer type){
        Response res = logitService.getList(pageIndex, pageSize, type, keyword);
        return res;
    }
}
