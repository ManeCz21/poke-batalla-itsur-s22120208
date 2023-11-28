/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Manuel Cano Zavala s22120208
 */
public class Triturar extends MovimientoEstado {
     public Triturar() {
        this.tipo = Movimiento.TiposDeMovimiento.SINIESTRO;
        this.potencia = 80;
        this.precision = 100;
        this.puntosPoder = 24;   
}
}