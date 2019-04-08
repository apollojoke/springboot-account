package com.example.account.mapper;

import com.example.account.domain.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 账户查询封装接口
 *
 * @Author: liuweif
 * @Date: 2019/4/4 9:56
 * @version: v
 */
@Mapper
public interface IAccountMapper {
    /**
     * id查找
     * @param id
     * @return
     */
    Account find(int id);

    /**
     * 账户查找
     *
     * @param accountId
     * @return
     */
    Account findByAccountId(String accountId);

    /**
     * 更新账户
     *
     * @param account
     * @return
     */
    int update(Account account);
}
