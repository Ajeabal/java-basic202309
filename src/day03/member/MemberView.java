package day03.member;

import java.util.Scanner;

// 역할: 회원관리 앱의 입출력을 담당
public class MemberView {

    Scanner sc;
    MemberRepository mr;

    public MemberView() {
        this.sc = new Scanner(System.in);
        this.mr = new MemberRepository();
        viewProcess();
    }

    /**
     * 초기 메인 화면을 출력
     */
    void mainView(boolean isTen) {
        System.out.println("\n##### 회원 관리 시스템 #####");
        if (isTen) {

        } else {
            System.out.println("* 1. 회원 정보 등록하기");
        }
        System.out.println("* 2. 개별회원 정보 조회하기");
        System.out.println("* 3. 전체회원 정보 조회하기");
        System.out.println("* 4. 회원 정보 수정하기");
        System.out.println("* 5. 회원 정보 삭제하기");
        System.out.println("* 6. 프로그램 끝내기");
        System.out.println("* 7. 회원 복구하기");
        System.out.println("=============================");
    }

    /**
     * 프로그램 화면 흐름을 제어하는 기능
     */

    void viewProcess() {
        while (true) {
            boolean isTen = checkIsTen();
            mainView(isTen);
            String menuNum = input(">> ");
            if (!isTen) {
                switch (menuNum) {
                    case "1":
                        signUp();
                        break;
                    case "2":
                        showChoosedMember();
                        break;
                    case "3":
                        mr.showMembers();
                        stop();
                        break;
                    case "4":
                        changePassword();
                        break;
                    case "5":
                        withdrawal();
                        break;
                    case "6":
                        String answer = input("# 정말로 종료합니까? [y/n] : ");
                        if (answer.toLowerCase().charAt(0) == 'y') {
                            System.out.println("# 프로그램을 종료합니다.");
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case "7":
                        memberRestore();
                        break;
                    default:
                        System.out.println("\n# 메뉴 번호를 다시 입력하세요");
                }
            } else {
                switch (menuNum) {
                    case "1":
                        System.out.println("가입된 회원이 10명을 넘어 회원 등록이 불가 합니다.");
                        stop();
                        break;
                    case "2":
                        showChoosedMember();
                        break;
                    case "3":
                        mr.showMembers();
                        stop();
                        break;
                    case "4":
                        changePassword();
                        break;
                    case "5":
                        withdrawal();
                        break;
                    case "6":
                        String answer = input("# 정말로 종료합니까? [y/n] : ");
                        if (answer.toLowerCase().charAt(0) == 'y') {
                            System.out.println("# 프로그램을 종료합니다.");
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case "7":
                        System.out.println("가입된 회원이 10명을 넘어 회원 복구가 불가 합니다.");
                        stop();
                        break;
                    default:
                        System.out.println("\n# 메뉴 번호를 다시 입력하세요");
                }
            }
        }
    }

    void memberRestore() {
        mr.showRemovedMembers();
        String email = input("# 복구할 대상의 이메일: ");
        String pw = input("# 복구할 대상의 비밀번호: ");
        mr.restoreMember(email, pw);
    }

    boolean checkIsTen() {
        int count = mr.checkMemberIsTen();
        if (count == 10){
            return true;
        }else {
            return false;
        }
    }

    private void changePassword() {
        // 이메일을 입력받음
        String email = input("# 수정 대상의 이메일: ");

        // 수정 대상 탐색
        Member member = mr.findMemberByEmail(email);

        // 회원이 탐색됨
        if (member != null) {
            System.out.printf("#%s님의 비밀번호를 변경합니다.\n", member.memberName);
            String newPassword = input("# 새로운 비밀번호: ");

            // 만약 새비번이 기존비번과 같은경우 pass
            if (member.password.equals(newPassword)) {
                System.out.println("# 기존 비밀번호와 동일합니다. 변경을 취소합니다.");
                stop();
                return;
            }
            mr.updatePassword(newPassword, email);
            System.out.println("# 비밀번호 변경이 완료되었습니다.");

        } else {
            System.out.println("\n# 조회 결과가 없습니다.");
        }
        stop();
    }

    // 회원가입 입출력을 처리하는 메서드
    void signUp() {

        String email = checkDuplicateEmailInput();
        String name = input("# 이름: ");
        String pw = input("# 패스워드: ");
        Gender gender = checkCorrectGenderInput();
        String age = input("# 나이: ");

        // 실제 배열에 저장 명령
        // 랜덤 아이디 생성 (1 ~ 999999)
        int randomId = (int) (Math.random() * 999999) + 1;
        Member newMember = new Member(randomId, email, pw, name, gender, Integer.parseInt(age));
        mr.addMember(newMember);

        System.out.println("# 회원 가입 성공!!");
        stop();
    }
    void withdrawal() {

        String email = input("# 이메일: ");
        String pw = input("# 패스워드: ");

        mr.deleteMember(email, pw);

        System.out.println("# 회원 탈퇴 완료");
        stop();
    }

    private Gender checkCorrectGenderInput() {
        while (true) {
            String inputGender = input("# 성별 [M/F]: ");
            switch (inputGender.toUpperCase()) {
                case "M":
                    return Gender.MALE;
                case "F":
                    return Gender.FEMALE;
                default:
                    System.out.println("# 성별을 M또는 F로 입력하세요!");
            }
        }
    }

    private String checkDuplicateEmailInput() {
        while (true) {
            String email = input("# 이메일: ");
            if (!mr.isDuplicatedEmail(email)) {
                return email;
            }
            System.out.println("# 이메일이 중복되었습니다.");
        }
    }

    void showChoosedMember() {
        // 이메일을 입력받음
        String email = input("# 수정 대상의 이메일: ");
        mr.showChoosedMember(email);
        stop();
    }

    // 입력처리를 간편하게 해주는 메서드
    public String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    // 엔터를 누르기전까지 멈추는 기능
    void stop() {
        System.out.println("\n======= 엔터를 눌러서 계속...======");
        sc.nextLine();
    }
}
