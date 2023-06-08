package org.placeholder.task;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.placeholder.model.ResponsePost;
import org.placeholder.model.ResponsePostItem;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.placeholder.utils.Constants.RESPONSE_POST;

public class GetPost implements Task {

    String resource;

    public GetPost(String resource) {
        this.resource = resource;
    }

    public static GetPost getPost(String resource) {
        return instrumented(GetPost.class,resource);
    }
    @Override

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/"+resource));
        String response= SerenityRest.lastResponse().asString();
        List<ResponsePostItem> responseItems = from(response).getList("", ResponsePostItem.class);
        actor.remember(RESPONSE_POST,responseItems);

    }
}
