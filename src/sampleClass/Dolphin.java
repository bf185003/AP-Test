package sampleClass;

public class Dolphin extends Animal{
    @Override
    public String sound() {
        return "叽叽！";
    }

    @Override
    public String move() {
        return "游泳！";
    }

    public String show(){
        return "水上表演！";
    }

    @Override
    public String toString() {
        return sound() + move();
    }
}
