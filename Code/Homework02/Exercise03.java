public class Exercise03 {
    public static void main(String[] args) {
        for (int i = 1000; i <= 2000; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }

        int N = 5;
        for (int i = 0; i < N; i++) {
            System.out.println();
            if (i % 2 == 0) {
                System.out.print(" ");
            }
            for (int j = 0; j < N ; j++) {
                System.out.print("* ");
            }
        }
    }
}
