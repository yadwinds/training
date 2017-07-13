import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Swarn on 6/29/2017.
 */
public class WeatherTestSteps {
    private RequestSpecification request;
    private ValidatableResponse json;
    private Response response;

    private String URL = "http://api.openweathermap.org/data/2.5/weather";

    @Given("^Existing city with name \"([^\"]*)\"$")
    public void existing_city_with_name(String arg1) throws Throwable {
        request = given().param("APPID","ff1196b05786b07d2cb71c37f142adbe").
                          param("q","NewDelhi");

        // Write code here that turns the phrase above into concrete actions

    }

    @When("^User gets the weather by city name$")
    public void user_gets_the_weather_by_city_name() throws Throwable {
        response = request.when().get(URL);
        System.out.println("response: " + response.prettyPrint());
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^The status code is (\\d+)$")
    public void the_status_code_is(int statuscode) throws Throwable {
        json = response.then().statusCode(statuscode);

        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^Response has the following info$")
    public void response_has_the_following_info(Map<String,String> responseFields) throws Throwable {
        for(Map.Entry<String,String> field: responseFields.entrySet()){
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(),equalTo(Integer.parseInt(field.getValue())));
            }
            else {
                json.body(field.getKey(),equalTo(field.getValue()));
            }
        }

    }

}
