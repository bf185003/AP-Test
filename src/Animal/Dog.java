package Animal;


public class Dog extends Animal{
    @Override
    public String sound() {//Override的返回类型和参数列表一定不能修改。但是overload的参数是必须要修改的，返回类型不可以修改小范围。
                             //就是说，不能把父类的public改成private，可以把父类的protected改成public
                        //称为override annotation
        return "汪汪！";
    }

    @Override
    public String move() {
        return "跑！";
    }

    public String hunting(){
        return "打猎！";
    }

    @Override
    public String toString() {
        return sound() + move();
    }
}
