package com.chl.util;

/**
 * 文本信息的工具类
 * 以后修改文本信息，直接去修改这里就可以了
 * 工具类是静态的，所以要用static 静态修饰方法
 * 见到写死的东西就用文本信息提取类给提取出来
 */
public class TextUtil {
    //welcome的界面
    //static 修饰方法，1、可以直接被 类名.方法() 调用 2、在内存中只有1份，其他修改，他会跟着自动修改
    //还有，关于static静态 代码块，它一般适用于 界面场景的提前加载，如 王者荣耀中 峡谷的轮廓永远优先英雄出现

    /**
     * static{
     *     //这就叫做 静态代码块
     * }
     */
    public static void welcome(){
        System.out.println("*********************");
        System.out.println("先生/女士");
        System.out.println("欢迎使用ATM取款机");
        System.out.println("*********************");
    }
}
