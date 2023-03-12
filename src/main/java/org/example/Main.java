package org.example;

import org.example.mochila.Mochila;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el número de ejercicio a realizar: ");
        System.out.println("1. Laberinto");
        System.out.println("2. Mochila");

        int opcion = input.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Inicio laberinto");
                String[][] lab =
                        {{"¡", "#", "#", "#", "#", "#"},
                                {" ", "#", "#", "#", " ", "#"},
                                {" ", " ", "#", " ", "#", "#"},
                                {"#", " ", "#", " ", " ", "#"},
                                {"#", " ", " ", " ", " ", "#"},
                                {"#", "#", " ", "#", " ", "#"},
                                {"#", "#", " ", "#", " ", "X"},
                                {"#", "#", "#", "#", "#", "#"},
                        };
                Laberinto laberinto = new Laberinto(lab);
                laberinto.avanzar();
                break;
            case 2:
                Mochila mochila = new Mochila();

                mochila.estadoMochila();
                mochila.guardarObjetos();
                mochila.mostrarObjetos();
                break;
        }
    }
}