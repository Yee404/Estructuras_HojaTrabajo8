import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * La clase Proceso representa un proceso en un sistema operativo, con su
 * nombre,
 * usuario y valor de línea.
 * 
 * Implementa la interfaz Comparable para permitir la comparación de procesos
 * basada en su prioridad.
 */
public class Proceso implements Comparable<Proceso> {
    private String n_Proceso;
    private String n_Usuario;
    private int valorLinea;

    /**
     * Constructor de la clase Proceso.
     * 
     * @param n_Proceso  El nombre del proceso.
     * @param n_Usuario  El nombre del usuario que ejecuta el proceso.
     * @param valorLinea El valor de línea del proceso, que determina su prioridad.
     */
    public Proceso(String n_Proceso, String n_Usuario, int valorLinea) {
        this.n_Proceso = n_Proceso;
        this.n_Usuario = n_Usuario;
        this.valorLinea = valorLinea;
    }
    @Override
    /**
     * Método que compara dos procesos basándose en su prioridad.
     * 
     * @param proceso2 El otro proceso con el que se compara.
     * @return Un valor negativo si este proceso tiene una prioridad menor que el
     *         proceso2,
     *         un valor positivo si tiene una prioridad mayor, o cero si tienen la
     *         misma prioridad.
     */
    public int compareTo(Proceso Proceso2) {
        return Integer.compare(this.getPriority(), Proceso2.getPriority());
    }

    /**
     * Método que calcula la prioridad del proceso basándose en su valor de línea.
     * 
     * @return La prioridad del proceso.
     */
    public int getPriority() {
        return 20 + valorLinea;
    }

    /**
     * Método main utilizado para leer los procesos desde un archivo de texto,
     * insertarlos en una cola de prioridad y mostrarlos en orden de prioridad.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan en este
     *             caso).
     */
    public static void main(String[] args) {
        PriorityQueue<Proceso> cola_prioridad = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader("procesos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String n_Proceso = partes[0];
                String n_Usuario = partes[1];
                int valorLinea = Integer.parseInt(partes[2]);
                cola_prioridad.offer(new Proceso(n_Proceso, n_Usuario, valorLinea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar los procesos en orden de prioridad
        while (!cola_prioridad.isEmpty()) {
            Proceso proceso = cola_prioridad.poll();
            System.out.println(proceso);
        }
    }
}