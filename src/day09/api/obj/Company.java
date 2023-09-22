package day09.api.obj;

import java.util.Objects;

public class Company {
    private String color;
    private String address;

    public Company(String color, String address) {
        this.color = color;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "color='" + color + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(color, company.color) && Objects.equals(address, company.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, address);
    }
}
