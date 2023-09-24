package cn.esuny.super_cube.model.user_account;


public class Account_Authentication {
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String loginName) {
        this.account = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
