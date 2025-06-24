//package com.example.demo.virtualThreads;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.IntStream;
//
//public class VirtualThreadsTest {
//
//    public static void main(String[] args) throws InterruptedException {
//
////        ExecutorService executor = Executors.newFixedThreadPool(100);
////
////        long start = System.currentTimeMillis();
////
////        for (int i = 0; i < 1000; i++) {
////            executor.submit(() -> {
////                try {
////                    Thread.sleep(1000);  // Simulate I/O
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            });
////        }
////
////        executor.shutdown();
////        executor.awaitTermination(5, TimeUnit.MINUTES);
////
////        long end = System.currentTimeMillis();
////        System.out.println("Traditional Threads Time: " + (end - start) + "ms");
//
//        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
//
//        long start = System.currentTimeMillis();
//
//        for (int i = 0; i < 1000; i++) {
//            executor.submit(() -> {
//                try {
//                    Thread.sleep(1000);  // Simulate I/O
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        executor.shutdown();
//        executor.awaitTermination(5, TimeUnit.SECONDS);
//
//        long end = System.currentTimeMillis();
//        System.out.println("Virtual Threads Time: " + (end - start) + "ms");
//    }
//}