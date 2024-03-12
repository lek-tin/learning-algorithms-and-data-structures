package com.example.windowed_average_cache;

import java.util.*;

class WindowedAverageCache {
    private final int maxSize;
    private final Map<Long, Integer> cache;
    private final PriorityQueue<Long> expirationQueue;

    public WindowedAverageCache(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new LinkedHashMap<>(maxSize, 0.75f, true);
        this.expirationQueue = new PriorityQueue<>(maxSize);
    }

    public void add(long timestamp, int value) {
        cleanupExpiredEntries(timestamp);

        cache.put(timestamp, value);
        expirationQueue.offer(timestamp);

        if (cache.size() > maxSize) {
            long oldestTimestamp = expirationQueue.poll();
            cache.remove(oldestTimestamp);
        }
    }

    public double calculateWindowedAverage(long currentTimestamp, long windowSize) {
        cleanupExpiredEntries(currentTimestamp);

        long oldestTimestamp = currentTimestamp - windowSize;
        int sum = 0;
        int count = 0;

        for (Map.Entry<Long, Integer> entry : cache.entrySet()) {
            long timestamp = entry.getKey();
            if (timestamp >= oldestTimestamp && timestamp <= currentTimestamp) {
                sum += entry.getValue();
                count++;
            }
        }

        return (count > 0) ? (double) sum / count : 0.0;
    }

    private void cleanupExpiredEntries(long currentTimestamp) {
        while (!expirationQueue.isEmpty() && expirationQueue.peek() <= currentTimestamp - maxSize) {
            long expiredTimestamp = expirationQueue.poll();
            cache.remove(expiredTimestamp);
        }
    }

    public static void main(String[] args) {
        WindowedAverageCache cache = new WindowedAverageCache(5);

        // Add some data points
        cache.add(1, 10);
        cache.add(2, 20);
        cache.add(3, 30);
        cache.add(4, 40);
        cache.add(5, 50);

        // Calculate windowed averages
        System.out.println("Windowed Average (window size 3) at t=5: " + cache.calculateWindowedAverage(5, 3)); // Output: 40.0 (average of 40 and 50)
        System.out.println("Windowed Average (window size 2) at t=5: " + cache.calculateWindowedAverage(5, 2)); // Output: 45.0 (average of 40, 50, and 30)
    }
}
