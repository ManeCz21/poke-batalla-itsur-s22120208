package mx.edu.itsur.pokebatalla.model.Pokemons;


import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.moves.Lanzallamas;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;
import mx.edu.itsur.pokebatalla.model.moves.Rugido;
import mx.edu.itsur.pokebatalla.model.moves.Triturar;

/**
 *
 * @author Manuel Cano Zavala s22120208
 */
public class Arcanine extends Pokemon implements Serializable {
        public enum Movimientos {
        LANZALLAMAS,
        RUGIDO,
        TRITURAR,
    }

    public Arcanine() {
        tipo = "FUEGO";
        hp = 90;
        ataque = 110;
        defensa = 80;
        nivel = 1;
        precision = 2;
    }

    //Constructor alterno 1
    public Arcanine(String nombre) {
        this(); //invocando al constructor default
        this.nombre = nombre;

    }
     @Override
        public Enum[] getMovimientos() {
            return Arcanine.Movimientos.values();
        }
        @Override
     public void atacar(Pokemon oponente, int ordinalMovimiento) {

        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;
        Arcanine.Movimientos movimientoAUtilizar = Arcanine.Movimientos.values()[ordinalMovimiento];
        switch (movimientoAUtilizar) {
            case LANZALLAMAS:
                instanciaMovimiento = new Lanzallamas();
                break;
            case RUGIDO:
                instanciaMovimiento = new Rugido();
                break;
                case TRITURAR:
                instanciaMovimiento = new Triturar();
                break;

            //Otros movimientos aquí...
            default:
                throw new AssertionError();
        }

        //Aplicar el movimiento
        instanciaMovimiento.utilizar(this, oponente);
    }
}