import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySerializer {

    // GUARDA LA LISTA DE LIBROS EN UN ARCHIVO USANDO SERIALIZACION
    public void saveLibrary(List<Book> books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // TODO: ESCRIBIR LA LISTA COMPLETA DE LIBROS EN EL ARCHIVO
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CARGA LA LSITA DE LIBROS DESDE UNA ARCHIVO SERIALIZADO
    public List<Book> loadLibrary(String fileName) {

        File file = new File(fileName);

        if (!file.exists() || file.length() == 0) {
            // SI EL ARCHIVO NO EXISTE O ESTA VACIO, SE RETORNA NULL
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // TODO: LEER Y DEVOLVER LA LISTA DE LIBROS DESERIALIZADA
            return (List<Book>) ois.readObject();
        } catch (EOFException e) {
            System.err.println("The file is empty or corrupted: " + fileName);
            return null; // RETORNA NULL SI HUBO UN PROBLEMA CON LA DESIALIZACION
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}