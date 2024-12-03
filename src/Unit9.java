import Animal.*;
import java.util.ArrayList;

//面向对象，继承，多态的测试。
public class Unit9 {
    Dolphin d = new Dolphin("Mike");
    Animal a = new Dog("花花");
    Animal c = new Animal();

    public void doAnimal(){

        //Dog e = (Dog) c; 这句话报错的，super类不能转换成子类，反之，子类永远可以转换成父类。下面这句话是对的
        Dog f = (Dog) a;//注意这里，a和f共用一个对象

        System.out.println(d.sound());
        System.out.println(a.sound()); //调用的是dog的sound
        d.show();//d是dolphin，可以直接调用个性化的show方法。
        ((Dog) a).hunting(); //如果想调用a的dog的个性方法，必须把animal前面强制转换为dog才行。
        //a.hunting();这样是错的，只能调用Animal基础的方法。

        ArrayList<Animal> zoo = new ArrayList<Animal>(0);
        zoo.add(new Dog("旺财"));
        zoo.add(new Dolphin("小杜"));
        zoo.add(new Animal());
        zoo.add(new Dove("小白"));
        zoo.add(new Dog("大黄"));
        zoo.add(new Dove("点子"));

        for (int i = 0; i < zoo.size(); i++) {
            System.out.println(zoo.get(i));//直接调用toString的方法，toString是Object类的基本方法，所有的类都是从挂这里派生的。
        }

        for (int i = 0; i < zoo.size(); i++) {
            if(zoo.get(i) instanceof Dog)//找到只有狗才print。instanceof可以用来判断是啥类。注意Java关键字都是小写的，不是骆驼命名法
                                         //但是@这种标注有是大写开头的。
                System.out.println(zoo.get(i).name + ((Dog) zoo.get(i)).hunting()); //把zoo中列表的对象先转换成dog，再调用dog的方法hunting
                                                                  //一定要注意必须先转换完dog，再调用hunting，因此前面有个小括号。

            if(zoo.get(i) instanceof Dolphin)
                System.out.println(zoo.get(i).name + ((Dolphin) zoo.get(i)).show());

        }

        Animal x = new Chihuahua(); //演示instanceof可以表达对象的类及其父类，但是不能是兄弟类
        if(x instanceof Animal)
            System.out.println("x is Animal");
        else
            System.out.println("x is not Animal");

        if(x instanceof Dove)
            System.out.println("x is Dove");
        else
            System.out.println("x is not dove");

        if(x instanceof Dog)
            System.out.println("x is Dog");
        else
            System.out.println("x is not dog");

        if(x instanceof Chihuahua)
            System.out.println("x is Chihuahua");
        else
            System.out.println("x is not Chihuahua");

        if(x instanceof BorderCollie)
            System.out.println("x is BorderCollie");
        else
            System.out.println("x is not BorderCollie");


    }
}
