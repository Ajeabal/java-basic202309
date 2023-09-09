package day03.member;

import java.util.Arrays;

// 책임(역할): 회원을 여러명 저장 관리하는 클래스
public class MemberRepository {

    // 필드: 회원 배열
    // [ { id: 1, name: 'ddd' }, {} ]
    Member[] memberList; // 가입된 회원 배열
    Member[] removeMembers; // 삭제된 회원 배열

    public MemberRepository() {
        this.memberList = new Member[]{
                new Member(1, "abc@def.com", "1234", "콩벌레", Gender.MALE, 15),
                new Member(2, "fff@ggg.com", "4567", "팥죽이", Gender.FEMALE, 30),
                new Member(3, "a@a.com", "a", "a", Gender.FEMALE, 1),
                new Member(4, "b@b.com", "b", "b", Gender.FEMALE, 2),
                new Member(5, "c@c.com", "c", "c", Gender.FEMALE, 3),
                new Member(6, "d@d.com", "d", "d", Gender.FEMALE, 4),
                new Member(7, "e@e.com", "e", "e", Gender.FEMALE, 5),
                new Member(8, "f@f.com", "f", "f", Gender.FEMALE, 6),
                new Member(9, "g@g.com", "g", "g", Gender.FEMALE, 7)
        };
        this.removeMembers = new Member[]{};
    }

    /**
     * 모든 회원정보를 출력하는 메서드
     */
    void showMembers() {
        System.out.printf("=============== 현재 회원정보 ( 총 %d명 ) ============\n", memberList.length);
        for (Member member : memberList) {
            System.out.println(member.inform());
        }
    }


    void showChoosedMember(Member member) {
        System.out.printf("번호: %s\n", member.memberId);
        System.out.printf("이메일: %s\n", member.email);
        System.out.printf("비밀번호: %s\n", member.password);
        System.out.printf("이름: %s\n", member.memberName);
        System.out.printf("성별: %s\n", member.gender);
        System.out.printf("나이: %s\n", member.age);

    }

    int checkMemberIsTen() {
        return memberList.length;
    }

    /**
     * 새로운 회원정보를 추가하는 메서드
     */
    boolean addMember(Member newMember) {
        // push 알고리즘
        Member[] temp = new Member[memberList.length + 1];
        for (int i = 0; i < memberList.length; i++) {
            temp[i] = memberList[i];
        }
        temp[temp.length - 1] = newMember;
        memberList = temp;
        return true;
    }

    void addRemoveMembers(Member newRemoveMembers) {
        Member[] temp = new Member[removeMembers.length + 1];
        for (int i = 0; i < removeMembers.length; i++) {
            temp[i] = removeMembers[i];
        }
        temp[temp.length - 1] = newRemoveMembers;
        removeMembers = temp;
    }

    /**
     * 이메일의 중복여부를 확인하는 메서드
     *
     * @return - 중복되었다면 true, 아니라면 false
     * @param1 email - 중복검사 대상 이메일
     */
    boolean isDuplicatedEmail(String email) {
        for (Member member : memberList) {
            if (email.equals(member.email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 이메일을 통해 특정 회원 객체를 찾아서 반환하는 메서드
     *
     * @return - 해당 이메일과 일치하는 회원의 모든정보 객체
     * 이메일이 일치하지 않으면 null 리턴
     * @param1 email - 탐색할 멤버객체의 이메일
     */
    Member findMemberByEmail(String email) {
        for (Member member : memberList) {
            if (email.equals(member.email)) {
                return member;
            }
        }
        return null;
    }

    /**
     * 비밀번호를 수정하는 메서드
     */
    void updatePassword(String newPassword, String email) {
        Member member = findMemberByEmail(email);
        member.password = newPassword;
    }

    /**
     * 회원탈퇴를 처리하는 메서드
     */
    int indexOf(String email, String pw) {
        int index = 0;
        for (int i = 0; i < memberList.length; i++) {
            if (memberList[i].email.equals(email) && memberList[i].password.equals(pw)) {
                index = i;
                break;
            } else {
                index = -1;
            }
        }
        return index;
    }

    int indexOfRemoveMember(String email, String pw) {
        int index = 0;
        for (int i = 0; i < removeMembers.length; i++) {
            if (removeMembers[i].email.equals(email) && removeMembers[i].password.equals(pw)) {
                index = i;
                break;
            } else {
                index = -1;
            }
        }
        return index;
    }

    Member findMemberByEmailAndPassWord(String email, String pw) {
        for (Member member : removeMembers) {
            if (email.equals(member.email) && pw.equals(member.password)) {
                return member;
            }
        }
        return null;
    }

    void deleteMember(String email, String pw) {
        addRemoveMembers(findMemberByEmail(email));
        int deleteTargetIndex = indexOf(email, pw);
        if (deleteTargetIndex != -1) {
            Member[] temp = new Member[memberList.length - 1];
            for (int i = deleteTargetIndex; i < memberList.length - 1; i++) {
                memberList[i] = memberList[i + 1];
            }
            for (int j = 0; j < temp.length; j++) {
                temp[j] = memberList[j];
            }
            memberList = temp;
            System.out.println("# 회원 탈퇴 완료");
        } else {
            System.out.println("회원정보를 찾지 못했습니다.");
        }
    }

    void showRemovedMembers() {
        System.out.printf("=============== 현재 탈퇴 회원정보 ( 총 %d명 ) ============\n", removeMembers.length);
        for (Member member : removeMembers) {
            System.out.println(member.inform());
        }
    }

    void restoreMember(String email, String pw) {
        Member newMember = findMemberByEmailAndPassWord(email, pw);
        if (newMember == null){
            System.out.println("회원정보를 찾지 못했습니다.");
            return;
        }
        Member[] temp1 = new Member[memberList.length + 1];
        for (int i = 0; i < memberList.length; i++) {
            temp1[i] = memberList[i];
        }
        temp1[temp1.length - 1] = newMember;
        memberList = temp1;
        int deleteTargetIndex = indexOfRemoveMember(email, pw);
        if (deleteTargetIndex != -1) {
            Member[] temp2 = new Member[removeMembers.length - 1];
            for (int j = deleteTargetIndex; j < removeMembers.length - 1; j++) {
                removeMembers[j] = removeMembers[j + 1];
            }
            for (int j = 0; j < temp2.length; j++) {
                temp2[j] = removeMembers[j];
            }
            removeMembers = temp2;
            System.out.println("회원복구가 완료 되었습니다.");
        } else {
            System.out.println("회원정보를 찾지 못했습니다.");
        }
    }
}
