package com.example.test1.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangshengwei_zidie
 * @description
 * @date 2022-04-21-10:11 PM
 */
@RestController
@Slf4j
public class TestController {


    @GetMapping("/test")
    public String test(){
        log.info("=========get test success!========");
        log.error("======error=============");
        log.debug("========debug==========");
        try {
           int i = 1/0;
        } catch (Exception e) {
            log.info(" 异常信息e:{}", e);
            log.info(" 异常信息getMessage:{}", e.getMessage());
            log.info("======info=============");
            log.info(" 异常信息getStackTrace:{}", e.getStackTrace());
            log.info("======info=============");
            log.info(" 异常信息toString:{}", e.toString());
        }

        return "=========get test success!========";
    }

    @PostMapping("/notifyAsyncOrSyncTest4")
    public String notifyAsyncOrSyncTest4(
            @RequestBody List<String> notifyAsyncOrSyncInfo) {
        return "1111";
    }
    public static void main(String[] args) {
        List<String> receivers  = new ArrayList<>();
        receivers.add( "2222");
        receivers.add( "3333");


        System.out.println( new Gson().toJson(receivers));
    }

}
