
package mx.edu.itsur.pokebatalla.model.Pokemons;


import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.moves.Lenguetazo;
import mx.edu.itsur.pokebatalla.model.moves.RayoConfuso;
import mx.edu.itsur.pokebatalla.model.moves.Hipnosis;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Manuel Cano Zavala s22120208
 */
public class Gengar extends Pokemon implements Serializable{
    public enum Movimientos {
        RAYO_CONFUSO,
        HIPNOSIS,
        LENGUETAZO,
    }

    public Gengar() {
        tipo = "FANTASMA, VENENO";
        hp = 130;
        ataque = 261;
        defensa = 149;
        nivel = 50;
        precision = 5;
    }

    //Constructor alterno 1
    public Gengar(String nombre) {
        this(); //invocando al constructor default
        this.nombre = nombre;

    }
    
    @Override
        public Enum[] getMovimientos() {
            return Gengar.Movimientos.values();
        }
        @Override
     public void atacar(Pokemon oponente, int ordinalMovimiento) {

        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;
        Gengar.Movimientos movimientoAUtilizar = Gengar.Movimientos.values()[ordinalMovimiento];
        switch (movimientoAUtilizar) {
            case RAYO_CONFUSO:
                instanciaMovimiento = new RayoConfuso();
                break;
            case HIPNOSIS:
                instanciaMovimiento = new Hipnosis();
                break;
                case LENGUETAZO:
                instanciaMovimiento = new Lenguetazo();
                break;

            //Otros movimientos aquí...
            default:
                throw new AssertionError();
        }

        //Aplicar el movimiento
        instanciaMovimiento.utilizar(this, oponente);

    }
    
}
