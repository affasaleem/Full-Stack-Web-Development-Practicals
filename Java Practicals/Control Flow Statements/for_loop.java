public class for_loop {
    public static void main(String[] args) {
        // for loop
        // for (int i = 1; i <= 5; i++) {
        //     for(int j=1; j<=i; j++){
        //         System.out.print("$");
        //     }
        //     System.out.println("*");
        // }

        // revers
        int row = 4;
        for (int i=1; i<=row; i++) {
            for(int j=1; j<=row-i; j++){
                System.out.print(" ");
            }
            for (int k=1; k<=i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
