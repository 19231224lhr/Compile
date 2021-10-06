import cal.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int a,b;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        int c;
        c = Add.add(a, b);
        System.out.println(c);
    }
}
