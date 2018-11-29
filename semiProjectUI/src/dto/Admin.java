package dto;

public class Admin {

    // 관리자아이디 
    private String adminId;

    // 관리자비밀번호 
    private String adminPw;

    // 세션ID 
    private String sessionId;

    // 온라인 
    private String online;

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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    // AdminTb 모델 복사
    public void CopyData(Admin param)
    {
        this.adminId = param.getAdminId();
        this.adminPw = param.getAdminPw();
        this.sessionId = param.getSessionId();
        this.online = param.getOnline();
    }
}