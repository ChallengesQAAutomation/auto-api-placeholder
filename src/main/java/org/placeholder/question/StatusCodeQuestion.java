package org.placeholder.question;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class StatusCodeQuestion implements Question<Boolean> {
    int responseCode;

    public StatusCodeQuestion(int responseCode) {
        this.responseCode = responseCode;
    }

    public static StatusCodeQuestion statusCodeof(int responseCode) {
        return new StatusCodeQuestion(responseCode);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (SerenityRest.lastResponse().statusCode() == responseCode);
    }
}
