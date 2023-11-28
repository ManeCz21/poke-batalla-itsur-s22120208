package mx.edu.itsur.pokebatalla.model.Pokemons;

import java.io.IOException;
import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.Battles.Batalla;
import mx.edu.itsur.pokebatalla.model.Battles.Entrenador;
import mx.edu.itsur.pokebatalla.model.archivos.Files;


/**
 *
 *  * @author Manuel Cano Zavala s22120208
 */
public class Main /*extends JFrame implements Runnable */ implements Serializable {

    public static void main(String[] args) {

        Batalla x = Files.leerPartida();

        if (x == null) {
            Pikachu a = new Pikachu("Paco");
            Gengar b = new Gengar("Kevin");
            Vulpix c = new Vulpix ("Manuel");
            Arcanine d = new Arcanine("Adrian");
            Charmander e = new Charmander("Eddy");

            Entrenador en1 = new Entrenador("Ash");
            en1.capturarPokemon(a);
            en1.capturarPokemon(e);

            Entrenador en2 = new Entrenador("Nick");
            en2.capturarPokemon(b);
            en2.capturarPokemon(c);

            x = new Batalla(en1, en2);
        }
        x.desarrollarBatalla();

        if (x.hayGanador()) {
            System.out.println("¿Desea empezar una nueva partida? (Si/No)");

            char respuesta = 'N';
            try {
                respuesta = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
            } catch (IOException ex) {
                System.out.println("Error al leer la respuesta. Intenta de nuevo.");
                ex.printStackTrace();
            }

            if (respuesta == 'S' || respuesta == 's') {
                // Borra el archivo de la partida guardada
                Files.borrarPartida();
                //Pokemons 
                Arcanine d = new Arcanine("Adrian");
                Charmander e = new Charmander("Eddy");
                Pikachu a = new Pikachu("Paco");
                Gengar b = new Gengar("Kevin");
                
                Entrenador nuevoEntrenador1 = new Entrenador("Manuel");
                nuevoEntrenador1.capturarPokemon(d);
                nuevoEntrenador1.capturarPokemon(e);
                
                Entrenador nuevoEntrenador2 = new Entrenador("Bismarck");
                nuevoEntrenador2.capturarPokemon(b);
                nuevoEntrenador2.capturarPokemon(a);
                

                Batalla nuevaBatalla = new Batalla(nuevoEntrenador1, nuevoEntrenador2);
                nuevaBatalla.desarrollarBatalla();
            }
        }
    }
}

