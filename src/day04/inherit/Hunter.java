package day04.inherit;

public class Hunter extends Player {

    private String beast;

    public Hunter(String nickName) {
        super(nickName);
        this.beast = "미샤";
    }

    @Override
    public void status() {
        super.status();
        System.out.println("# beast = " + beast);
    }

    public void arrowShot() {
        System.out.println("화살 발사");
    }

    public String getBeast() {
        return beast;
    }

    public void setBeast(String beast) {
        this.beast = beast;
    }
}
