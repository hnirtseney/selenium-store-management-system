package common;

import org.testng.annotations.Test;

public class MyTest {

    private int param1;
    private String param2;

    public MyTest(int param1, String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    @Test
    public void testMethod() {
        System.out.println("Kiểm thử với: " + param1 + " và " + param2);
        // Logic kiểm thử hoặc các xác nhận ở đây
    }
}