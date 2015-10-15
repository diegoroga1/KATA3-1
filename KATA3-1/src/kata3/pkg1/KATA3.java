/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata3.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Melany
 */
public class KATA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic heres
        Histogram<String>  miHisto = new Histogram<>();
        String name ="C:\\Users\\Melany\\Documents\\emailsfilev1.txt";
        
        try {
            BufferedReader fileIn= new BufferedReader(new FileReader(name));
            String mail;
            
            while((mail=fileIn.readLine())!=null){
                if(mail.contains("@")){
                    miHisto.increment(mail.split("@")[1]);
                    
                }
            }
            
        }catch(Exception e){
            System.out.println("Fichero no existe");
        
        }
        
        
        HistogramDisplay histo = new HistogramDisplay(miHisto);
        histo.execute();
    }
    
}
