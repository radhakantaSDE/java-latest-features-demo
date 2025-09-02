package com.learn.app.concepts.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapOperation {

  public void linkedHashMapExamples() {

    // Ex-1 : Access order
    Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);

    linkedHashMap.put("A", 1);
    linkedHashMap.put("B", 2);
    linkedHashMap.put("C", 3);

    linkedHashMap.get("A");
    linkedHashMap.get("B");

    linkedHashMap.put("D", 4);

    System.out.println(linkedHashMap);
  }
}
