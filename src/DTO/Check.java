/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Xqy
 */
public class Check {
    Scanner sc = new Scanner(System.in);
    public String checkId() {
        String id;
        sc = new Scanner(System.in);
        do {
            id = sc.nextLine();
            if (!id.trim().equals("")) {
                break;
            } else {
                System.err.println("Id is not empty, please input again!");
            }
        } while (true);
        return id;
    }
    public String checkPlace() {
        String place;
        Scanner sc = new Scanner(System.in);
        do {
            place = sc.nextLine();
            if (!place.trim().equals("")) {
                break;
            } else {
                System.err.println("Place is not empty, please input again!");
            }
        } while (true);
        return place;
    }
    public Date checkDate(String date) {
        Date d = null;
       while (true) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                d = df.parse(date);
                return d;
            } catch (Exception e) {
                System.out.println("Invalid input date!!!.Please Re-enter:");
            }
        }
    }
    public long daysBt2day(Date d1){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        long millis=System.currentTimeMillis();   
        java.sql.Date d2=new java.sql.Date(millis);
        
        c1.setTime(d1);
        c2.setTime(d2);
        
        long nday=(c2.getTime().getTime()-c1.getTime().getTime())/(24*3600*1000);
        return nday;
    }
    public String checkName(){
        String name;
        sc = new Scanner(System.in);
        do {
            name = sc.nextLine();
            if (!name.trim().equals("")) {
                break;
            } else {
                System.err.println("Id is not empty, please input again!");
            }
        } while (true);
        return name;
    }
    public int checkInt() {
        int number;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Invalid number, please input again!");
            }
        } while (true);
        return number;
    }
}
