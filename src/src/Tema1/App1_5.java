package Tema1;
import java.io.*;
public class App1_5 {
    public static void main(String[] args) throws IOException{

        //creamos objeto File al directorio donde esta Ejemplo2
        File directorio = new File("./out/production/src/");

        //El proceso a ejecutar es Ejemplo2
        ProcessBuilder pb = new ProcessBuilder("java", "Tema1.Ejemplo9");

        //se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);

        System.out.printf("Directorio de trabajo: %s%n",pb.directory());

        //se ejecuta el proceso
        Process p = pb.start();

        //obtener la salida devuelta por el proceso
        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null) {
                System.out.println("ERROR >" +liner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
