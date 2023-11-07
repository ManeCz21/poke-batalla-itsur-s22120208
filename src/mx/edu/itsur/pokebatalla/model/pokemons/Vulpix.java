/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.pokemons;

import mx.edu.itsur.pokebatalla.model.moves.AtaqueRapido;
import mx.edu.itsur.pokebatalla.model.moves.OndaIgnea;
import mx.edu.itsur.pokebatalla.model.moves.Latigo;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Juan Pablo Torres Zavala
 */
public class Vulpix extends Pokemon{
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
     public void atacar(Pokemon oponente, Vulpix.Movimientos movimientoAUtilizar) {

        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;
        switch (movimientoAUtilizar) {
            case ONDA_IGNEA:
                instanciaMovimiento = new OndaIgnea();
                break;
            case LATIGO:
                instanciaMovimiento = new Latigo();
                break;
                case ATAQUE_RAPIDO:
                instanciaMovimiento = new AtaqueRapido();
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
