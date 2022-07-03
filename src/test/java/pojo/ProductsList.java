package pojo;

import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductsList {
    private String  id;
    private  String name;
    private String price;
    private String brand;
   // private Category category;

    public HashMap<String,Object>getir(){
        HashMap<String,Object>map=new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("price",price);
        map.put("brand",brand);
        return map;
    }

}
