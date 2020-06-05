package com.mmall.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shuhao
 * @date 2020/6/5 16:42
 */
@Slf4j
public class Escape {
    
    private int thisCanBeEscape = 5;
    
    public Escape(){
        new InnerClass();
    }
    
    private class InnerClass {
        
        public InnerClass(){
            log.info("{}", Escape.this.thisCanBeEscape);
        }
        
        
    }
    
    public static void main(String[] args) {
        Escape escape = new Escape();
    }
    
    
}
