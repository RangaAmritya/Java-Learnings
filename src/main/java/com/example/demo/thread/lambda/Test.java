package com.example.demo.thread.lambda;

public class Test {


    public static void main(String [] args) throws InterruptedException {

        long initTime = System.currentTimeMillis();
        int arr[] = new int[100];

        for(int i=0;i<=99;i++){
            arr[i]=i;
        }
        Thread thread1=firstHalf(0, arr.length/2,arr);
        Thread thread2=secondHalf(arr.length/2, arr.length, arr);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        firstHalf1(0, arr.length/2,arr);
        secondHalf1(arr.length/2, arr.length, arr);


        long endTime = System.currentTimeMillis();
        System.out.println("Total Time : "+ (endTime-initTime));
    }

    private static void firstHalf1(int start, int end, int[] arr) {

        for(int i=start;i<end;i++){
            if(arr[i]%2==0){
                System.out.println("even : "+arr[i]);
            }
            try{
                Thread.sleep(100);
            }catch (InterruptedException ex){
                ex.getMessage();
            }
        }
    }

    private static void secondHalf1(int start, int end, int[] arr) {

        for (int i = start; i < end; i++) {
            if (arr[i] % 2 != 0) {
                System.out.println("odd : " + arr[i]);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        }
    }

    public static Thread firstHalf(int start,int end,int arr[])throws InterruptedException{
       return new Thread(()->{
            for(int i=start;i<end;i++){
                if(arr[i]%2==0){
                    System.out.println("even : "+arr[i]);
                }
                try{
                    Thread.sleep(100);
                }catch (InterruptedException ex){
                    ex.getMessage();
                }
            }
        });
    }

    public static Thread secondHalf(int start,int end,int arr[]){
        return new Thread(()->{
           for(int i=start;i<end;i++){
               if(arr[i]%2!=0){
                   System.out.println("odd : "+arr[i]);
               }
               try{
                   Thread.sleep(100);
               }catch (InterruptedException ex){
                   ex.getMessage();
               }
           }
        });
    }





}
