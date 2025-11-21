package SortNumericArray;
public class ArraySorting {
	public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9, 3};
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum of elements: " + sum);
        double average = (double) sum / numbers.length;
        System.out.println("Average of elements: " + average);
    }
}
}
