package controller;

import java.io.IOException;

/**
 * @author Alex Volodhai
 */
public class ConsoleController implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i != 10; i = System.in.read()) {}
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
