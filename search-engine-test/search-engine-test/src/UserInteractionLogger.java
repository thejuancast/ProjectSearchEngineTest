import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserInteractionLogger {

    private static final String LOG_FILE = "src/resources/data/user_interactions.log";

    // Method to log search interactions
    public void logSearch(String searchTerm) {
        log("Search for: " + searchTerm);
    }

    // Method to log sorting interactions
    public void logSort(String sortCriteria) {
        log("Sorted by: " + sortCriteria);
    }

    // Method to log viewing all books
    public void logViewAllBooks() {
        log("Viewed all books");
    }

    // METODO GENERICO PARA REGISTRAR MENSAJES CON UNA MARCA DE TIEMPO
    public void log(String message) {
        try(FileWriter writer = new FileWriter(LOG_FILE, true)) {
            // OBTIENE LA FECHA Y HORA ACTUAL
            String timestamp = LocalDateTime.now().toString();

            // ESCRIBE EL MENSAJE EN EL ARCHOV CON LA MARCA DEL TIEMPO
            writer.write("[" + timestamp + "]" + message + "\n");
        } catch (IOException e) {
            // MUESTRA UN MENSAJE DE ERROR SI FALLA LA ESCRITURA
            e.printStackTrace();
        }
    }
}
