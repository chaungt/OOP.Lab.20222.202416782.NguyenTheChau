package Triangle;
import java.util.Scanner;
public class DisplayTriangle {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter n: ");
		int n = keyboard.nextInt();
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

	}

}
