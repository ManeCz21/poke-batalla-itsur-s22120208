package mx.edu.itsur.pokebatalla.model.Battles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import mx.edu.itsur.pokebatalla.model.Pokemons.Pokemon;

/**
 *
 * @author Manuel Cano Zavala
 */
public class Batalla {

    protected Entrenador entrenador1;
    protected Entrenador entrenador2;
    protected int turno = 1;
    protected boolean batallaFinalizada = false;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    public void desarrollarBatalla() {
        System.out.println("¿Y el gordo?");
        System.out.println("Lo mato Bartolo");
        System.out.println(" --------------------------------- Que comience la batalla --------------------------*");
        System.out.println("LOS OPONENTES SON: ");
        System.out.println(entrenador1.getNombre() + "    <---------------- CONTRA --------------->   " + entrenador2.getNombre());

        System.out.println("");

        
        do {
            try {
                eligirPokemon(entrenador1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Solamente cuentas con:  " + "{" + entrenador1.getPokemonsCapturados().size() + "}" + "  Elige alguno de tus Pokemons");
                entrenador1.setPokemonActual(null);
            }
        } while (entrenador1.getPokemonActual() == null);

        do {
            try {
                eligirPokemon(entrenador2);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Solamente cuentas con:  " + "{" + entrenador2.getPokemonsCapturados().size() + "}" + "  Elige alguno de tus Pokemons");
                entrenador2.setPokemonActual(null);
            }
        } while (entrenador2.getPokemonActual() == null);

        while (!batallaFinalizada) {
            Entrenador entrenadorEnTurno = (turno == 1) ? entrenador1 : entrenador2;
            Entrenador oponente = (turno == 1) ? entrenador2 : entrenador1;

            System.out.println(" ----------------" + " TURNO DEL ENTRENADOR: " + entrenadorEnTurno.getNombre() + " ----------------");

            if (oponente.getPokemonActual() == null) {
                System.out.println("No hay un Pokemon seleccionado para el oponente");
                return;
            }

            seleccionarAtaque(entrenadorEnTurno, oponente.getPokemonActual());
            if (entrenadorEnTurno.getPokemonActual() == null || entrenadorEnTurno.getPokemonActual().gethp() <= 0) {
                cambiarPokemon(entrenadorEnTurno);

                // Repetir el turno del entrenador que no desea cambiar de Pokémon
                while (entrenadorEnTurno.getPokemonActual() == null || entrenadorEnTurno.getPokemonActual().gethp() <= 0) {
                    System.out.println("Este entrenador no puede avanzar sin cambiar de Pokemon.");
                    cambiarPokemon(entrenadorEnTurno);
                }
            }

            if (oponente.estaDerrotado()) {
                System.out.println("¡El entrenador " + oponente.getNombre() + " ha sido derrotado");
                System.out.println(" --------------------------------- La batalla ha terminado  ---------------------------------");
                batallaFinalizada = true;
            } else {
                // Cambiar el turno
                turno = (turno == 1) ? 2 : 1;
            }
        }
    }

    private void eligirPokemon(Entrenador entrenadorEnturno) {
        int idx = 1;
        System.out.println("████████████████████████████████████████████");
        for (Pokemon pokemon : entrenadorEnturno.getPokemonsCapturados()) {
            System.out.println(idx + ".- " + pokemon.getClass().getSimpleName() + " HP: " + pokemon.gethp() + " DEFENSA: " + pokemon.getDefensa() + " NIVEL: " + pokemon.getNivel()  );
            idx++;
            System.out.println("████████████████████████████████████████████");
        }
        System.out.println("");
        System.out.println("Elige un pokemon " + entrenadorEnturno.getNombre() + ":");

        char auxLectura = '0';

        try {
            auxLectura = (char) System.in.read();
            System.in.read((new byte[System.in.available()]));
        } catch (IOException ex) {
        }
        Pokemon pokemonSeleccionado = entrenadorEnturno.getPokemonsCapturados()
                .get(Character.getNumericValue(auxLectura) - 1);
        entrenadorEnturno.setPokemonActual(pokemonSeleccionado);
    }

    private void seleccionarAtaque(Entrenador entrenadorEnturno, Pokemon oponente) {

        Pokemon pokemonActual = entrenadorEnturno.getPokemonActual();

        System.out.println("--------------------------------------");
        System.out.println("Selecciona un ataque para " + pokemonActual.getClass().getSimpleName() + " Con una vida actual de " + pokemonActual.gethp());
        System.out.println("Con defensa de: " + pokemonActual.getDefensa());
        System.out.println("Y un nivel de: " + pokemonActual.getNivel());
        int idx = 1;

        for (Enum movimiento : pokemonActual.getMovimientos()) {
            System.out.println(idx + ".- " + movimiento);
            idx++;
        }
        System.out.println("--------------------------------------");

        int opcionAtaque = -1;

   
        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String input = br.readLine();

           
                opcionAtaque = Integer.parseInt(input);

                if (opcionAtaque < 1 || opcionAtaque > pokemonActual.getMovimientos().length) {
                    System.out.println("La opcion de ataque que ingresaste no es valida. Intentalo de nuevo.");
                } else {
                    break;
                }
            } catch (IOException ex) {
                System.out.println("Error al leer la entrada. Intentalo de nuevo.");
            } catch (NumberFormatException ex) {
                System.out.println("Ingresa un numero valido e intentalo de nuevo.");
            }
        }

    
        entrenadorEnturno.instruirMovimientoAlPokemonActual(oponente, opcionAtaque - 1);
    }

    ///Cambiar pokemon
    private void cambiarPokemon(Entrenador entrenador) {
        System.out.println("¿Deseas cambiar de Pokemon? (S/N)");
        char respuesta = 'N';
 
        while (true) {
            try {
                respuesta = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
                break;  
            } catch (IOException ex) {
                System.out.println("Error de entrada o salida al leer la respuesta. Intentalo de nuevo.");
            }
        }

        if (respuesta == 'S' || respuesta == 's') {

            System.out.println("Los Pokemons disponibles son: ");
            int idx = 1;
            for (Pokemon pokemon : entrenador.getPokemonsCapturados()) {
                System.out.println(idx + ".- " + pokemon.getClass().getSimpleName());
                idx++;
            }

            System.out.println("Elige un nuevo Pokemon:");

            char auxLectura = '0';

            try {
                auxLectura = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
            } catch (IOException ex) {
            }

            int indicePokemonNuevo = Character.getNumericValue(auxLectura) - 1;

           
            if (indicePokemonNuevo >= 0 && indicePokemonNuevo < entrenador.getPokemonsCapturados().size()) {
                Pokemon nuevoPokemon = entrenador.getPokemonsCapturados().get(indicePokemonNuevo);
                entrenador.setPokemonActual(nuevoPokemon);
                System.out.println("Ahora " + nuevoPokemon.getClass().getSimpleName() + " esta tu equipo.");
            } else {
                System.out.println("La opcion de Pokemon no es valida. Intentalo de nuevo.");
            }

        }
    }
}
