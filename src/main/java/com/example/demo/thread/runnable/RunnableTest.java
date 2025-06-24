package com.example.demo.thread.runnable;

public class RunnableTest {

    public static void main(String [] args) throws InterruptedException{

        long initialTime = System.currentTimeMillis();
        int arr[] = new int[100];
        for(int i=0;i<100;i++){
            arr[i]=i;
        }

        MyThread1 myThread1 = new MyThread1(arr,0,arr.length/2);
        MyThread2 myThread2 = new MyThread2(arr,arr.length/2, arr.length);
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


        long endTime = System.currentTimeMillis();
        System.out.println("total time : "+(endTime-initialTime));
    }
    static class MyThread1 implements Runnable{

        int arr[];
        int start;
        int end;
        public MyThread1(int[] arr,int start,int end) {
            this.arr=arr;
            this.start=start;
            this.end=end;

        }

        @Override
        public void run() {
            for(int i=start;i<arr.length;i++){
                if(arr[i]%2==0){
                    System.out.println("even : "+arr[i]);
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException ex){
                        ex.getMessage();
                    }

                }
            }
        }
    }
    static class MyThread2 implements Runnable {
        int arr[];
        int start;
        int end;
        MyThread2(int arr[],int start,int end){
            this.arr=arr;
        }
        @Override
        public void run(){
            for(int i=0;i<arr.length;i++){
                if(arr[i]%2!=0){
                    System.out.println("odd : "+arr[i]);
                }
                try{
                    Thread.sleep(100);
                }catch (InterruptedException ex){
                    ex.getMessage();
                }
            }
        }
    }
}
