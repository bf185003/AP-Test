package sampleClass;

public class Dove extends Animal{
    @Override
    public String sound() {
        return "咕咕！";
    }

    @Override
    public String move() {
        return "飞！";
    }

    public String sendMail(){
        return "送信！";
    }

    @Override
    public String toString() {
        return sound() + move();
    }
}
