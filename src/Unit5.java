public class Unit5 {

    //1: 一个Class类，通常由3部分组成：属性Property、构造器constructor、方法Method
    //2: 属性Property、attribute，都是指同一个意思
    //3: Method方法和Function函数，都是指同一个意思
    //4：Object对象和Instance实例，都是指同一个意思
    //5:

    //step1 以下变量分别：属于谁？在哪里能看到？哪里能改？值的作用域范围是哪？
    //打开Math的类的实现，学习一下
    public int attrPublic = 0;              //属于对象，对象内外都能看，对象内外都能改。类中不能改。只是在当前对象中。
    private int attrPrivate = 1;            //属于对象，对象内能看到，对象内能改。类中不能改。只是在当前对象中。
    public static int attrPublicStatic = 2; //属于类本身，内外和类定义都能看到，类和对象都能修改修改。全局对象和类共享一个值
    private static int attr_static = 0;     //属于类本身，对象内和类能看到，只能在类内的静态函数修改。全局对象和类共享一个值
    public final int ATTR_FINAL;            //属于对象，对象内外能看到，设置完一次就不能改。只是在当前对象中。
                                            // 注意final只有2个地方能设置值，一个是定义的这里，一个是构造函数。但是如果这里定义赋值了，构造函数也无法修改。
    public static final int ATTR_STATIC_FINAL = 100;//对象内外、类能看到。通常在类定义设置完就不改了。全局对象和类共享一个值。
    private static final double ATTR_STATIC_FINAL_PRIVATE = 2.01;



    //step 2 函数的构造
    //method/function 介绍 ，方法和函数都是一码事，java叫方法，其他语言叫函数
    // <access type> <return type> <identifier> <parameter list>
    //access type : public  private static
    //return type : void , other  有返回值的，我们通常不能当作单独语句。void必须是当作单独语句使用。
    //identifier  : 起一个好听好理解的名字
    //parameter list : 类型1 名字1， 类型2 名字2，...(可以没有参数，可以有参数)
    //return value : void的不需要写，写也没事。
    //static的method,只能用自己的参数或static的参数，也能调用其他static方法
    public static int staticSum(int n){
        privateStaticMethod();//void的方法通常当作一条语句。这里只static方法只能调用另外的static方法
        System.out.println(isPrime(n)); //不是void的方法，通常都当作一个值来使用
        return n + ATTR_STATIC_FINAL + (int)ATTR_STATIC_FINAL_PRIVATE;
    }

    //private私有的、static静态的方法
    private static void privateStaticMethod(){  //方法命名一般遵循驼峰法（Camel Case）,首字母小写，后续每个单词首字母大写，其他都小写。缩写都是大写）。
        return; // void 的方法可以写一个空返回，也可以不写。如果不是void的方法 必须要写return。
    }

    //step3 函数的类型，这两个函数在哪里能看到?
    // 如果第一个函数参数输入4 ，返回多少。
    ////注意，如果函数是void的，不能放在表达式里面调用。只能单独一行调用。比如把第二个函数换成void则报错。
    public int method1(int a){//这里的参数叫形参，formal parameter
        int result = method2(a * 10); //这个result的作用域只在当前方法，其他人看不到。
                                                //这里的a叫实际参数，actual parameter
                                                //实参的作用域就是当前函数
        System.out.println("我是method 1 的调用：参数a = " + a + " result = " + result); //这里会打印多少？
        boolean prime = Unit5.isPrime(a);//非静态的函数，可以调用静态的函数。也能改静态变量。但是反过来不行。静态函数不能调用非静态的函数和变量。
        return result;
    };

    private int method2(int b){
        int result = method3(b + 10);//这个result的作用域只在当前方法，其他人看不到。
        System.out.println("我是method 2 的调用：参数b = " + b + " result = " + result); //这里会打印多少？
        return result;
    };

    private int method3(int c){
        int result = c + 3;
        System.out.println("我是method 3 的调用：参数c = " + c + " result = " + result);
        return result;
    }

    //方法返回什么的返回值,在其他计算中就当什么值用，以下都是什么返回值，能在哪些函数中用。
     public int abc(){ return 10;};
     public double def(){ return 10.0;};
     public boolean ghi(){ return true;};
     public String jkl(){ return "abcd";};
     //public void mno(){ return 10};

     public void test(){
         double a = 2 / abc(); //是否正确？？？a = 多少？ 0.0
         double b = 2 / def(); //是否正确？？？b = 多少？ 0.2
//         double c = 10 / ghi(); //是否正确？？？
//         double d = 10 / jkl(); //是否正确？？？

         if(ghi())//是否正确？
             System.out.println("TRUE");

         String s = jkl().substring(0,1); //是否正确？
         s = jkl() + jkl() + jkl();
     }


    //带参数的method，return的时候注意，必须要有，不能有遗漏
    //下面就掉了如果n < 0的情况，编译器会报错。考虑下怎么改。
//    public int sign(int n){
//        if (n > 10)
//            return 1;
//        else if (n > 0)
//            return 0;
//        else if (n == 0)
//            return -1;
//    }

    //step4 重载
    //Method Overload!!!方法重载
    // 不同参数可以同名,参数的：个数、类型、顺序，这三个任何一个不一样都是Overload，查看Math.abs,String.indexof有几种重载方法
    //在main中分别调用这两个方法，sum(5,5) sum(5,5.0)如何区分出来调用的是谁呢？
    public int sum(int n1){ return  n1 + 1;}
    public int sum(int n1,int n2){ return  n1 + n2;}
    public double sum(double n1,int n2){ return n1 + n2;}
    public double sum(int n1,double n2){return n1 + n2;}


    //step5 构造函数
    // 如果构造函数没写缺省的，直接写了带参数的，那么对象必须带参数创建。
    //注意构造函数的3个特点：1和类名一样的名字 2没有返回值，也不需要写void 3是在new的时候调用，否则是null
    public Unit5(){
        this.ATTR_FINAL = attr_static;
    }
    public Unit5(int attr_final){
        this.ATTR_FINAL = attr_final;//final可以在构造函数种改一次
    }

    //注意！！如果你写了返回值或void，这就是一个普通方法，不是构造器Constructor了。普通方法可以和类重名。
    public int Unit5(){
        return 0;
    }

    public Unit5(int attr_final,int attrPublic){
        this.ATTR_FINAL = attr_final;
        this.attrPublic = attrPublic; //注意这个里的=后面的attrPublic是传进来的实参，不是
                                      //Class的变量attrPublic，一定要注意区分！！
                                      //实参的作用域就是当前函数
    }



    //这是一个类里面内置的静态的类
    public static class miniClass{
        public static void miniMethod(){
            System.out.println("我是类中类");
        }
    }

    //判断一个数是否是素数Prime
    public static boolean isPrime(int a){
        int j = 10;// j这个变量只在当前方法有效
                    //注意，变量的作用域越大，命名越长，好让更多的人理解
        for (int i = 2; i < a; i++) {
            if( a % i == 0)
                return false;
        }
        //System.out.println(i);这样的语法是错的，i已经出了作用域
        return true;
    }
}
