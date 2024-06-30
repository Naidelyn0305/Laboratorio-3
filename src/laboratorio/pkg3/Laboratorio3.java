/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio.pkg3;

import java.util.Scanner;

/**
 *
 * @author Naidelyn Gutierrez
 */
public class Laboratorio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuSistema menuSistema = new MenuSistema();
        menuSistema.menu(scanner);
    }
}