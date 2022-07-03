package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.ProductsList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;

public class Api01Steps extends TestBaseApi {
    Response response;
    List<String> sepet = new ArrayList<>();
    List<String> gecici = new ArrayList<>();
    List<String> elemanlar = new ArrayList<>();
    List<String> listem = new ArrayList<>();
    List<String> value = new ArrayList<>();
    HashMap<Integer, List<String>> urunler = new HashMap<>();
    String id;
    String name;
    String price;
    String brand;
    ProductsList pojo = new ProductsList();
    List<HashMap<String,Object>>sonUrunListesi=new ArrayList<>();
    JsonPath json;

    @Given("kullanici {string} endpointine request gonderir")
    public void kullanici_endpointine_request_gonderir(String pathParametresi) {
        setup();
        spec.pathParam("1", pathParametresi);
        response = given().spec(spec).when().get("/{1}");
        response.prettyPeek();


    }

    @Then("kullanici status codu dogrular")
    public void kullanici_status_codu_dogrular() {
        Assert.assertEquals(200, response.statusCode());

    }

    @Then("kullanici urunlerin sayisinin {int} oldugunu dogrular")
    public void kullanici_urunlerin_sayisinin_oldugunu_dogrular(Integer urunSayisi) {
        String liste = response.asString();
        liste = liste.substring(35);
        listem = List.of(liste.split("}},"));
        Assert.assertTrue(listem.size() == urunSayisi);

    }

    @Then("kullanici fiyati {int} den kucuk olan urunleri log dosyasina yazdirir")
    public void kullanici_fiyati_den_kucuk_olan_urunleri_log_dosyasina_yazdirir(Integer deger) throws IOException {

         for (int j = 0; j < listem.size(); j++) {

          elemanlar = List.of(listem.get(j).split(","));
          //   System.out.println("listem: " + elemanlar);

          gecici = List.of(elemanlar.get(0).split(":"));
          id = gecici.get(1);
          gecici = List.of(elemanlar.get(1).split(":"));
          name = gecici.get(1);
          gecici = List.of(elemanlar.get(2).split(":"));
          price = gecici.get(1);
          gecici = List.of(elemanlar.get(3).split(":"));
          brand = gecici.get(1);
          //System.out.println(id + " " + name + " " + price + " " + brand);

          ProductsList pojo = new ProductsList(id, name, price, brand);

          sepet.add(0, pojo.getId());
          sepet.add(1, pojo.getName());
          sepet.add(2, pojo.getPrice());
          sepet.add(3, pojo.getBrand());

          urunler.put((j + 1), Collections.singletonList(sepet.get(0) + sepet.get(1) + sepet.get(2) + sepet.get(3)));

      }
      System.out.println("ürünler: " + urunler);
      Set s = urunler.entrySet();
      Iterator it = s.iterator();
      while (it.hasNext()) {
          Map.Entry m = (Map.Entry) it.next();
          // getKey() metodu anahtarı (key) verir.
          int key = (Integer) m.getKey();
          // getValue() metodu değeri verir
          value = (List<String>) m.getValue();
          System.out.println("Anahtar :" + key + " Değer :" + value);
          String arr[] = value.get(0).split("Rs.");
          String price = arr[1];
          int price1 = Integer.valueOf(price.replaceAll("\\D", ""));
          if (price1 < deger) {
              saveFile(value);


          }
      }

    }

    public static void saveFile(List<String> Liste) throws IOException {
        File file = new File("src/test/java/pojo/fiyati1000denAzOlanUrunler.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(String.valueOf(Liste) + "\n");
        bWriter.close();
    }


}


