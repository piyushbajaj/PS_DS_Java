package Session.Uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: Session.Uber
 * <p>
 * User: piyushbajaj
 * Date: 05/02/25
 * Time: 3:22 pm
 * <p>
 * Step 1: Build the Graph
 * Step 2: With BFS technique and using HashSet lets gets the best exchange rate
 */
public class CurrencyExchange {

    Map<String, Map<String, Float>> currencyExchangeMap;

    public CurrencyExchange() {
        this.currencyExchangeMap = new HashMap<>();
    }

    static class Node {
        String sourceCurrency;
        String destinationCurrency;
        float exchangeRate;

        public Node(String sourceCurrency, String destinationCurrency, float exchangeRate) {
            this.sourceCurrency = sourceCurrency;
            this.destinationCurrency = destinationCurrency;
            this.exchangeRate = exchangeRate;
        }
    }

    /**
     * TC: O(N)
     *
     * @param data
     */
    public void buildCurrencyGraph(final List<Node> data) {
        for (final Node node : data) {
            this.currencyExchangeMap.computeIfAbsent(node.sourceCurrency,
                k -> new HashMap<>()).put(node.destinationCurrency, node.exchangeRate);

            this.currencyExchangeMap.computeIfAbsent(node.destinationCurrency,
                k -> new HashMap<>()).put(node.sourceCurrency, 1.0f / node.exchangeRate);

        }
    }

    public float getBestPrice_dfs(final String source, final String target) {
        Set<String> visitedCurrency = new HashSet<>();
        return getBestPrice_dfs_util(source, target, visitedCurrency, 1f);
    }

    private float getBestPrice_dfs_util(final String source, final String target, Set<String> visitedCurrency,
                                        float rate) {
        if (Objects.equals(source, target)) {
            return rate;
        }

        visitedCurrency.add(source);

        float maxRate = -1;

        if (this.currencyExchangeMap.containsKey(source)) {
            Map<String, Float> next = currencyExchangeMap.get(source);
            for (String key : next.keySet()) {
                if (visitedCurrency.contains(key)) {
                    continue;
                }

                float currRate = getBestPrice_dfs_util(key, target, visitedCurrency, rate * next.get(key));
                maxRate = Math.max(maxRate, currRate);
            }
        }

        return maxRate;
    }

    /**
     * TC: O(N*M)
     *
     * @param source
     * @param target
     * @return
     */
    private float getBestPrice(final String source, final String target) {
        if (this.currencyExchangeMap == null || this.currencyExchangeMap.isEmpty()) {
            return -1;
        }

        final Queue<String> currencyQueue = new LinkedList<>();
        final Queue<Float> exchangeRateQueue = new LinkedList<>();
        currencyQueue.offer(source);
        exchangeRateQueue.offer(1f);
        Set<String> visitedCurrency = new HashSet<>();
        float optimalRate = -1f;
        while (!currencyQueue.isEmpty()) {
            String currentCurr = currencyQueue.poll();
            float currentRate = 0;
            if (exchangeRateQueue.peek() != null) {
                currentRate = exchangeRateQueue.poll();
            }
            if (visitedCurrency.contains(currentCurr)) {
                continue;
            }
            visitedCurrency.add(currentCurr);
            if (this.currencyExchangeMap.containsKey(currentCurr)) {
                Map<String, Float> next = currencyExchangeMap.get(currentCurr);
                for (String key : next.keySet()) {
                    if (!visitedCurrency.contains(key)) {
                        currencyQueue.offer(key);
                        if (key.equals(target)) {
                            optimalRate = Math.max(currentRate * next.get(key), optimalRate);
                        }
                        exchangeRateQueue.offer(currentRate * next.get(key));
                    }
                }
            }
        }
        return optimalRate;
    }

//    private float getBestPrice_delta(final String source, final String target) {
//        if (this.currencyExchangeMap == null || this.currencyExchangeMap.isEmpty()) {
//            return -1;
//        }
//
//        final Queue<String> currencyQueue = new LinkedList<>();
//        final Queue<Float> exchangeRateQueue = new LinkedList<>();
//        currencyQueue.offer(source);
//        exchangeRateQueue.offer(1f);
//        Set<String> visitedCurrency = new HashSet<>();
//        float optimalRate = -1f;
//        while (!currencyQueue.isEmpty()) {
//            String currentCurr = currencyQueue.poll();
//            float currentRate = 0;
//            if (exchangeRateQueue.peek() != null) {
//                currentRate = exchangeRateQueue.poll();
//            }
//
//            if (currentCurr.equals(target)) {
//                optimalRate = Math.max(currentRate * next.get(key), optimalRate);
//            }
//
//
//            if (visitedCurrency.contains(currentCurr)) {
//                continue;
//            }
//            visitedCurrency.add(currentCurr);
//            if (this.currencyExchangeMap.containsKey(currentCurr)) {
//                Map<String, Float> next = currencyExchangeMap.get(currentCurr);
//                for (String key : next.keySet()) {
//                    if (!visitedCurrency.contains(key)) {
//                        currencyQueue.offer(key);
//                        if (key.equals(target)) {
//                            optimalRate = Math.max(currentRate * next.get(key), optimalRate);
//                        }
//                        exchangeRateQueue.offer(currentRate * next.get(key));
//                    }
//                }
//            }
//        }
//        return optimalRate;
//    }

