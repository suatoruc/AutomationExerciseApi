Feature: Automation Exercise Api09 testi


  Scenario: Api09 testi
    Given kullanici "verifyLogin" endpointe delete islemi icin request gonderir
    Then  kullanici verifylogin endpointine delete islemi sonrasi responseCode  405 kodu aldigini dogrular
    And  kullanici delete islemi sonrasi gelen cevabin "This request method is not supported." oldugunu dogrular