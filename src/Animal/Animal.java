package Animal;

//练习父类和子类的继承
//注意如果类是final的不能继承，方法和属性是final的也不能Overide
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
