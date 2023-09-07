package day02;

public enum Genre {

    HIPHOP("힙합"),

    KPOP("케이팝"),

    STREET("스트리트"),

    URBAN("어반");

    private String genreName;

    Genre(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }
}
