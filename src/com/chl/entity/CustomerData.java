package com.chl.entity;

import java.util.ArrayList;
import java.util.List;

//使用单例模式，保证数据的唯一性，把客户初始化了
public class CustomerData {
    private static CustomerData ourInstance = new CustomerData();
    private List<Customer> customerList; //提取List<Customer>变量作为成员变量 加Git Set变量

    public static CustomerData getInstance() {
        return ourInstance;
    }

    private CustomerData() {
        //在构造中 初始化数据 需要写循环把customer拿出来
        customerList = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            //每循环一次，诞生一个customer 对象， 放入到集合当中
            //new一个customer对象
            Customer customer = new Customer();
            customer.setAccount("5201314"+i);
            customer.setPassword("123");
            customer.setCname("小陈"+i+"号");
            customer.setMoney(10000);
            customer.setPhoneNum("12303332"+i);
            customerList.add(customer);   //存到List集合中进行封装

        }
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

