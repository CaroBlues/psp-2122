package Tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {
    public static void main(String[] args) throws IOException {

        //Ejecutamos el proceso DIR
        Process p = new ProcessBuilder("ls", "-la").start();

        //Mostramos carácter a carácter la salida generada por DIR
        try {
            InputStream is = p.getInputStream();
            BufferedReader bris = new BufferedReader(new InputStreamReader(is));
            String liner;
            while ((liner = bris.readLine()) != null) {
                System.out.println(liner);
            }
            bris.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int exitVal;
        try {
            exitVal = p.waitFor(); //recoge la salida de System.exit()
            System.out.println("Valor de Salida: " +exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
