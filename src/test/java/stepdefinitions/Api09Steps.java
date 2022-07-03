package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class Api09Steps extends TestBaseApi{
    Response response;
    @Given("kullanici {string} endpointe delete islemi icin request gonderir")
    public void kullaniciEndpointeDeleteIslemiIcinRequestGonderir(String pathParametresi) {
   setup();
   spec.pathParam("1",pathParametresi);
   response=given().spec(spec).contentType("application/json; charset=utf-8").when().delete("/{1}");
   response.prettyPeek();
    }

    @Then("kullanici verifylogin endpointine delete islemi sonrasi responseCode  {int} kodu aldigini dogrular")
    public void kullaniciVerifyloginEndpointineDeleteIslemiSonrasiResponseCodeKoduAldiginiDogrular(int code) {
    int donenCode= Integer.valueOf(response.jsonPath().getString("responseCode"));
        Assert.assertEquals(code,donenCode);
    }

    @And("kullanici delete islemi sonrasi gelen cevabin {string} oldugunu dogrular")
    public void kullaniciDeleteIslemiSonrasiGelenCevabinOldugunuDogrular(String donenMesaj) {

        Assert.assertEquals(donenMesaj,response.jsonPath().getString("message"));

        }
}
