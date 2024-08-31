package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Tag("property")
    @Test
    void simpleTest(){
        String browser = System.getProperty("browser", "mozilla");

        System.out.println(browser);
    }
}
