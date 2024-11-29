package sampleClass;

//练习父类和子类的继承
public class Animal {
    public String sound(){
        return "动物会发叫！";
    }
    public String move(){
        return "动物会移动！";
    }

    @Override
    public String toString(){
        return sound() + move();
    }
}
