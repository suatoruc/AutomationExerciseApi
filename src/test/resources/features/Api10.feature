Feature: Automation Exercise Api10 testi


  Scenario: Api10 testi
    Given kullanici post islemi icin requesti "verifyLogin" endpointe gonderir
    Then  kullanici post islemi sonrasi verifylogin endpointinden responseCode 400 kodu aldigini dogrular
    And  kullanici post islemi sonrasi gelen response da "Bad Request" oldugunu dogrular