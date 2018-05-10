package springinaction.ch04.web;

import org.junit.Assert;
import org.junit.Test;

public class HomeControllerTest {
    @Test
    public void testHomePage() {
        HomeController homeController = new HomeController();
        Assert.assertEquals("home", homeController.home());
    }
}
