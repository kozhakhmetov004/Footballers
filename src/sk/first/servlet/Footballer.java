package sk.first.servlet;

public class Footballer {

    private Long id;
    private String name;
    private String surname;
    private int salary;
    private String club;
    private int transferPrice;
    private Born_cities born_city;

    public Footballer(Long id, String name, String surname, int salary, String club, int transferPrice, Born_cities born_city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.club = club;
        this.transferPrice = transferPrice;
        this.born_city = born_city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(int transferPrice) {
        this.transferPrice = transferPrice;
    }

    public Born_cities getBorn_city() {
        return born_city;
    }

    public void setBorn_city(Born_cities born_city) {
        this.born_city = born_city;
    }
}
