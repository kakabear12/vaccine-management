/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreaterFile;

import DTO.Student;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xqy
 */
public class WriteStudent {
    public static void main(String[] args) {
        try {
            String filename = "student.txt";
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            List<Student> list= new ArrayList<>();
            list.add(new Student("SE15000", "Hoa Doan"));
            list.add(new Student("SE15001", "My Hanh"));
            list.add(new Student("SE15002", "Thanh Dat"));
            list.add(new Student("SE15003", "Tran Ha"));
            list.add(new Student("SE15004", "Van Tien"));
            list.add(new Student("SE15005", "Tan Nhan"));
            list.add(new Student("SE15006", "Ho Van"));
            list.add(new Student("SE15007", "Minh Tien"));
            for (Student st : list) {
                oStream.writeObject(st);
            }
            oStream.close();
            file.close();
        } catch (Exception e) {
        }
    }
}
