package com.chl.service;

import com.chl.entity.Customer;
import com.chl.entity.CustomerData;
import com.chl.util.TextUtil;

import java.util.List;
import java.util.Scanner;

//此类是 完成 客户的 所有业务（增删改查）
public class CustomerService {//因为无法与list做对比，所以要把list拿过来
//    CustomerData customerDate = CustomerData.getInstance(); //调用CustomerData中的getInstance()
//    List<Customer> customerList = customerDate.getCustomerList(); //拿到CustomerData中这10个数据
    private List<Customer> customerList; //初始化
    private Customer currentCustomer;
    //查，登录 判断账号密码是否正确
    public void checkPwd(String cardid,String cardPwd){
        CustomerData customerDate = CustomerData.getInstance(); //调用CustomerData中的getInstance()
        customerList = customerDate.getCustomerList(); //拿到CustomerData中这10个数据
        //1、拿到 cardid中的账户名 和 cardPwd 对 Customer中的list中的数据做对比 如果一样则正确
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                //拿出来customer这个人
                currentCustomer = customer;
                //账户正确
                System.out.println("欢迎"+customer.getCname()+"顾客登录！请注意您的安全");
                TextUtil.oneLeveOption();
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);
                //如何保证 1 2 3 4 5...让它回到此界面去？
            }
        }
    }

    private void oneOption(String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");
                //查询余额
                doSelectMoney();
                    //当按下1之后，回退到 1级选项
                goOneHome();
                break;
            case "2":
                goGetMoneyHome();
                goOneHome();

                break;
            case "3":
                System.out.println("转账");
                doTruanMoney();
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                doSaveMoney();
                goOneHome();
                break;
            case "5":
                doQuitCard();
                break;

        }
    }




    //退卡
    private void doQuitCard() {
        System.out.println("你是否继续操作yes/no[Y/N]");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("y")) {
            TextUtil.welcome();
        }

        if (s.equalsIgnoreCase("n")) {
            System.out.println("请取出您的信用卡");

        }
    }

    //存款
    private void doSaveMoney() {
        //1、有个提示界面
        System.out.println("请输入您想存入的金额");
        System.out.println("1.100    2.200    3.其他");
        Scanner sc = new Scanner(System.in);
        int cun = sc.nextInt();
        if (cun == 1) {
            double r = currentCustomer.getMoney() + 100;
            System.out.println("您的账户余额是" + r);
            currentCustomer.setMoney(r);
        } else if (cun == 2) {
            double r = currentCustomer.getMoney() + 200;
            System.out.println("您的账户余额是" + r);
            currentCustomer.setMoney(r);
        } else if (cun == 3) {
            System.out.println("请存入1000元及以上的整钱");
            double t = sc.nextDouble();
            if (t % 100 == 0) {
                if (t >= 1000) {
                    double r = currentCustomer.getMoney() + t;
                    System.out.println("您的账户余额是" + r);
                    currentCustomer.setMoney(r);
                } else {
                    System.out.println("您存入的钱小于1000");
                }
            } else {
                System.out.println("请存入整钱");
            }

        }else{
            System.out.println("请放入百元");
        }

    }


    //转账
    private void doTruanMoney(){
        System.out.println("请输入对方的转账号码：");
        Scanner scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("请输入你需要转账的金额：");
        String otherMoney = scanner.nextLine();
        //做计算  自己的钱 - otherMoney， 别人的钱 + otherMoney
        Double otherMoneyInt = Double.parseDouble(otherMoney);
        double currentMoney = currentCustomer.getMoney()-otherMoneyInt; //自己被 减去 转账后的钱
        //别人 加钱 ， 根据otherAccount 本人的账户查询出 别人的余额，查出别人的余额后，修改别人的余额
        //因为所有的人都在customerList 都在这个集合中， 那么遍历这个集合
        Customer other = null;
        for (Customer customer : customerList) {
            //如果 customer.getAccount(账户) 等于 otherAccount， 那么这个 人 就被选出来了
            if (customer.getAccount().equals(otherAccount)) {
                other=customer; //说明已经找到这个人了

            }

        }

        double otherOneMoney = other.getMoney() + otherMoneyInt; //别人的钱

        //自己和别人 都更新一下 钱数
        currentCustomer.setMoney(currentMoney);
        other.setMoney(otherOneMoney); //注意：有问题？没有更新到List集合中，只是更新到了Customer other = null 中
    }

    //查询余额
    private void doSelectMoney() {
        double money = currentCustomer.getMoney();
        System.out.println("余额"+money);

    }

    //返回一级目录
    private void goOneHome(){
        TextUtil.oneLeveOption(); //再次显示上面的界面，回退到上个版本
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option); //递归算法
    }

    //取款
    private void goGetMoneyHome(){
        TextUtil.getMoneyUI();
        //1、让客户输入
        Scanner scanner = new Scanner(System.in);
        String numIn = scanner.nextLine();
        if (numIn.equals("1")){
            //那么 取款100 那么就应该 让顾客的 钱 -100
            double money = currentCustomer.getMoney();
            money=money-100;
            System.out.println("您的余额是：" + money);
            //取完款项之后，更新 原有的 存款
            currentCustomer.setMoney(money);

        }

    }
}

