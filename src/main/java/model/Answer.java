package model;

import java.io.Serializable;
import java.util.Arrays;

public class Answer implements Serializable {
    public static final long serialVersionUID = 2L;
    Student student;
    Object[] answers;
    boolean[] isRights;
    boolean allreadyRegistration;

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setAnswers(Object[] answers) {
        this.answers = answers;
    }

    public void setIsRights(boolean[] isRights) {
        this.isRights = isRights;
    }

    public void setAllreadyRegistration(boolean allreadyRegistration) {
        this.allreadyRegistration = allreadyRegistration;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Student getStudent() {
        return student;
    }

    public Object[] getAnswers() {
        return answers;
    }

    public boolean[] getIsRights() {
        return isRights;
    }

    public boolean isAllreadyRegistration() {
        return allreadyRegistration;
    }

    public Answer(Student student, Object[] answers, boolean[] isRights, boolean allreadyRegistration) {
        this.student = student;
        this.answers = answers;
        this.isRights = isRights;
        this.allreadyRegistration = allreadyRegistration;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "student=" + student +
                ", answers=" + Arrays.toString(answers) +
                ", isRights=" + Arrays.toString(isRights) +
                ", allreadyRegistration=" + allreadyRegistration +
                '}';
    }
}
