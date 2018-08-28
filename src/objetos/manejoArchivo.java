package objetos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class manejoArchivo {
    private File archivo;
    public manejoArchivo(File archivo) {
        this.archivo=archivo;
    }

    public void leerTexto() {
        String texto = "";
        try {
            String cadena;
            String textos = "";
            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufRead = new BufferedReader(fileReader);
            while ((cadena = bufRead.readLine()) != null) {
                textos = textos + cadena + "\n";
            }
            bufRead.close();
            fileReader.close();
            texto = textos;
            JOptionPane.showMessageDialog(null, "Se ha abierto el archivo");
        } catch (Exception ex) {
            texto = "";
            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
        }
    }
}
