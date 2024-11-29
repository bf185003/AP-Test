package sampleClass;


public class Dog extends Animal{
    @Override
    public void sound() {//Override的返回类型和参数列表一定不能修改。但是overload的参数是必须要修改的，返回类型可以不修改。
        System.out.println("汪汪！");
    }

    @Override
    public void move() {
        System.out.println("跑！");
    }

    public void hunting(){
        System.out.println("打猎！");
    }
}
