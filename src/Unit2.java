import java.util.Scanner;

import static java.lang.String.format;

public class Unit2 {

    //下面这个函数注意，虽然我们说对象是传递引用的，但是String不一样，因为他一旦定义了就不能变了，所以类似传值引用，得需要返回一个String才行，
    //这里返回的orgStr实际上和入参的orgStr已经不是一个对象了，和Person不一样。
    //所有的内置的基本类型，比如Integer、Double都是不可变的对象类型，因此用起来就当和传值一样的。这叫：不可变对象（immutable）
    public static String strReplace(String orgStr,String replaceSrc,String replaceTo){
        int i = orgStr.indexOf(replaceSrc);
        if (i != -1)
        {
            orgStr = orgStr.substring(0,i) + replaceTo +
                    orgStr.substring(i + replaceSrc.length());
        }
        return orgStr;
    }

    public static double CycleArea(double r){
            return Math.PI * Math.pow(r , 2);
    }

    public void doClass() {
        Person xiaonuan1 = new Person("小暖", 15, 120, "女");
        Person xiaonuan2 = new Person("小暖", 15, 120, "女");
        Person xiaonuan3 = xiaonuan1;

        //step1 toString函数
        System.out.println(xiaonuan1);

        //step2 equals函数，返回true false
        System.out.println(xiaonuan1 == xiaonuan2);
        System.out.println(xiaonuan1.equals(xiaonuan2));

        //step3 compareTo函数，返回-1 0 1 ，不能用==，否则128以上出错。多种赋值方法
        Integer i1 = 7;
        Integer i2 = Integer.valueOf(7);
        i2 = i1;
        i2 = i1.intValue();//等价于取值

        System.out.println(i2.compareTo(i1));

        //Step4 注意！ Integer的equals和String的不一样，值相等就认为是相等的
        System.out.println(i2.equals(i1));

        //Step5,同样，Integer类，也重写了tostring，可以直接打印对象
        System.out.println(i2);

        //step6， Integer的max和min的静态只读变量
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    //step7 Math类的方法
    public void doMath() {

        //注意int的范围
        int value = 2147483647 + 1;
        System.out.println(value);

        //注意float和double的值的 == 比较会有问题，可以用大于小于，不要用等于判断
        double x = 1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1;
        System.out.println(x == 0.5);
        System.out.println(x);


        double a = 9;
        double b = -5;
        System.out.println(Math.pow(a, 2));
        System.out.println(Math.sqrt(a));
        System.out.println(Math.abs(b));

        //打印半径为a的圆面积，
        Scanner input = new Scanner(System.in);
        System.out.print("Please input radius of a cycle: ");
        double r = input.nextDouble();

        if (r > 0)
            System.out.println("The area of cycle with raidus is " + r + " is " + CycleArea(r));
        else
            System.out.println("The radius must > 0 !");
        //提问，如果算球的体积怎么算，做个算体积的函数


        //step8 非常重要！！ Random方法,生成0<= c1 <6.0
        double c1 = Math.random() * 6;

        //生成4.0<= c1 <6.0,跨度是多少，就乘以多少
        c1 = 4 + Math.random() * 2;

        // int 0<=int1<=9 返回int，跨度需要加1,注意强制转换前加括号
        int int1 = (int) (Math.random() * 10);

        //生成 10<= int1 <= 100
        int1 = 10 + (int) (Math.random() * 91);

    }


   //Step9 String,注意,字符串开始定义完，一样的都是一个对象，除非强行建新对象，后面修改后也会创建新对象
    public void doString() {
            String s1 = "hello";
            String s2 = new String("hello");
            String s3 = "hello";
            String s4 = s1;
            s1 = s1 + " world!";
            System.out.println(s4);

            //Step10 String的equals和Integer一样的，只要值一样，就是true
            System.out.println(s4.equals(s3));

            //Step11 String compareTo,顺序从小到大 0-9 A-Z a-z， 小是负数，大是正数，0是相等 ，打开wps，看一下全部的字符集
            //不是比String长度，就是比出现的字母顺序
            //AB和ABC，被包含的小
            s1 = "012313";
            s2 = "A";
            System.out.println(s1.compareTo(s2));

            //Step 11 indexOf, 从左开始，从0开始
            //Length,是从1开始，空字符串是0，A是1，标点和空格也算
            s1 = "hello, World!";
            System.out.println(s1.length());
            System.out.println(s1.indexOf('W'));
            System.out.println(s1.indexOf("lo"));
            System.out.println(s1.indexOf("llo"));
            System.out.println(s1.indexOf("lol"));

            //Step 12 ,substring,两个overload的方法；
            //注意!!! 第二个的end字符是不包含的，开始是闭区间，结束是开区间
            System.out.println(s1.substring(7));
            System.out.println(s1.substring(7, 9));
            System.out.println(s1.substring(3, 4));
            System.out.println(s1.substring(3, 3));//返回空
            //System.out.println(s1.substring(3,2));//报错
            System.out.println(s1.substring(3, 12));
            System.out.println(s1.substring(3, 13));//end大1是可以的
            //System.out.println(s1.substring(3,14));//end大2是报错的

            //Step 13 ,写一个函数，做字符串替换，把指定字符串替换成另外一个字符串，Love变成hate
            s1 = "I Love you！";
            s2 = "Love";
            s3 = "hate";

            System.out.println(s1);
            System.out.println(strReplace(s1, s2, s3));

            //Step 13 ,unit3学完while后，写一个函数 把多个i love you 变成 i hate you
            s1 = "I Love you！ I Love you！！ I Love you！！！";

        }

}
