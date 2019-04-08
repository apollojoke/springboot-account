package com.example.account;

import com.example.account.domain.Account;
import com.example.account.mapper.IAccountMapper;
import com.example.account.service.impl.TransferServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTranfserApplicationTests {

    @Autowired
    private IAccountMapper accountMapper;
    @Autowired
    private TransferServiceImpl transferService;
//    @Autowired
//    private Account account;

    @Test
    public void contextLoads() {
        System.out.println(accountMapper.find(1));
       // System.out.println(accountMapper.update(account));
    }

//    public void trans(){
//        Integer fromId = 2;
//        Integer toId = 1;
//        Double money = 200d;
//        String result = transferService.transfer(fromAccountId,toId,money);
//
//    }

}
