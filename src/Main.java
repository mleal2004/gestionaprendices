import com.gestionaprendices.dao.AprendizDAO;
import com.gestionaprendices.modelo.Aprendiz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AprendizDAO dao = new AprendizDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestión de Aprendices ---");
            System.out.println("1. Agregar aprendiz");
            System.out.println("2. Listar aprendices");
            System.out.println("3. Actualizar aprendiz");
            System.out.println("4. Eliminar aprendiz");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Documento de identidad: ");
                    String documento = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    Aprendiz aprendiz = new Aprendiz(0, nombre, apellido, documento, correo, telefono);
                    if (dao.agregarAprendiz(aprendiz)) {
                        System.out.println("Aprendiz agregado exitosamente.");
                    } else {
                        System.out.println("Error al agregar aprendiz.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Lista de Aprendices ---");
                    for (Aprendiz a : dao.listarAprendices()) {
                        System.out.println(a.getIdAprendiz() + " | " + a.getNombre() + " " + a.getApellido());
                    }
                    break;

                case 3:
                    System.out.print("ID del aprendiz a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo apellido: ");
                    String nuevoApellido = scanner.nextLine();
                    System.out.print("Nuevo documento: ");
                    String nuevoDocumento = scanner.nextLine();
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();

                    Aprendiz aprendizActualizar = new Aprendiz(idActualizar, nuevoNombre, nuevoApellido, nuevoDocumento, nuevoCorreo, nuevoTelefono);
                    if (dao.actualizarAprendiz(aprendizActualizar)) {
                        System.out.println("Aprendiz actualizado exitosamente.");
                    } else {
                        System.out.println("Error al actualizar aprendiz.");
                    }
                    break;

                case 4:
                    System.out.print("ID del aprendiz a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    if (dao.eliminarAprendiz(idEliminar)) {
                        System.out.println("Aprendiz eliminado exitosamente.");
                    } else {
                        System.out.println("Error al eliminar aprendiz.");
                    }
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
