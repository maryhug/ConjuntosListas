
public class Lista {

    Nodo punta;

    public Lista(Nodo punta){
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


    public void insertarFinal(int dato)
    {
        if (punta == null)
        {
            Nodo nuevo = new Nodo(dato);
            punta = nuevo;
        }
        else
        {
            Nodo aux = punta;
            while(aux.getLiga() != null)
            {
                aux = aux.getLiga();
            }
            Nodo nuevo = new Nodo(dato);
            aux.setLiga(nuevo);
        }
    }

    public void cantidadElementos(){
        int cont = 0;
        Nodo P = punta;
        while(P!=null) {
            cont++;
            P = P.getLiga();
        }

        System.out.println("La cantidad de elemetos es: " + cont);
    }

    public void pertenece(int dato){
        boolean pertenece = false;
        Nodo P = punta;
        while(P!=null){
            if (P.getDato() == dato){
                pertenece = true;

            }
            P = P.getLiga();
        }

        if(pertenece){
            System.out.println("El dato pertenece al conjunto");
        }else{
            System.out.println("El dato no pertenece al conjunto");
        }
    }
    public void mostrar(){
        Nodo P = punta;
        while (P!= null){
            System.out.println(P.getDato());
            P=P.getLiga();
        }
    }

    public void union( Nodo punta2){
        Nodo P = punta;
        Nodo Q = punta2;
        while (P.getLiga() != null ){
            P = P.getLiga();
        }
        P.setLiga(Q);
    }
    public void eliminarDuplicado(){
        Nodo P = punta;
        Nodo Q = P.getLiga();
        while (P != null){
            while (Q != null){
                if ( Q.getDato() == P.getDato()){
                    eliminar(Q.getDato());
                }
            }

        }


    }

    public void eliminar(int R){
        Nodo P = punta;
        Nodo Q = P.getLiga();

        while(Q!=null){
            if (Q.getDato() == R){
                P.setLiga(Q.getLiga());
                Q.setLiga(null);
            }

            P = P.getLiga();
            Q = Q.getLiga();
        }


    }




}


    /*Mostrar, x
    Cantidad de elementos,xx
    pertenece o no,x
    insertar al final x,
    union,x
    eliminar duplicado,X
    interseccion
    igualdad
    subconjunto
    complemento
    diferencia
    diferencia simetrica
    eliminar X
    posición
     */




