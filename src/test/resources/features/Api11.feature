Feature: Automation Exercise Api11 testi


  Scenario: Api11 testi
    Given kullanici get islemi icin requesti "getUserDetailByEmail" endpointe gonderir
    Then  kullanici get islemi sonrasi verifylogin endpointinden responseCode 400 kodu aldigini dogrular
    And  kullanici get islemi sonrasi gelen response da "Bad request, email parameter is missing in GET request." oldugunu dogrular