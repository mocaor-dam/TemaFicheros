package ejercicioMP3;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.IllegalFormatCodePointException;


public class Main {
    static void main(String[] args) {
        Path ruta = Path.of("src/files/0103. Fun Time - AShamaluevMusic.mp3");

        try (FileChannel canal = FileChannel.open(ruta, StandardOpenOption.READ)){

            long longitud = canal.size();

            canal.position(longitud - 128);

            ByteBuffer buffer = ByteBuffer.allocate(3);
            canal.read(buffer);
            buffer.flip();
            String tag = new String(buffer.array());
            if (!tag.equals("TAG")){
                System.out.println("hola, no va.");
                return;
            }
            System.out.printf("Canción: %s%n", buscarByteBuffer(30, canal));
            System.out.printf("Artista: %s%n", buscarByteBuffer(30, canal));
            System.out.printf("Album: %s%n", buscarByteBuffer(30, canal));
            System.out.printf("Año: %s%n", buscarByteBuffer(4, canal));
            System.out.printf("Comentario: %s%n", buscarByteBuffer(30, canal));



        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String buscarByteBuffer(int capacidad, FileChannel canal) throws IOException {
        ByteBuffer buffer2 = ByteBuffer.allocate(capacidad);
        canal.read(buffer2);
        buffer2.flip();
        return new String(buffer2.array()).trim();

    }
}
