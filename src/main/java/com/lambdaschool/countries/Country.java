package com.lambdaschool.countries;
import java.util.concurrent.atomic.AtomicLong;

public class Country {

    private static AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int landMass;
    private int medianAge;

    public Country(String name, int population, int landMass, int medianAge) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getMedianAge() {
        return medianAge;
    }


    @Override
    public String toString() {
        return "Countries{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", landMass=" + landMass +
                ", medianAge=" + medianAge +
                '}';
    }
}
