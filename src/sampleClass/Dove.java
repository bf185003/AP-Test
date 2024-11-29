package sampleClass;

public class Dove extends Animal{
    @Override
    public void sound() {
        System.out.println("咕咕！");
    }

    @Override
    public void move() {
        System.out.println("飞！");
    }
}
