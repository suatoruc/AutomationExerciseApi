package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class Api11Steps extends TestBaseApi{
    Response response;
    @Given("kullanici get islemi icin requesti {string} endpointe gonderir")
    public void kullaniciGetIslemiIcinRequestiEndpointeGonderir(String pathParametre) {
        setup();
        spec.pathParam("1",pathParametre);
        response=given().spec(spec).contentType(ContentType.JSON).when().get("/{1}");
        response.prettyPeek();

    }

    @Then("kullanici get islemi sonrasi verifylogin endpointinden responseCode {int} kodu aldigini dogrular")
    public void kullaniciGetIslemiSonrasiVerifyloginEndpointindenResponseCodeKoduAldiginiDogrular(int statusCode) {
        Assert.assertEquals(statusCode,response.jsonPath().getInt("responseCode"));
    }


    @And("kullanici get islemi sonrasi gelen response da {string} oldugunu dogrular")
    public void kullaniciGetIslemiSonrasiGelenResponseDaOldugunuDogrular(String mesaj) {
    Assert.assertEquals(mesaj,response.jsonPath().getString("message"));
    }
}
