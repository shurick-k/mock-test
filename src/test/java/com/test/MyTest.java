package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;

@RunWith(MockitoJUnitRunner.class)
public class MyTest {
    @InjectMocks
    private ChildClass childClass = new ChildClass();

    @Mock
    private MyService service;

    @Test
    public void test1() {
        childClass.myMethod();
    }
}


class MyService {
    private String stringval;

    public String getStringval() {
        return stringval;
    }

    public void setStringval(String stringval) {
        this.stringval = stringval;
    }
}

class ChildClass extends ParentClass {

    public void myMethod() {

        String myval = callParentClassMethod();

    }
}

class ParentClass {

    @Inject
    private MyService myservice;
//there is no constructor or setter method for this injected object

    protected String callParentClassMethod() {
        return myservice.getStringval();
    }

}
