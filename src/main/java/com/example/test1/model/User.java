package com.example.test1.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-01-19-2:09 PM
 */
/*CREATE TABLE `user` (
        `id` int(32) NOT NULL AUTO_INCREMENT,
        `userName` varchar(32) NOT NULL,
        `passWord` varchar(50) NOT NULL,
        `realName` varchar(32) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;*/
@Data
@Builder
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
}