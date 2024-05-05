package common;

import org.testng.annotations.Factory;

public class MyTestFactory{

    @Factory
    public Object[] createInstances() {
        return new Object[] {
            new MyTest(1, "A"),
            new MyTest(2, "B"),
            new MyTest(3, "C")
        };
    }
}
