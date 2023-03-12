package org.example.mochila;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Mochila {
    Scanner input = new Scanner(System.in);
    int objMaxMochi = objetosMochi();
    double capacidadPesoMochila = pesoMochi();
    int objetosAGuardar = numObjetos();

    ObjetoMochila listaObjetos[] = new ObjetoMochila[objetosAGuardar];
    ObjetoMochila objetosEnMochila[] = new ObjetoMochila[objMaxMochi];

    public int numObjetos() {
        int num;
        while (true) {
            System.out.println("Ingrese la cantidad de objetos que guardará");
            if (input.hasNextInt()) {
                num = input.nextInt();
                return num;
            } else {
                System.out.println("Ingrese un dato valido. Solo números.");
                input.next();
            }
        }
    }

    public int objetosMochi() {
        int num;
        while (true) {
            System.out.println("Ingrese la cantidad de objetos que puede guardar la mochila.");
            if (input.hasNextInt()) {
                num = input.nextInt();
                return num;
            } else {
                System.out.println("Ingrese un dato valido. Solo números.");
                input.next();
            }
        }
    }

    public double pesoMochi() {
        int num;
        while (true) {
            System.out.println("Ingrese el peso máximo en KG.");
            if (input.hasNextInt()) {
                num = input.nextInt();
                return num;
            } else {
                System.out.println("Ingrese un dato valido. Solo números.");
                input.next();
            }
        }
    }

    public void estadoMochila() {
        System.out.println("La mochila tiene capacidad de " + objMaxMochi + " objetos y " + capacidadPesoMochila + "Kg.");
        System.out.println();
        System.out.println("##########################################");
        System.out.println();
    }

    public String ingresoNombre(String message) {
        Pattern pattern = Pattern.compile("[A-Za-z]*");
        String nombreObjeto;
        while (true) {
            System.out.println(message);
            if (input.hasNext(pattern)) {
                nombreObjeto = input.next();
                return nombreObjeto;
            } else {
                System.out.println("Está ingresando caracteres no validos para un nombre");
                input.next();
            }
        }
    }

    public double ingresoPeso(String message) {
        int peso;
        while (true) {
            System.out.println(message);
            if (input.hasNextInt()) {
                peso = input.nextInt();
                return peso;
            } else {
                System.out.println("Ingrese un dato valido. Solo números.");
                input.next();
            }
        }
    }

    public void guardarObjetos() {

        double pesoTotal = 0;
        double pesoSobrante = 0;

        if (listaObjetos.length <= objMaxMochi) {

            for (int i = 0; i < listaObjetos.length; i++) {
                String name = ingresoNombre("Ingrese nombre del " + (i + 1) + " objeto: ");

                double weight = ingresoPeso("Ingrese peso del " + (i + 1) + " objeto en Kg: ");

                ObjetoMochila nuevoObjeto = new ObjetoMochila(name, weight);

                listaObjetos[i] = nuevoObjeto;

                objetosEnMochila[i] = nuevoObjeto;

                pesoTotal += objetosEnMochila[i].getPesoObjeto();

                if (pesoTotal > capacidadPesoMochila) {
                    ObjetoMochila listaAuxiliar[] = new ObjetoMochila[objetosEnMochila.length - 1];
                    System.out.println("No se puede agregar ese objeto. La mochila pesaría demasiado.");

                    //objetosEnMochila = Arrays.copyOf(objetosEnMochila, objetosEnMochila.length -1);

                    System.arraycopy(objetosEnMochila, 0, listaAuxiliar, 0, i);

                    System.arraycopy(objetosEnMochila, i + 1, listaAuxiliar, i, (objetosEnMochila.length - 1) - i);
                    objetosEnMochila = listaAuxiliar;
                }
            }
            if (pesoTotal < capacidadPesoMochila) {
                pesoSobrante = capacidadPesoMochila - pesoTotal;
                System.out.println("En la mochila sobró capacidad para agregar objetos de " + pesoSobrante + "Kg");
            }
        } else {
            System.out.println("Solo se pueden guardar " + objMaxMochi + " objetos en la mochila.");

        }
    }

    public void mostrarObjetos() {
        //if (objetosEnMochila != ) {
            //System.out.println("No se guardaron objetos.");
        //} else {
            System.out.println();
            System.out.println("Objetos guardados: ");
            System.out.println();
            for (int i = 0; i <= objetosEnMochila.length; i++) {
                if (objetosEnMochila[i] == null) {
                    break;
                }
                System.out.println((i + 1) + ". " + objetosEnMochila[i].getNombreObjeto() + " con peso de: " + objetosEnMochila[i].getPesoObjeto() + "Kg.");
            }
        }
    }

