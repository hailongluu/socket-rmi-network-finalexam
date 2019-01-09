/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author hailo
 */
public class Student implements Serializable {

    public static final long serialVersionUID = 1L;
String maSV;
String hovaten;
String IP;
int group;

    @Override
    public String toString() {
        return "Student{" + "maSV=" + maSV + ", hovaten=" + hovaten + ", IP=" + IP + ", group=" + group + '}';
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHovaten() {
        return hovaten;
    }

    public String getIP() {
        return IP;
    }

    public int getGroup() {
        return group;
    }

    public Student(String maSV, String hovaten, String IP, int group) {
        this.maSV = maSV;
        this.hovaten = hovaten;
        this.IP = IP;
        this.group = group;
    }

    
}
