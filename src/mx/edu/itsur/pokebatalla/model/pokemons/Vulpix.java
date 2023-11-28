package mx.edu.itsur.pokebatalla.model.Pokemons;


import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.moves.AtaqueRapido;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;
import mx.edu.itsur.pokebatalla.model.moves.OndaIgnea;
import mx.edu.itsur.pokebatalla.model.moves.Latigo;



/**
 *
 * @author Manuel Cano Zavala s22120208
 */
public class Vulpix extends Pokemon implements Serializable{
    public enum Movimientos {
        ONDA_IGNEA,
        LATIGO,
        ATAQUE_RAPIDO,
    }

    public Vulpix() {
        tipo = "FUEGO";
        hp = 38;
        ataque = 41;
        defensa = 40;
        nivel = 1;
        precision = 4;
    }

    //Constructor alterno 1
    public Vulpix(String nombre) {
        this(); //invocando al constructor default
        this.nombre = nombre;

    }
      @Override
        public Enum[] getMovimientos() {
            return Vulpix.Movimientos.values();
        }
        @Override
     public void atacar(Pokemon oponente, int ordinalMovimiento) {

        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;
        Vulpix.Movimientos movimientoAUtilizar = Vulpix.Movimientos.values()[ordinalMovimiento];
        switch (movimientoAUtilizar) {
            case ATAQUE_RAPIDO:
                instanciaMovimiento = new AtaqueRapido();
                break;
            case ONDA_IGNEA:
                instanciaMovimiento = new OndaIgnea();
                break;
                case LATIGO:
                instanciaMovimiento = new Latigo();
                break;

            //Otros movimientos aquí...
            default:
                throw new AssertionError();
        }

        //Aplicar el movimiento
        instanciaMovimiento.utilizar(this, oponente);

    }
    
}

