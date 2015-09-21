package CRM;

import core.BaseTest;
import org.testng.annotations.Test;
import ui_Layer.blocks.HomePage;

/**
 * Created by Libe on 20.09.2015.
 */
public class TestHomePage extends BaseTest {

    HomePage homePage;

    @Test
    public void TestHomePage() {
    homePage = new HomePage();
        homePage.openHomePage();
    }

}
