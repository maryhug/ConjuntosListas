
public class Lista {

    Nodo punta;

    public Lista(Nodo punta) {
        this.punta = punta;
    }

    public Nodo getPunta() {
        return punta;
    }

    public void setPunta(Nodo punta) {
        this.punta = punta;
    }

    public Lista() {

    }

    public void leerString(String cadena) {

        String datos[] = cadena.split(",");
        for (int i = 0; i < datos.length; i++) {
            if ((0 <= Integer.parseInt(datos[i]) && (Integer.parseInt(datos[i]) <= 100))) {
                insertarFinal(Integer.parseInt(datos[i]));
            } else {
                System.out.println("El dato " + datos[i] + " no es válido");
            }
        }

    }

    public void insertarFinal(int dato) {
        if (punta == null) {
            Nodo nuevo = new Nodo(dato);
            punta = nuevo;
        } else {
            Nodo aux = punta;
            while (aux.getLiga() != null) {
                aux = aux.getLiga();
            }
            Nodo nuevo = new Nodo(dato);
            aux.setLiga(nuevo);
        }
    }

    public int cantidadElementos() {
        int cont = 0;
        Nodo P = punta;
        while (P != null) {
            cont++;
            P = P.getLiga();
        }
        return cont;
    }

    public boolean pertenece(int dato) {
        boolean pertenece = false;
        Nodo P = punta;
        while (P != null) {
            if (P.getDato() == dato) {
                pertenece = true;

            }
            P = P.getLiga();
        }

        if (pertenece) {
            System.out.println("El dato pertenece al conjunto");
        } else {
            System.out.println("El dato no pertenece al conjunto");
        }
        return pertenece;
    }

    public void mostrar() {

        Nodo P = punta;
        while (P != null) {
            System.out.println(P.getDato());
            P = P.getLiga();
        }
    }

    public Lista union(Nodo punta2, Lista lista) {
        Nodo Q = punta2;
        Lista union = lista;
        Nodo P = union.getPunta();
        while (P.getLiga() != null) {
            P = P.getLiga();
        }
        P.setLiga(Q);
        return union;
    }

    public void eliminarDuplicado() {

        Nodo P = punta;
        ordenar();
        while (P != null) {
           Nodo Q = P.getLiga();
            while (Q != null) {
                if (P.getDato() == Q.getDato()) {
                    eliminar(Q.getDato());
                    P = punta;
                    Q = P.getLiga();
                }else {
                    Q = Q.getLiga();
                }
            }
            P = P.getLiga();
        }
    }

    public void eliminar(int R) {
        Nodo P = punta;
        Nodo Q = P.getLiga();
        if (P.getDato() == R) {
            punta = punta.getLiga();
            P.setLiga(null);
        }else {
            while (Q != null) {
                if (Q.getDato() == R) {
                    P.setLiga(Q.getLiga());
                    Q.setLiga(null);
                }

                P = P.getLiga();
                if (P != null) {
                    Q = P.getLiga();
                } else {
                    Q = null;
                }
            }
        }

    }

    public Lista interseccion(Nodo punta2) {
        Nodo P = punta;
        Lista inter = new Lista();
        while (P != null) {
         Nodo Q = punta2;
            while (Q != null) {
                if (P.getDato() == Q.getDato()) {
                    inter.insertarFinal(P.getDato());
                }
                Q = Q.getLiga();
            }
            P = P.getLiga();

        }
        inter.ordenar();
        inter.eliminarDuplicado();
        return inter;
    }

    public void igualdad(Lista lista2) {
        Nodo P = punta;
        Nodo Q = lista2.getPunta();
        boolean igual = false;
        ordenar();
        if ((cantidadElementos()) == (lista2.cantidadElementos())) {
            while (P != null) {
                if (P.getDato() == Q.getDato()) {
                    igual = true;
                }
                Q = Q.getLiga();
                P = P.getLiga();
            }
        }
        if (igual) {
            System.out.println("Los conjuntos son iguales");
        } else {
            System.out.println("Los conjuntos no son iguales");
        }

    }

    public void ordenar() {
        Nodo P = punta;
        Nodo Q = P.getLiga();
        while (P != null) {
            while (Q != null) {
                if (Q.getDato() < P.getDato()) {
                    int aux = Q.getDato();
                    Q.setDato(P.getDato());
                    P.setDato(aux);
                }
                Q = Q.getLiga();
            }
            P = P.getLiga();
            if (P != null) {
                Q = P.getLiga();
            }
        }
    }

