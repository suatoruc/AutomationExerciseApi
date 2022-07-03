package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Users;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Api10Steps extends TestBaseApi{
    Response response;

    @Given("kullanici post islemi icin requesti {string} endpointe gonderir")
    public void kullaniciPostIslemiIcinRequestiEndpointeGonderir(String pathParametresi) {
        setup();
        spec.pathParam("1",pathParametresi);
        Users pojo=new Users("deneme@team03trCoacing.com","deneme11!");
        HashMap<String ,Object>expected=new HashMap<>();
        expected.put("email","denem1e@team03trCoacing.com");
        expected.put("password","den1eme11!");
        response=given().spec(spec).contentType("application/json").body(expected.get("password").toString()).when().post("/{1}");
        response.prettyPeek();
    }

    @Then("kullanici post islemi sonrasi verifylogin endpointinden responseCode {int} kodu aldigini dogrular")
    public void kullaniciPostIslemiSonrasiVerifyloginEndpointindenResponseCodeKoduAldiginiDogrular(int responCode) {
        Assert.assertEquals(responCode,response.statusCode());
    }

    @And("kullanici post islemi sonrasi gelen response da {string} oldugunu dogrular")
    public void kullaniciPostIslemiSonrasiGelenResponseDaOldugunuDogrular(String mesaj) {
    Assert.assertTrue(response.statusLine().contains(mesaj));
    }
}
