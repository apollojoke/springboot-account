package com.example.account.service.impl;


import com.example.account.mapper.IAccountMapper;
import com.example.account.domain.Account;
import com.example.account.service.ITransfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: liuweif
 * @Date: 2019/4/3 10:25
 * @version: v
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TransferServiceImpl  implements ITransfService {
    /**
     * 转账操作
     *
     * @param fromAccountId
     * @param toAccountId
     * @param money
     * @return 转账结果
     */
    @Autowired
    private IAccountMapper iAccountMapper;


    @Override

    public String transfer(String fromAccountId,String toAccountId,Double money){


        /**
         * 验证账户
         */
       Account toAccount = iAccountMapper.findByAccountId(toAccountId);
        if(toAccount == null) {
            return "转入账户" + toAccountId + "不存在！";

        }

        /**
         * 验证余额
         */
        Account fromAccount = iAccountMapper.findByAccountId(fromAccountId);
        if(fromAccount.getRemaining()<money){
            return "账户"+fromAccountId+"余额不足";
        }
        /**
         * 更新账户
         */

        fromAccount.setRemaining(fromAccount.getRemaining()-money);
        iAccountMapper.update(fromAccount);
        toAccount.setRemaining(toAccount.getRemaining()+money);
        iAccountMapper.update(toAccount);

            return "转账成功!\n"  +"   转出账户： " + fromAccountId + "\n" + "  转入账户: " + toAccountId + "\n" + "金额： " +money;

    }

    @Override
    /**
     * 充值
     */
    public String recharge(String accountId,@RequestParam("money") Double money) {
        Account account = iAccountMapper.findByAccountId(accountId);
        if(account == null) {
            return "充值账户" + accountId + "不存在！";

        }

        account.setRemaining(account.getRemaining() + money );
        iAccountMapper.update(account);
        return "充值成功!\n"  +"   充值账户： " + accountId + "\n"+ "充入金额： " +money;
    }

}
