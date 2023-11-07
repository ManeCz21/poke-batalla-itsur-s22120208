/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.pokemons;

import mx.edu.itsur.pokebatalla.model.moves.Lanzallamas;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;
import mx.edu.itsur.pokebatalla.model.moves.Rugido;
import mx.edu.itsur.pokebatalla.model.moves.Triturar;

/**
 *
 * @author Juan Pablo Torres Zavala
 */
public class Arcanine extends Pokemon {
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
     public void atacar(Pokemon oponente, Arcanine.Movimientos movimientoAUtilizar) {

        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;
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
        atacar(oponente, instanciaMovimiento);

    }
     
    @Override
    protected void atacar(Pokemon oponente, Movimiento move) {

        //Aplicar el movimiento
        move.utilizar(this, oponente);
    }     
}
