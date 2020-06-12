package com.yurets_y.spring_tutor_001.lazy_bin_init;

public class MasterComponent {
    private LazyComponent lazyComponent;

    public MasterComponent() {
        System.out.println("Master component init (void constructor)...");
    }

    public MasterComponent(LazyComponent lazyComponent) {
        System.out.println("Master component init...");
        this.lazyComponent = lazyComponent;
    }

    public void useComponent(){
        System.out.println("Master component use lazy component...");
        lazyComponent.doSomething();
    }

    public void setLazyComponent(LazyComponent lazyComponent) {
        System.out.println("Use setter init method....");
        this.lazyComponent = lazyComponent;
    }
}
