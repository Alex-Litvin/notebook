package ua.training.model.entity;

public class Address {
    private Integer postcode;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Address { " + "\n" +
                "postcode = " + postcode + ",\n" +
                "city = " + city + ",\n" +
                "street = " + street + ",\n" +
                "houseNumber = " + houseNumber + ",\n" +
                "apartmentNumber = " + apartmentNumber + " }";
    }
}
