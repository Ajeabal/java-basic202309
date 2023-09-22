package day09.api.obj;

import java.util.Objects;

public class Pen {
    private Company company;
    private Integer serial;
    private String color;
    private Long price;

    public Pen(Company company, int serial, String color, long price) {
        this.company = company;
        this.serial = serial;
        this.color = color;
        this.price = price;
    }

    public Pen() {
    }

    @Override
    public String toString() {
        return "pen{" +
                "company=" + company +
                ", serial=" + serial +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    // equals를 오버라이딩할 때는
    // 반드시 hashCode()도 같이 오버라이딩 해야한다.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pen) {
            Pen target = (Pen) obj;
            return this.serial == target.serial
                    && this.company.equals(target.company)
                    && this.color.equals(target.color);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial, color, company);
    }
}
