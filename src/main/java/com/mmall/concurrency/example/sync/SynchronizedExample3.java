package com.mmall.concurrency.example.sync;

import com.mmall.concurrency.annoation.NotThreadSafe;
import com.mmall.concurrency.annoation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author shuhao
 * @date 2020/6/5 15:37
 */
@Slf4j
@NotThreadSafe
public class SynchronizedExample3 {
    
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;
    
    /*
    这里虽然对count变量增加volatile关键字，但是仍然无法保证线程安全性，分析见下面add()方法
     */
    public volatile static int count = 0;
    
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        for(int i = 0; i < clientTotal; i++){
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }
    
    
    private static void add(){
        count++;
        /*
        这里我们分析，线程进行加操作的时候进行了哪几步
        1.对volatile修饰的变量进行写之前必须从主存中取出该值 count
        2.执行加1操作
        3.强制把count变量写回主存
        
        volatile关键字只是规定了对变量操作前和操作后的要求，
        但是当两个线程同时进行第一步从主存中取出count，就会导致结果不正确。
        因为当一个线程对该变量使用时并未对该变量进行锁定
        
         */
    }
    
}
