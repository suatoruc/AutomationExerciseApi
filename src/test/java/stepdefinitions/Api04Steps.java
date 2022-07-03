package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.BrandsList;

import static io.restassured.RestAssured.given;

public class Api04Steps extends TestBaseApi{
Response response;

    @Given("kullanici put islemi {string} endpointe request gonderir")
    public void kullaniciPutIslemiEndpointeRequestGonderir(String pathParametresi) {
    setup();
        spec.pathParam("1", pathParametresi);
        BrandsList pojo=new BrandsList("11","Saklambac");


        response = given().spec(spec).contentType(ContentType.JSON).body(pojo.toString()).when().put("/{1}");
    }

    @Then("kullanici put islemi sonrasi response olarak {int} kodu aldigini dogrular")
    public void kullaniciPutIslemiSonrasiResponseOlarakKoduAldiginiDogrular(int code) {
        int responseCode= Integer.parseInt(response.jsonPath().getString("responseCode"));
        Assert.assertEquals(code,responseCode);
    }


    @And("kullanici put islemi sonrası responce ile gelen mesajin {string} oldugunu dogrular")
    public void kullaniciPutIslemiSonrasıResponceIleGelenMesajinOldugunuDogrular(String donenMesaj) {
        Assert.assertEquals(donenMesaj,response.jsonPath().getString("message"));
    }


}
