package joker.bloodbanktest;

/**
 * Created by Joker on 25-Jan-17.
 */

public class Contact {

    String dName;
    String dMobile;
    String dEmail;
    String dLoca;
    String dPass;
    String dBldgrp;
    String dAge;
    int dLastD;
    int dLastM;
    int dLastY;

    public int getdLastD() {
        return dLastD;
    }

    public void setdLastD(int dLastD) {
        this.dLastD = dLastD;
    }

    public int getdLastM() {
        return dLastM;
    }

    public void setdLastM(int dLastM) {
        this.dLastM = dLastM;
    }

    public int getdLastY() {
        return dLastY;
    }

    public void setdLastY(int dLastY) {
        this.dLastY = dLastY;
    }

    String dWeight;
    String bloodborneHiv;
    String bloodborneHp;

    void setdName(String str)
    {
        this.dName = str;
    }
    String getdName()
    {
        return this.dName;
    }
    void setdMobile(String str)
    {
        this.dMobile = str;
    }
    String getdMobile()
    {
        return this.dMobile;
    }
    void setdEmail(String str)
    {
        this.dEmail = str;
    }
    String getdEmail()
    {
        return this.dEmail;
    }
    void setdLoca(String str)
    {
        this.dLoca = str;
    }
    String getdLoca()
    {
        return this.dLoca;
    }
    void setdPass(String str)
    {
        this.dPass = str;
    }
    String getdPass()
    {
        return this.dPass;
    }
    void setdBldgrp(String str)
    {
        this.dBldgrp = str;
    }
    String getdBldgrp()
    {
        return this.dBldgrp;
    }
    void setdAge(String str)
    {
        this.dAge = str;
    }
    String getdAge()
    {
        return this.dAge;
    }
    void setdWeight(String str)
    {
        this.dWeight = str;
    }
    String getdWeight()
    {
        return this.dWeight;
    }

    public String getBloodborneHiv() {
        return bloodborneHiv;
    }

    public void setBloodborneHiv(String bloodborneHiv) {
        this.bloodborneHiv = bloodborneHiv;
    }

    public String getBloodborneHp() {
        return bloodborneHp;
    }

    public void setBloodborneHp(String bloodborneHp) {
        this.bloodborneHp = bloodborneHp;
    }
}