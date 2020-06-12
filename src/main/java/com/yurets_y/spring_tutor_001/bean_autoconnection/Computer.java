package com.yurets_y.spring_tutor_001.bean_autoconnection;

public class Computer {
    private Body body;

    private Monitor monitor;

    private Monitor monitor2;


    public Computer() {
    }

    public Computer(Body body) {
        this.body = body;
    }

    public Computer(Body body, Monitor monitor) {
        System.out.println("Constructor (body + monitor) used");
        this.body = body;
        this.monitor = monitor;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        System.out.println("set body method used");
        this.body = body;
    }

    public void setMonitor2(Monitor monitor2) {
        System.out.println("setSecondMonitor used");
        this.monitor2 = monitor2;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        System.out.println("set monitor method used");
        this.monitor = monitor;
    }
}
