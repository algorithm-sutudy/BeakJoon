package week1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

        scanner.close();
    }
}
