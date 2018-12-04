package dto;

public class Admin {

    // 관리자아이디 
    private String adminId;

    // 관리자비밀번호 
    private String adminPw;


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(String adminPw) {
        this.adminPw = adminPw;
    }


    // AdminTb 모델 복사
    public void CopyData(Admin param)
    {
        this.adminId = param.getAdminId();
        this.adminPw = param.getAdminPw();
    }
}