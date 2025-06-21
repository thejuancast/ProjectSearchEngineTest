import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil {

    // TODO: METODO DE ORDENAMIENTO DE BUBBLE SORT
    public static void bubbleSort(List<Book> books, Comparator<Book> comparator) {

        int n = books.size();
        // RECORRE TODOS LOS ELEMENTOS DE LA LISTA
        for (int i = 0; i < n; i++) {
            // ULTIMOS I ELEMENTOS YA ESTAN EN SU LUGAR
            for (int j = 0; j < n - 1; j++) {
                // COMPARA ELEMENTOS ADYACENTES USANDO EL COMPARADOR
                if (comparator.compare(books.get(j), books.get(j + 1)) > 0) {
                    // INTERCAMBIA LOS ELEMENTOS SI ESTAN EN EL ORDEN INCORRECTO
                    Collections.swap(books, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(List<Book> books, Comparator<Book> comparator) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(books.get(j), key) > 0) {
                books.set(j + 1, books.get(j));
                j = j - 1;
            }
            books.set(j + 1, key);
        }
    }

    public static void quickSort(List<Book> books, Comparator<Book> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(books, comparator, low, high);
            quickSort(books, comparator, low, pi - 1);
            quickSort(books, comparator, pi + 1, high);
        }
    }

    private static int partition(List<Book> books, Comparator<Book> comparator, int low, int high) {
        Book pivot = books.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(books.get(j), pivot) <= 0) {
                i++;
                Collections.swap(books, i, j);
            }
        }
        Collections.swap(books, i + 1, high);
        return i + 1;
    }
}
