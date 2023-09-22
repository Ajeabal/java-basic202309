package day05.poly.car;

public class CarShop {


    public Car exportCar(int money) {
        if (money == 6000) {
            return new Mustang();
        } else if (money == 5000) {
            return new Stinger();
        } else if (money == 3000) {
            return new Avante();
        }
        return null;
    }
}
