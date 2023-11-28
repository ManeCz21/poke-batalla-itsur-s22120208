package mx.edu.itsur.pokebatalla.model.Pokemons;

import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.moves.Impactrueno;
import mx.edu.itsur.pokebatalla.model.moves.Latigo;
import mx.edu.itsur.pokebatalla.model.moves.AtaqueRapido;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Manuel Cano Zavala s22120208
 */
    public class Pikachu extends Pokemon implements Serializable{

        public enum Movimientos {
            IMPACTRUENO,
            ATAQUE_RAPIDO,
            LATIGO
        }

        //Constructor default
        public Pikachu() {
            tipo = "ELECTRICO";
            hp = 35;
            ataque = 55;
            defensa = 30;
            nivel = 1;
            precision = 4;
            xp = 64; //Poner la xp correspondiente a cada pokemon
        }

        public Pikachu(String nombre) {
            this(); //invocando al constructor default
            this.nombre = nombre;
        }

        @Override
        public Enum[] getMovimientos() {
            return Pikachu.Movimientos.values();
        }
        

        @Override
        public void atacar(Pokemon oponente, int ordinalMovimiento) {

            Movimiento instanciaMovimiento;
            Pikachu.Movimientos movimientoAUtilizar = Pikachu.Movimientos.values()[ordinalMovimiento];
            
            switch (movimientoAUtilizar) {
                case IMPACTRUENO:
                    instanciaMovimiento = new Impactrueno();
                    break;
                case ATAQUE_RAPIDO:
                    instanciaMovimiento = new AtaqueRapido();
                    break;
                case LATIGO:
                    instanciaMovimiento = new Latigo();
                    break;
                default:
                    throw new AssertionError();
            }
            if (this.hp <= 0) {
                System.out.println("Pikachu esta agotado y no puede realizar mas movimientos.");
                return;
            }

            instanciaMovimiento.utilizar(this, oponente);
        }

    }
