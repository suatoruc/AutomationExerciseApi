Feature:  Automation Exercise Api03 testi

  @api01
  Scenario: Api03 test
    Given kullanici "brandsList" endpointe request gonderir
    Then  kullanici response olarak 200 kodu aldigini dogrular
     And  kullanici "POLO" markali ürünlerin sayısının 6 oldugunu dogrular
    Then  kullanici "HM" markali ürünlerin sayısının 5 oldugunu dogrular
     And  kullanici 8 farklı ürün çeşidi olduğunu doğrular



