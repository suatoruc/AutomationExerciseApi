Feature: Automation Exercise Api04 testi

  @api01
  Scenario: Api03 test
    Given kullanici put islemi "brandsList" endpointe request gonderir
    Then  kullanici put islemi sonrasi response olarak 405 kodu aldigini dogrular
    And  kullanici put islemi sonrası responce ile gelen mesajin "This request method is not supported." oldugunu dogrular