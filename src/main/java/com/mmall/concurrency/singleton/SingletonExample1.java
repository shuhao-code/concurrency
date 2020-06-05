package com.mmall.concurrency.singleton;

/**
 * @author shuhao
 * @date 2020/6/5 19:46
 */

import com.mmall.concurrency.annoation.NotThreadSafe;

/**
 * 懒汉式单例模式
 * 对于单线程而言，这个程序不存在问题，
 * 但是对于多线程程序，可能创造出来不止一个对象，那么此时就不是单例模式了
 *
 */
@NotThreadSafe
public class SingletonExample1 {
    
    private SingletonExample1(){
    
    }
    
    private static SingletonExample1 instance = null;
    
    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
