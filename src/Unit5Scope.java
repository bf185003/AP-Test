//练习变量的作用域，最简单的记法，就是变量在定义所在的花括号内有效。
//Scope of Variables
public class Unit5Scope {
    private static int class_i = 30;     //这个变量是所有类都能操作的
    private int instance_i = 10;     //这个变量是当前对象的所有method都可以操作的

    public void Method1(int para_i){ //方法参数中的变量，仅在这个方法内有效。
        int method_i = 20;       //这个变量，仅在当前函数中使用，退出函数就消失
                                 //方法内的变量，又叫局部变量Local Variables
        System.out.println(method_i + instance_i);
        for (int i = 0; i < 5; i++) { //这个i，仅在for中有效，退出循环后消失
            if (i == 5){
              int j = i;            //这个j，仅在if中有效，退出j消失
              System.out.println(j);
            }
            //System.out.println(j);  这样写报错。
            System.out.println(i + instance_i);
        }
        {
            int x = 30;     //拓展开来，只要用花括号包含在一起的，就是在当前的花括号及子花括号内有效
        }
        //System.out.println(x); 这样报错
        //System.out.println(x); 这样报错
        //System.out.println(i); 这样写也报错
    }

    public void Method2(){
        System.out.println(class_i); //类的静态变量能用
        System.out.println(instance_i); //对象\实例的变量能用
        //System.out.println(para_i);  其他方法的局部变量不能用
        //System.out.println(method_i); 同上

    }

    private void privateMethod(){
        System.out.println("I am a private Method");
    }

    //！！重要
    public int otherInstanceprivate(Unit5Scope theOther){
        theOther.privateMethod();
        return theOther.instance_i; //注意这个要点，肯定要考，就是这里引用的theOther是另外一个实例，但是
                                    //在当前的类方法中，是可以用.的方法调用同一个类的实例的私有变量，也能调用私有的函数。
    }
}
