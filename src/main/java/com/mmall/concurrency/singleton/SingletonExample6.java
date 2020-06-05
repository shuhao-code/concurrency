package com.mmall.concurrency.singleton;

/**
 * @author shuhao
 * @date 2020/6/5 19:46
 */

import com.mmall.concurrency.annoation.Recommend;
import com.mmall.concurrency.annoation.ThreadSafe;

/**
 * 通过静态内部类的方式进行单例设计   [推荐使用]
 * 优点:
 *      静态内部类的优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。
 *      即当SingleTon第一次被加载时，并不需要去加载SingleTonHoler，只有当getInstance()方法第一次被调用时，
 *      才会去初始化INSTANCE,第一次调用getInstance()方法会导致虚拟机加载SingleTonHoler类，
 *      这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
 */
@ThreadSafe
@Recommend
public class SingletonExample6 {
    
    private SingletonExample6(){
    
    }
    
    public static  SingletonExample6 getInstance(){
        return InnerClass.instance;
    }
    
    
    private static class InnerClass {
        private static SingletonExample6 instance = new SingletonExample6();
    }
    
    
}
