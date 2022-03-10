package com.xiaobai.swagger.controller;

import com.xiaobai.swagger.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaobai
 * @create 2021-05-06 15:14
 */
@Controller
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/async")
    @ResponseBody
    public String async(){
        asyncService.hello();
        return "success";
    }

}
