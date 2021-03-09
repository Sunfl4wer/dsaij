package chapter02;

public class OrderedArray {
  private long[] a;
  private int nElems;

  public OrderedArray(final int max) {
    this.a = new long[max];
    this.nElems = 0;
  }

  public int size() {
    return nElems;
  }

  public int find(final long searchKey) {
    int lowerBound = 0;
    int upperBound = nElems-1;
    int currentlyIn;

    while(true) {
      currentlyIn = (lowerBound+upperBound)/2;
      if (a[currentlyIn] == searchKey) {
        return currentlyIn;
      }
      if (upperBound < lowerBound) {
        return nElems;
      }
      if (searchKey < a[currentlyIn]) {
        upperBound = currentlyIn-1;
      }
      if (searchKey > a[currentlyIn]) {
        lowerBound = currentlyIn+1;
      }
    }
  }

  public void insert(final long value) {
    if (a.length == 0) {
      return;
    }
    if (a.length == nElems) {
      throw new ArrayStoreException("Array is full!");
    }
    if (nElems == 0) {
      a[0] = value;
      nElems++;
      return;
    }
    if (nElems > 0 && a[0] > value) {
      for (int i = nElems; i > 0; i--) {
        a[i] = a[i-1];
      }
      a[0] = value;
      nElems++;
      return;
    }
    if (nElems > 0 && a[nElems-1] < value) {
      a[nElems] = value;
      nElems++;
      return;
    }
    int lowerBound = 0;
    int upperBound = nElems-1;
    while (lowerBound != upperBound - 1) {
      int currentIndex = (lowerBound+upperBound)/2;
      if (value < a[currentIndex]) {
        upperBound = currentIndex;
      }
      if (value > a[currentIndex]) {
        lowerBound = currentIndex;
      }
    }
    for (int i = nElems; i > upperBound; i--) {
      a[i] = a[i-1];
    }
    a[upperBound] = value;
    nElems++;
  }

  public boolean delete(final long value) {
    final int valueIndex = this.find(value);
    if (valueIndex == nElems) {
      return false;
    }
    for (int i = valueIndex; i < nElems-1; i++) {
      a[i] = a[i+1];
    }
    a[nElems-1] = 0;
    nElems--;
    return true;
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
}
