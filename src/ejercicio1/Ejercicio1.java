package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio1 {
    static void main(String[] args) {
        File f = new File("./src/ejercicio1/leeme.txt");



        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)){
            /*int contador = 0;

            while (br.readLine() != null){
                contador++;
            }

            System.out.printf("Habia %d lineas", contador);*/
            System.out.printf("Habia %d lineas", br.lines().count());

            Path fichero = Path.of("./src/ejercicio1/leeme.txt");
            System.out.printf("Habia %d lineas", Files.lines(fichero).count());



            Files.lines(fichero).count();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
