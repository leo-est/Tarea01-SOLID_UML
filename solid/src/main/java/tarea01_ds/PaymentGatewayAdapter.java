/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea01_ds;

/**
 *
 * @author marit
 */
public class PaymentGatewayAdapter implements IProcesadorPago, IProcesadorReembolso {
    
    private String proveedorPasarela;

    public PaymentGatewayAdapter(String proveedorPasarela) {
        this.proveedorPasarela = proveedorPasarela;
    }

    @Override
    public boolean procesarCobro(double monto, String datosPago) {
        System.out.println("Cobrando $" + monto + " vía Gateway (" + proveedorPasarela + "). Datos: " + datosPago);
        // Simulación de cobro exitoso
        return true;
    }

    @Override
    public boolean ejecutarReembolso(String idReserva, double monto) {
        System.out.println("Ejecutando reembolso de $" + monto + " para la reserva [" + idReserva + "] vía Gateway (" + proveedorPasarela + ").");
        // Simulación de reembolso exitoso
        return true;
    }
}
