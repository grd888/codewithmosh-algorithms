package org.gdelgado;

public class Array {
  private int[] items;
  private int count;

  public Array(int length) {
    items = new int[length];
  }

  public void insert(int n) {
    if (count == items.length) {
      int[] newItems = new int[count * 2];
      for (int i = 0; i < items.length; i++) {
        newItems[i] = items[i];
      }
      items = newItems;
    }
    items[count++] = n;
  }

  public void removeAt(int index) {
    if (index < 0 || index >= count) {
      throw new IllegalArgumentException();
    }
    for (int i = index; i < count; i++) {
      items[i] = items[i + 1];
    }
    count--;
  }

  public int indexOf(int item) {
    for (int i = 0; i < count; i++) {
      if (items[i] == item)
        return i;
    }
    return -1;
  }

  public int max() {
    int currentMax = Integer.MIN_VALUE;
    for (int i = 0; i < count; i++) {
      if (items[i] > currentMax)
        currentMax = items[i];
    }
    return currentMax;
  }

  public Array intersect(Array other) {
    Array common = new Array(1);
    for (int i = 0; i < count; i++) {
      if(other.indexOf(items[i]) != -1) {
        common.insert(items[i]);
      }
    }
    return common;
  }

  public void reverse() {
    int[] reversed = new int[items.length];
    int newCount = 0;
    for (int i = count - 1; i >= 0; i--) {
      reversed[newCount++] = items[i];
    }
    items = reversed;
  }

  public void insertAt(int item, int index) {
    if(count == items.length) {
      int[] newItems = new int[count * 2];
      for (int i = 0; i < items.length; i++) {
        newItems[i] = items[i];
      }
      items = newItems;
    }
    for(int i = count - 1; i >= index; i--) {
      items[i + 1] = items[i];
    }
    items[index] = item;
  }

  void print() {
    for (int i = 0; i < count; i++) {
      System.out.println(items[i]);
    }
  }
}
