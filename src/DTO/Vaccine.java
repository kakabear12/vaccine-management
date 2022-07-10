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
public class Vaccine implements Serializable{
    private String vID;
    private String vName;

    public Vaccine() {
    }
    
    
    public Vaccine(String vID, String vName) {
        this.vID = vID;
        this.vName = vName;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    @Override
    public String toString() {
        return  vID + "\t" + vName ;
    }
    
     
}
