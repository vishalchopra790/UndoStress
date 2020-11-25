package Tests;

import java.util.Scanner;

public class practice {






    public static void main(String[] args) {
        String prime="";

        int digit=50;

        for(int i=0;i<=digit;i++){
            int counter=0;
            for(int j=i;j>=1;j--){
                if(i%j==0) {
                    counter = counter + 1;
                }

            }
            if(counter==2)
                prime=prime+i+" ";
        }
        System.out.println(prime);
    }

}
