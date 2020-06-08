package com.mmall.concurrency.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shuhao
 * @date 2020/6/8 20:55
 */
public class CountDownLatchExample1 {
    
    private final static int threadCount = 5;
    private static int count = 0;
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        
        for(int i = 0; i < 10; i++){
            exec.execute(()->{
                try {
                    add();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        
        System.out.println(count);
        exec.shutdown();
    }
    
    private static void add(){
        count++;
    }
    
    
    
    
}
