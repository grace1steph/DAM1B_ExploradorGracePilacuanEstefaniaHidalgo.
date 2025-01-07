public class Enemigo {
    private final int ARRIBA = 1;
    private final int ABAJO = 2;
    private final int IZQUIERDA = 3;
    private final int DERECHA = 4;

    private Posicion posicionActual;

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        posicionActual = posicionActual;
    }

    public Enemigo() {
        int fila = (int)(Math.random()*6);
        int columna = (int)(Math.random()*20);
        this.posicionActual = new Posicion(fila, columna);
    }

    public void moverse(){
        int direccion = (int)(Math.random()*4)+1;
        if (direccion >= 1 && direccion <= 4 ){
            if(direccion == ARRIBA){
                if (posicionActual.getCoordenadaFila() > 0 ){
                    posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() -1 );
                }
            } else if (direccion == ABAJO){
                if (posicionActual.getCoordenadaFila() < 5){
                    posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() +1 );
                }
            } else if (direccion == IZQUIERDA) {
                if (posicionActual.getCoordenadaCol() < 19) {
                    posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() - 1);
                }
            } else if (direccion == DERECHA) {
                if (posicionActual.getCoordenadaCol() > 0){
                    posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() + 1);
                }
            }
        }
    }
}
