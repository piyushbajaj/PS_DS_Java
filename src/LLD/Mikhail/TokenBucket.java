package LLD.Mikhail;

import java.util.concurrent.TimeUnit;

/**
 * Project: DS_Algo
 * Package: LLD.MIkhail
 * <p>
 * User: piyushbajaj
 * Date: 15/03/23
 * Time: 8:22 am
 * <p>
 * Reference (Mikhail System Design):
 * <a href="https://www.youtube.com/watch?v=FU4WlwfS3G0&list=PL0evysyBWYO4n2wkp1UgqpUfSsXnu5EMf&index=5&ab_channel=SystemDesignInterview">...</a>
 */
public class TokenBucket {
    private final long maxBucketSize;
    private final long refillRate;

    private double currentBucketSize;
    private long lastRefillTimestamp;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        // Number of tokens initially is equal to the maximum capacity
        this.currentBucketSize = maxBucketSize;

        // Current time in nanoseconds
        this.lastRefillTimestamp = System.nanoTime();
    }

    // Synchronized, as several threads maybe calling the method concurrently
    public synchronized boolean allowRequest(int tokens) {
        // First, refill bucket with tokens accumulated since the last call
        refill();

        // If bucket has enough tokens, call is allowed
        if (currentBucketSize >= tokens) {
            currentBucketSize = currentBucketSize - tokens;

            System.out.println("currentBucketSize after deduction: " + currentBucketSize);

            return true;
        }

        // Request is throttled as bucket doesn't have enough tokens
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        // This many tokens accumulated since the last refill
        double tokensToAdd = (now - lastRefillTimestamp) * refillRate / 1e9;
        System.out.println("Current TimeStamp: " + now);
        System.out.println("tokensToAdd: " + tokensToAdd);
        // Number of tokens should never exceed maximum capacity
        currentBucketSize = Math.min(currentBucketSize + tokensToAdd, maxBucketSize);
        System.out.println("currentBucketSize: " + currentBucketSize);
        lastRefillTimestamp = now;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(10, 10);
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println(tokenBucket.allowRequest(6));
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println(tokenBucket.allowRequest(5));
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(tokenBucket.allowRequest(5));
    }
}
