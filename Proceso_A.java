import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * La clase Proceso_A contiene un programa principal que lee procesos desde un
 * archivo de texto,
 * los inserta en dos estructuras de datos diferentes (una implementación
 * personalizada de Heap y
 * una PriorityQueue del Java Collection Framework), y los muestra en orden de
 * prioridad.
 */
public class Proceso_A {
    /**
     * Método principal que lee los procesos desde un archivo de texto, los inserta
     * en una implementación
     * personalizada de Heap y en una PriorityQueue del Java Collection Framework, y
     * los muestra en orden de prioridad.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan en este
     *             caso).
     */
    public static void main(String[] args) {
        HeapUsingIterativeBinaryTree<Integer, Proceso> colaPersonalizada = new HeapUsingIterativeBinaryTree<P, V>(
                new ComparadorNumeros());
        PriorityQueue<Proceso> colaFrameworkJava = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader("procesos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombreProceso = partes[0];
                String nombreUsuario = partes[1];
                int niceValue = Integer.parseInt(partes[2]);
                Proceso proceso = new Proceso(nombreProceso, nombreUsuario, niceValue);
                colaPersonalizada.Insert(proceso.getPriority(), proceso);
                colaFrameworkJava.offer(proceso);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Procesos con Implementación Personalizada:");
        while (!colaPersonalizada.isEmpty()) {
            Proceso proceso = colaPersonalizada.remove();
            System.out.println(proceso);
        }

        // Collection Framework
        System.out.println("\nProcesos con Implementación de Java Collection Framework:");
        while (!colaFrameworkJava.isEmpty()) {
            Proceso proceso = colaFrameworkJava.poll();
            System.out.println(proceso);
        }
    }
}
