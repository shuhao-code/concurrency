package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author shuhao
 * @date 2020/6/8 20:55
 */
@Slf4j
public class SemaphoneExample2 {
    
    private final static int threadCount = 20;
    
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        
        for(int i = 0; i < threadCount; i++){
            final int threadNum = i;
            exec.execute(()->{
                try {
                    semaphore.acquire(3);
                    add(threadNum);
                    semaphore.release(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        
        exec.shutdown();
    }
    
    private static void add(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{}", threadNum);
    }
    
    
    
    
}
