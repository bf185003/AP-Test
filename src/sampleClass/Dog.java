package sampleClass;


public class Dog extends Animal{
    @Override
    public String sound() {//Override的返回类型和参数列表一定不能修改。但是overload的参数是必须要修改的，返回类型可以不修改。
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
