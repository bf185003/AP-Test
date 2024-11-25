package sampleClass;

import java.util.ArrayList;

//学生类
public class Student {
    private ArrayList<Course> selectCourseList = new ArrayList<Course>(0); // 学生选课表，不限数量

    public void addCourse(Course s) {
        //选课
        selectCourseList.add(s);
    }
    public void removeCourse(Course s) {
        //删除某个选中的课
        selectCourseList.remove(s);
    }
}
