package joker.bloodbanktest;

/**
 * Created by Joker on 30-Jan-17.
 */

public class DonorDetails {

    String dName, dMobile, dLoca, dBldgrp, dAge, dWeight, dpass, dEmail;
    int dLastD, dLastM, dLastY;
    int _id;

    public DonorDetails( int _id, String dName,  String dMobile, String dEmail, String dLoca, String dpass, String dBldgrp, String dAge, String dWeight, int dLastD, int dLastM, int dLastY) {
        this.dName = dName;
        this.dMobile = dMobile;
        this.dLoca = dLoca;
        this.dBldgrp = dBldgrp;
        this.dAge = dAge;
        this.dWeight = dWeight;
        this.dpass = dpass;
        this.dEmail = dEmail;
        this.dLastD = dLastD;
        this.dLastM = dLastM;
        this.dLastY = dLastY;
        this._id = _id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdMobile() {
        return dMobile;
    }

    public void setdMobile(String dMobile) {
        this.dMobile = dMobile;
    }

    public String getdLoca() {
        return dLoca;
    }

    public void setdLoca(String dLoca) {
        this.dLoca = dLoca;
    }

    public String getdBldgrp() {
        return dBldgrp;
    }

    public void setdBldgrp(String dBldgrp) {
        this.dBldgrp = dBldgrp;
    }

    public String getdAge() {
        return dAge;
    }

    public void setdAge(String dAge) {
        this.dAge = dAge;
    }

    public String getdWeight() {
        return dWeight;
    }

    public void setdWeight(String dWeight) {
        this.dWeight = dWeight;
    }

    public String getDpass() {
        return dpass;
    }

    public void setDpass(String dpass) {
        this.dpass = dpass;
    }

    public String getdEmail() {
        return dEmail;
    }

    public void setdEmail(String dEmail) {
        this.dEmail = dEmail;
    }

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

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}