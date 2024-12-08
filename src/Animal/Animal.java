package Animal;

//练习父类和子类的继承
//注意如果类是final的不能继承，方法和属性是final的也不能Override
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
        return "我叫" + name + "，我会" + sound() +"，会"+ move();
    }

    //这个方法可以被子类重写和访问，但是包的外部不能。当前包的其他类也能直接访问本方法。
    protected void method1(){
        System.out.println("I am a protected method of Animal!");
    }

}
