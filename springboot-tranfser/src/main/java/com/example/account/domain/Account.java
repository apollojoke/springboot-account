package com.example.account.domain;

import lombok.Data;

/**
 * @Author: liuweif
 * @Date: 2019/4/4 9:42
 * @version: v
 */
@Data
public class Account {
    private Integer id;
    private String name;
    private String accountId;
    private Double remaining;

}
