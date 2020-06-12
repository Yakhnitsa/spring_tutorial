package com.yurets_y.spring_tutor_001.lazy_bin_init;

public class LazyComponent {

    public LazyComponent() {
        System.out.println("Lazy component init...");
    }

    public void doSomething(){
        System.out.println("Lazy component do something");
    }
}
