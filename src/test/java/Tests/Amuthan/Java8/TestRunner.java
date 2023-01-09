package Tests.Amuthan.Java8;

public class TestRunner {
    public static void main(String[] args) {
        IPrintable obj = a->a+"Hello";
        System.out.println(obj.print("vishal"));
    }
}
