import Human.*;
//Java和类的基本知识
public class Unit1 {
    public static void inc(int x,int y) //传值引用和传参数引用的对比
    {
        x ++;
        System.out.println(x);
        y ++;
    }

    public void doClass() {
        int x = 5;
        int y = 6;
        inc(x,y);
        System.out.println(x);

        Person zhunan = new Person("朱楠",50,110,"女");
        Person fuwei = new Person("付威",51,160,"男");
        Person fuxiaonuan = new Person("付小暖",15,110,"女");
        Person somebody  = fuxiaonuan;

        for (int i = 0; i < 10; i++) {
            System.out.println(fuxiaonuan.getName() + " 性别" + fuxiaonuan.getGender() +
                    " 年龄" + fuxiaonuan.getAge() + "岁 体重" + fuxiaonuan.getWeight());
            fuxiaonuan.grow();
            fuxiaonuan.LosingWeight(5);
        }
        somebody.grow();
        System.out.println(fuxiaonuan.getAge());
        Person.setMaxAge(200);

        System.out.println(fuxiaonuan.getName() +"最大年龄"+fuxiaonuan.getMaxAge());
        System.out.println(fuwei.getName() +"最大年龄"+fuxiaonuan.getMaxAge());
        System.out.println(zhunan.getName() +"最大年龄"+fuxiaonuan.getMaxAge());
    }
}
