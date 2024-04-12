import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Proceso_A {
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

        System.out.println("Procesos atendidos con implementación personalizada:");
        while (!colaPersonalizada.isEmpty()) {
            Proceso proceso = colaPersonalizada.remove();
            System.out.println(proceso);
        }

        // Collection Framework
        System.out.println("\nProcesos atendidos con implementación de Java Collection Framework:");
        while (!colaFrameworkJava.isEmpty()) {
            Proceso proceso = colaFrameworkJava.poll();
            System.out.println(proceso);
        }
    }
}
