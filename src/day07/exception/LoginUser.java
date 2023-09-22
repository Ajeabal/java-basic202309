package day07.exception;

public class LoginUser {

    String userAccount; // 사용자 가입 계정
    String userPassword; // 사용자 가입시 설정한 비밀번호

    public LoginUser(String userAccount, String userPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }

    public String validate(String inputAccount, String inputPassword) throws LoginFailException {
        if (userAccount.equals(inputAccount)) {
            if (userPassword.equals(inputPassword)) {
                // 로그인 성공
                return "SUCCES";
            } else {
                // 비번 불일치
                throw new LoginFailException("비밀번호가 올바르지 않음!");
            }
        } else {
            // 계정정보 불을치
            throw new LoginFailException("아이디가 올바르지 않음!");

        }
    }
}
