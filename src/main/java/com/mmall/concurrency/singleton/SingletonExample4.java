package com.mmall.concurrency.singleton;

/**
 * @author shuhao
 * @date 2020/6/5 19:46
 */

/**
 * 饿汉式的单例设计模式
 * 创建对象的时机是在SingletonExample4这个类被系统装载的时候,
 * 这会导致系统开机负担增大,并且如果系统运行过程中并没有使用这个单例对象,那么就会造成资源浪费
 */
public class SingletonExample4 {
    
    private SingletonExample4(){
    
    }
    
    private static SingletonExample4 instance = new SingletonExample4();
    
    public static synchronized SingletonExample4 getInstance(){
        return instance;
    }
}
