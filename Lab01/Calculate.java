package Basics;
import javax.swing.JOptionPane;
public class Calculate {

	public static void main(String[] args) {
		String strNum1, strNum2;
		double num1, num2;
		double sum, difference, product, quotient;
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number ", JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number ", JOptionPane.INFORMATION_MESSAGE);
		num1 = Double.parseDouble(strNum1);
		num2 = Double.parseDouble(strNum2);
		sum = num1 + num2;
		difference = Math.abs(num1 - num2);
		product = num1 * num2;
		quotient = num1 / num2;
		System.out.println("The sum of two number is: " + sum);
		System.out.println("The difference of two number is: " + difference);
		System.out.println("The product of two number is: " + product);
		System.out.println("The quotient of two number is: " + quotient);
	}
}
