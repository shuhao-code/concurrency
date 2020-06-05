package com.mmall.concurrency.singleton;

/**
 * @author shuhao
 * @date 2020/6/5 19:46
 */

import com.mmall.concurrency.annoation.Recommend;
import com.mmall.concurrency.annoation.ThreadSafe;
import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * 通过枚举的方式进行单例设计   [推荐使用]
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {
    
    private SingletonExample7(){
    
    }
    
    public static SingletonExample7 getInstance(){
        return EnumSinleton.INSTANCE.getInstance();
    }
    
    private enum EnumSinleton {
        INSTANCE;
        private SingletonExample7 instance = null;
        
        private EnumSinleton(){
            instance = new SingletonExample7();
        }
        
        private SingletonExample7 getInstance(){
            return instance;
        }
    }
    
    
    
    
    
}
