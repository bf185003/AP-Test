package Animal;

public class Dove extends Animal{

    public Dove(String n){
        super(n);
    }

    @Override
    public String sound() {
        return "咕咕";
    }

    @Override
    public String move() {
        return "飞";
    }

    public String sendMail(){
        return "送信";
    }

    @Override
    public String toString() {
        return "我叫" + name + "，我会" + sound() +"，会"+ move() + "，会" + sendMail();
    }
}
