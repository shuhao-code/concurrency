package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author shuhao
 * @date 2020/6/8 20:55
 */
@Slf4j
public class CountDownLatchExample2 {
    
    private final static int threadCount = 200;
    private static int count = 0;
    
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        
        for(int i = 0; i < 5000; i++){
            final int threadNum = i;
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
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        
        log.info("count : {}", count);
        
        exec.shutdown();
    }
    
    private static void add() throws Exception{
        //Thread.sleep(100);
        //log.info("{}", threadNum);
        count++;
    }
    
    
    
    
}
