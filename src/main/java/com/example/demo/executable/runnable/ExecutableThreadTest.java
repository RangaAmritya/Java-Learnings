//package com.example.demo.executable.runnable;
//
//
//import java.util.concurrent.*;
//public class ExecutableThreadTest {
//
//    public static void main(String []args){
//
//        long initTime = System.currentTimeMillis();
//        int arr[] = new int[100];
//        for(int i=0;i<arr.length;i++){
//            arr[i]=i;
//        }
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        executorService.submit(()->{
//            for(int i=0;i<arr.length/2;i++){
//                if(arr[i]%2==0){
//                    System.out.println("even : "+arr[i]);
//                }
//                try{
//                    Thread.sleep(100);
//                }catch (InterruptedException ex){
//                    ex.getMessage();
//                }
//
//            }
//        });
//        executorService.submit(()->{
//           for(int i=arr.length/2;i<arr.length;i++){
//               if(arr[i]%2!=0){
//                   System.out.println("odd : "+arr[i]);
//               }
//               try{
//                   Thread.sleep(100);
//               }catch (InterruptedException ex){
//                   ex.getMessage();
//               }
//           }
//        });
//
//        executorService.shutdown();
//        try {
//            executorService.awaitTermination(10,TimeUnit.SECONDS );
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("total time : "+(endTime-initTime));
//        // total time = 5539
//    }
//}
