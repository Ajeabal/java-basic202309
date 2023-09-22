package day05.poly.car;

import util.Utility;

public class Main {
    public static void main(String[] args) {

        Avante avante = new Avante();
        Car avante2 = new Avante();
        Car mustang = new Mustang();
        Car stinger = new Stinger();

        Car[] cars = {avante, avante2, mustang, stinger};
        for (Car c : cars) {
            c.accelerate();
        }

        Object[] arr = {"hello", "안녕", 10, false};

        Utility.makeLine();

        Driver park = new Driver();
        park.drive(avante);
        park.drive(mustang);
        park.drive(stinger);

        CarShop shop = new CarShop();
        Utility.makeLine();
        Mustang myCar = (Mustang) shop.exportCar(6000);
        myCar.accelerate();

//        Car car = new Car();
//        Avante aaa = (Avante) car;

        Car kakao = shop.exportCar(5000);
        System.out.println(kakao instanceof Avante);
        System.out.println(kakao instanceof Stinger);
        System.out.println(kakao instanceof Mustang);

        if (kakao instanceof Mustang) {
            Mustang ms = (Mustang) kakao;
        }
    }
}
