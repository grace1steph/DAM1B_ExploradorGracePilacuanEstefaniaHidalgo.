public class Explorador {
    private final int ARRIBA = 1;
    private final int ABAJO = 2;
    private final int IZQUIERDA = 3;
    private final int DERECHA =4;
    private String nombre;
    private Posicion posicionActual;

    public Explorador(String nombre) {
        this.nombre = nombre;
        int fila = (int) (Math.random() *6);
        this.posicionActual = new Posicion(fila,0);
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    public void moverse (int direccion){
        if (direccion >= 1 && direccion <= 4 ){
            if(direccion == ARRIBA){
                if (posicionActual.getCoordenadaFila() > 0 ){
                    posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() -1 );
                }else {
                    System.out.println("No puedes salir del mapa");
                }
            } else if (direccion == ABAJO){
                if (posicionActual.getCoordenadaFila() < 5){
                    posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() +1 );
                }else {
                    System.out.println("No puedes salir del mapa");
                }
            } else if (direccion == IZQUIERDA) {
                if (posicionActual.getCoordenadaCol() < 19) {
                    posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() - 1);
                } else {
                    System.out.println("No puedes salir del mapa");
                }
            } else if (direccion == DERECHA) {
                if (posicionActual.getCoordenadaCol() > 0){
                    posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() + 1);
                } else {
                    System.out.println("No puedes salir del mapa");
                }
            }
        } else {
            System.out.println("La dirección es errónea");
        }
    }
}
