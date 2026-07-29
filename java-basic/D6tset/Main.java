package D6tset;

public class Main {
    public static void main(String[] args) {
//        Person a = new Person("a",4);
//        Person b = new Person("b",3);
//        b.setAge(7);
//        System.out.println(b.getAge());
//        Order a = new Order();
//        System.out.println(a.getOrderId());
//        Order b = new Order();
//        System.out.println(b.getOrderId());
//        Order c = new Order();
//        System.out.println(c.getOrderId());
//        double tax = Rectangle.calculateTax(100);
//        System.out.println(tax);
        Book a = new Book("a");
        Book b = new Book("bbbbb");
        a.borrow();
        a.borrow();
        a.returnBook();
        System.out.println(a.isBorrowed());
        System.out.println(b.getTitle());
        b.returnBook();
        b.borrow();
    }
}
