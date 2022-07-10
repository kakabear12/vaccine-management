/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Xqy
 */
public class injectionList extends ArrayList<StudentVac> {

    StudentList stList;

    Scanner sc = new Scanner(System.in);

    public injectionList(StudentList stList) {
        this.stList = stList;
    }

    public int findsID(String sID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getsID().equals(sID)) {
                return i;
            }
        }
        return -1;
    }

    public StudentVac search(String sID) {
        for (StudentVac stv : this) {
            if (stv.getsID().equals(sID)) {
                return stv;
            }
        }
        return null;
    }

    public StudentVac searchjID(String jID) {
        for (StudentVac stv : this) {
            if (stv.getjID().equals(jID)) {
                return stv;
            }
        }
        return null;
    }

    public String ChecksID(String sID) {
        Check c = new Check();
        while (true) {
            sID = c.checkId().toUpperCase();
            if (stList.search(sID) != -1) {
                return sID;
            } else {
                System.out.println("Invalid ID. Retype!!");
            }
        }
    }
// add 1 stvac to list
    public void addAll() {
        String asn = "";
        StudentVac stv = new StudentVac();
        do {
            String sID = "";
            System.out.println("Input student ID: ");
            sID = ChecksID(sID);
            stv.input();
            stv.setsID(sID);
            if (this.add(stv)) {
                System.out.println("Added.");
            } else {
                System.out.println("Add Failed, retype!");
            }
            System.out.println("Do you want adding a injections? Yes or No(Y/N)");
            asn = sc.nextLine().toUpperCase();
        } while (asn.equals("Y"));

    }

    public void showInfo() {
        System.out.printf("%-14s %-14s %-12s %-12s %-16s %-12s %-16s\n", "Injection ID", "Student ID", "Vaccine ID", "1st Place", "Date 1", "2nd Place", "Date 2");
        for (StudentVac stv : this) {
            if ((stv.getD2()) != null && (stv.getPlace2() != null)) {
                stv.output();
            }
        }
    }
//update 1 stvac to list
    public void updateVaccination() {
        String jID;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        Check c = new Check();
        System.out.println("Input injection need update: ");
        jID = c.checkId().toUpperCase();
        StudentVac kq = searchjID(jID);
        if (kq != null) {
            System.out.println("Input 2nd injection place need update: ");
            kq.setPlace2(c.checkPlace().toUpperCase());
            System.out.println("Input 2nd injection date need update: ");
            kq.setD2(c.checkDate(sc.nextLine()));
            System.out.println("Result after update: ");
            kq.output();
            System.out.println("Student has completed 2 injections!");
        } else {
            System.out.println("Injection does not exist.");
        }
    }

    public boolean remove(String jID) {
        StudentVac kq = searchjID(jID);
        return this.remove(kq);
    }
//delete 1 object student vaccine
    public void delete() {
        String jID;
        Check c = new Check();
        System.out.println("Input jID you want to delete: ");
        jID = c.checkId().toUpperCase();
        String ans;
        System.out.print("Are you sure you want to delete this food?  Yes or No(1/0)");
        ans = sc.nextLine().toUpperCase();
        if (ans.equals("Y")) {
            if (this.remove(jID)) {
                System.out.println("Deleted!.");
            } else {
                System.out.println("Deleted failed!");
            }
        }
    }
//Search by ID student
    public void searchBysID() {
        Check c = new Check();
        System.out.println("Input student ID");
        String sID = c.checkId().toUpperCase();
        StudentVac kq = this.search(sID);
        if (kq != null) {
            kq.output();
        } else {
            System.out.println("Search fail!");
        }
    }

    public boolean upDateFromstList(StudentList stList) {
        return stList.loadFromFile();
    }
//loadfie
    public void readfile() {
        stList.loadFromFile();
        String file = "Vaccinations.txt";
        StudentVac stv = new StudentVac();
        try {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            while (true) {
                stv = (StudentVac) ois.readObject();
                this.add(stv);
                if (is.available() < 1) {//Trả về số lượng byte có thể được đọc đến chặn, mặc định là 0
                    break;
                }
            }
            ois.close();
            is.close();
            for (Student st : stList) {
                String sID = st.getsID();
                stv = search(sID);
                if (stv == null) {
                    stv = new StudentVac(st);
                    this.add(stv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//save file
    public void writeFile() {
        String filename = "Vaccinations.txt";
        try {

            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            for (StudentVac stv : this) {
                oStream.writeObject(stv);
            }
            oStream.close();
            file.close();
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("Fail!");
        }
    }

}
