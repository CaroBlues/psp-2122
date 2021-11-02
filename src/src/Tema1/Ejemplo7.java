package Tema1;
import java.io.*;
public class Ejemplo7 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("ls","-la");
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");

        pb.redirectOutput(fOut);
        pb.redirectError(fErr);
        pb.start();
    }
}
