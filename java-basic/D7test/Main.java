package D7test;

import java.util.Date;

public class Main {
    //在 `Main` 裡：
//        1. 建立一個 `Employee[]` 陣列，放 1 個 `Manager`、1 個一般 `Employee`、1 個 `Intern`
//        2. 用 for-each 迴圈，印出每個人的名字和 `calculateSalary()` 的結果
//3. 用 `instanceof` 判斷，如果是 `Manager`，額外印出「這位是主管，獎金是 [bonus]」
    public static void main(String[] args) {
        Employee [] employees=new Employee[3];
        employees[0]=new Employee("a",50000);
        employees[1]=new Manager("b",40000,3000);
        employees[2]=new Intern("c");
        for (Employee em : employees){
            System.out.println(em.name);
            System.out.println("薪資:"+em.calculateSalary());
            if (em instanceof Manager manager){
                System.out.println("這位是主管，獎金是"+manager.getBonus());
            }
        }
    }


//    public static void main(String[] args) {
////        Circle a = new Circle("a");
////        Square b = new Square("b");
////
////        a.draw();
////        b.draw();
//        Shape [] a = new Shape[4];
//        a[0]=new Circle("aa");
//        a[1]=new Square("a");
//        a[2]=new Square("b");
//        a[3]= new Circle("nnn");
//
//        for (Shape b : a){
//            b.draw();
//            if (b instanceof Circle circle){
//                circle.showName();
//            }else if (b instanceof Square square){
//                square.showName();
//            }
//        }
//
//    }
}
