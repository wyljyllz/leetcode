package test.service;

import test.dao.Eat;

/**
 * @ClassName eatIml
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class eatIml implements Eat {
    @Override
    public void eat() {
        System.out.println("开始吃午饭");
    }
}
