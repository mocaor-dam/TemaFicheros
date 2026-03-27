package ejercicio10;

import utils.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ejercicio10 {
    static void main(String[] args) {
        leerFichero();
    }

    public static void leerFichero(){
        String nombreFichero = MiEntradaSalida.leerLinea("Indica el nombre del fichero \n");

        Path fichero = Path.of("src", "ejercicio10", nombreFichero);

        if (Files.isRegularFile(fichero) && Files.isReadable(fichero)){

            Pattern p = Pattern.compile("^F\\s((?:\\w:\\/)?(?:\\w+\\/)*[\\d\\p{L}]{3,}\\.\\p{L}{3})$");

            try (Stream<String> lineas = Files.lines(fichero)){
                lineas.map(p::matcher).filter(Matcher::find)
                        //Coge el grupo 1 que es to do el parentesis, ya que con ?: digo que no lo coja
                        .map(m -> m.group(1))
                        .map(Path::of)
                        .forEach(s -> {
                            try {
                                Files.createFile(s);
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
