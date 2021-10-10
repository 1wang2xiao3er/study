package cn.edu.jxnu.HYCServlet.Day02;

import java.util.Date;

public class CustomerT {

    private String name;
    private String pwd;
    private String email;
    private Date date;



    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CustomerT{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }









}
