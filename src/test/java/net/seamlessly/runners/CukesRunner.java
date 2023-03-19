package net.seamlessly.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "net/seamlessly/step_definitions",
        dryRun = false,
        tags = "" //tags here and tags in login fature than that test will run

        //dryRun = true --> do not run my step_definitions, but only check if any step is missing snippet
        //dryRun = false --> this will turn off dryRun, and our code will run as expected.
)

public class CukesRunner {
}
