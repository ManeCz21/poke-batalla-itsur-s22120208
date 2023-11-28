package mx.edu.itsur.pokebatalla.model.archivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mx.edu.itsur.pokebatalla.model.Battles.Batalla;

/**
 *
 * @author Manuel Cano Zavala s22120208
 */

public class Files {

    public static final String PARTIDA_FILE_NAME = "Partida.pokebatalla";

    public static void guardarPartida(Batalla x) {
        try (ObjectOutputStream escritorDeObjetos = new ObjectOutputStream(new FileOutputStream(PARTIDA_FILE_NAME))) {
            escritorDeObjetos.writeObject(x);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Batalla leerPartida() {
        Batalla x = null;
        try (ObjectInputStream lectorDeObjetos = new ObjectInputStream(new FileInputStream(PARTIDA_FILE_NAME))) {
            x = (Batalla) lectorDeObjetos.readObject();
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return x;
    }
    
    public static void borrarPartida() {
    File file = new File(PARTIDA_FILE_NAME);
    if (file.exists()) {
        file.delete();
        System.out.println("Ultima Partida Eliminada.");
    }
}
}
