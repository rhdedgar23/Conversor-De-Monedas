import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    static String base;
    static String destino;
    static double tasaDeConversion;
    static double resultadoDeConversion;

    public static void realizaConversion(String divisaOrigen, String divisaDestino, double cantidadAConvertir) {
        Gson gson = new GsonBuilder()
                //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//Gson reconoce las variables en minusculas
                //y las convierte en camel case
                .setPrettyPrinting()
                .create();

        String direccion = "https://v6.exchangerate-api.com/v6/9f7bd40e9c019f9aad79e3c1/pair/" +
                divisaOrigen + "/" +
                divisaDestino + "/" +
                cantidadAConvertir;
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            //System.out.println(response.body());

            ConversorExchangeRate conversorER = gson.fromJson(json, ConversorExchangeRate.class);
            //System.out.println(conversorER);

            System.out.println("*******************************************************************\n" +
                    cantidadAConvertir + " " + divisaOrigen +
                    " --> " +
                    conversorER.conversion_result() + " " + divisaDestino +
                    "\n*******************************************************************");
        } catch(IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la direccion.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}