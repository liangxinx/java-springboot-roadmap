package Day10;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        while (true){
            System.out.println("1. 新增學生");
            System.out.println("2. 查詢學生");
            System.out.println("3. 修改學生姓名");
            System.out.println("4. 修改學生年齡");
            System.out.println("5. 刪除學生");
            System.out.println("6. 顯示所有學生");
            System.out.println("0. 離開系統");
            System.out.print("請選擇：");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.println("輸入學號");
                    String id = scanner.nextLine();
                    System.out.println("輸入姓名");
                    String name = scanner.nextLine();
                    System.out.println("輸入年紀");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        manager.addStudent(new Student(id,name,age));
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("輸入要查詢的學號");
                    String id = scanner.nextLine();
                    Student found = manager.findStudentById(id);
                    if (found != null){
                        System.out.println("查詢結果"+found);
                    }else {
                        System.out.println("沒有這個人");
                    }
                }
                case 3 -> {
                    System.out.println("輸入要修改的學號");
                    String id = scanner.nextLine();
                    System.out.println("輸入新姓名");
                    String newName = scanner.nextLine();
                    manager.updateStudentName(id,newName);
                }
                case 4 -> {
                    System.out.println("輸入要修改的學號");
                    String id = scanner.nextLine();
                    System.out.println("輸入新年紀");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    manager.updateStudentAge(id,newAge);
                }
                case 5 -> {
                    System.out.println("輸入要刪除的學號");
                    String id = scanner.nextLine();
                    manager.removeStudent(id);
                }
                case 6 ->manager.prntAllStudents();
                case 0 ->{
                    System.out.println("end");
                    return;
                }
                default -> System.out.println("輸入無效");

            }
        }
//        StudentManager manager = new StudentManager();
//        manager.addStudent(new Student("C001","小花",10));
//        manager.addStudent(new Student("C002","小王",11));
//        manager.addStudent(new Student("C003","阿花",9));
//
////        manager.prntAllStudents();
////        System.out.println(manager.findStudentById("C004"));
//        manager.updateStudentAge("C001",20);
//        manager.updateStudentName("C002","cc");
//        manager.removeStudent("C003");
//        manager.prntAllStudents();

    }
}
