package org.example;

public class Vehiculo implements Runnable{
    private String nombre;
    private Pistas pistas;

    public Vehiculo(String nombre, Pistas pistas) {
        this.nombre = nombre;
        this.pistas = pistas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pistas getPistas() {
        return pistas;
    }

    public void setPistas(Pistas pistas) {
        this.pistas = pistas;
    }

    @Override
    public void run() {
        int pista = -1;
        int tiempo = new java.util.Random().nextInt(4) + 2;

        try {
            pista = pistas.entrar(this);
            System.out.println(nombre + " está realizando la prueba durante " + tiempo + " segundos.");
            Thread.sleep(tiempo * 1000);
            System.out.println(nombre + " ha tardado " + tiempo + " segundos en realizar la prueba.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (pista != -1) {
                pistas.salir(pista, this);
            }
        }    }
}
