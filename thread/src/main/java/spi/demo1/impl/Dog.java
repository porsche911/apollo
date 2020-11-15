package spi.demo1.impl;

import spi.demo1.IShout;

public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}
