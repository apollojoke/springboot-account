package com.example.account.controller;

import com.example.account.service.impl.TransferServiceImpl;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 转账controller层
 *
 * @Author: liuweif
 * @Date: 2019/4/4 10:55
 * @version: v
 */
@Controller
public class TransferController {
    @Autowired
    private TransferServiceImpl transferService;

    /**
     * 首页
     * @return
     */
    @GetMapping("/index")
    public String index() {

        return "index";
    }
    @GetMapping("/recharge")
    public String recharge() {

        return "recharge";
    }

    /**
     * 转账返回
     * @param fromAccountId
     * @param toAccountId
     * @param money
     * @return
     */
    @RequestMapping("/transfer")
    @ResponseBody
    public String doTransfer(@RequestParam("fromAccountId") String fromAccountId,@RequestParam("toAccountId") String toAccountId,@RequestParam("money") double money) {
        if (this.checkParams(new String[]{fromAccountId, toAccountId})) {
            if (money > 0) {
                String result = transferService.transfer(fromAccountId, toAccountId, money);
                return result;

            } else {
                return "转账失败，金额必须大于0";
            }
        }else {
            return "账户不能为空！";
        }


    }
//    @ExceptionHandler({Exception.class})
//    public String processException(Exception exception){
//        return "failure";
//    }

    /**
     * 验证参数
     *
     * @param params
     * @return
     */
    private boolean checkParams(String[] params){
        for(String param:params){
          if(param ==""||param==null||param.isEmpty()){
            return false;
        }
    }
    return true;
  }

    /**
     * 充值
     *
     * @param accountId
     * @param money
     * @return
     */

    @RequestMapping("/rechar")
    @ResponseBody
    public String doCharge(@RequestParam("accountId") String accountId,@RequestParam("money") double money){
        if (this.checkParams(new String[]{(accountId)})) {
            if (money > 0) {
                String result = transferService.recharge(accountId, money);
                return result;

            } else {
                return "充值失败，金额必须大于0";
            }
        }else {
            return "账户不能为空！";
        }
    }

}
