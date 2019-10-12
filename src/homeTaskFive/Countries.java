package homeTaskFive;

public enum Countries implements IGetAreaPopulation {

    Belarus,
    Russia,
    Ukraine,
    China,
    Latvia,
    Sweden,
    France,
    Austria,
    Portugal,
    Spain;
    private int areaKm;
    private long population;

    public int getArea() {
        return areaKm;
    }

    public void setArea(int areaKm) {
        this.areaKm = areaKm;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }


}

