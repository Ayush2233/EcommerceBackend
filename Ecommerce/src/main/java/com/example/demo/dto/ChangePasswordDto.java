package com.example.demo.dto;

public class ChangePasswordDto {

    private int id;
    private String oldpassword;

    private String newpassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public ChangePasswordDto(int id, String oldpassword, String newpassword) {
        this.id = id;
        this.oldpassword = oldpassword;
        this.newpassword = newpassword;
    }
}
