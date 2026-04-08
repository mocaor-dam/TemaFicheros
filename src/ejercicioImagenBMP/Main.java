package ejercicioImagenBMP;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    static void main(String[] args) {
        Path rutaImagen = Path.of("src/files/pradera.bmp");
        Path rutaDestino = Path.of("src/files/destino.bmp");


        try (FileChannel canal = FileChannel.open(rutaImagen, StandardOpenOption.READ);
             FileChannel canal2 = FileChannel.open(rutaDestino, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            ByteBuffer buffer = ByteBuffer.allocate(54);
            ByteBuffer buffer1 = ByteBuffer.allocate(3);
            canal.read(buffer);
            buffer.flip();
            canal2.write(buffer);

            while (canal.read(buffer1) > 0) {
                buffer1.flip();
                byte azul = buffer1.get(0);
                byte verde = buffer1.get(1);
                byte rojo = buffer1.get(2);

                byte inverso1 = (byte) ~azul;
                byte inverso2 = (byte) ~verde;
                byte inverso3 = (byte) ~rojo;

                buffer1.put(0, inverso1);
                buffer1.put(1, inverso2);
                buffer1.put(2, inverso3);

                canal2.write(buffer1);
                buffer1.clear();
            }

        } catch (IOException e) {
            System.out.printf("%s \n", e.getMessage());
        }

    }

}
