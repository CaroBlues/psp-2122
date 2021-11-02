package Tema2;

public class SolicitaSuspender {
    private boolean solicitaSuspender;

    public synchronized void set(boolean b){
        solicitaSuspender=b;
        notifyAll();
    }

    public synchronized void esperandoReanudar() throws InterruptedException{
        while(solicitaSuspender){
            wait();
        }
    }
}
