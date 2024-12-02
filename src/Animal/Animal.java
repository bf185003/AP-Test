package Animal;

//练习父类和子类的继承
//注意如果类是final的不能继承，方法和属性是final的也不能Overide
public class Animal {
    public String name;

    public Animal(){
        name = "??";
    }

    public Animal(String n){
        name = n;
    }

    public String sound(){
        return "发声";
    }
    public String move(){
        return "移动";
    }

    @Override
    public String toString(){
        return sound() + move();
    }
}
