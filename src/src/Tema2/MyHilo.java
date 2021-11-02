package Tema2;

public class MyHilo extends Thread{
    private SolicitaSuspender suspender=new SolicitaSuspender();
    private boolean stopHilo=false;
    public void Suspende(){
        suspender.set(true);
    }
    public void Reanudar(){
        suspender.set(false);
    }
    public void run(){
        try {
            while (!stopHilo){

                suspender.esperandoReanudar();
            }
        }catch (InterruptedException e){

        }
    }
}
