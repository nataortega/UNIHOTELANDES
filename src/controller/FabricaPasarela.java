package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modelo.Pasarela;
import modelo.Tarjeta;

public class FabricaPasarela {

    public void crearPasarela(){
        
        List<String> lineas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("Data/pasarela.txt"))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            for(int i=0;i<=lineas.size();i++){
                Pasarela pasarela= new Pasarela(lineas.get(i));
                String rutaArchivo = "Data/"+lineas.get(i)+".txt";
                String contenido = "Este es el contenido del archivo.";
                crearArchivoTexto(rutaArchivo, contenido);
                String rutaArchivojson = "Data/"+lineas.get(i)+".json";
                String contenidojson = "{ 'pago': 'exitoso'}";
                crearArchivoTexto(rutaArchivojson, contenidojson);
                String rutaArchivolog = "Data/"+lineas.get(i)+".log";
                String contenidolog = "Este es el contenido del archivo.";
                crearArchivoTexto(rutaArchivolog, contenidolog);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearArchivoTexto(String rutaArchivo, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void realizarPago(Tarjeta laTarjeta, String nombrePasarela){
        boolean transaccionExitosa=laTarjeta.validacion();
        boolean respuesta = generarRespuestaBinariaRandom();
        String resultado ="El resultado de la transaccion con la tarjeta de numero "+ laTarjeta.getNumero()+" es: ";
        if(transaccionExitosa && respuesta){
            resultado= resultado+"Exitoso";
        }
        else{
            resultado= resultado+"Fallido"; 
        }
        String rutaArchivo = "Data/"+nombrePasarela+".txt";
        String contenido = resultado;
        String rutaArchivojson = "Data/"+nombrePasarela+".json";
        String contenidojson = "{ 'pago':"+resultado+"}";
        String rutaArchivolog = "Data/"+nombrePasarela+".log";
        String contenidolog = resultado;
        
        escribirEnArchivo(rutaArchivo, contenido);
        escribirEnArchivo(rutaArchivojson, contenidojson);
        escribirEnArchivo(rutaArchivolog, contenidolog);

    }
    public static boolean generarRespuestaBinariaRandom() {
        Random random = new Random();
        return random.nextBoolean();
    }
    public static void escribirEnArchivo(String rutaArchivo, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            bw.write(contenido);
            bw.newLine(); // Agregar salto de línea si lo deseas
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
