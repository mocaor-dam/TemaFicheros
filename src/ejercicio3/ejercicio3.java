package ejercicio3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ejercicio3 {

    static void main(String[] args) {
        /*

        Forma IO

        File salida = new File("./src/ejercicio3/salidaEj3.txt");
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(new FileWriter(salida, true))) {

            String linea;

            while ((linea = bf.readLine()) != null && !linea.equalsIgnoreCase("fin")){
               //pw.write(linea);
                pw.println(linea);
            }


        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        */

        //Forma NIO

        Path fichero = Path.of("./src/ejercicio3/salidaEj3.txt");


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String linea;

            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")){
                Files.writeString(fichero, linea, StandardOpenOption.APPEND);
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
