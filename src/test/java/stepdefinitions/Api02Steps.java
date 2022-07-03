package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Api02Steps extends TestBaseApi{
    Response response;

    @Given("kullanici post islemi {string} endpointe request gonderir")
    public void kullaniciPostIslemiEndpointeRequestGonderir(String pathParametresi) {
    setup();
    spec.pathParam("1",pathParametresi);
        HashMap<String,String>userType=new HashMap<>();
        HashMap<String,Object>category=new HashMap<>();
        HashMap<String,Object>expectedrequest=new HashMap<>();
        userType.put("usertype","Man");
        category.put("usertype",userType);
        category.put("category","Tops");
        expectedrequest.put("id","333");
        expectedrequest.put("name","Cibil");
        expectedrequest.put("price","RS. 333");
        expectedrequest.put("brand","Cibilli");
        expectedrequest.put("category",category);


        //ProductsList pojo=new ProductsList("222","Saksi","Rs.450","Kaya");
        response=given().spec(spec).contentType("application/json; charset=utf-8").body(expectedrequest.toString()).when().post("/{1}");
    response.prettyPeek();
    }


    @Then("kullanici post islemi sonrasi response olarak {int} kodu aldigini dogrular")
    public void kullaniciPostIslemiSonrasiResponseOlarakKoduAldiginiDogrular(int code) {
       // System.out.println(response.jsonPath().getString("responseCode"));
        int responseCode= Integer.parseInt(response.jsonPath().getString("responseCode"));
        Assert.assertEquals(code,responseCode);
    }


    @And("kullanici responce ile gelen mesajin {string} oldugunu dogrular")
    public void kullaniciResponceIleGelenMesajinOldugunuDogrular(String donenMesaj) {
       // System.out.println(response.jsonPath().getString("message"));
        Assert.assertEquals(donenMesaj,response.jsonPath().getString("message"));
    }

}
