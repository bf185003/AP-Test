import java.util.Scanner;

import static java.lang.String.format;

//学习String方法、Math的方法
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

        //Step4 注意！ Integer的equals和Person类的不一样，Integer值相等就认为是相等的，Person哪怕值相等也不是相等的。
        //String等内置类也是同样特性
        System.out.println(i2.equals(i1));

        //注意，Integer类不能用 == 进行值判断，128以下是对的，因为他们共用了一个内存对象，但是大于128，Java就给它建立了一个新对象
        //大于128这个时候 == 就判断不对了，判断两个Integer大小只能用equals。
        System.out.println(i2 == i1);

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
        //为什么下面x 会等于 0.50000000000001呢？因为0.1在计算机中是用两个分数相加模拟的。
        //但是 x = 1.0 - 0.25 - 0.5则没有问题，因为0.25和0.5都能用分数完全用二进制表示
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

    //补充Math的一些函数介绍，增加round、floor、ceil的函数的介绍
    public static void doMath2(){
        //round是四舍五入的函数
        long a;
        double b;
        a = Math.round(1.0);    //1
        a = Math.round(1.4);    //1
        a = Math.round(1.5);    //2
        a = Math.round(1.6);    //2

        a = Math.round(-1.0);    //-1
        a = Math.round(-1.4);    //-1
        a = Math.round(-1.5);    //-1   注意这里！！！，其实round函数是 + 0.5后，再向下取整，这个加完后是-1.0
        a = Math.round(-1.6);    //-2

        //floor是向下取整函数，注意负数的方向也是往下
        //另外注意，floor返回的double类型
        b = Math.floor(1.0);    // == 1.0
        b = Math.floor(1.4);    // == 1.0
        b = Math.floor(1.5);    // == 1.0
        b = Math.floor(1.6);    // == 1.0
        b = Math.floor(-1.0);   // == -1.0
        b = Math.floor(-1.4);   // == -2.0
        b = Math.floor(-1.5);   // == -2.0
        b = Math.floor(-1.6);   // == -2.0

        //ceil是向上取整，也要注意负数的方向
        //返回的是double值
        b = Math.ceil(1.0);     // == 1.0
        b = Math.ceil(1.4);     // == 2.0
        b = Math.ceil(1.5);     // == 2.0
        b = Math.ceil(1.6);     // == 2.0
        b = Math.ceil(-1.0);    // == -1.0
        b = Math.ceil(-1.4);    // == -1.0
        b = Math.ceil(-1.5);    // == -1.0
        b = Math.ceil(-1.6);    // == -1.0

    }


   //Step9 String,注意,字符串开始定义完，一样的都是一个对象，除非强行建新对象，后面修改后也会创建新对象
    public void doString() {
            String s1 = "hello";
            String s2 = new String("hello");
            String s3 = "hello";
            String s4 = s1;
            s1 = s1 + " world!";
            //System.out.println(s4);

            //Step10 String的equals和Integer一样的，只要值一样，就是true
            System.out.println(s4.equals(s2));

            //Step11 String compareTo,顺序从小到大 0-9 A-Z a-z，
            //小是负数，大是正数，0是相等 ，打开wps，看一下全部的字符集
            //不是比String长度，就是比出现的字母顺序。但是如果前面字符一样，后面长度不一样，就是长短了。
            //AB和ABC，被包含的小。
            s1 = "012313";
            s2 = "A";
            System.out.println(s1.compareTo(s2));

            //注意！！！，compareTo有一个问题!!!!
            //如果两个字符串不一样，返回出现不一样的字符的unicode差值，
            //如果两个字符串前面一样，但是长度不一样，则返回两个字符串的长度差值，不是unicode差值了。切记切记。
            //例如下面返回：-8
            s1 = "Hello";
            s2 =  "Hello World!!";
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

    //tolowercase 转换大写和小写函数
    //charAt函数
    //单个字符的大小写转换操作
    public void doString2(){
            String str = "ABCDabcd";
            char c;
            //string的方法，toLowerCase，toUpperCase 所有字符串都转换成小写或大写
            System.out.println(str.toLowerCase());
            System.out.println(str.toUpperCase());

            //charAt函数，获取指定位置的字符，注意index是从0开始
            //注意是返回char类型
            c = str.charAt(0);//取到A，转成小写a

            //Character.toLowerCase是进行单个字符大小写转换的函数
            System.out.println(Character.toLowerCase(c));

            c = str.charAt(4);//取到a，转成大写A
            System.out.println(Character.toUpperCase(c));
        }

}
