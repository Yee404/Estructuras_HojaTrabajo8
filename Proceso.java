import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Proceso implements Comparable<Proceso> {
    private String n_Proceso;
    private String n_Usuario;
    private int valorLinea;

    public Proceso(String n_Proceso, String n_Usuario, int valorLinea) {
        this.n_Proceso = n_Proceso;
        this.n_Usuario = n_Usuario;
        this.valorLinea = valorLinea;
    }

    @Override
    public int compareTo(Proceso Proceso2) {
        return Integer.compare(this.getPriority(), Proceso2.getPriority());
    }

    public int getPriority() {
        return 20 + valorLinea;
    }

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