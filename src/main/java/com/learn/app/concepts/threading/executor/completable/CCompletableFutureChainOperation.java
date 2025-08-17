package com.learn.app.concepts.threading.executor.completable;

import java.util.concurrent.CompletableFuture;

public class CCompletableFutureChainOperation {

    public void testThenApply() {

        // Step-1 : Call Search Service
        CompletableFuture<Integer> cfCallSearchService = CompletableFuture.supplyAsync(() -> {
            int result = 5; // Simulated result from search service
            try {
                Thread.sleep(1000); // Simulating a delay
                System.out.println("Executed Search Service "+result+"... Thread : "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e.getMessage());
            }
            return result ; // Simulated result from search service
        });

        // Step-2 : Call Price Service using the result from Search Service
        CompletableFuture<Integer> cfCallPriceService = cfCallSearchService.thenApply(searchResult -> {
            int priceRes = searchResult * 10; // Simulated calculation based on search result
            try {
                Thread.sleep(1000); // Simulating a delay
                System.out.println("Executed Price Result: " + priceRes + "... Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e.getMessage());
            }
            return priceRes; // Simulated result from price service
        });

        // Wait for the final result
        try {
            Integer finalResult = cfCallPriceService.get(); // Blocking call to get the final result
            System.out.println("Final Result: " + finalResult);
        } catch (Exception e) {
            System.out.println("Error occurred while waiting for the result: " + e.getMessage());
        }
    }


    public void testThenCompose() {

        CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> {return "John";});
        CompletableFuture<String> greetingFuture = nameFuture.thenCompose(name ->
            CompletableFuture.supplyAsync(() -> "Hello, " + name + "!"));

        greetingFuture.thenAccept(e -> System.out.println("Greeting: " + e));
    }

    public static void main(String[] args) {
        CCompletableFutureChainOperation operation = new CCompletableFutureChainOperation();
        operation.testThenApply();
        operation.testThenCompose();
    }


}
