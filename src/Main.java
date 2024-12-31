import Animal.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        Unit8 unit = new Unit8();
//        unit.do2dArray3();


        //Person p = new Person;
        //p.method1(); 不能调用protected的方法


//        StopWatch sw = new StopWatch();
//        sw.start();
//        unit.doArray();
//
//        sw.stop();
//        sw.printElapsedTime();

        Unit5 unit = new Unit5();


//          Unit5 unit2 = new Unit5();
          //System.out.println(Unit5);34
//          Unit5 unit1 = new Unit5();
//          System.out.println(Unit5.attrPublicStatic);
//        Unit5 unit = new Unit5(213);//谁是Class定义 ,谁是instance？？
//        unit.attrPublic = 101;
//        Unit5.attrPublicStatic = 123;
//        Unit5.miniClass.miniMethod();
//        unit.attrPublicStatic = 1222;
//        System.out.println(unit.attrPublicStatic);
//        unit.method_public(5);//它会怎么打印？
//        int a = unit.method_public(7) + 4;//a等于多少？

        //Unit5 unit2;// 注意：当你声明一个对象引用但不对其进行初始化（即没有使用 new 创建实例或赋值为已有对象），它的默认值是 null。
    }

    //基础练习第一课，搭建Java环境，安装IDE，Github，然后练习写如下代码
    public static void function(){//这块先不用管为什么这么写，就这么写
        System.out.println("hello world!"); //基础输出语句，以逗号为一句的结束

        System.out.print("hello world!");System.out.println("hello world!"); //可以两行写在一起，但是必须用分号分隔，否则报错
                                                                             //注意第一句是print，第二句是println，这两个一个是
                                                                             //不带回车，一个是带回车。
        System.out.println(1 + 2 + 3);  //也可以直接输出计算结果 ，这是加法 （注意格式，操作符前后一般加空格，看的清晰一些）
        System.out.println(10 - (2 + 9));  //这是减法，带括号的
        System.out.println(2 * 2 * 3.1415926); //输出半径为2的圆面积，这是乘法
        System.out.println((14 / 45.30) / 1.6); //这是除法

        System.out.println("Rectangle Area = " + 4.5 * 7.9); //也可以让字符和数字一起输出，用+号连起来，注意字符要在前面，后面的数字会转换成字符
        System.out.println("Rectangle Perimeter = " + (4.5 + 7.9) * 2);

    }


}