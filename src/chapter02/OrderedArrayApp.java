package chapter02;

import java.util.Random;

public class OrderedArrayApp {
  public static void main(final String[] args) {
    final int arraySize = 10000;
    final OrderedArray orderedArray = new OrderedArray(arraySize);
    final Random rd = new Random();
    for (int i = 0; i < arraySize; i++) {
      orderedArray.insert(rd.nextLong());
    }
    System.out.println(orderedArray.toString());
  }
}
