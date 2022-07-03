package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.BrandsList;

import static io.restassured.RestAssured.given;

public class Api06Steps extends TestBaseApi{
    Response response;
    @Given("kullanici post islemi icin {string} endpointe request gonderir")
    public void kullaniciPostIslemiIcinEndpointeRequestGonderir(String pathParametresi) {
        setup();
        spec.pathParam("1",pathParametresi);
      BrandsList pojo=new BrandsList("22","Polok");



        response=given().spec(spec).contentType("application/json; charset=utf-8").body(pojo.getId()).when().post("/{1}");
//response.prettyPeek();
    }

    @Then("kullanici post islemi sonrasi responseCode  {int} kodu aldigini dogrular")
    public void kullaniciPostIslemiSonrasiResponseCodeKoduAldiginiDogrular(int code) {
        int responseCode= Integer.valueOf(response.jsonPath().getString("responseCode"));
        Assert.assertEquals(code,responseCode);
            }

    @And("kullanici post islemi sonrasi responce ile gelen mesajin {string} oldugunu dogrular")
    public void kullaniciPostIslemiSonrasiResponceIleGelenMesajinOldugunuDogrular(String donenMesaj) {
       // String msg=response.getBody().jsonPath().getString("message");
        String msg=response.jsonPath().getString("message");
          Assert.assertEquals(donenMesaj,msg);
    }


}
