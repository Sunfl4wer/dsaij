package chapter03;

public class SimpleSortingAlgorithm {
  private long[] a;
  private int nElems;

  public SimpleSortingAlgorithm(final long[] array) {
    this.a = array;
    this.nElems = array.length;
  }

  public SimpleSortingAlgorithm(final int size) {
    this.a = new long[size];
    nElems = 0;
  }

  public void insert(final long value) {
    a[nElems] = value;
    nElems++;
  }

  /*
  Bubble sort:
  Time complexity: O(n^2)

  An implementation for bubble sort on an array 'a' of length n
  Init k with the value of n-1
  1. Traverse through 'a' using index 'i' from 0 to k
  2. if a[i] > a[i+1]
        swap(a[i], a[i+1])
  3. Reduce the value of k by one unit if k > 1 and repeat from 1 to 3
   */
  public long[] bubbleSort() {
    final long[] newArray = this.a;
    final long start = System.currentTimeMillis();
    for (int i = nElems - 1; i > 1; i--) {
      for (int j = 0; j < i; j++) {
        if (newArray[j] > newArray[j+1]) {
          final long temp = newArray[j];
          newArray[j] = newArray[j+1];
          newArray[j+1] = temp;
        }
      }
    }
    final long end = System.currentTimeMillis();
    System.out.println("Execution time of bubble sort: " + ((double) end - (double) start)/1000 + "s");
    return newArray;
  }

  /*
    Selection sort:
    - Time complexity: O(n^2)
    - Number of swap: O(n)

    An implementation of the selection sort on an array 'a' of length n
    Initialize k with the value of 0
    1. Find min in array a from k to n-1
    2. Swap between a[k] and the array element that has the min value
    3. Increase the value of k by one unit and repeat the algorithm
   */
  public long[] selectionSort() {
    final long[] newArray = this.a;
    final int nElems = this.nElems;
    final long start = System.currentTimeMillis();

    for (int i = 0; i < nElems-1; i++) {
      int minIndex = i;
      for (int j = i; j < nElems; j++) {
        if (a[j] < a[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        final long temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
      }
    }

    final long end = System.currentTimeMillis();
    System.out.println("Execution time of selection sort: " + ((double) end - (double) start)/1000 + "s");
    return newArray;
  }

  /*
    Insertion sort:
    - Time complexity: O(n^2)
    - Number of comparison: O(n^2)
    - Number of swap: O(n^2)

    Implementation of insertion sort for an array 'a' of n elements.
    Initialize variable 'k' of value 1
    1. Initialized variable 'j' of value k-1 and marked = a[k]
    2. while (j > 0 and a[k] > mark)
        a[j+1] = a[j]
        j--
    3. Repeat with the value of 'k' increase by one unit.
   */
  public long[] insertionSort() {
    final long[] newArray = this.a;
    final int nElems = this.nElems;
    final long start = System.currentTimeMillis();

    for (int i = 1; i < nElems; i++) {
      int j = i-1;
      long marked = a[i];
      while(j >= 0 && a[j] > marked) {
        a[j+1] = a[j];
        j--;
      }
      a[j+1] = marked;
    }

    final long end = System.currentTimeMillis();
    System.out.println("Execution time of insertion sort: " + ((double) end - (double) start)/1000 + "s");
    return newArray;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append('[');
    if (nElems > 0) {
      for (int i = 0; i < nElems - 1; i++) {
        sb.append(a[i]);
        sb.append(' ');
      }
      sb.append(a[nElems - 1]);
    }
    return sb.append(']').toString();
  }

  public static void toString(final long[] a) {
    final StringBuilder sb = new StringBuilder();
    final int nElems = a.length;
    sb.append('[');
    if (nElems > 0) {
      for (int i = 0; i < nElems - 1; i++) {
        sb.append(a[i]);
        sb.append(' ');
      }
      sb.append(a[nElems - 1]);
    }
    System.out.println(sb.append(']').toString());
  }
}
