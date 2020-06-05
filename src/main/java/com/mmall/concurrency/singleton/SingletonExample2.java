package com.mmall.concurrency.singleton;

/**
 * @author shuhao
 * @date 2020/6/5 19:46
 */

import com.mmall.concurrency.annoation.NotRecommend;
import com.mmall.concurrency.annoation.ThreadSafe;

/**
 * 对懒汉式的改进1
 * 这里直接对getInstance()方法加上synchronized关键字,
 * 虽然保证了只会创造出一个实例,但是执行效率却会大大降低
 */
@ThreadSafe
@NotRecommend
public class SingletonExample2 {
    
    private SingletonExample2(){
    
    }
    
    private static SingletonExample2 instance = null;
    
    public static synchronized SingletonExample2 getInstance(){
        if(instance == null){
            instance = new SingletonExample2();
        }
        return instance;
    }
}
