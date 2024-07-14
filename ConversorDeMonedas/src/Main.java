import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static String divisaOrigen = "";
    private static String divisaDestino = "";
    private static double cantidadAConvertir = 0;
    private static Scanner scanner = new Scanner(System.in);
    static Conversor conversor = new Conversor();

    public static void main(String[] args) {
        int opcion = 0;

        while(opcion != 7){
            imprimeMenu();

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                //System.out.println(e.getMessage());
                System.out.println("OPCION NO VALIDA!");
                scanner.nextLine();
                opcion = 0;
            }

            switch (opcion){
                case 1:
                    divisaOrigen = "MXN";
                    divisaDestino = "USD";
                    ingresaDenominacion();
                    conversor.realizaConversion(divisaOrigen, divisaDestino, cantidadAConvertir);
                    break;
                case 2:
                    divisaOrigen = "USD";
                    divisaDestino = "MXN";
                    ingresaDenominacion();
                    conversor.realizaConversion(divisaOrigen, divisaDestino, cantidadAConvertir);
                    break;
                case 3:
                    divisaOrigen = "MXN";
                    divisaDestino = "COP";
                    ingresaDenominacion();
                    conversor.realizaConversion(divisaOrigen, divisaDestino, cantidadAConvertir);
                    break;
                case 4:
                    divisaOrigen = "COP";
                    divisaDestino = "MXN";
                    ingresaDenominacion();
                    conversor.realizaConversion(divisaOrigen, divisaDestino, cantidadAConvertir);
                    break;
                case 5:
                    divisaOrigen = "MXN";
                    divisaDestino = "CLP";
                    ingresaDenominacion();
                    conversor.realizaConversion(divisaOrigen, divisaDestino, cantidadAConvertir);
                    break;
                case 6:
                    divisaOrigen = "CLP";
                    divisaDestino = "MXN";
                    ingresaDenominacion();
                    conversor.realizaConversion(divisaOrigen, divisaDestino, cantidadAConvertir);
                    break;
                case 7: break;
                default: break;
            }
        }
    }

    private static void imprimeMenu(){
        System.out.println("***********************SELECCIONA UNA OPCION***********************\n" +
                "1 -> MXN a USD\n" +
                "2 -> USD a MXN\n" +
                "3 -> MXN a COP\n" +
                "4 -> COP a MXN\n" +
                "5 -> MXN a CLP\n" +
                "6 -> CLP a MXN\n" +
                "7 -> Salir\n" +
                "*******************************************************************");
    }

    private static void ingresaDenominacion(){
        System.out.println("Ingresa cantidad de " + divisaOrigen + " a convertir:\n");
        try {
            cantidadAConvertir = scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("CANTIDAD NO VALIDA!");
            ingresaDenominacion();
        }
    }
}
