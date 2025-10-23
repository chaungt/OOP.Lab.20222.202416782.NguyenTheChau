package Basics;
import java.util.Scanner;
public class NumbersOfDays {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the month: ");
		String month = keyboard.nextLine().trim().toLowerCase();
		System.out.println("Enter the year: ");
		int year = keyboard.nextInt();
        int days = -1;
        switch (month) {
            case "1": case "01": case "jan": case "jan.": case "january":
                days = 31;
                break;
            case "2": case "02": case "feb": case "feb.": case "february":
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            case "3": case "03": case "mar": case "mar.": case "march":
                days = 31;
                break;
            case "4": case "04": case "apr": case "apr.": case "april":
                days = 30;
                break;
            case "5": case "05": case "may":
                days = 31;
                break;
            case "6": case "06": case "jun": case "jun.": case "june":
                days = 30;
                break;
            case "7": case "07": case "jul": case "jul.": case "july":
                days = 31;
                break;
            case "8": case "08": case "aug": case "aug.": case "august":
                days = 31;
                break;
            case "9": case "09": case "sep": case "sep.": case "september":
                days = 30;
                break;
            case "10": case "oct": case "oct.": case "october":
                days = 31;
                break;
            case "11": case "nov": case "nov.": case "november":
                days = 30;
                break;
            case "12": case "dec": case "dec.": case "december":
                days = 31;
                break;
        }

        if (days != -1) {
            System.out.println(days);
        }

	}

}
