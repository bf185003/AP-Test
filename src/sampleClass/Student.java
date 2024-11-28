package sampleClass;

import java.util.ArrayList;

//学生类，练习Association，类的关联关系
//1：该类从Person继承，注意extends是复数形式，是第三人称单数的意思。父类又叫超类supperClass，子类叫subclass
//这样name，age就不需要重新定义了，直接从Person父类继承过来即可。父类的所有public方法也能用
//2：注意如果类标注了是final，就不允许别人继承了，断子绝孙类。 public final class Nochild
//3：注意，java的一个类不支持从多个类继承，防止菱形继承问题，即一个类只能有1个父类。这个和C++、python不一样
//java通过interface可以实现多继承，后面再说。
//4：但是Java支持多层继承，即子类还可作为另外一个类的父类
//5：子类并不是比超类/父类的内容少，相反有可能会更多。
//6：子类能用父类的public的、protected的方法、属性。private的属性和方法不能用。
public class Student extends Person{
    private double gpa = 0;
    private ArrayList<Course> selectCourseList = new ArrayList<Course>(0); // 学生选课表，不限数量

    public Student(String name, int age, int weight, String gender,double g){
        super(name,age,weight,gender);//注意！！，子类缺省不会调用父类的构造函数，必须用super(...)的方式调用
                                      //调用父类的构造函数，必须在constructor的第一句话！！
                                      //注意super关键字和this关键字区别开，this()是调用本类的其他构造器的。
        gpa = g;
    }

    public void addCourse(Course s) {
        //选课
        selectCourseList.add(s);
    }
    public void removeCourse(Course s) {
        //删除某个选中的课
        selectCourseList.remove(s);
    }

    //以下是Override（重写/覆盖）了父类的方法，重写父类的方法，必须名字、返回值、参数都得一模一样才行。
    //注意@Override，前面加了@的这种叫Java注解，这种注解不是必须的。但是为了可靠起见，加上它之后，编译器会帮你检查是否是Override
    //注意不能override父类的私有方法
    //描述一下overload和override的区别
    @Override
    public String toString() {
        return super.toString() + " GPA is : " + gpa;   //super关键字可以访问父类的属性和方法
    }

    public String getGPA(){
        return super.getName() + " GPA is : "+ gpa; //通过super.可以直接调用父类的方法
    }

    //可以override父类的protected的方法
    @Override
    public void method1() {
        super.method1();
    }
}
