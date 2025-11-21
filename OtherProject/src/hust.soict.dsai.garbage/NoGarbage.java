package hust.soict.dsai.garbage;
import java.util.Random;

public class NoGarbage {

	public static void main(String[] args) {
		Random r = new Random(123);
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(10_000_000);
        for (int i = 0; i < 10_000_000; i++) {
            sb.append(r.nextInt(2));
            if (i % 100_000 == 0) {
                System.out.println("Generated " + i + " bits...");
            }
        }

        String s = sb.toString();
        System.out.println("Final length: " + s.length());
        System.out.println("Finished in " + (System.currentTimeMillis() - start) + " ms");

	}

}
