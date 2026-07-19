package com.user.userinfo.learntest;

import java.util.concurrent.atomic.AtomicInteger;

class Singleton{
//    private static Singleton instance = new Singleton();
    private Singleton(){

    }
//    public static Singleton getInstance(){
//        return instance;
//    }

    private static Singleton instance;

    public static Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }


}

class AtomicClass{

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void   increment(){
        atomicInteger.incrementAndGet();
    }

    public void   decrement(){
        atomicInteger.decrementAndGet();
    }

    public void   set(){
        boolean b = atomicInteger.compareAndSet(0, 12345);
        System.out.println("Atomic Integer Value: "+atomicInteger.get()+" Compare and Set Result: "+b);
    }

    public int get(){
        return atomicInteger.get();
    }

}

public class CodeTest {

    public static void main(String[] args) {

//        Thread t1 = new Thread(() -> {
//            System.out.println(Singleton.getInstance().hashCode());
//        });
//
//        Thread t2 = new Thread(() -> {
//            System.out.println(Singleton.getInstance().hashCode());
//        });
//
//        t1.start();
//        t2.start();

//        AtomicClass atomicClass = new AtomicClass();
//
//        Thread thread1 = new Thread(()->{
//            for(int i=0;i<10000;i++){ atomicClass.increment();}
//        });
//
//        Thread thread2 = new Thread(()->{
//            for(int i=0;i<10000;i++){ atomicClass.increment();}
//        });
//        System.out.println("Atomic Integer Value: "+atomicClass.get());
//
//        thread1.start();
//        thread2.start();
//
//        System.out.println("Atomic Integer Value: "+atomicClass.get());
//
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Atomic Integer Value: "+atomicClass.get());


        try {
            int a=10/0;
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }


    }

}
