package model;

public class Address {
    private int id;
    private String postalCode;

    public Address(int id, String postalCode) {
        this.id = id;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
