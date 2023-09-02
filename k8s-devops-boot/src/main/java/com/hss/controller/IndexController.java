package com.hss.controller;

import com.hss.utils.ResultObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 主页 - Controller
 * </p>
 *
 * @author Hss
 * @date 2023-09-02
 */
@RestController
@Slf4j
public class IndexController {

    /**
     * 欢迎页
     * @param param
     * @return
     */
    @GetMapping(value = "/index")
    public ResultObj index(@RequestParam(value = "param",required = false) String param){
        String data = "welcome to k8s devops boot demo; param=" + param;
        log.info(data);
        return ResultObj.successByData(data);
    }
}
