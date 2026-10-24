package org.example;

public class Pistas {
    private boolean[] disponibles = {true, true};

    public synchronized int entrar(Vehiculo coche) throws InterruptedException {
        while (!disponibles[0] && !disponibles[1]) {
            System.out.println(coche.getNombre() + " está esperando una pista...");
            wait();
        }

        int pistaAsignada = -1;
        boolean pistaEncontrada = false;

        for (int i = 0; i < disponibles.length && !pistaEncontrada; i++) {
            if (disponibles[i]) {
                disponibles[i] = false;
                pistaAsignada = i;
                pistaEncontrada = true;
                System.out.println(coche.getNombre() + " entra en la pista " + (i + 1));
            }
        }

        return pistaAsignada;
    }

    public synchronized void salir(int pista, Vehiculo coche) {
        disponibles[pista] = true;
        System.out.println(coche.getNombre() + " sale de la pista " + (pista + 1));
        notifyAll();
    }
}
