package ui_Layer.blocks;

import core.Driver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Libe on 20.09.2015.
 */
public abstract class PageFactorySettings {

        public PageFactorySettings() {
            PageFactory.initElements(Driver.get(), this);}
    }


