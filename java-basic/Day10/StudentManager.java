package Day10;
import java.util.ArrayList;
public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
        System.out.println("學生新增成功");
    }

    public Student findStudentById(String id){
        for (Student s : students){
            if (s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }
    public void prntAllStudents(){
        if(students.isEmpty()){
            System.out.println("目前沒有任何學生");
        }else{
            for(Student s : students){
                System.out.println(s);
            }
        }
    }

    public void updateStudentName(String id,String newName){
        Student student = findStudentById(id);
        if (student==null){
            System.out.println("找不到"+id+"該學生");
            return;
        }
        student.setName(newName);
        System.out.println("興改成功"+student);
    }

    public void updateStudentAge(String id,int newAge){
        Student student = findStudentById(id);
        if (student==null){
            System.out.println("找不到"+id+"該學生");
            return;
        }
        student.setAge(newAge);
        System.out.println("修改成功"+student);
    }

    public void removeStudent(String id){
        Student student = findStudentById(id);
        if (student==null){
            System.out.println("找不到"+id+"該學生");
            return;
        }
        students.remove(student);
        System.out.println("刪除成功"+student);
    }
}
