package sk.first.servlet;

public class Born_cities {

    private int id;
    private String name;
    private String country_code;

    public Born_cities(int id, String name, String country_code) {
        this.id = id;
        this.name = name;
        this.country_code = country_code;
    }

    public Born_cities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
