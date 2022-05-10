package com.chao.genericity;

public class Apple<T> {
    
    private T info;
    
    public Apple() {}
    
    public Apple(T info) {
        this.info = info;
    }
    
    public void setInfo(T info) {
        this.info = info;
    }
    
    public T getInfo() {
        return this.info;
    }

    public static void main(String[] args) {
        Apple<String> al = new Apple<String>("苹果");
        new Apple<Double>(5.67);
    }
}
