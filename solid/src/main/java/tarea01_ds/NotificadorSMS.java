/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea01_ds;

/**
 *
 * @author marit
 */
public class NotificadorSMS implements INotificador {
    
    @Override
    public void enviarMensaje(Usuario destinatario, String asunto, String contenido) {
        System.out.println("--- ENVIANDO SMS ---");
        System.out.println("Destinatario: " + destinatario.toString()); // Asegúrate de que Usuario tenga un método para obtener su teléfono
        System.out.println("Asunto: " + asunto);
        System.out.println("Contenido: " + contenido);
    }
}
