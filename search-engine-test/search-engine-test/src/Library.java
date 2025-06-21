import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {

    // LISTA DE LIBROS QUE CONTIENE LA BIBLIOTECA
    private List<Book> books = new ArrayList<>();

    // CARGA LOS LIBROS DESDE UN ARCHIVO DE TEXTO
    public void loadBooks(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // LEER CADA LINEA DEL ARCHIVO
            while ((line = br.readLine()) != null) {
               // SE DIVIDE CADA LINEA USANDO COMA COMO SEPARADOR
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int publicationYear = Integer.parseInt(parts[2].trim());

                    // CREAR UN NUEVO OBJECTO BOOK Y AGREGARLO A LA LISTA
                    books.add(new Book(title,author,publicationYear));
                }
            }
        } catch (IOException e) {
            // IMRIMIR ERROR SI FALLA LA LECTURA DEL ARCHIVO
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByKeyword(String keyword) {

        for (Book book: books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                return book;
            }
        }

        return null; // NO SE ENCONTRO NINGUN LIBRO QUE COINCIDA
    }


    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
