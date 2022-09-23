package com.example.demo;

public class MultiThreading {

//    static Integer lastUpdatedValue =0;

    static Object lock = new Object();
    public static void main(String[] args) {

//        MultiThreading multiThreading = new MultiThreading();
//        MyThread1 evenThread = new MyThread1(multiThreading);
//        MyThread2 oddThread = new MyThread2(multiThreading);
//        Integer lastUpdatedValue =0;
//        MyThread1 evenThread = new MyThread1(lastUpdatedValue);
//        MyThread2 oddThread = new MyThread2(lastUpdatedValue);
//        Object lock = new Object();
        A a= new A();
        Thread evenThread = new
        Thread(() -> {
            a.printEven();
        });
        Thread oddThread = new
                Thread(() -> {
           a.printOdd();
        });
        evenThread.start();
        oddThread.start();


//        OddEvenPrintMain oep = new OddEvenPrintMain();
//        Thread t1 = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                oep.printEven();
//
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                oep.printOdd();
//
//            }
//        });
//
//        t1.start();
//        t2.start();
    }

}
class OddEvenPrintMain {

    int count = 1;
    int MAX = 20;

    public void printOdd() {
        synchronized (this) {
            while(count<MAX) {
                while (count % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd Thread :" + count);
                count++;
                notify();
            }
        }
    }

    public void printEven() {

        synchronized (this) {
            while(count < MAX) {
                while (count % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even thread :" + count);
                count++;
                notify();
            }

        }
    }
}