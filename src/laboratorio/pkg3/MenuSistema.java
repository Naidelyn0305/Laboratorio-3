/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio.pkg3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.awt.Color;
public class MenuSistema {

    public static char[][] estadio;
    private static final int FILAS = 10;
    private static final int COLUMNAS = 10;
    private static final int ASIENTOS_OCUPADOS = 15;
    private static final int[][] PRECIOS = {{5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000},
    {10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000},
    {15000, 15000, 15000, 15000, 15000, 15000, 15000, 15000, 15000, 15000}};
    private static final char[] SECCIONES = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private static int[][] asientosOcupados;
    private static List<String[]> espectadores = new ArrayList<>();

    public MenuSistema() {
        estadio = new char[FILAS][COLUMNAS];

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                estadio[i][j] = ' ';
            }
        }
    }

    public static void menu(Scanner scanner) {
        while (true) {
            imprimirMenu();
            int opcion = Integer.parseInt(validar(scanner, "Digite una opción: ", "^[1-5]$", "Error solo debe digitar opciones del 1 al 5"));
            accionMenu(opcion, scanner);
            if (opcion == 5) {
                break;
            }
        }
    }

    private static void imprimirMenu() {
        System.out.println("Menú del Sistema");
        System.out.println("1- Visualizar estadio y precios de los asientos");
        System.out.println("2- Registro de espectadores");
        System.out.println("3- Compra de entradas");
        System.out.println("4- Reporte de Ventas");
        System.out.println("5- Salir");
    }

    private static void accionMenu(int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                visualizarEstadioYPrecios();
                break;
            case 2:
                registrarEspectador(scanner);
                break;
            case 3:
                System.out.println("Compra de entradas");
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    private static String validar(Scanner scanner, String mensajeEntrada, String patron, String mensajeError) {
        String entrada = "";
        while (true) {
            System.out.println(mensajeEntrada);
            entrada = scanner.nextLine();
            if (entrada.matches(patron)) {
                break;
            } else {
                System.out.println(mensajeError);
            }
        }
        return entrada;
    }

    private static void visualizarEstadioYPrecios() {
        reservarAsientosOcupados();
        imprimirMatrizConColores();
        mostrarPrecios();
    }

    private static void reservarAsientosOcupados() {
        if (estadio != null) {
            if (asientosOcupados == null) {
                asientosOcupados = new int[ASIENTOS_OCUPADOS][2];
                Random random = new Random();
                for (int i = 0; i < ASIENTOS_OCUPADOS; i++) {
                    asientosOcupados[i][0] = random.nextInt(FILAS);
                    asientosOcupados[i][1] = random.nextInt(COLUMNAS);
                }
            }

            // Marcar los asientos ocupados en el estadio
            for (int[] asiento : asientosOcupados) {
                estadio[asiento[0]][asiento[1]] = 'R';
            }
        } else {
            System.out.println("El objeto 'estadio' no ha sido inicializado correctamente.");
        }
    }

   private static void imprimirMatrizConColores() {
    String[][] matriz = new String[10][10];

    char letra = 'A';
    int maxLongitudColumna = 0;
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            //Se esta utlizando String.valueOf(letra); donde la variable letra la convertimos a String y se almacena en cada posicion de la matriz mediante concatenacion
            matriz[i][j] = (10 - i) + String.valueOf(letra);
            //Math. para obtener el maximo de dos valores 
            maxLongitudColumna = Math.max(maxLongitudColumna,matriz[i][j].length());
             }
                letra++;  
             }
           for(int i=0;i<10;i++){
             for(int j=0;j<10;j++){
             String elemento = matriz [i][j];
             if (estadio[i][j] == 'R'){
              System.out.print(colorearTexto(ajustarAnchura(elemento,maxLongitudColumna),Color.RED));  
             }else{
             System.out.print(ajustarAnchura(elemento,maxLongitudColumna));
             }
            System.out.print(" ");
            }
     
          System.out.println();
        }
    
               
    }   
        // se crea esta funcion con el fin de ajustar la longitud de la matriz mediante format
     private static String ajustarAnchura(String texto,int longitudDeseada) {
         //"%-"+ longitudDeseada+"s" se utiliza para alinear el texto a la izquierda y que la longitud del texto sea igual a longitudDeseado o la lalongitud que se necesite 
         return String.format("%-"+ longitudDeseada+"s",texto);
}
     

// Se crea un metodo para colores 
private static String colorearTexto(String texto, Color color) {
    String colorCode = "";
    // Color.RED es una constante de la clase java.awt.Color;
    if (color.equals(Color.RED)) {
        colorCode = "\u001B[31m"; // Código de color rojo
    }
    return colorCode + texto + "\u001B[0m"; // Resetear el color al final del texto
}
    private static void mostrarPrecios() {
        System.out.println("\nPrecios de los asientos:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < SECCIONES.length; j++) {
                System.out.println("Fila " + (i * 3 + 1) + "-" + (i * 3 + 3) + ", Sección " + SECCIONES[j] + ": $" + PRECIOS[i][j]);
            }
        }
    }

    private static void registrarEspectador(Scanner scanner) {
        System.out.println("Registro de espectadores:");
        while (true) {
            System.out.print("Cédula: ");
            String cedula = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Género (M/F): ");
            String genero = scanner.nextLine();
            espectadores.add(new String[]{cedula, nombre, genero});
            System.out.println("Espectador registrado exitosamente.");
            System.out.print("¿Desea registrar otro espectador? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}
