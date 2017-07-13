import io.restassured.mapper.ObjectMapper;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Swarn on 6/29/2017.
 */
public class TestRunner {

    private String URL = "http://api.openweathermap.org/data/2.5/weather";

    @Test
    public void getWeatherbyCity(){
        String APPID= "APPID:ff1196b05786b07d2cb71c37f142adbe";
        String q = "NewDelhi";

        given().param("APPID",APPID).
                param("q",q).
                when().
                get(URL).
                then().
                statusCode(HttpStatus.SC_OK).
                body("main.temp",equalTo(300.15),
                        "main.pressure",equalTo(1002));


    }
}
