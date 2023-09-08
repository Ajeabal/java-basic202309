package day03.member;

public class Test {
    public static void main(String[] args) {
        MemberRepository mr = new MemberRepository();
        Member thief = new Member(4, "zzz@vvv.com", "1357", "밥도둑", Gender.MALE, 11);
        mr.addMember(thief);
        mr.showMembers();
        System.out.println("================");

        String email = "fff@ggg.com";
        boolean flag1 = mr.isDuplicatedEmail(email);
        System.out.println("flag1 = " + flag1);
    }
}
