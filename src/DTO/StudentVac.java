/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Xqy
 */
public class StudentVac extends Student implements Serializable{
    private String jID;
    private String vID;
    private String place1;
    private Date d1;
    private String place2;
    private Date d2;

    public StudentVac(String sID, String sName) {
        super(sID, sName);
    }

    public StudentVac() {
    }
    
    public StudentVac(String sID,String jID, String vID, String place1, Date d1, String place2, Date d2) {
        super(sID);
        this.jID = jID;
        this.vID = vID;
        this.place1 = place1;
        this.d1 = d1;
        this.place2 = place2;
        this.d2 = d2;
    }

    public StudentVac(Student st) {
        super(st.getsID(), st.getsName());
    }

    

    public String getjID() {
        return jID;
    }

    public void setjID(String jID) {
        this.jID = jID;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public Date getD1() {
        return d1;
    }

    public void setD1(Date d1) {
        this.d1 = d1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public Date getD2() {
        return d2;
    }

    public void setD2(Date d2) {
        this.d2 = d2;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        Check c = new Check();
        VaccineList vl = new VaccineList();
        if (this != null) {
            if (vID == null) {//chua cap nhat
                System.out.println("Input injection ID: ");
                jID = c.checkId().toUpperCase();
                vID = vl.listOfVac().toUpperCase();
                System.out.println("Input 1st injection place: ");
                place1 = c.checkPlace().toUpperCase();
                System.out.println("Input 1st injection date: ");
                sc = new Scanner(System.in);
                d1 = c.checkDate(sc.nextLine());
                if (c.daysBt2day(d1) >= 28) {//du so ngay de nhap mui 2
                    System.out.println("Do you want input 2nd injection? (Y/N)");
                    String ans = sc.nextLine().toUpperCase();
                    if (ans.equals("Y")) {
                        System.out.println("Input 2nd injection place:");
                        place2 = c.checkPlace().toUpperCase();
                        sc = new Scanner(System.in);
                        System.out.println("Input 2n injection date: ");
                        d2 = c.checkDate(sc.nextLine());
                    } else {
                        place2 = "";
                        d2 = null;
                    }
                }
            } else if (place1 != null && (c.daysBt2day(d1) >= 28)) {
                System.out.println("Do you want input 2nd injection? (Y/N)");
                String ans = sc.nextLine().toUpperCase();
                if (ans.equals("Y")) {
                    System.out.println("Input 2nd injection place:");
                    place2 = c.checkPlace().toUpperCase();
                    System.out.println("Input 2n injection date: ");
                    d2 = c.checkDate(sc.nextLine());
                } else {
                    place2 = "";
                    d2 = null;
                }
            } else {
                System.out.println("Had two injections!");
            }
            
        }else{
            System.out.println("Invalid student ID. Retype.");
        }
    }  

    @Override
    public String toString() {
        return  getsID()+"\t " + jID + "\t" + vID + "\t" + place1 + "\t" + printDate(d1) + "\t" + place2 + "\t" + printDate(d2) ;
    }
    public void output(){
        System.out.printf("%-14s %-14s %-12s %-12s %-16s %-12s %-14s\n", this.getjID(), this.getsID(), this.getvID(), this.getPlace1(), printDate(d1), this.getPlace2(), printDate(d2));
    }
    public String printDate(Date d ){
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	if(d==null) return null;
	return df.format(d);
    } 
    
}
