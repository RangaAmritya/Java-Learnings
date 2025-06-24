package com.example.demo.executable.advance;

import java.util.Arrays;
import java.util.concurrent.*;

public class ExecutableAdvanceTest {

    public static void main(String [] args) throws ExecutionException,InterruptedException {
        long initialTime = System.currentTimeMillis();
        int arr[] = new int[100];
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> sumOfEven = ()-> Arrays.stream(arr)
                .peek(e -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }).filter(e->e%2==0).sum();

        Callable<Integer> sumOfOdd = ()->Arrays.stream(arr)
                .peek(e -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }).filter(e->e%2!=0).sum();
        Future<Integer> evenSum = executorService.submit(sumOfEven);
        Future<Integer> oddSum = executorService.submit(sumOfOdd);
        Integer resultEven = evenSum.get();
        Integer resultOdd = oddSum.get();
        int resultEven1 = Arrays.stream(arr).peek(e -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }).filter(e->e%2==0).sum();

        int resultOdd1 = Arrays.stream(arr)
                .peek(e -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .filter(e->e%2!=0).sum();

        System.out.println(resultOdd);
        System.out.println(resultEven);
        long endTime = System.currentTimeMillis();

        System.out.println("total time : "+(endTime-initialTime));
        // result of executable with callable and future function
//        2500
//        2450
//        total time : 1603


        // without executable
//        2500
//        2450
//        total time : 3246
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available logical processors: " + cores);


    }


}
