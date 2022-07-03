Feature: Automation Exercise Api02 testi

  @api01
  Scenario: Api02 test
    Given kullanici post islemi "productsList" endpointe request gonderir
    Then  kullanici post islemi sonrasi response olarak 405 kodu aldigini dogrular
    And  kullanici responce ile gelen mesajin "This request method is not supported." oldugunu dogrular