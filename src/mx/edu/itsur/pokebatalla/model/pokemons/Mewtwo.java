package mx.edu.itsur.pokebatalla.model.pokemons;

import mx.edu.itsur.pokebatalla.model.moves.BolaVoltio;
import mx.edu.itsur.pokebatalla.model.moves.GotaVital;
import mx.edu.itsur.pokebatalla.model.moves.CambiaDefensa;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Juan Pablo Torres Zavala
 */
public class Mewtwo extends Pokemon {

    /**
     * Movimientos que puede realizar el Pokémon
     */
    public enum Movimientos {
        BOLA_VOLTIO,
        CONFUSION,
        CAMBIA_DEFENSA,

        //Otros movimientos...
    }

    //Constructor default
    public Mewtwo() {
        this.tipo = "PSIQUICO";
        this.hp = 45;
        this.ataque = 110;
        this.defensa = 90;
        this.nivel = 1;
        this.precision = 5;
    }

    //Constructor alterno 1
    public Mewtwo(String nombre) {
        this(); //invocando al constructor default
        this.nombre = nombre;
    }

    public void atacar(Pokemon oponente, Mewtwo.Movimientos movimientoAUtilizar) {

        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;        
        switch (movimientoAUtilizar) {
            case BOLA_VOLTIO:
                instanciaMovimiento = new BolaVoltio();
                break;
            case CONFUSION:
                instanciaMovimiento = new GotaVital();
                break;
            case CAMBIA_DEFENSA:
                instanciaMovimiento = new CambiaDefensa();
                break;

            //Otros movimientos aquí...                
            default:
                throw new AssertionError();
        }

        //Aplicar el movimiento
        atacar(oponente, instanciaMovimiento);

    }
     
    @Override
    protected void atacar(Pokemon oponente, Movimiento move) {

        //Aplicar el movimiento
        move.utilizar(this, oponente);
    }     
}