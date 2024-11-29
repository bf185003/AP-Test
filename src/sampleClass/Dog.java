package sampleClass;

public class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("汪汪！");
    }

    @Override
    public void move() {
        System.out.println("跑！");
    }
}
