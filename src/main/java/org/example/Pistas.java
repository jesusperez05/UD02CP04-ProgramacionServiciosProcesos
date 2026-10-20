package org.example;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Pistas {
    private boolean[] disponibles = {true, true};

    public synchronized int entrar(Vehiculo coche) throws InterruptedException {

        while (!disponibles[0] && !disponibles[1]) {
            System.out.println(coche.getNombre() + " está esperando una pista...");
            wait();
        }

        for (int i = 0; i < disponibles.length; i++) {
            if (disponibles[i]) {
                disponibles[i] = false;

                System.out.println(coche.getNombre() + " entra en la pista " + (i + 1));
                return i;
            }
        }
        return -1;
    }

    public synchronized void salir(int pista, Vehiculo coche) {
        disponibles[pista] = true;
        System.out.println(coche.getNombre() + " sale de la pista " + (pista + 1));
        notifyAll();
    }
}
