package day04.encap;

public class main {
    public static void main(String[] args) {
        Car myCar = new Car("그랜져");
//        myCar.speed = -999999999;
//        myCar.mode = 'Z';
        myCar.setSpeed(90);
        System.out.println(myCar.getSpeed());
        myCar.setMode('D');
        System.out.println(myCar.getMode());

//        myCar.moveCylinder();
//        myCar.inject();
//        myCar.putOil();
        myCar.pressButton();
    }
}
