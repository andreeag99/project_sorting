package org.example;
import org.json.JSONObject;

import java.util.ArrayList;
public class JsonFile {

    //convert product object to json object
    public static JSONObject convertToJSONObject(Product o) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", o.getTitle());
        jsonObject.put("yearOfAppearance", o.getYearOfAppearance());
        jsonObject.put("duration", o.getDuration());
        jsonObject.put("director", o.getDirector());
        jsonObject.put("ageRestriction", o.getAgeRestriction());
        jsonObject.put("price", o.getPrice());
        jsonObject.put("genre", o.getGenre());
        jsonObject.put("type", o.getType());
        if(o.getType().equals("Series")){
            Series x = (Series) o;
            jsonObject.put("rentness", x.getRentness());
        }
        return jsonObject;
    }

    //convert product list to json object list
    public static ArrayList<JSONObject> jsonObjectsList(ArrayList<Product> productArrayList) {
        ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<JSONObject>();
        for (Product product : productArrayList) {
            jsonObjectArrayList.add(convertToJSONObject(product));
        }
        return jsonObjectArrayList;
    }


    //convert json object to product
    public static Product convertJsonToProduct(JSONObject jsonObject) {

        String title = jsonObject.getString("title");
        int yearOfAppearance = jsonObject.getInt("yearOfAppearance");
        int duration = jsonObject.getInt("duration");
        String director = jsonObject.getString("director");
        int ageRestriction = jsonObject.getInt("ageRestriction");
        int price = jsonObject.getInt("price");
        String genre = jsonObject.getString("genre");
        String type = jsonObject.getString("type");

        Product product = null;

        switch(type) {
            case "Movie":
                product = new Movie(title, yearOfAppearance, duration, director, ageRestriction, price, genre, type);
                break;
            case "Series":
                product = new Series(title, yearOfAppearance, duration, director, ageRestriction, price, genre, type);
                if (jsonObject.getBoolean("rentness")){
                    ((Series) product).rentSeries();
                }
                break;

        }
        return product;
    }
}




