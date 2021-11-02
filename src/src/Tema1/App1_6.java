package Tema1;
import java.io.*;
public class App1_6 {
    public static void main(String[] args) throws IOException {

        ProcessBuilder pb = new ProcessBuilder("java", "-classpath","./out/production/src","Tema1.App1_6Pruebas");
        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        //A esto se le puede meter un Scanner para hacerlo mas facil
        os.write("2\n".getBytes());
        os.write("5\n".getBytes());
        os.flush();

        InputStream is = p.getInputStream();

        BufferedReader bris = new BufferedReader(new InputStreamReader(is));
        String liner = null;
        while ((liner = bris.readLine()) != null) {
            System.out.println(liner);
        }

        is.close();
        bris.close();

        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " +exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
