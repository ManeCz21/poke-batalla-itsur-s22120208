/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Manuel Cano Zavala s22120208
 *
 */
public class Hipnosis extends MovimientoEstado {
     public Hipnosis() {
        this.tipo = Movimiento.TiposDeMovimiento.PSIQUICO;
        this.potencia = 100;
        this.precision = 60;
        this.puntosPoder = 32;   
}
}