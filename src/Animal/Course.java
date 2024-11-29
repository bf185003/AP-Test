package Animal;

import Human.Faculty;
import Human.Student;

import java.util.ArrayList;

//课程类
public class Course {
    private String courseName;
    private ArrayList<Student> studentList = new ArrayList<Student>(0); //选中当前课的学生列表
    private Faculty faculty;//当前课程的老师，只能有一个。
    private final int MAX_STUDENT = 50;

    //课程增加学生，最多50人
    public void addStudent(Student s){
        if(studentList.size() < MAX_STUDENT) {
            studentList.add(s);
        }else{
            System.out.println("选课人数已满，无法选这门课。");
        }
    }

    //取消某个学生的选课
    public void removeStudent(Student s){
        studentList.remove(s);
    }

    //给当前课程设置教师
    public void setFaculty(Faculty thefaculty){
        faculty = thefaculty;
    }
}
