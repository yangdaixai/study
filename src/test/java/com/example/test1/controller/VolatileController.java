package com.example.test1.controller;

import com.example.test1.bean.VolatileBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-02-23-5:40 PM
 */
@RestController

public class VolatileController {

    @Autowired
    VolatileBean volatileBean;

/*    @GetMapping("/test")
    public String  test() {
        return "get test success!";
    }*/


    @GetMapping("/test")
    public boolean  test() {
        return volatileBean.IsSendMessageByOa();
    }

    @PostMapping("/set/{isSendMessageByOa}")
    public void test1(@RequestParam boolean isSendMessageByOa) throws InterruptedException {
        System.out.println("isSendMessageByOa-- 设置值："+isSendMessageByOa);
        System.out.println("isSendMessageByOa--睡眠之前: "+ volatileBean.IsSendMessageByOa());
        volatileBean.setIsSendMessageByOa(isSendMessageByOa);

        TimeUnit.SECONDS.sleep(30);
        System.out.println("isSendMessageByOa--睡眠之后: "+ volatileBean.IsSendMessageByOa());

    }

    @PostMapping("/set/{isSendMessageByOa2}")
    public void test2(@RequestParam boolean isSendMessageByOa) throws InterruptedException {
        System.out.println("isSendMessageByOa2-- 设置值："+isSendMessageByOa);
        System.out.println("isSendMessageByOa2--设置之前: "+ volatileBean.IsSendMessageByOa());
        volatileBean.setIsSendMessageByOa(isSendMessageByOa);
        //TimeUnit.SECONDS.sleep(30);
        System.out.println("isSendMessageByOa2--设置之后: "+ volatileBean.IsSendMessageByOa());
    }



}
