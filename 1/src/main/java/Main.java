import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in ));
        String s=bf.readLine();
        int a=Integer.parseInt(String.valueOf(s.charAt(0)-'0'));
        int b=Integer.parseInt(String.valueOf(s.charAt(2)-'0'));
        Course course=new Course();
        course.setNum(a);
        course.setTeacher_id(b);
        course.print();
    }
}
@Getter @Setter
class Course{

    private Integer num;
    private int teacher_id;
    Course(){
        num=0;
        teacher_id=-1;
    }
    Course(Integer a,Integer b){
        num=a;
        teacher_id=b;
    }
    public void print(){
        StringBuilder s=new StringBuilder("this class has ");
        s.append(num);
        s.append(" and teacher id is ");
        s.append(teacher_id);
        System.out.println(s.toString());
    }
}