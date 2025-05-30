import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private Map<String, String> contactos = new HashMap<>();
    private final String archivo = "contactos.txt";

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",", 2);
                if (partes.length == 2) {
                    contactos.put(partes[0], partes[1]);
                }
            }
            System.out.println("Contactos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, String> entrada : contactos.entrySet()) {
                writer.write(entrada.getKey() + "," + entrada.getValue());
                writer.newLine();
            }
            System.out.println("Contactos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo: " + e.getMessage());
        }
    }

    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entrada : contactos.entrySet()) {
            System.out.println(entrada.getKey() + " : " + entrada.getValue());
        }
    }

    public void create(String numero, String nombre) {
        contactos.put(numero, nombre);
        System.out.println("Contacto creado exitosamente.");
    }

    public void delete(String numero) {
        if (contactos.remove(numero) != null) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("El número no fue encontrado.");
        }
    }
}
