package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class setupConfiguration {

    public static Actor user;
    @Managed(uniqueSession = true)
    private static final Logger logger = LogManager.getLogger(setupConfiguration.class);

    @Before
    public void prepareStage() {
        String theRestApiBaseUrl ="https://jsonplaceholder.typicode.com";
        logger.info("\n Running......Env \n {} con la Base Url \n {} ",System.getProperty("env"), theRestApiBaseUrl);
        user = Actor.named("user")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));
        OnStage.setTheStage(new OnlineCast());
    }



    @After
    public void after() {
        logger.info("End......");
    }


}
