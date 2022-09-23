package com.example.demo;

import java.util.ArrayList;
import java.util.Queue;

public class A {

    public A(){}
    int lastUpdatedValue =1;

    public void printEven() {
        synchronized (this) {
            while(lastUpdatedValue <20) {
                while (lastUpdatedValue % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd Thread :" + lastUpdatedValue);
                lastUpdatedValue++;
                notify();
            }
        }
    }
    public void printOdd() {
        synchronized (this) {
            while (lastUpdatedValue <20) {
                while (lastUpdatedValue % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd Thread :" + lastUpdatedValue);
                lastUpdatedValue++;
                notify();
            }
        }

    }
}