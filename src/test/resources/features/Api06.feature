Feature: Automation Exercise Api06 testi

  @api01
  Scenario: Api06 test
    Given kullanici post islemi icin "searchProduct" endpointe request gonderir
    Then  kullanici post islemi sonrasi responseCode  400 kodu aldigini dogrular
    And  kullanici post islemi sonrasi responce ile gelen mesajin "Bad request, search_product parameter is missing in POST request." oldugunu dogrular