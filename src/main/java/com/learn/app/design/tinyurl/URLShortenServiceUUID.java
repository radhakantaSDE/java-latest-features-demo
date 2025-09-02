package com.learn.app.design.tinyurl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class URLShortenServiceUUID {

  private Map<String, String> longUrlMap = new HashMap<>();
  private Map<String, String> shortUrlMap = new HashMap<>();
  private static final String BASE_URL = "http://ping.com/";
  private static final String ALPHABET =
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  public String shortenURL(String longURL) {

    if (longUrlMap.containsKey(longURL)) {
      return longUrlMap.get(longURL);
    }

    // Generate UUID for uniqueness
    String uuid = UUID.randomUUID().toString();
    String shortKey = generateCodeFromHash(uuid.hashCode());

    while (shortUrlMap.containsKey(shortKey)) {
      uuid = UUID.randomUUID().toString();
      shortKey = generateCodeFromHash(uuid.hashCode());
    }

    longUrlMap.put(longURL, BASE_URL + shortKey);
    shortUrlMap.put(shortKey, longURL);

    return BASE_URL + shortKey;
  }

  private String generateCodeFromHash(int hash) {

    StringBuilder shortKey = new StringBuilder();
    int base = ALPHABET.length(); // 62
    while (hash != 0) {
      shortKey.append(ALPHABET.charAt(Math.abs(hash % base)));
      hash /= base;
    }
    return shortKey.toString();
  }

  public static void main(String[] args) {

    URLShortenServiceUUID urlShortenService = new URLShortenServiceUUID();
    String longURL = "https://m365.cloud.microsoft/chat/?auth=2&origindomain=microsoft365";
    String shortURL = urlShortenService.shortenURL(longURL);
    System.out.println("Shortened URL: " + shortURL);
  }
}
