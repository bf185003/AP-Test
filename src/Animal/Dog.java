package Animal;


//1：Animal，注意extends是复数形式，是第三人称单数的意思。父类又叫超类supperClass，子类叫subclass
//这样name就不需要重新定义了，直接从Animal父类继承过来即可。父类的所有public方法也能用
//2：注意如果类标注了是final，就不允许别人继承了，断子绝孙类。 public final class Nochild
//3：注意，java的一个类不支持从多个类继承，防止菱形继承问题，即一个类只能有1个父类。这个和C++、python不一样
//java通过interface可以实现多继承，后面再说。
//4：但是Java支持多层继承，即子类还可作为另外一个类的父类
//5：子类并不是比超类/父类的内容少，相反有可能会更多。
//6：子类能用父类的public的、protected的方法、属性。private的属性和方法不能用。
public class Dog extends Animal{

    public Dog(){
        super();
    }

    public Dog(String n){
        super(n);
    }

    @Override
    public String sound() {//Override的返回类型和参数列表一定不能修改。但是overload的参数是必须要修改的，返回类型不可以修改小范围。
                             //就是说，不能把父类的public改成private，可以把父类的protected改成public
                        //称为override annotation
        return "汪汪";
    }

    @Override
    public String move() {
        return "跑";
    }

    public String hunting(){
        return "打猎";
    }

    @Override
    public String toString() {
        return sound() + move();
    }
}
