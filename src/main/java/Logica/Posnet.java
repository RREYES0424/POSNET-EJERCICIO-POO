package Logica;

public class Posnet {
    public static final double RECARGO_POR_CUOTA = 0.03;
    public static final int MIN_CANT_COUTAS = 1;
    public static final int MAX_CANT_CUOTAS = 6;
    
    public Ticket efectuarPago(TarjetaDeCredito tarjeta, double montoAAbonar, int cantCoutas){
        Ticket elTicket = null;
        if (datosValidos(tarjeta,montoAAbonar,cantCoutas)) {
            double montoFinal = montoAAbonar + montoAAbonar * recargoSegunCuotas(cantCoutas);
            if(tarjeta.tieneSaldoDisponible(montoFinal)){
                tarjeta.descontar(montoFinal);
                String nomApe = tarjeta.nombreCompletoTitular();
                double montoPorCuota = montoFinal / cantCoutas;
                elTicket = new Ticket(nomApe, montoFinal, montoPorCuota);
            }
        }
        return elTicket;
    }
    
    private boolean datosValidos(TarjetaDeCredito tarjeta, double monto, int cant){
        boolean esTarjetaValida = tarjeta != null;
        boolean esMontoValido = monto > 0;
        boolean cantCuotasValidas = cant >= MIN_CANT_COUTAS && cant <= MAX_CANT_CUOTAS;

        return esTarjetaValida && esMontoValido && cantCuotasValidas;
    }
    
    private double recargoSegunCuotas(int cantCoutas){
        return (cantCoutas - 1) * RECARGO_POR_CUOTA;
    }
}
