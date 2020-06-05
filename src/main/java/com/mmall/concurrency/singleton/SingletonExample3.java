package com.mmall.concurrency.singleton;

/**
 * @author shuhao
 * @date 2020/6/5 19:46
 */

import com.mmall.concurrency.annoation.NotThreadSafe;

/**
 * 双重检查
 * 再次对懒汉式进行改进,使用双重检查的方式设计单例模式
 * 这是比较好的设计单例模式的思路,
 * 优点:
 *      1.通过懒加载的方式,保证系统快速启动,
 *      2.利用synchronized 关键字和双重检查保证只有一个单例对象
 */
@NotThreadSafe
public class SingletonExample3 {
    
    private SingletonExample3(){
    
    }
    
    private static SingletonExample3 instance = null;
    
    public static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            synchronized (SingletonExample1.class){
                if(instance == null){
                    instance = new SingletonExample3();
                }
            }
        }
        return instance;
    }
}
