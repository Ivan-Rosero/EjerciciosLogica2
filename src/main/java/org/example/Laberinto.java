package org.example;

import java.util.Scanner;

public class Laberinto {

    Scanner input = new Scanner(System.in);
    int filActual = 0;
    int colActual = 0;

    int filSalida = 6;
    int colSalida = 5;

    int filasTotales;
    int columnasTotales;
    String[][] lab;

    public Laberinto(String[][] lab) {
        this.filasTotales = lab.length;
        this.columnasTotales = lab[0].length;
        this.lab = lab;
    }

    public void imprimirLaberinto(String[][] lab) {
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                System.out.print(lab[i][j]);
            }
            System.out.println();
        }
    }

    public void avanzar() {
        this.imprimirLaberinto(lab);
        while (lab[filActual][colActual] != lab[filSalida][colSalida]) {
            System.out.println();
            System.out.println("Ingrese movimiento: ");
            System.out.println("Arriba: W");
            System.out.println("Abajo: S");
            System.out.println("Izquierda: A");
            System.out.println("Derecha: D");

            try {
                String movimiento = input.nextLine();
                if(movimiento.equalsIgnoreCase("w") || movimiento.equalsIgnoreCase("s")
                    || movimiento.equalsIgnoreCase("a") || movimiento.equalsIgnoreCase("d")) {


                    if (movimiento.equalsIgnoreCase("W")) {
                        if (!lab[filActual - 1][colActual].equals("#") && !(filActual - 1 < 0)) {
                            lab[filActual - 1][colActual] = "¡";
                            lab[filActual][colActual] = " ";
                            filActual--;
                        } else {
                            System.out.println();
                            System.out.println("No se puede avanzar por esa dirección");
                            System.out.println();
                        }
                    }

                    if (movimiento.equalsIgnoreCase("S")) {
                        if (!lab[filActual + 1][colActual].equals("#") && !(filActual + 1 > 8)) {
                            lab[filActual + 1][colActual] = "¡";
                            lab[filActual][colActual] = " ";
                            filActual++;
                        } else {
                            System.out.println();
                            System.out.println("No se puede avanzar por esa dirección");
                            System.out.println();
                        }

                    }

                    if (movimiento.equalsIgnoreCase("A")) {
                        if (!lab[filActual][colActual - 1].equals("#") && !(colActual - 1 < 0)) {
                            lab[filActual][colActual - 1] = "¡";
                            lab[filActual][colActual] = " ";
                            colActual--;
                        } else {
                            System.out.println();
                            System.out.println("No se puede avanzar por esa dirección");
                            System.out.println();
                        }
                    }

                    if (movimiento.equalsIgnoreCase("D")) {
                        if (!lab[filActual][colActual + 1].equals("#") && !(colActual + 1 > 6)) {
                            lab[filActual][colActual + 1] = "¡";
                            lab[filActual][colActual] = " ";
                            colActual++;
                        } else {
                            System.out.println();
                            System.out.println("No se puede avanzar por esa dirección");
                            System.out.println();
                        }
                    }
                }else {
                    throw new IllegalArgumentException("Ingrese una opción valida");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }


            this.imprimirLaberinto(lab);
        }
        System.out.println();
        System.out.println("Felicidades! saliste del laberinto!");
    }
}
