public class Unit5 {

    //以下分别在哪里能看，哪里能改？
    //打开Math的类的实现，学习一下
    public int attrPublic = 0;
    private int attrPrivate = 1;
    public static int attrPublicStatic = 2;
    public final int ATTR_FINAL;
    public static final int ATTR_STATIC_FINAL = 100;
    private static final double ATTR_STATIC_FINAL_PRIVATE = 2.01;
    public static int attr_static = 0;

    //如果构造函数没写缺省的，直接写了带参数的，那么对象必须带参数创建。
    public Unit5(int attr_final){
        this.ATTR_FINAL = attr_final;//final可以在构造函数种改一次
    }

    //method/function 介绍 ，方法和函数都是一码事，java叫方法，其他语言叫函数
    // <access type> <return type> <identifier> <parameter list>
    //access type : public  private
    //return type : void , other
    //identifier  : 起一个好听好理解的名字
    //parameter list : 类型1 名字1， 类型2 名字2，...(可以没有参数，可以有参数)

    //static的method,只能用自己的参数或static的参数，也能调用其他static方法
    public static int staticSum(int n){
        staticMethod();
        return n + ATTR_STATIC_FINAL + (int)ATTR_STATIC_FINAL_PRIVATE;
    }

    //private私有的、static静态的方法
    private static void staticMethod(){
        return; // void 的方法可以写一个空返回，也可以不写。如果不是void的方法 必须要写return。
    }

    //这是一个类里面内置的静态的类
    public static class miniClass{
        public static void miniMethod(){
            System.out.println("我是类中类");
        }
    }


}
