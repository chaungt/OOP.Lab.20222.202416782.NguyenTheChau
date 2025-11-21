package Basics;
import java.util.Scanner;
public class SolveEquations {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose equation type:");
        System.out.println("1. First-degree (ax + b = 0)");
        System.out.println("2. System of first-degree equations with two variable");
        System.out.println("3. Second-degree (ax² + bx + c = 0)");
        System.out.print("Your choice: ");
        int choice = keyboard.nextInt();
        switch (choice) {
        case 1:
            solveLinear(keyboard);
            break;
        case 2:
            solveLinearSystem(keyboard);
            break;
        case 3:
            solveQuadratic(keyboard);
            break;
        default:
            System.out.println("Invalid choice.");
    }
}
private static void solveLinear(Scanner keyboard) {
    System.out.print("Enter a: ");
    double a = keyboard.nextDouble();
    if (a == 0) {
        System.out.println("Invalid number");
        return;
        }
    System.out.print("Enter b: ");
    double b = keyboard.nextDouble();

    if (a == 0) {
        if (b == 0) {
            System.out.println("Infinite solutions (all real numbers).");
        } else {
            System.out.println("No solution.");
        }
    } else {
        double x = -b / a;
        System.out.println("Solution: x = " + x);
    }
}
private static void solveLinearSystem(Scanner keyboard) {
	System.out.print("Enter first equation: ");
    System.out.print("Enter a11: ");
    double a11 = keyboard.nextDouble();
    System.out.print("Enter a12: ");
    double a12 = keyboard.nextDouble();
    System.out.print("Enter b1: ");
    double b1 = keyboard.nextDouble();
    System.out.print("Enter second equation: ");
    System.out.print("Enter a21: ");
    double a21 = keyboard.nextDouble();
    System.out.print("Enter a22: ");
    double a22 = keyboard.nextDouble();
    System.out.print("Enter b2: ");
    double b2 = keyboard.nextDouble();
    double D  = a11 * a22 - a12 * a21;
    double Dx = b1 * a22 - b2 * a12;
    double Dy = a11 * b2 - a21 * b1;
    if (D == 0) {
        System.out.println("No unique solution");
    } else {
        double x1 = Dx / D;
        double x2 = Dy / D;
        System.out.println("System solution: x1 = " + x1 + ", x2 = " + x2);
    }
}
    
private static void solveQuadratic(Scanner keyboard) {
	System.out.print("Enter a: ");
    double a = keyboard.nextDouble();
    if (a == 0) {
        System.out.println("Invalid number");
        return;
        }
    System.out.print("Enter b: ");
    double b = keyboard.nextDouble();
    System.out.print("Enter c: ");
    double c = keyboard.nextDouble();
    double discriminant = b * b - 4 * a * c;
    if (discriminant < 0) {
        System.out.println("No real solution.");
    } else if (discriminant == 0) {
        double x = -b / (2 * a);
        System.out.println("One real root: x = " + x);
    } else {
        double sqrtD = Math.sqrt(discriminant);
        double x1 = (-b + sqrtD) / (2 * a);
        double x2 = (-b - sqrtD) / (2 * a);
        System.out.println("Two real roots: x1 = " + x1 + ", x2 = " + x2);
    }
}

}
