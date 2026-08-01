package Day10;

public class Student {
    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<=0 || age>=150){
            System.out.println("年齡不正常");
            return;
        }
        this.age = age;
    }

    //新東西 toString
    @Override
    public String toString(){
        return "學號: " + id + ", 姓名: " + name + ", 年齡: " + age;
    }
}
