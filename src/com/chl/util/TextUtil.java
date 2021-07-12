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

    //客户的一级选择
    public static void oneLeveOption(){
        System.out.println("*******************************");
        System.out.println("*****请输入您想要的操作类型********");
        System.out.println("*****1、余额查询    2、取款*******");
        System.out.println("*****3、转账    4、存款**********");
        System.out.println("*****5、退卡    ****************");
        System.out.println("*******************************");
    }

    //static 方法带有 static关键字的方法是静态方法，可以直接 类名.方法名()调用
    public static void getMoneyUI(){
        System.out.println("*******************************");
        System.out.println("*****请输入您想取款的项目：********");
        System.out.println("*****1、100      2、200*********");
        System.out.println("*****3、300      4、500*********");
        System.out.println("*****5、800      6、1000********");
        System.out.println("*****7、2000     8、其他*********");
        System.out.println("********************************");
    }
}
