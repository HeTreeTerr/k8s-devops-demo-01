package com.hss.controller;

import com.alibaba.fastjson.JSON;
import com.hss.config.MyConfig;
import com.hss.utils.ResultObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

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

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 欢迎页
     * @param param
     * @return
     */
    @GetMapping(value = "/index")
    public ResultObj index(@RequestParam(value = "param",required = false) String param){
        String data = "welcome to k8s devops boot demo; param=" + param;
        log.info("data={}",data);
        return ResultObj.successByData(data);
    }

    /**
     * 配置项读取
     * @return
     */
    @GetMapping(value = "/config")
    public ResultObj config(){
        Map<String,Object> configMap = JSON.parseObject(JSON.toJSONString(myConfig),Map.class);
        log.info("configMap={}",configMap);
        return ResultObj.successByData(configMap);
    }

    /**
     * 通讯验证
     * @return
     */
    @GetMapping(value = "/network")
    public ResultObj network(){
        String res = restTemplate.getForObject(myConfig.getHttpUrl(),String.class,Collections.EMPTY_MAP);
        log.info(res);
        return ResultObj.successByData(res);
    }
}
