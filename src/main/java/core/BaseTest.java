package core;

import com.thoughtworks.selenium.ScreenshotListener;
import org.testng.annotations.*;


//@Listeners(ScreenshotListener.class)
//@Listeners(RetryTestListener.class) //, ScreenshotListener.class)
public class BaseTest {

    //*@BeforeClass
    @BeforeTest
        public void init() {
        Driver.init();
    }


//    @BeforeMethod
//    public void checkRestartPage(){
//        try {
//        HomePage.open();
//        //System.out.println("2) reload page");
//        //Driver.logOut();
//        } catch (org.openqa.selenium.TimeoutException e1) {
//        }
//        catch (Exception e) {
//            System.out.println("=======================================================");
//            e.printStackTrace();
//            //Driver.tearDown();
//            //System.exit(0);
//        }
//    }


    //*@AfterClass
    @AfterSuite
    public void cleanup() {
        //System.out.println();
        //System.out.println("----------------------------------------------------");
        Driver.tearDown();
    }
}