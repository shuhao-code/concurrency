package com.mmall.concurrency.singleton;

/**
 * @author shuhao
 * @date 2020/6/5 19:46
 */

import com.mmall.concurrency.annoation.ThreadSafe;

@ThreadSafe
public class SingletonExample5 {
    
    private SingletonExample5(){
    
    }
    
    //这里使用volatile关键字,可以防止JVM进行指令重排
    private volatile static SingletonExample5 instance = null;
    
    public static synchronized SingletonExample5 getInstance(){
        if(instance == null){
            synchronized (SingletonExample1.class){
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
