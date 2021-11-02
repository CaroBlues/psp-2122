package Tema1;
import java.io.*;
import java.util.Scanner;

public class App1_6Pruebas {
    public static void main(String[] args) {

        Scanner texto = new Scanner(System.in);
        int n1;
        int n2;
        try {
            System.out.println("Número 1: ");
            n1 = texto.nextInt();
            System.out.println("Número 2: ");
            n2 = texto.nextInt();

            int res = n1 + n2;
            System.out.println("Resultado de suma: " +res);
            //No sé de donde cojones se saca el valor la verdad, ni el debug ayuda
            texto.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
