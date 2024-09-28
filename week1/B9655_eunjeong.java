import java.util.Scanner;

public class B9655_eunjeong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n % 2 == 0) {
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }

    }
}