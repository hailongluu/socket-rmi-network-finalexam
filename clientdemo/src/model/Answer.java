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
public class Answer implements Serializable{
        public static final long serialVersionUID = 2L;
Student student;
Object[] answer;
boolean[] isRights;
boolean areadyRegistration;

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setAnswer(Object[] answer) {
        this.answer = answer;
    }

    public void setIsRights(boolean[] isRights) {
        this.isRights = isRights;
    }

    public void setAreadyRegistration(boolean areadyRegistration) {
        this.areadyRegistration = areadyRegistration;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Student getStudent() {
        return student;
    }

    public Object[] getAnswer() {
        return answer;
    }

    public boolean[] isIsRights() {
        return isRights;
    }

    public boolean isAreadyRegistration() {
        return areadyRegistration;
    }

    public Answer(Student student, Object[] answer, boolean[] isRights, boolean areadyRegistration) {
        this.student = student;
        this.answer = answer;
        this.isRights = isRights;
        this.areadyRegistration = areadyRegistration;
    }

    @Override
    public String toString() {
        for (int i = 0; i < isRights.length; i++) {
            System.out.println(isRights[i]);
        }
        return "Answer{" + "student=" + student + ", answer=" + answer + ", isRights=" + isRights + ", areadyRegistration=" + areadyRegistration + '}';
    
    }

}
