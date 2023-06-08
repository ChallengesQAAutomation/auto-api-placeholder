package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class setupConfiguration {

    static EnvironmentVariables environmentVariables;
    public static Actor admin;
    public static Actor student;
    @Managed(uniqueSession = true)
    private static final Logger logger = LogManager.getLogger(setupConfiguration.class);

    @Before
    public void prepareStage() {
        String theRestApiBaseUrl ="";
        logger.info("\n Running......Env \n {} con la Base Url \n {} ",System.getProperty("env"), theRestApiBaseUrl);
        admin = Actor.named("admin")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));
        student = Actor.named("student")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));
        OnStage.setTheStage(new OnlineCast());
    }



    @After
    public void after() {
        logger.info("End......");
    }


}
