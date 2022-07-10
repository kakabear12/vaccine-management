/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Xqy
 */


public class StudentList extends ArrayList<Student> {

    public StudentList() {
        super();
    }

    public boolean loadFromFile() {
        try {
            String file = "student.txt";
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);           
            while (true) {
                Student  st = (Student) ois.readObject();
                this.add(st);
                if (is.available() < 1) {
                    break;
                }
            }
            ois.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public int search(String sID) {
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).getsID().equals(sID))
                return i;
        }
        return -1;
    }
    public void print(){
        for (Student thi : this) {
            System.out.println(" ID: "+thi.getsID()+" Name "+thi.getsName());
        }
    }
    
}
