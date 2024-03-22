package org.example;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Movie extends Product implements Buy{



//create movie object
    @JsonCreator
    public Movie(@JsonProperty("title") String title,
                  @JsonProperty("yearOfAppearance") int yearOfAppearance,
                  @JsonProperty("duration") int duration,
                  @JsonProperty("director") String director,
                  @JsonProperty("ageRestriction") int ageRestriction,
                  @JsonProperty("price") int price,
                  @JsonProperty("genre") String genre,
                  @JsonProperty("type") String type){
        super(title,yearOfAppearance, duration, director, ageRestriction, price, genre,type );

    }



//implement buy function inherited from buy interface
    public boolean buyMovie(ArrayList<Product> moviesList, Movie movieName){
        return movieName.delete( moviesList,movieName);

    }


    //delete movie object from product list
    public boolean delete(ArrayList<Product> moviesList, Movie movieName){
        return moviesList.remove(movieName);

    }


    @Override
    public String getType() {
        return "Movie";
    }


}
