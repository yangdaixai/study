package com.example.test1.repository;

import com.example.test1.model.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-01-18-8:53 PM
 */
@Repository
public interface AccountMapper {
    public int save(Account account);
//    public int update(Account account);
 //   public int deleteById(long id);
    public List<Account> findAll();
    public Account findById(long id);
    Account findByUserName( String userName);





}