    public static void main(String[] args) {
//        CurrencyExchange currencyExchange = new CurrencyExchange();
//
//        // Test 1
//        List<Node> data = new ArrayList<>();
//        data.add(new Node("USD", "JPY", 110));
//        data.add(new Node("USD", "AUD", 1.45));
//        data.add(new Node("JPY", "GBP", 0.0070));
//
//        // Build Current Graph Relationship
//        currencyExchange.buildCurrencyGraph(data);
//
//        // Get Best Optimal Exchange Rate
//        System.out.println("GBP -> AUD: " + currencyExchange.getBestPrice("GBP", "AUD"));
//
//        // Test 2
//        CurrencyExchange currencyExchange2 = new CurrencyExchange();
//        List<Node> data2 = new ArrayList<>();
//
//        data2.add(new Node("GBP", "EUR", 10));
//        data2.add(new Node("EUR", "USD", 1.1));
//
//        // Build Current Graph Relationship
//        currencyExchange2.buildCurrencyGraph(data2);
//
//        // Get Best Optimal Exchange Rate
//        System.out.println("10 GBP -> USD: " + currencyExchange2.getBestPrice("GBP", "USD") * 10);
//
//        // Test 3
//        CurrencyExchange currencyExchange3 = new CurrencyExchange();
//        List<Node> data3 = new ArrayList<>();
//
//        data3.add(new Node("GBP", "EUR", 10));
//        data3.add(new Node("EUR", "USD", 1.1));
//        data3.add(new Node("USD", "JPY", 1080.3));
//
//        // Build Current Graph Relationship
//        currencyExchange3.buildCurrencyGraph(data3);
//
//        // Get Best Optimal Exchange Rate
//        System.out.println("10 GBP -> JPY: " + currencyExchange3.getBestPrice("GBP", "JPY") * 10);
//
//
//        // Test 4
//        CurrencyExchange currencyExchange4 = new CurrencyExchange();
//        List<Node> data4 = new ArrayList<>();
//
//        data4.add(new Node("GBP", "CAD", 1.671));
//        data4.add(new Node("INR", "CAD", 0.0185));
//        data4.add(new Node("CAD", "EUR", 0.685));
//
//        // Build Current Graph Relationship
//        currencyExchange4.buildCurrencyGraph(data4);
//
//        // Get Best Optimal Exchange Rate
//        System.out.println("EUR -> INR: " + currencyExchange4.getBestPrice("EUR", "INR"));
//
//
//        // Test 5
//        CurrencyExchange currencyExchange5 = new CurrencyExchange();
//        List<Node> data5 = new ArrayList<>();
//
//        data5.add(new Node("EUR", "USD", 1.1));
//        data5.add(new Node("USD", "INR", 70.0));
//        data5.add(new Node("INR", "JPY", 1.5));
//        data5.add(new Node("EUR", "GBP", 0.9));
//        data5.add(new Node("GBP", "MP", 27.3));
//        data5.add(new Node("MP", "JPY", 4.7));
//
//        // Build Current Graph Relationship
//        currencyExchange5.buildCurrencyGraph(data5);
//
//        // Get Best Optimal Exchange Rate
//        System.out.println("10 EUR -> JPY: " + currencyExchange5.getBestPrice("EUR", "JPY") * 10);

        // Test 6
        CurrencyExchange currencyExchange6 = new CurrencyExchange();
        List<Node> data6 = new ArrayList<>();

        data6.add(new Node("GBP", "EUR", 10));
        data6.add(new Node("EUR", "USD", 1.1F));
        data6.add(new Node("EUR", "JPY", 900));
        data6.add(new Node("USD", "JPY", 1080.3f));

        // Build Current Graph Relationship
        currencyExchange6.buildCurrencyGraph(data6);

        // Get Best Optimal Exchange Rate
        System.out.println("10 GBP -> JPY: " + currencyExchange6.getBestPrice_dfs("GBP", "JPY") * 10);

    }
}



