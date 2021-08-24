package Lab_02;

import javafx.application.Platform;
import javafx.scene.control.Label;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ping implements Runnable {
    private static Lock lock = new ReentrantLock(); //Create a lock instance
    private Label tLabel;  //Hold the text ping or pong
    private String txt="";
    private int times = 30;   //Number of time the text will display

    //Default Constructor
    public ping(Label tLabel){
        this.tLabel = tLabel;
    }

    @Override
    public void run() {
        lock.lock();  //Acquire the lock
        try {
            for (int i = 0; i < times; i++) {
                if (tLabel.getText().trim().length() == 0){
                    txt = "Ping";
                } else
                    txt = "";

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        tLabel.setText(txt);
                    }
                });

                Thread.sleep(300);
            }
        }catch (InterruptedException ex){
        }
        finally {
            lock.unlock();  //Release lock
        }
    }
}
