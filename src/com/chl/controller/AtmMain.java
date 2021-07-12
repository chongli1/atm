package com.chl.controller;

//自动导包
import com.chl.entity.Customer;
import com.chl.entity.CustomerData;
import com.chl.util.TextUtil;

import java.util.List;
import java.util.Scanner;

/**
 * atm 取款机入口 是入口就要有main方法
 * 主界面
 * 程序步骤：1、AtmMain  2、Customer实体类  3、CustomerData  4、CustomerService
 */
public class AtmMain {

    private static String cardid;
    private static String cardPwd;

    public static void main(String[] args) {
        //测试 客户类 的数据  //作业1、对Manager管理类做出 单例模式，并测试是否 数据初始化了
        CustomerData customerDate = CustomerData.getInstance(); //调用CustomerData中的getInstance()
        List<Customer> customerList = customerDate.getCustomerList(); //拿到CustomerData中这10个数据
//        for (Customer customer : customerList) {
//           System.out.println("customer = " + customer); //通过遍历测试一下是否拿到了10个数据
//       }
        //欢迎界面 为 一个阶段
        TextUtil.welcome(); //文本信息提取类，把欢迎界面提取到了TextUtil类中了

        int i = 0;
        while (i < 6){
            //输入账户密码 一个阶段 练习：如果超过5次 就终止程序（跳出循环）
            doWritePassword();
            //其他操作 为 一个阶段 (这些阶段为面向过程,会不停的重复所以 需要进行封装）
            //1、校验角色  2、判断账户密码的正确性
            doCheckPassword(cardid,cardPwd); //通过判断cardid的长度和密码看是客户还是管理员
            i++;
        }



    }
    //判断角色 和 判断密码
    private static void doCheckPassword(String cardid,String cardPwd) {
        //1、先校检角色，判断 cardid 的长度
        if (cardid.length()==8) { //密码为8，为客户
            //校验密码

        }
    }

    //输入账户名
    private static void doWritePassword() {
        System.out.println("请输入卡号");
        Scanner scanner = new Scanner(System.in);
//        String cardid = scanner.nextLine(); //提取局部变量变为成员变量
        cardid = scanner.nextLine();
        System.out.println("cardid = " + cardid);
        System.out.println("请输入密码");
//        String cardPwd = scanner.nextLine(); //提取局部变量变为成员变量
        cardPwd = scanner.nextLine();
        System.out.println("cardPwd = " + cardPwd);
    }

}

