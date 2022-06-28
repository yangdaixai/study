package com.example.test1.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-02-28-5:16 PM
 */
@Component

public class VolatileBean {
  private   AtomicBoolean isSendMessageByOa = new AtomicBoolean();

   public void setIsSendMessageByOa(boolean value) {
      this.isSendMessageByOa.set(value);
   }

   public boolean IsSendMessageByOa() {
      return isSendMessageByOa.get();
   }
}
