/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio.pkg3;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author Naidelyn Gutierrez
 */
public class Laboratorio3 {

    public static void main(String[] args) {
        MenuSistema menuSistema = new MenuSistema(); // Crear una instancia del menú del sistema
        Scanner scanner = new Scanner(System.in); // Inicializar el scanner para entrada por teclado
        List<Venta> ventas = new ArrayList<>(); // Lista para almacenar las ventas (si aplica)

        // Ejecutar el menú del sistema
        MenuSistema.menu(scanner, ventas, menuSistema.espectadores);

        // Cerrar el scanner al finalizar
        scanner.close();
    }
}
