package com.example.test1.repository;

import com.example.test1.model.User;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-01-19-2:16 PM
 */

@SpringBootTest

public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void sel() throws Exception {
    //    User user = userMapper.Sel(12);

        User user = userMapper.selectUserById(13);
        System.out.println("user=:"+user);

    }

    @Test
    public void update() {
        User user = userMapper.Sel(12);
        System.out.println("user=:"+user);
        user.setUserName("杨圣伟");
        user.setPassWord("qwer@123");
        user.setRealName("管理员");
        int result = userMapper.update(user);
        System.out.println("result:"+result);
    }
 @Test
 public void  updateMapTest() {

     List<User> userList = userMapper.findAll();
     userList.forEach(u->{
         u.setUserName(u.getUserName()+"1128");
         u.setPassWord(u.getPassWord()+2228);
         u.setRealName(u.getRealName()+3328);
     });
     Map<Integer, User> userMap = userList.stream().collect(Collectors.toMap(u->u.getId(),u->u));
     System.out.println("userMap:"+userMap);
    int result = userMapper.updateMap(userMap);
    System.out.println("result:"+result);

    }

    @Test
    public void save() {
        User user = User.builder()
                .userName("pppp")
                .passWord("fff")
                .realName("vvv")
                .build();
        //返回1插入成功
        int  result = userMapper.save(user);
        System.out.println("result=:"+result);
    }

    @Test
    public void deleteBuyId() {
        int result = userMapper.deleteById(12);
        System.out.println("result:"+ result);
    }

    @Test
    public void findByNameAndPassWord(){
        User user = userMapper.findByNameAndPassWord("pppp","fff");
        System.out.println("user:"+user);
    }

    @Test
    public void findAll() {
        List<User> userList = userMapper.findAll();
        System.out.println("userList:"+ userList);

    }
}