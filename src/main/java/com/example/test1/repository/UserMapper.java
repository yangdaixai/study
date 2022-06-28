package com.example.test1.repository;

import com.example.test1.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper {

    User Sel(int id);

     int save(User user);
     int update(User user);
     //这使用@Param注解 html中就不要在使用parameterType指定传入参数类型，mybatis会自动推到参数类型
     int updateMap(@Param("userMap") Map<Integer,User> userMap);
   int deleteById(int id);
    User findByNameAndPassWord(String userName,String passWord);
     List<User> findAll();


    /* Account findById(long id);
     Account findByName(String name);
     Account findById2(Long id);
     Account findByNameAndAge(String name,int age);*/


    //根据 id 查询 user 表数据
    @Select("select * from user where id = #{id}")
    public User selectUserById(int id) throws Exception;
    
    //向 user 表插入一条数据
    @Insert("insert into user(username,sex,birthday,address) value(#{username},#{sex},#{birthday},#{address})")
    public void insertUser(User user) throws Exception;

    //根据 id 修改 user 表数据
    @Update("update user set username=#{username},sex=#{sex} where id=#{id}")
    public void updateUserById(User user) throws Exception;

    //根据 id 删除 user 表数据
    @Delete("delete from user where id=#{id}")
    public void deleteUserById(int id) throws Exception;
}
