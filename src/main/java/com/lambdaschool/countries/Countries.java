package com.lambdaschool.countries;

public class Countries {

    private String name;
    private int population;
    private int landMass;
    private int medianAge;

    public Countries(String name, int population, int landMass, int medianAge) {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandMass() {
        return landMass;
    }

    public void setLandMass(int landMass) {
        this.landMass = landMass;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
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
