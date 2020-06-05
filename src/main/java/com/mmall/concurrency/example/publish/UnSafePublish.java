package com.mmall.concurrency.example.publish;

import com.mmall.concurrency.annoation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author shuhao
 * @date 2020/6/5 16:33
 */
@Slf4j
@NotThreadSafe
public class UnSafePublish {
    
    private String[] states = {"a","b","c"};
    
    public String[] getStates(){
        return states;
    }
    
    
    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        log.info("states {}",Arrays.toString(unSafePublish.getStates()));
        unSafePublish.getStates()[0] = "d";
        log.info("states {}",Arrays.toString(unSafePublish.getStates()));
    }
    
    
}
