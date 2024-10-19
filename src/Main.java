import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        Lista lista2 = new Lista();
        //Llena la lista 2 con los datos del archivo lista2.txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Recursos/lista2.txt"));
            String line = reader.readLine();
            while (line != null) {
                lista2.leerString(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Llena el conjunto universal con los datos del archivo ConjuntoUniversal.txt
        Lista conjuntoUniversal = new Lista();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Recursos/ConjuntoUniversal.txt"));
            String line = reader.readLine();
            while (line != null) {
                conjuntoUniversal.leerString(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Menú
        int opcion=0;

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
                System.out.println("11. Diferencia");
                System.out.println("12. Diferencia simetrica ");
                System.out.println("13. Posicion");
                System.out.println("14. Salir ");

                System.out.print("Elige una opción: ");
                try {
                    opcion = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Opción no válida.");
                    scanner.next();
                    continue;
                }
                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa los datos a agregar,números del 1 al 100: ");

                        String datos = scanner.next();
                        lista.leerString(datos);
                        break;
                    case 2:
                        System.out.println("Cantidad de elementos: " );
                        System.out.println(lista.cantidadElementos());
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
                        Lista union = lista.union(lista2.getPunta(), lista);
                        union.mostrar();
                        break;
                    case 6:
                        System.out.print("Ingresa el dato a eliminar: ");
                        int datoEliminar = scanner.nextInt();
                        lista.eliminar(datoEliminar);
                        lista.mostrar();
                        break;
                    case 7:
                        System.out.println("Eliminar duplicados");
                        lista.eliminarDuplicado();
                        lista.mostrar();
                        break;
                    case 8:
                        System.out.println("Intersección");
                        Lista interseccion = lista.interseccion(lista2.getPunta());
                        interseccion.mostrar();
                        break;
                    case 9:
                        System.out.println("Igualdad");
                        lista.igualdad(lista2);
                        break;
                    case 10:
                        System.out.println("Subconjunto");
                        lista.subconjunto(lista2);
                        break;
                    case 11:
                        System.out.println("Diferencia");
                        Lista diferencia = lista.diferencia(lista2.getPunta(), lista);
                        diferencia.mostrar();
                        break;
                    case 12:
                        System.out.println("Diferencia simétrica");
                        Lista diferenciaSimetrica = lista.diferenciaSimetrica(lista2.getPunta(), lista);
                        diferenciaSimetrica.mostrar();
                        break;
                    case 13:
                        System.out.print("Ingresa el dato a buscar: ");
                        int datoPosicion = scanner.nextInt();
                        lista.posicion(datoPosicion);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (opcion != 14);
        }
}
