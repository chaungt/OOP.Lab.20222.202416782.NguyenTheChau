package hust.soict.dsai.garbage;
import java.util.Random;

public class GarbageCreator {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        Runtime runtime = Runtime.getRuntime();
        StringBuilder sb = new StringBuilder(10_000_000);
        for (int i = 0; i < 100_000_000; i++) {
            s += r.nextInt(2);
            if (i % 100_000 == 0) {
                long usedMemory = runtime.totalMemory() - runtime.freeMemory();
                long maxMemory = runtime.maxMemory();
                double usedPercent = (usedMemory * 100.0) / maxMemory;
                if (usedPercent > 90.0) {
                    System.out.println("⚠️ Too much garbage! Stopping before OutOfMemoryError.");
                    break;
                }
            }
        }
        String s = sb.toString();
        System.out.println("Final length: " + s.length());
        System.out.println("Finished in " + (System.currentTimeMillis() - start) + " ms");
    }
}
