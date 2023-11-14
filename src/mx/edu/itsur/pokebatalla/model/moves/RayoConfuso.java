/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Manuel Cano Zavala
 */
public class RayoConfuso extends MovimientoEstado {
     public RayoConfuso() {
        this.tipo = Movimiento.TiposDeMovimiento.FANTASMA;
        this.potencia = 100;
        this.precision = 100;
        this.puntosPoder = 16;   
}
}