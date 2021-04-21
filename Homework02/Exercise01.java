package Homework02;

public class Exercise01 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        // Teil 1
        if (a % b == 0 || b % a == 0) {
            System.out.println("Teilbar");
        } 
        
        //Teil 2
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("True");
        }
    }
}
