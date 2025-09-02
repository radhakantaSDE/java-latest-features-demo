package com.learn.app.concepts.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
  private final int capacity;

  public LRUCache(int capacity) {
    super(capacity, 0.75f, true); // true = access order
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > capacity;
  }

  public static void main(String[] args) {
    LRUCache<Integer, String> cache = new LRUCache<>(3);

    cache.put(1, "One");
    cache.put(2, "Two");
    cache.put(3, "Three");

    cache.get(1); // Access 1 to make it recently used
    cache.put(4, "Four"); // This should evict key 2

    System.out.println(cache); // Output: {3=Three, 1=One, 4=Four}
  }
}
