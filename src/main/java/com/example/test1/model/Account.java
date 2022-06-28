package com.example.test1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-01-18-8:46 PM
 */
/*CREATE TABLE `account` (
        `id` BIGINT NOT NULL AUTO_INCREMENT,
        `user_name` varchar(32) NOT NULL,
        `pass_word` varchar(50) NOT NULL,
        `age` INT DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private long id;
    private String userName;
    private String passWord;
    private int age;
}
