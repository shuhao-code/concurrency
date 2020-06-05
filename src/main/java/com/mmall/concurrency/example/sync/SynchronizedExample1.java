package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shuhao
 * @date 2020/6/5 15:37
 */
@Slf4j
public class SynchronizedExample1 {
    
    public void test1() {
        synchronized (this) {
            for(int i = 0; i < 10; i++){
                //log.info("test1 -> {}", i);
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
    
    
    public synchronized void test2(){
        for(int i = 0; i < 10; i++){
            //log.info("test2 -> {}", i);
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
    
    
    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        executorService.execute(() -> {
            example1.test1();
        });
        executorService.execute(() -> {
            example1.test1();
        });
    }
    
    
}
