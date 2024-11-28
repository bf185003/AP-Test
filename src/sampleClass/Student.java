package sampleClass;

import java.util.ArrayList;

//学生类，练习Association，类的关联关系
//该类从Person继承，注意extends是复数形式，是第三人称单数的意思
//这样name，age就不需要重新定义了，直接从Person父类继承过来即可。父类的所有public方法也能用
//注意如果类标注了是final，就不允许别人继承了，断子绝孙类。 public final class Nochild
//注意，java的一个类不支持从多个类继承，防止菱形继承问题，即一个类只能有1个父类。这个和C++、python不一样
//java通过interface可以实现多继承，后面再说。
//但是Java支持多层继承，即子类还可作为另外一个类的父类
public class Student extends Person{
    private double gpa = 0;
    private ArrayList<Course> selectCourseList = new ArrayList<Course>(0); // 学生选课表，不限数量

    public Student(String name, int age, int weight, String gender,double g){
        super(name,age,weight,gender);//注意！！，子类缺省不会调用父类的构造函数，必须用super(...)的方式调用
                                      //调用父类的构造函数，必须在constructor的第一句话！！
                                      //注意和this()区别开，this()是调用本类的其他构造器的。
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
    //注意@Override这种叫注解，这种注解不是必须的。但是为了可靠起见，加上它之后，编译器会帮你检查
    @Override
    public String toString() {
        return super.toString() + " GPA is : " + gpa;
    }

    public String getGPA(){
        return super.getName() + " GPA is : "+ gpa; //通过super.可以直接调用父类的方法
    }
}
