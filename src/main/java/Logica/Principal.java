package Logica;

public class Principal {

    public static void main(String[] args) {
        Posnet posnet = new Posnet();
        Persona persona1 = new Persona("5164856", "Ricardo", "Reyes Flores", "8989898989", "correo@correo.com");
        TarjetaDeCredito tdc1 = new TarjetaDeCredito("FakeBank", "1256987845365298", 15000, EntidadFinanciera.CASTERMAD, persona1);
        System.out.println("Tarjeta antes del pago: " + tdc1.toString());
        
        System.out.println("Ticket tras pagar...");
        Ticket ticketGenerado = posnet.efectuarPago(tdc1, 10000, 5);
        System.out.println(ticketGenerado.toString());
        
        System.out.println("Tarjeta despues del pago: " + tdc1.toString());
     
    }
}
