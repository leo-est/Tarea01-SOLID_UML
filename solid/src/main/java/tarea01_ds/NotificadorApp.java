/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea01_ds;

/**
 *
 * @author marit
 */
public class NotificadorApp implements INotificador {
    
    @Override
    public void enviarMensaje(Usuario destinatario, String asunto, String contenido) {
        System.out.println("--- ENVIANDO NOTIFICACIÓN PUSH (APP) ---");
        System.out.println("Destinatario: " + destinatario.toString()); 
        System.out.println("Asunto: " + asunto);
        System.out.println("Contenido: " + contenido);
    }
}