/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Xqy
 */
public class Student implements Serializable{
    private String sID;
    private String sName;

    public Student() {
    }

    public Student(String sID, String SName) {
        this.sID = sID;
        this.sName = SName;
    }
    
    public Student(String sID){
       this.sID = sID;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String SName) {
        this.sName = SName;
    }

    @Override
    public String toString() {
        return sID + "\t\t" + sName;
    }
    
}
