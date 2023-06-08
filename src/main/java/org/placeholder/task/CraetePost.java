package org.placeholder.task;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.placeholder.model.RequestPost;
import org.placeholder.model.ResponsePostItem;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;
import static org.placeholder.utils.Constants.RESPONSE_POST;
import static org.placeholder.utils.Constants.RESPONSE_POST_CREATE;

public class CraetePost implements Task {

    RequestPost requestPost;
    String resource;

    public CraetePost(String resource) {
        this.resource = resource;
    }

    public static CraetePost forResource(String resource) {
        return new CraetePost(resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        requestPost=new RequestPost.Builder().jsonDefult().build();
        actor.attemptsTo(Post.to("/"+resource)
                .with(request->request
                        .header("Content-Type","application/json")
                        .body(requestPost)));
        String response= SerenityRest.lastResponse().asString();
        ResponsePostItem responseItem = from(response).getObject("", ResponsePostItem.class);
        actor.remember(RESPONSE_POST_CREATE,responseItem);
    }
}
