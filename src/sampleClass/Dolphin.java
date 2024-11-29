package sampleClass;

public class Dolphin extends Animal{
    @Override
    public void sound() {
        System.out.println("叽叽！");
    }

    @Override
    public void move() {
        System.out.println("游泳！");
    }
}
