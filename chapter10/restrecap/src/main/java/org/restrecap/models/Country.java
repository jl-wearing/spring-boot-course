package org.restrecap.models;

public class Country {
    private String name;
    private int population;

    public void setName(String name){
        this.name = name;
    }

    public void setPopulation(int population){
        this.population = population;
    }

    public String getName(){
        return this.name;
    }

    public int getPopulation(){
        return this.population;
    }

    public static Country of(String name, int population){
        Country country = new Country();
        country.name = name.trim();
        country.population = population;
        return country;
    }
}
