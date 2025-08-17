package com.learn.app.concepts.threading.locking.advancedlock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Imagine a system where:*****
 * Many threads read configuration settings frequently.
 * Occasionally, an admin thread updates the configuration.
 * Using ReadWriteLock improves performance by allowing concurrent reads while ensuring exclusive access for writes.
 * */

public class ReadWriteLockOperation {
    private final Map<String, String> config = new HashMap<>();
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public String readConfig(String key) {
        readLock.lock();
        try {
            String value = config.get(key);
            System.out.println("Reading configuration by: " + Thread.currentThread().getName() + " Value: " + value);
            return value;
        } finally {
            readLock.unlock();
        }
    }

    public void writeConfig(String key, String value) {
        writeLock.lock();
        try {
            config.put(key, value);
            System.out.println("Writing configuration by: " + Thread.currentThread().getName() + " Key: " + key + " Value: " + value);
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ReadWriteLockOperation readWriteLockOperation = new ReadWriteLockOperation();
        for (int i = 0; i < 5; i++) {
            final int index = i;
            executorService.execute(() -> {
                readWriteLockOperation.writeConfig("key" + index, "value" + index);
            });
        }
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNum = rand.nextInt(5) + 1;

            executorService.execute(() -> {
                readWriteLockOperation.readConfig("key" + randomNum);
            });
        }
        executorService.close();
    }
}
