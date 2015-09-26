package Authorization;

import core.BaseTest;
import org.testng.annotations.Test;
import ui_Layer.blocks.HomePage;
import ui_Layer.blocks.UserPage;

/**
 * Created by Libe on 20.09.2015.
 */
public class C0001 extends BaseTest {
    HomePage homePage;
    UserPage userPage;
    String email = "sa@bb.com";
    String password = "y0D@1927";

    @Test
    public void positiveAuthorizationAdmin () {
        homePage = new HomePage();
        userPage= new UserPage();
        homePage.openHomePage();
        homePage.authorization(email, password);
        userPage.logout();
    }
}
