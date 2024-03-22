package org.example;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Movie.class, name = "Movie"),
        @JsonSubTypes.Type(value = Series.class, name = "Series")
})

public abstract class Product {

    protected final String title;
    protected final int yearOfAppearance;
    protected final int duration;
    protected final String director;
    protected final int ageRestriction;
    protected int price;
    protected String genre;

    protected String type;

//construct product object
    @JsonCreator
    public Product(@JsonProperty("title") String title,
                   @JsonProperty("yearOfAppearance") int yearOfAppearance,
                   @JsonProperty("duration") int duration,
                   @JsonProperty("director") String director,
                   @JsonProperty("ageRestriction") int ageRestriction,
                   @JsonProperty("price") int price,
                   @JsonProperty("genre") String genre,
                   @JsonProperty("type") String type
                   )
                    {
        this.title = title;
        this.yearOfAppearance = yearOfAppearance;
        this.duration = duration;
        this.director = director;
        this.ageRestriction = ageRestriction;
        this.price = price;
        this.genre = genre;
        this.type = type;
    }

    public  String getGenre(){return genre;}
    public int getYearOfAppearance() {
        return yearOfAppearance;
    }


    public int getDuration() {
        return duration;
    }


    public String getDirector() {
        return director;
    }


    public int getAgeRestriction() {
        return ageRestriction;
    }
    public int getPrice(){return price;}

    public String getTitle(){return title;}

    public abstract String getType();




}
