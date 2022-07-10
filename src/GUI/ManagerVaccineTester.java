/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.StudentList;
import DTO.injectionList;

/**
 *
 * @author Xqy
 */
public class ManagerVaccineTester {

    public static void main(String[] args){
        System.out.println("Welcome to Food Management - @ 2021 by <SE150511 - Nguyen Thanh Trung>");
        Menu mnu = new Menu();
        mnu.add("Show information all students have been injected");
        mnu.add("Add student's vaccine injection information");
        mnu.add("Updating information of students' vaccine injection");
        mnu.add("Delete student vaccine injection information");
        mnu.add("Search for injection information by studentID");
        mnu.add("Others- Quit");
        StudentList list1 = new StudentList();
        injectionList list2 = new injectionList(list1);
        list2.readfile();
        int userChoice;
        do {
            userChoice = mnu.getUserChoice();
            switch (userChoice) {
                case 1:
                    list2.showInfo();
                    break;
                case 2:
                    list2.addAll();
                    break;
                case 3:
                    list2.updateVaccination();
                    break;
                case 4:
                    list2.delete();
                    break;
                case 5:
                    list2.searchBysID();
                    break;
            }
        } while (userChoice >= 0 && userChoice < 6);
        list2.writeFile();
    }
}
