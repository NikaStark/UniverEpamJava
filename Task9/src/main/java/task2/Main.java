package task2;

import task2.entitys.*;

import java.util.concurrent.Exchanger;

/**
 * @author Alex Volochai
 */
public class Main {

    public static void main(String[] args) {
        Exchanger<Integer> groundCounter = new Exchanger<>();
        Exchanger<Integer> storageGround = new Exchanger<>();
        new TakerFromStorage(storageGround);
        new TakerFromGround(storageGround, groundCounter);
        new Counter(groundCounter);
    }

}

