package org.example;

public class Main {
    static void main() throws InterruptedException {
        Pistas pistas = new Pistas();

        Vehiculo v1 = new Vehiculo("V1", pistas);
        Vehiculo v2 = new Vehiculo("V2", pistas);
        Vehiculo v3 = new Vehiculo("V3", pistas);
        Vehiculo v4 = new Vehiculo("V4", pistas);

        Thread t1 = new Thread(v1);
        Thread t2 = new Thread(v2);
        Thread t3 = new Thread(v3);
        Thread t4 = new Thread(v4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}