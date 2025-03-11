import java.util.List;
import java.util.Scanner;

import com.devsenior.cdiaz.model.Book;
import com.devsenior.cdiaz.service.BookService;

public class Main {
    

    public static void main(String[] args) {
        

        Library libreria = Libreria.getInstancia();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE EMERGENCIAS ===");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Consultar libro");
            System.out.println("3. Registrar un usuario");
            System.out.println("4. Realizar un prestamo");
            System.out.println("5. Consultar Préstamos por Usuario");
            System.out.println("6. Finalizar jornada (cerrar sistema)");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    BookService.RegistryBook(libreria, sc);
                    break;
                case 2:
                    libreria.mostrarEstadoRecursos();
                    break;
                case 3:
                    atenderEmergenciaMenu(libreria, sc);
                    break;
                case 4:
                    libreria.mostrarEstadisticas();
                    break;
                case 5:
                    libreria.mostrarEstadisticas();
                    break;
                case 6:
                    System.out.println("Finalizando jornada...");
                    libreria.finalizarJornada();
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        sc.close();
    }



    private static void RegistryBook(String sc,String isbn, String title, String author){
        System.out.println("1. Id de libro");
              isbn = sc.nextLine();
            System.out.println("2. Nombre del libro");
             title = sc.nextLine();
         System.out.println("2. Nombre del autor del libro");
             author = sc.nextLine();
             System.out.print("  ");
             System.out.printf(" Id de libro:      " + isbn);
         System.out.printf(" Nombre del libro: " + title);
        System.out.printf(" Nombre del autor: " + author);
            
        
    }
   //  sistema.registrarRecurso(new Bomberos("Unidad-B1", 5, 100));
   //     sistema.registrarRecurso(new Bomberos("Unidad-B2", 3, 80));
   //     sistema.registrarRecurso(new Ambulancia("Unidad-A1", 2, 100));
   //     sistema.registrarRecurso(new Ambulancia("Unidad-A2", 2, 60));
   //     sistema.registrarRecurso(new Policia("Unidad-P1", 4, 100));
   //     sistema.registrarRecurso(new Policia("Unidad-P2", 2, 70));
    
//---
    // private static void addBook(Book libro, Scanner sc, String isbn, String title, String author) {
    //     System.out.println("\n=== REGISTRAR LIBRO ===");
       
       
    //     System.out.println("1. Id de libro");
    //     String sc = sc.nextLine();
    //     System.out.println("2. Nombre del libro");
    //     String title = sc.nextLine();
    //     System.out.println("2. Nombre del autor del libro");
    //     String author = sc.nextLine();
    //     System.out.print("  ");
    //     System.out.printf(" Id de libro:      " + isbn);
    //     System.out.printf(" Nombre del libro: " + title);
    //     System.out.printf(" Nombre del autor: " + author);
        
    //     }

        
}
