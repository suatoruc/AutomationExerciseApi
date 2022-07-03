package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.BrandsList;

import static io.restassured.RestAssured.given;

public class Api08Steps extends TestBaseApi{
   Response response;
    @Given("kullanici {string} endpointe post islemi icin request gonderir")
    public void kullaniciEndpointePostIslemiIcinRequestGonderir(String parthParametresi) {
   setup();
   spec.pathParam("1",parthParametresi);
BrandsList pojo=new BrandsList("1","selami");
   response=given().spec(spec).contentType("application/json; charset=utf-8").body(pojo.getId()).when().post("/{1}");
   // response.prettyPeek();
    }

    @Then("kullanici verifylogin endpointine post islemi sonrasi responseCode  {int} kodu aldigini dogrular")
    public void kullaniciVerifyloginEndpointinePostIslemiSonrasiResponseCodeKoduAldiginiDogrular(int code) {
        int responseCode= Integer.valueOf(response.jsonPath().getString("responseCode"));
        Assert.assertEquals(code,responseCode);
    }

    @And("kullanici post islemi sonrasi gelen cevabin {string} oldugunu dogrular")
    public void kullaniciPostIslemiSonrasiGelenCevabinOldugunuDogrular(String donenMesaj) {
        String msg=response.jsonPath().getString("message");
        Assert.assertEquals(donenMesaj,msg);
    }
}
