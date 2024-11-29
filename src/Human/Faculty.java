package Human;

import Animal.Course;

import java.util.ArrayList;

//讲师类，也是从Person继承
public class Faculty extends Person{
    private ArrayList<Course> courseList = new ArrayList<Course>(0);
    private final int MAX_COURSE = 3;

    public void addCourse(Course c){
        if (courseList.size() < MAX_COURSE){
            courseList.add(c);
        }else{
            System.out.println("您本学期教的课数量已经满了。");
        }
    }
}
