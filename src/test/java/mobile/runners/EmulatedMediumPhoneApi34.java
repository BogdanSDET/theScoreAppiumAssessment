package mobile.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"mobile.stepDefinitions"},
        dryRun=false,
        monochrome=true,
        tags = "@test",
        plugin = {"pretty"
                , "html:target/RealGooglePixelPhone6/cucumber/report.html"
                , "summary"
        }
)
public class EmulatedMediumPhoneApi34 extends RunnerBase{
}
