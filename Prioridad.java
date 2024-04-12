import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Prioridad {
    public static void main(String[] args) {
        PriorityQueue<Proceso> colaPrioridad = new PriorityQueue<>();

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
