package org.example;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public  class Series extends Product implements Rent{


    protected boolean rentness = false ;

//create series object
    @JsonCreator
    public Series(@JsonProperty("title") String title,
                  @JsonProperty("yearOfAppearance") int yearOfAppearance,
                  @JsonProperty("duration") int duration,
                  @JsonProperty("director") String director,
                  @JsonProperty("ageRestriction") int ageRestriction,
                  @JsonProperty("price") int price,
                  @JsonProperty("genre") String genre,
                  @JsonProperty("type") String type)
                 {
        super(title,yearOfAppearance, duration, director, ageRestriction, price, genre,"Series");

    }



    public boolean getRentness(){return rentness;}

//implement rent function inherited from rent interface
    public boolean rentSeries(){
        if(rentness){
            return false;
        }
        rentness = true;
        return true;
    }
    public int getPrice(){
        return price;
    }

    @Override
    public String getType() {
        return "Series";
    }
}
