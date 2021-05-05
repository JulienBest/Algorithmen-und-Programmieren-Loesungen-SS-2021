public class Exercise02 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if (a == b && b == c && a == c) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }

        double x = 0.1;
        double y = 1.5;

        if (x < 1 && x > 0 && y < 1 && y > 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
