package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Api03Step extends TestBaseApi{
Response response;


HashMap<String,Integer>toplamUrun=new HashMap<>();
    List<String> listem=new ArrayList<>();
    String gecici[];

    @Given("kullanici {string} endpointe request gonderir")
    public void kullaniciEndpointeRequestGonderir(String pathParametresi) {

   setup();
     spec.pathParam("1", pathParametresi);
     response = given().spec(spec).when().get("/{1}");
     response.prettyPeek();


    }
    @Then("kullanici response olarak {int} kodu aldigini dogrular")
    public void kullaniciResponseOlarakKoduAldiginiDogrular(int responseCode) {
       Assert.assertEquals(responseCode,response.statusCode());

    }




    @And("kullanici {string} markali ürünlerin sayısının {int} oldugunu dogrular")
    public void kullaniciMarkaliÜrünlerinSayısınınOldugunuDogrular(String marka, int adet) {
        String liste = response.asString();
        liste = liste.substring(35);
        listem = List.of(liste.split("}, \\{"));
       // System.out.println(listem);
        int urunAdeti=0;
        int i=0;
        for (String w:listem  ) {
            gecici= w.split("nd");
            w=gecici[1];
            w=w.replaceAll("\\W","").toUpperCase();
                    toplamUrun.put(w,i);
            if (w.equals(marka)){
            urunAdeti++;
            i++;
        }
                }
        //System.out.println(urunAdeti);
        Assert.assertEquals(adet,urunAdeti);


    }

    @And("kullanici {int} farklı ürün çeşidi olduğunu doğrular")
    public void kullaniciFarklıÜrünÇeşidiOlduğunuDoğrular(int markaSayisi) {
       // System.out.println(toplamUrun);
        Assert.assertEquals(markaSayisi,toplamUrun.size());
    }


}

