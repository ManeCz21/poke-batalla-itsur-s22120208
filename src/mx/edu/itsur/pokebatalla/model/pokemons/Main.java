package mx.edu.itsur.pokebatalla.model.Pokemons;

import mx.edu.itsur.pokebatalla.model.Battles.Batalla;
import mx.edu.itsur.pokebatalla.model.Battles.Entrenador;

/**
 *
 *  * Manuel Cano Zavala
 */
public class Main {

    public static void main(String[] args) {
        //Unidad 4 

        Pikachu a = new Pikachu("Paco");
        Gengar b = new Gengar("Kevin");
        Vulpix c = new Vulpix("Adrian");
        Arcanine d = new Arcanine("Eddy");
        Charmander e = new Charmander("Manuel");

        Entrenador en1 = new Entrenador("Ash");
        en1.capturarPokemon(a);
        en1.capturarPokemon(e);

        Entrenador en2 = new Entrenador("Nick");
        en2.capturarPokemon(b);
        en2.capturarPokemon(c);

        Batalla x = new Batalla(en1, en2);
        x.desarrollarBatalla();

        
    }

}
