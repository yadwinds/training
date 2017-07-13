import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Swarn on 6/20/2017.
 */
public class WeatherSteps {
    private Response response;
    private RequestSpecification request;


    private String URL = "http://api.openweathermap.org/data/2.5/weather";
    //private int statuscode;


    @Given("^I hit the service endpoint$")
    public void i_hit_the_service_endpoint() throws Throwable {

        response = given().param("q","NewDelhi").
                           param("APPID","ff1196b05786b07d2cb71c37f142adbe").
                           get("http://api.openweathermap.org/data/2.5/weather");
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^I get the response$")
    public void i_get_the_response() throws Throwable {
        System.out.println(response.prettyPrint());
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^I get the status code (\\d+)$")
    public void i_get_the_status_code(int statuscode) throws Throwable {
        statuscode = response.getStatusCode();
        System.out.println("statuscode is" + " " + statuscode);
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @And("^I get following info in the response$")
    public void i_get_following_info_in_the_response(DataTable table) throws Throwable {
        List<List<String>>  data = table.raw();
        given().body("main.temp", (ObjectMapper) equalTo(282.15));
        System.out.println(data.get(0).get(1));
        System.out.println(data.get(1).get(1));


        }

        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
       // throw new PendingException();
    }


