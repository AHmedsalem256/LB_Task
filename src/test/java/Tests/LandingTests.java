package Tests;

import Data.LoadProperties;
import org.testng.annotations.Test;
import java.util.Properties;

public class LandingTests extends BaseTest {

    Properties prop;

    @Test
    public void Validate_Landing_RightPage(){
        LP.validateLogo();
    }

    @Test
    public void SearchForProduct(){
        prop = LoadProperties.LoadTheData("src/test/resources/Env.properties");
        String word = prop.getProperty("KeyWord");
        LP.TypeSearchBar(word);
        LP.validateAllCardsContainMazdamx5(word);
    }

    @Test
    public void FilterSideSearch(){
        LP.TypeSearchBar("mazdamx-5");
        /*This Filter Section I cannot find it*/
    }

}
