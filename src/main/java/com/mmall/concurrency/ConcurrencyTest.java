package com.mmall.concurrency;

import com.mmall.concurrency.annoation.NotThreadSafe;
import com.mmall.concurrency.annoation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author shuhao
 * @date 2020/6/4 22:12
 */
@Slf4j
@NotThreadSafe
public class ConcurrencyTest {
    
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;
    
    public static int count = 0;
    
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
    
//    public static void main(String[] args) throws Exception{
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        //final Semaphore semaphore = new Semaphore(threadTotal);
//        final CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
//        for(int i = 0; i < clientTotal; i++){
//            executorService.execute(() ->{
//                try {
//                    countDownLatch.countDown();
//                    countDownLatch.await();
//                    //semaphore.acquire();
//                    add();
//                    //semaphore.release();
//                } catch (Exception e) {
//                    log.error("exception",e);
//                }
//                //countDownLatch.countDown();
//            });
//        }
//        //countDownLatch.await();
//        executorService.shutdown();
//        log.info("count:{}", count);
//    }
    
    private static void add(){
        count++;
    }
    
    
}
