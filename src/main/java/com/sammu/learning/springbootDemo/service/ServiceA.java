package com.sammu.learning.springbootDemo.service;

import com.sammu.learning.springbootDemo.component.TestA;
import com.sammu.learning.springbootDemo.component.TestB;

public class ServiceA {

    TestA testA;

    TestB testB;

    public ServiceA(TestA testA){
        this.testA = testA;

        testB = testB;

    }

    public void printService(){
        testA.printClassName();
        testB.printClassName();
    }
}
