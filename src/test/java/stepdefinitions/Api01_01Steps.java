package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.ProductsList;
import utilities.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Api01_01Steps extends TestBaseApi{
Response response;
JsonPath json;
List<HashMap<String,Object >>sonUrunListesi=new ArrayList<>();
ProductsList pojo;


    @Given("kullanici {string} endpointine response almak icin request gonderir")
    public void kullaniciEndpointineResponseAlmakIcinRequestGonderir(String pathparametresi) {
    setup();
    spec.pathParam("1",pathparametresi);
    response=given().spec(spec).contentType(ContentType.JSON).when().get("/{1}");


    }

    @Then("kullanici genel response un status codunun {int} oldugunu dogrular")
    public void kullaniciGenelResponseUnStatusCodununOldugunuDogrular(int statusCode) {

        json=response.jsonPath();
        Assert.assertEquals(statusCode,json.getInt("responseCode"));
    }

    @And("kullanici response ile gelen urunlerin sayisinin {int} oldugunu dogrular")
    public void kullaniciResponseIleGelenUrunlerinSayisininOldugunuDogrular(int urunAdeti) {
             Assert.assertEquals(urunAdeti,json.getList("products").size());
    }

    @And("kullanici response ile gelen urunlerin fiyati {int} den kucuk olan urunleri log dosyasina yazdirir")
    public void kullaniciResponseIleGelenUrunlerinFiyatiDenKucukOlanUrunleriLogDosyasinaYazdirir(int fiyat) {
        for (int i = 0; i <json.getList("products").size() ; i++) {
            pojo=new ProductsList(json.getString("products.id["+i+"]"),
                                  json.getString("products.name["+i+"]"),
                                  json.getString("products.price["+i+"]"),
                                  json.getString("products.brand["+i+"]"));

            sonUrunListesi.add(pojo.getir());
             }
        String  gecici;
        for (int i = 0; i <sonUrunListesi.size() ; i++) {
            gecici= ((String) sonUrunListesi.get(i).get("price")).replaceAll("Rs. ","");
            if (Integer.valueOf(gecici)<fiyat){
                Log.info(  (String) sonUrunListesi.get(i).get("id")+" "+
                           (String) sonUrunListesi.get(i).get("name")+" "+
                           (String) sonUrunListesi.get(i).get("price")+" "+
                           (String) sonUrunListesi.get(i).get("brand"));
            }


        }
        }


    }

