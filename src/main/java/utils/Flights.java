package utils;

public class Flights {

    private String flyingFromCity;
    private String flyingFromAirport;
    private String flyingToCity;
    private String flyingToAirport;
    private String departingDate;
    private String returningDate;

    public String getFlyingFromCity() {
        return flyingFromCity;
    }

    public void setFlyingFromCity(String flyingFromCity) {
        this.flyingFromCity = flyingFromCity;
    }

    public String getFlyingFromAirport() {
        return flyingFromAirport;
    }

    public void setFlyingFromAirport(String flyingFromAirport) {
        this.flyingFromAirport = flyingFromAirport;
    }

    public String getFlyingToCity() {
        return flyingToCity;
    }

    public void setFlyingToCity(String flyingToCity) {
        this.flyingToCity = flyingToCity;
    }

    public String getFlyingToAirport() {
        return flyingToAirport;
    }

    public void setFlyingToAirport(String flyingToAirport) {
        this.flyingToAirport = flyingToAirport;
    }

    public String getDepartingDate() {
        return departingDate;
    }

    public void setDepartingDate(String departingDate) {
        this.departingDate = departingDate;
    }

    public String getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(String returningDate) {
        this.returningDate = returningDate;
    }
}
