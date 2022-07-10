/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreaterFile;

import DTO.Vaccine;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xqy
 */
public class WriteVaccine {
    public static void main(String[] args) {
        try {
            String filename = "vaccine.txt";
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            List<Vaccine> list= new ArrayList<>();
            list.add(new Vaccine("Covid-V001", "AstraZeneca"));
            list.add(new Vaccine("Covid-V002", "SPUTNIK V"));
            list.add(new Vaccine("Covid-V003", "Vero Cell"));
            list.add(new Vaccine("Covid-V004", "Pfizer"));
            list.add(new Vaccine("Covid-V005", "Mederna"));
            for (Vaccine vc : list) {
                oStream.writeObject(vc);
            }
            oStream.close();
            file.close();
        } catch (Exception e) {
        }
    }
}
