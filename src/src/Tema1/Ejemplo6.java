package Tema1;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Ejemplo6 {
    public static void main(String[] args) {

        ProcessBuilder test = new ProcessBuilder();
        Map entorno = test.environment();
        System.out.println("Variables de entorno:");
        System.out.println(entorno);

        test = new ProcessBuilder("java", "LeerNombre", "Maria Jesús");

        //devuelve el nombre del proceso y sus argumentos
        List l = test.command();
        Iterator iter = l.iterator();
        System.out.println("\nArgumentos del comando:");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        test = test.command("ls", "-la");
        try {
            Process p = test.start(); //se ejecuta ls
            InputStream is = p.getInputStream();

            System.out.println();
            //mostramos en pantalla caracter a caracter
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char)c);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
