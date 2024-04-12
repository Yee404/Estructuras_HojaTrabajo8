import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * La clase Prioridad contiene un programa principal que lee procesos desde un
 * archivo de texto
 * y los inserta en una PriorityQueue del Java Collection Framework para su
 * posterior atención.
 */
public class Prioridad {
    /**
     * Método principal que lee los procesos desde un archivo de texto y los inserta
     * en una
     * PriorityQueue del Java Collection Framework para su posterior atención.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan en este
     *             caso).
     */
    public static void main(String[] args) {
        PriorityQueue<Proceso> colaPrioridad = new PriorityQueue<>();

        // lector archivo .txt
        try (BufferedReader br = new BufferedReader(new FileReader("procesos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parte = linea.split(",");
                String n_Proceso = parte[0];
                String n_Usuario = parte[1];
                int valorLinea = Integer.parseInt(parte[2]);
                colaPrioridad.offer(new Proceso(n_Proceso, n_Usuario, valorLinea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
