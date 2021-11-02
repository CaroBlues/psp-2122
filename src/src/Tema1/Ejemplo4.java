package Tema1;
import java.io.*;
public class Ejemplo4 {
    public static void main(String[] args) throws IOException{

        //preguntar esta parte
        File directorio = new File("./src");
        Process p = null;

        ProcessBuilder pb = new ProcessBuilder("bash","script_ejemplo4");
        pb.directory(directorio);
        p = pb.start();

        //escritura --envia entrada
        OutputStream os = p.getOutputStream();
        os.write("15-06-18\n".getBytes());
        os.flush(); //vacía el buffer de salida

        //lectura -- obtiene la salida de DATE
        InputStream  is = p.getInputStream();

        BufferedReader bris = new BufferedReader(new InputStreamReader(is));
        String liner = null;
        while ((liner = bris.readLine()) != null) {
            System.out.println(liner);
        }

        is.close();
        bris.close();

        //COMPROBACION DE ERROR - 0 bien - 1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " +exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
