package com.example.test1.repository;

import com.example.test1.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-01-19-3:01 PM
 */
@SpringBootTest
class AccountMapperTest {

    @Autowired
    AccountMapper accountRepository;
    @Test
    void save() {

      Account account =  Account.builder()
                .passWord("123")
                .userName("rrr")
                .age(30)
                .build();
       int result = accountRepository.save(account);
        System.out.println("result:"+result);
    }

    @Test
    void findAll() {
        List<Account> accountList = accountRepository.findAll();
        System.out.println("accountList:" + accountList);

    }



    @Test
    void findByUserName() {
      Account account =   accountRepository.findByUserName("rrr");
        System.out.println("account:" + account);
    }
}