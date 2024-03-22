package org.example;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Catalog {

    private JsonFile json= new JsonFile();
    private ArrayList<Product> productList = new ArrayList<Product>();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ArrayList<Product> getProductList(){
        return productList;
    }


    //add product object to list
    public void addToList(Product productName){

        productList.add(productName);

    }


    //display product list
    public ArrayList<Product> displayList(){
        return productList;
    }


    //delete a product object from list
    public void deleteProductFromList(Product productName) {
        productList.remove(productName);
    }


    static {
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

    }

//search for product in product list
    public ArrayList<Product> searchProduct(String productName) {
        try {
            return productList.stream().filter(product -> productName.equals(product.title)).collect(Collectors.toCollection(ArrayList::new));
        } catch (NullPointerException e) {
            System.out.println("Product doesn't exist");

            return new ArrayList<>();
        }
    }

//update product list from json object list
    public void updateObjList(ArrayList<JSONObject> list){
        productList.clear();
        for(JSONObject obj : list){
            productList.add( json.convertJsonToProduct(obj));

        }
    }





}
