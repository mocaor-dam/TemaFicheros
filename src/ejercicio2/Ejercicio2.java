package ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio2 {
    static void main(String[] args) {

        Path p = Path.of("./src/ejercicio1/leeme.txt");

        try (Stream<String> lineas = Files.lines(p)) {

            System.out.println(lineas.collect(Collectors.joining(" ")));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
