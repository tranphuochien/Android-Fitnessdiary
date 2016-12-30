package com.example.op.fitnessdiary.ClassObject;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by OP on 12/30/2016.
 */

public class Account implements Serializable {
    private String id;
    private String nickname;
    private String email;
    private String DOB;
    private int rank;
    private String gender;
    private String avatar;
    private String password;

    public Account(String nickname, String email, String dob, String gender, String password) {
        this.id  = UUID.randomUUID().toString();
        this.nickname = nickname;
        this.email = email;
        this.DOB = dob;
        this.gender = gender;
        this.rank = 0;
        this.avatar = "";
        this.password = password;
    }

    public Account(String id, String nickname, String email, String dob, String gender, String password) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.DOB = dob;
        this.gender = gender;
        this.rank = 0;
        this.avatar = "";
        this.password = password;
    }

    public Account(String id, String nickname, String email, String dob, int rank, String gender, String avatar, String password) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.DOB = dob;
        this.rank = rank;
        this.gender = gender;
        this.avatar = avatar;
        this.password = password;
    }

    private Account() {}

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getId() {return this.id;}

    public int getRank() {return this.rank;}

    public String getNickname()
    {
        return this.nickname;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getDOB()
    {
        return this.DOB;
    }

    public String getAvatar()
    {
        return this.avatar;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getGender() {return this.gender;}

}
