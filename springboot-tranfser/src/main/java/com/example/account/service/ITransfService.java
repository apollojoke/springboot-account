package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.mapper.IAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 转账接口
 *
 * @Author: liuweif
 * @Date: 2019/4/3 11:22
 * @version: v
 */
public interface ITransfService {
    /**
     * 转账
     *
     * @param fromAccountId
     * @param toAccountId
     * @param money
     * @return
     */
    String transfer(String fromAccountId,String toAccountId,Double money);

    /**
     * 充值
     *
     * @param accountId
     * @param money
     * @return
     */
    String recharge(String accountId,Double money);
}
