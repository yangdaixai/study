package com.example.test1.test;

import com.example.test1.model.Account;
import com.example.test1.repository.AccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

/**
 * @author yangshengwei_zidie
 * @description 从dataphin-oa迁移过来的代码
 * @date 2022-01-18-8:58 PM
 */
@SpringBootTest
public class Test2 {

    @Test
    public void test() {
        InputStream inputStream =
                Test2.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =  sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(); //获取实现接⼝口的代理理对象
        AccountMapper accountRepository =
                sqlSession.getMapper(AccountMapper.class); //添加对象
// // //
        Account account = new Account(3L, "王五", "111111", 24);
        int result = accountRepository.save(account);
        sqlSession.commit();
//查询全部对象
   /*     List<Account> list = accountRepository.findAll();
        for (Account account : list) {
            System.out.println(account);
            sqlSession.close(); //通过id查询对象
            Account account = accountRepository.findById(3L);
            System.out.println(account);
            sqlSession.close();*/
//修改对象
/*            Account account = accountRepository.findById(3L);
            account.setUsername("⼩小明");
            account.setPassword("000");
            account.setAge(18);
            int result = accountRepository.update(account);
            sqlSession.commit();
            System.out.println(result);
            sqlSession.close();*/
//通过id删除对象
/*            int result = accountRepository.deleteById(3L);
            System.out.println(result);
            sqlSession.commit();
            sqlSession.close();*/

        }

}
