import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        do {
            System.out.println("");
            System.out.println("""
            == Bienvenido al conversor de monedas para el Challenge Alura ==
            En este programa utilizamos la API de ExchangeRate-API para obtener las tasas de cambio
            entre las diferentes monedas. Para poder utilizarlo, deberas seguir las siguientes instrucciones:
            1. Escribe el código de la moneda base (por ejemplo, USD).
            2. Escribe el código de la moneda a la que quieres convertir (por ejemplo, MXN).
            3. Escribe la cantidad de la moneda base que quieres convertir.
            4. Presiona Enter para obtener el resultado de la conversión.
            """);

            try {
                System.out.print("Escribe el código de la moneda base: ");
                String monedaBase = scanner.nextLine();

                System.out.print("Escribe el código de la moneda a la que quieres convertir: ");
                String monedaDestino = scanner.nextLine();

                System.out.print("Escribe la cantidad de la moneda base (" + monedaBase.toUpperCase() + ") que deseas convertir: ");
                double cantidad = Double.parseDouble(scanner.nextLine());

                System.out.println("");

                Moneda moneda = consulta.buscaMoneda(monedaBase, monedaDestino, cantidad);
                System.out.println("La conversion es: " + moneda.conversion_result());

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
                break;
            }

            System.out.print("¿Desea realizar otra conversión? (S/N): ");

        } while (scanner.nextLine().equals("S") || scanner.nextLine().equals("s"));

        System.out.println("");
        System.out.println("** Gracias por utilizar nuestro conversor de monedas. ¡Hasta luego! **");
    }
}
