import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook agenda = new AddressBook();
        agenda.load();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ AGENDA ---");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    agenda.list();
                    break;
                case 2:
                    System.out.print("Ingrese el número: ");
                    String numero = sc.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine();
                    agenda.create(numero, nombre);
                    break;
                case 3:
                    System.out.print("Ingrese el número a eliminar: ");
                    String numEliminar = sc.nextLine();
                    agenda.delete(numEliminar);
                    break;
                case 4:
                    agenda.save();
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
