import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        Lista lista2 = new Lista();
        Lista lista3 = new Lista();
        lista2.insertarFinal(2);
        lista2.insertarFinal(4);
        lista2.insertarFinal(6);
        int opcion;

            do {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Agregar un dato");
                System.out.println("2. Cantidad de elementos");
                System.out.println("3. Pertenece o no");
                System.out.println("4. Mostrar todos los datos");
                System.out.println("5. Unión de conjuntos");
                System.out.println("6. Eliminar");
                System.out.println("7. Eliminar duplicado ");
                System.out.println("8. Interseccion");
                System.out.println("9. Igualdad");
                System.out.println("10. Subconjunto");
                System.out.println("11. Complemento");
                System.out.println("12. Diferencia");
                System.out.println("13. Diferencia simetrica");
                System.out.println("14. Posicion");
                System.out.println("15. Salir ");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa el dato a agregar: ");
                        int datoAgregar = scanner.nextInt();
                        lista.insertarFinal(datoAgregar);
                        break;
                    case 2:
                        lista.cantidadElementos();
                    case 3:
                        System.out.print("Ingresa el dato a buscar: ");
                        int datoBuscar = scanner.nextInt();
                        lista.pertenece(datoBuscar);
                        break;
                    case 4:
                        System.out.println("Lista de datos:");
                        lista.mostrar();
                        break;
                    case 5:
                        System.out.println(("Unión de conjuntos"));
                        lista.union(lista2.getPunta());
                        lista.mostrar();
                        break;
                    case 6:

                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (opcion != 15);
        }
}
