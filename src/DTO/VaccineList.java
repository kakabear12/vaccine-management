/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Xqy
 */
public class VaccineList extends ArrayList<Vaccine> {

    Scanner sc = new Scanner(System.in);

    public int getUserChoice() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "- " + this.get(i));
        }
        System.out.println("Choose option: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void loadFromFile() {
         try {
            String file = "vaccine.txt";
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Vaccine vc = null;
            while (true) {
                vc = (Vaccine) ois.readObject();
                this.add(vc);
                if (is.available() < 1) {
                    break;
                }
            }
            ois.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String listOfVac() {
        loadFromFile();
        String idV = "";
        System.out.println("List of Vaccine:");
        int choice = 0;
        do {
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    idV =this.get(choice - 1).getvID();
                    break;
                case 2:
                    idV =this.get(choice - 1).getvID();
                    break;
                case 3:
                    idV =this.get(choice - 1).getvID();
                    break;
                case 4:
                    idV =this.get(choice - 1).getvID();
                    break;
                case 5:
                    idV =this.get(choice - 1).getvID();
                    break;
            }
        } while (choice < 0 && choice >6);
        return idV;
    }

}
