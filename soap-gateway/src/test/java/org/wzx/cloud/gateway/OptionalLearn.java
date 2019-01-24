package org.wzx.cloud.gateway;

import org.junit.Test;

import java.util.Optional;

public class OptionalLearn {

    @Test
    public void test(){
        Optional<String> opt = Optional.ofNullable(null);
        Optional<String> opt1 = Optional.empty();
        System.out.println(opt.equals(opt1));
        System.out.println(opt.orElse("anime"));
        System.out.println(opt1.orElseGet(()->"burn"));
    }

}
