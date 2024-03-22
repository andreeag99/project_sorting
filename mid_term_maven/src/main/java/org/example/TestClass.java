package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class TestClass {

    DatabaseLink data = new DatabaseLink();





    @Test
    public void testMovieConstructor() {


        Movie movie = new Movie("SAW", 1999, 123, "John", 15, 23, "horror", "Movie");

        //check movie and product constructors
        Assertions.assertEquals("SAW", movie.getTitle());
        Assertions.assertEquals(1999, movie.getYearOfAppearance());
        Assertions.assertEquals(123, movie.getDuration());
        Assertions.assertEquals("John", movie.getDirector());
        Assertions.assertEquals(15, movie.getAgeRestriction());
        Assertions.assertEquals(23, movie.getPrice());
        Assertions.assertEquals("horror", movie.getGenre());
        Assertions.assertEquals("Movie", movie.getType());


    }


    @Test
    public void testSeriesConstructor() {

        Series series = new Series("The Office", 2002, 20, "Bob", 12, 23, "Sitcom", "Series");

        //check series and product constructors
        Assertions.assertEquals("The Office", series.getTitle());
        Assertions.assertEquals(2002, series.getYearOfAppearance());
        Assertions.assertEquals(20, series.getDuration());
        Assertions.assertEquals("Bob", series.getDirector());
        Assertions.assertEquals(12, series.getAgeRestriction());
        Assertions.assertEquals(23, series.getPrice());
        Assertions.assertEquals("Sitcom", series.getGenre());
        Assertions.assertEquals("Series", series.getType());


    }

    @Test
    public void testRentSeries() {

        Catalog catalog = new Catalog();


        ArrayList<Product> list = catalog.getProductList();
        Series series = new Series("The Office", 2002, 20, "Bob", 12, 23, "Sitcom", "Series");
        catalog.addToList(series);

        series.rentSeries();


        Assertions.assertTrue(series.getRentness());



    }


    @Test
    public void testProductToJsonFunction() {

        Movie movie = new Movie("SAW", 1999, 123, "John", 15, 23, "horror", "Movie");
        JsonFile jsonFile = new JsonFile();
        JSONObject jsonObj = jsonFile.convertToJSONObject(movie);

        //verify if constructor converts to json object
        ObjectMapper objectMapper = new ObjectMapper();

        Assertions.assertDoesNotThrow(() -> objectMapper.readTree(objectMapper.writeValueAsString(jsonObj)));


    }




}
