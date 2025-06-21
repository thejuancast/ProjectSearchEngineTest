import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        // CREACION DEL OBJETO
        Library library = new Library();

        // CARGAMOS EL ARCHIVO
        library.loadBooks("/home/coder/coursera/search-engine-test/src/resources/data/books.txt");

        // ANTES DE ORDENAR
        System.out.println("Before sorting:");
        library.viewAllBooks();

        // LLAMANDO A BUBBLESORT
        SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));

        // DESPUES DE ORDENAR
        System.out.println("After sorting by title:");
        library.viewAllBooks();

    }
}