    public void subconjunto(Lista lista2) {
        Nodo P = punta;
        Nodo Q = lista2.getPunta();
        boolean sub = false;
        ordenar();
        if ((cantidadElementos()) <= (lista2.cantidadElementos())) {
            while (P != null) {
                if (P.getDato() == Q.getDato()) {
                    sub = true;
                }
                Q = Q.getLiga();
                P = P.getLiga();
            }
        }
        if (sub) {
            System.out.println("El conjunto es subconjunto de lista 2");
            System.out.println("Y por lo tanto, lista 2 es complemento de la lista");
        } else {
            System.out.println("El conjunto no es subconjunto de lista 2");
            System.out.println("Y por lo tanto, lista 2 no es complemento de la lista");
        }
    }

    public Lista diferencia(Nodo punta2, Lista lista) {
        Lista dif = lista;
        Lista inter = interseccion(punta2);
        Nodo R = inter.getPunta();
        while (R != null) {
            dif.eliminar(R.getDato());
            R = R.getLiga();
        }
        return dif;
    }

    public Lista diferenciaSimetrica(Nodo punta2, Lista lista) {
        Lista inter = interseccion(punta2);
        Lista difSim = union(punta2, lista);

        Nodo R = inter.getPunta();
        difSim.eliminarDuplicado();
        Nodo P = difSim.getPunta();
        while (R != null) {
            difSim.eliminar(R.getDato());
            R = R.getLiga();
        }
        return difSim;
    }

    public void posicion(int dato) {
        Nodo P = punta;
        int cont = 1;
        if (pertenece(dato)){
            while (P != null) {
                if (P.getDato() == dato) {
                    System.out.println("El dato " + dato + " se encuentra en la posición " + cont);
                }
                P = P.getLiga();
                cont++;
            }
        }else {
            System.out.println("El dato no se encuentra en la lista");
        }

    }

    // método heapsort
    public void heapSort() {
        int n = cantidadElementos();

        // Construimos el heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        // Extraemos los elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Intercambiamos el primer nodo con el último nodo del heap
            Nodo firstNode = getNodoAt(0);
            Nodo lastNode = getNodoAt(i);
            int temp = firstNode.getDato();
            firstNode.setDato(lastNode.getDato());
            lastNode.setDato(temp);

            // Reducimos el heap y aplicamos heapify en la nueva raíz
            heapify(i, 0);
        }
    }
    // Método auxiliar para obtener un nodo en una posición específica
    private Nodo getNodoAt(int index) {
        Nodo actual = punta;
        for (int i = 0; i < index && actual != null; i++) {
            actual = actual.getLiga();
        }
        return actual;
    }

    // Método auxiliar para heapSort
    private void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        Nodo largestNode = getNodoAt(largest);
        Nodo leftNode = getNodoAt(left);
        Nodo rightNode = getNodoAt(right);

        // Verificamos si el hijo izquierdo es mayor que el nodo raíz
        if (left < n && leftNode != null && leftNode.getDato() > largestNode.getDato()) {
            largest = left;
            largestNode = leftNode;
        }

        // Verificamos si el hijo derecho es mayor que el nodo más grande hasta ahora
        if (right < n && rightNode != null && rightNode.getDato() > largestNode.getDato()) {
            largest = right;
            largestNode = rightNode;
        }

        // Si el nodo más grande no es la raíz
        if (largest != i) {
            Nodo rootNode = getNodoAt(i);
            int temp = rootNode.getDato();
            rootNode.setDato(largestNode.getDato());
            largestNode.setDato(temp);

            // Recursivamente aplicamos heapify al subárbol afectado
            heapify(n, largest);
        }
    }
//metodo de busqueda binaria
    public void busquedaBinaria(int dato) {
        ordenar();
        int inicio = 0;
        int fin = cantidadElementos() - 1;
        int mitad;
        boolean encontrado = false;
        while (inicio <= fin) {
            mitad = (inicio + fin) / 2;
            Nodo P = punta;
            for (int i = 0; i < mitad; i++) {
                P = P.getLiga();
            }
            if (P.getDato() == dato) {
                System.out.println("El dato " + dato + " se encuentra en la posición " + mitad);
                encontrado = true;
                break;
            } else if (P.getDato() < dato) {
                inicio = mitad + 1;
            } else {
                fin = mitad - 1;
            }
        }
        if (!encontrado) {
            System.out.println("El dato no se encuentra en la lista");
        }
    }





}



    /*Mostrar, x
    Cantidad de elementos,xx
    pertenece o no,x
    insertar al final x,
    union,x
    eliminar duplicado,X
    interseccion X
    igualdad X
    subconjunto X
    complemento X
    diferenciaX
    diferencia simetricaX
    eliminar X
    posiciónX
     */




