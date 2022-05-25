package step_definitions;

import io.cucumber.java.en.Given;

public class CommonStepDefs extends AbstractStepDefs{

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }
}
