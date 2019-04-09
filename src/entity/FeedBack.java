package entity;

public class FeedBack {
    private int id;
    private  int accountid;
    private String contend;
    private int status;

    public FeedBack(int id, int accountid, String contend, int status) {
        this.id = id;
        this.accountid = accountid;
        contend = contend;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getContend() {
        return contend;
    }

    public void setContend(String contend) {
        contend = contend;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
