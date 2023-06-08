package org.placeholder.question;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.placeholder.model.ResponsePostItem;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.placeholder.utils.Constants.RESPONSE_POST;

public class AttributesQuestion implements Question<Boolean> {
    DataTable expectedAttributes;
    public AttributesQuestion(DataTable expectedAttributes) {
        this.expectedAttributes = expectedAttributes;
    }
    private static final Logger logger = LogManager.getLogger(AttributesQuestion.class);

    public static AttributesQuestion attributesOf(DataTable expectedAttributes) {
        return new AttributesQuestion(expectedAttributes);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean req = false;
        for (List<String> row : expectedAttributes.cells()) {
            for (String cell : row) {
                req=SerenityRest.lastResponse().asString().contains(cell);
                if(!(req)){
                    logger.error("No match found for {} " + cell);
                }
            }
        }
        return req;
    }
}
