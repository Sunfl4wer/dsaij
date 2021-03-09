package chapter03;

import java.util.Arrays;
import java.util.Random;

public class SimpleSortingApp {
  public static void main(final String[] args) {
    final Random random = new Random();

    final int size = 100000;
    final long[] a = new long[size];
    for (int i = 0; i < size; i++) {
      a[i] = random.nextLong();
    }

    final SimpleSortingAlgorithm sortingAlgorithm = new SimpleSortingAlgorithm(a);
    final long start = System.currentTimeMillis();
    Arrays.sort(a);
    final long end = System.currentTimeMillis();
    System.out.println("Execution time Arrays library sort: " + ((double) end - (double) start)/1000 );
    System.out.println(Arrays.equals(a, sortingAlgorithm.bubbleSort()));
    System.out.println(Arrays.equals(a, sortingAlgorithm.selectionSort()));
    System.out.println(Arrays.equals(a, sortingAlgorithm.insertionSort()));
//    SimpleSortingAlgorithm.toString(sortingAlgorithm.bubbleSort());
  }
}
