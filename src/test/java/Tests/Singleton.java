package Tests;

public class Singleton {

    private static Singleton single_ref;
    private  String str;
    private Singleton(){
        str="JAI GURU JI";
    }

    public static Singleton getInstance(){
        if(single_ref==null)
            single_ref=new Singleton();
        return single_ref;
    }

    public static void main(String[] args) {
        Singleton x=Singleton.getInstance();
        Singleton y=Singleton.getInstance();
        Singleton z=Singleton.getInstance();

        x.str=x.str.toLowerCase();
        System.out.println(x.str);
        System.out.println(y.str);
        System.out.println(z.str);

        x.str=x.str.toUpperCase();
        System.out.println(x.str);
        System.out.println(y.str);
        System.out.println(z.str);
    }
}
