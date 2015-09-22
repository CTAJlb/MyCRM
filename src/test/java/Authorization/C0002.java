package Authorization;

import core.BaseTest;
import org.testng.annotations.Test;
import ui_Layer.blocks.HomePage;

/**
 * Created by Libe on 20.09.2015.
 */
public class C0002 extends BaseTest {
    HomePage homePage;
//    String email = "test";
//    String password = "test";
//    String erroMsg = "";

    @Test
    public void notValidCredentions() {
        homePage = new HomePage();
        homePage.openHomePage();
        homePage.authorization("test", "test");
        homePage.checkErrorAuth("The user name or password provided is incorrect.");

    }


}
