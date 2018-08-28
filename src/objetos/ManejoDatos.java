package objetos;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ManejoDatos {

    private List<Nodo> nodos;
    private List<Arista> aristas;
    private List<Conexion> conexiones;

    public ManejoDatos() {
        this.nodos = new ArrayList<>();
        this.aristas = new ArrayList<>();
        this.conexiones = new ArrayList<>();
    }

    public boolean insertarConexion(String nodo1, String nodo2, String arista) {
        if (consultarConexion(nodo1, nodo2, arista) == null) {
            Nodo nodos1 = consultaNodo(nodo1);
            Nodo nodos2 = consultaNodo(nodo2);
            Arista aristas = consultarArista(arista);
            if ((nodos1 != null && nodos2 != null && aristas != null) && (!nodo2.equals(nodo1))) {
                conexiones.add(new Conexion(nodos1, nodos2, aristas));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean insertarNodo(String nombre) {
        if (consultaNodo(nombre) == null) {
            nodos.add(new Nodo(nombre, nodos.size()));
            return true;
        } else {
            return false;
        }
    }

    public boolean insertarArista(String nombre) {
        if (consultarArista(nombre) == null) {
            aristas.add(new Arista(aristas.size(), nombre));
            return true;
        } else {
            return false;
        }
    }

    private Nodo consultaNodo(String nombre) {
        Nodo dato = null;
        for (int i = 0; i < nodos.size(); i++) {
            if (nombre.equals(nodos.get(i).getNombre())) {
                dato = nodos.get(i);
                break;
            }
        }
        return dato;
    }

    private Arista consultarArista(String nombre) {
        Arista dato = null;
        for (int i = 0; i < aristas.size(); i++) {
            if (nombre.equals(aristas.get(i).getNombre())) {
                dato = aristas.get(i);
                break;
            }
        }
        return dato;
    }

    private Conexion consultarConexion(String nodo1, String nodo2, String arista) {
        Conexion dato = null;
        for (int i = 0; i < conexiones.size(); i++) {
            if ((nodo1.equals(conexiones.get(i).getNodo1().getNombre()) && nodo2.equals(conexiones.get(i).getNodo2().getNombre())
                    && arista.equals(conexiones.get(i).getArista().getNombre()))
                    || (nodo1.equals(conexiones.get(i).getNodo2().getNombre()) && nodo2.equals(conexiones.get(i).getNodo1().getNombre())
                    && arista.equals(conexiones.get(i).getArista().getNombre()))) {
                dato = conexiones.get(i);
                break;
            }
        }
        return dato;
    }

    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.err.println("Error al cerrar el archivo aux_grafico.dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " aux_grafico.dot");
            //Esperamos medio segundo para dar tiempo a que la imagen se genere.
            //Para que no sucedan errores en caso de que se decidan graficar varios
            //árboles sucesivamente.
            Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }

    private String getCodigoGraphviz() {
        return "digraph grafica{\n"
                + "rankdir=TB;\n"
                + "node [shape = record, style=filled, fillcolor=seashell2];\n"
                + getCodigoInterno(0, "")
                + "}\n";
    }

    private String getCodigoInterno(int index, String etiqueta) {
        if (index < conexiones.size()) {
            
                etiqueta += "nodo" + conexiones.get(index).getNodo1().getId() + " [ label =\"" + conexiones.get(index).getNodo1().getNombre() + "|<C1>\"];\n";
                etiqueta += "nodo" + conexiones.get(index).getNodo1().getId() + ":C1->nodo" + conexiones.get(index).getNodo2().getId() + "\n";
                etiqueta += "nodo" + conexiones.get(index).getNodo2().getId() + " [ label =\"" + conexiones.get(index).getNodo2().getNombre() + "|<C1>\"];\n";
                etiqueta += getCodigoInterno(index + 1, "");
            
        }
        return etiqueta;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }

    public List<Conexion> getConexiones() {
        return conexiones;
    }

    public void setConexiones(List<Conexion> conexiones) {
        this.conexiones = conexiones;
    }
}
