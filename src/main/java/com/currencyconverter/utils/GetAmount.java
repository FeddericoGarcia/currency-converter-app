package main.java.com.currencyconverter.utils;

import java.util.Scanner;

import main.java.com.currencyconverter.menu.MainMenu;

public class GetAmount {
    private final Scanner scanner = new Scanner(System.in);

    public double getAmounts(){
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println(MainMenu.hr);
                System.out.println("⛔ ¡Opción incorrecta! ⛔. Ingresa un número válido");
                System.out.println(MainMenu.hr);
                scanner.nextLine();
            }
        }
    }
}
