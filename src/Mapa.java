import java.util.Random;

public class Mapa {
    private char[][] tablero;
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo [] listadoEnemigos;
    private Posicion [] posicionTrampas;

    public Mapa() {
        tablero = new char[6][20];
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }
        }
        //Colocar el tesoro en el mapa
        Random rnd = new Random();
        posTesoro = new Posicion(rnd.nextInt(6), rnd.nextInt(20) );
        tablero [posTesoro.getCoordenadaFila()][posTesoro.getCoordenadaCol()] = ' ';

        //Colocar las trampas en el mapa
        posicionTrampas = new Posicion[3];
        for (int i = 0; i < 3; i++) {
            Posicion trampa;
            do {
                trampa = new Posicion(rnd.nextInt(6), rnd.nextInt(20) );
            } while (tablero[trampa.getCoordenadaFila()][trampa.getCoordenadaCol()] != ' ');
            posicionTrampas[i] = trampa;
            tablero[trampa.getCoordenadaFila()][trampa.getCoordenadaCol()] = 'T';

            //Colocar los enemigos en el tablero
            listadoEnemigos = new Enemigo[3];
            for (int j = 0; j <3 ; j++) {
                Enemigo listado;
                do {
                    listado = new Enemigo();
                } while (tablero[listado.getPosicionActual().getCoordenadaFila()][listado.getPosicionActual().getCoordenadaCol()] != ' ');
                listadoEnemigos[i]= listado;
                tablero[listado.getPosicionActual().getCoordenadaFila()][listado.getPosicionActual().getCoordenadaCol()] = 'E';
            }

            // colocar el Jugador
            Explorador explorador = new Explorador();
            posJugador = new Posicion(explorador.getPosicionActual().getCoordenadaFila(),explorador.getPosicionActual().getCoordenadaCol());
            tablero[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';
        }
    }

    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {
        return posTesoro;
    }

    public Enemigo[] getListadoEnemigos() {
        return listadoEnemigos;
    }

    // mostrar
    public void mostrar(){
        for (int i = 0; i < 6; i++) {
            System.out.println("----------------------------------------------------------------------------------------");
            for (int j = 0; j < 20; j++) {
                String verde = "\u001B[32m";
                String rojo = "\u001B[31m";
                String morado = "\u001B[35m";
                String color;
                char c = tablero[i][j];
                switch (c){
                    case 'J' : color = verde;break;
                    case 'E' : color = rojo; break;
                    case 'T' : color = morado; break;
                    default:color = "\u001B[0m";
                }
                System.out.print(" |" + color + c + "\u001B[0m");
            }
            System.out.println(" |");
        }
        System.out.println("------------------------------------------------------------------------");
    }

    public boolean actualizaPosicionExplorador(Posicion posicionAnt){
        if (tablero[posicionAnt.getCoordenadaFila()][posicionAnt.getCoordenadaFila()] == 'T' ||
        tablero[posicionAnt.getCoordenadaFila()][posicionAnt.getCoordenadaCol()] == 'E'){
            return false;
        }
        tablero[posicionAnt.getCoordenadaFila()][posicionAnt.getCoordenadaCol()] = ' ';
        tablero[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'j';
        return true;
    }

    //Metodo para actualizar enemigos
    public void actualizarEnemigos(){
        for (int i = 0; i < listadoEnemigos.length; i++) {
            Enemigo enemigo = listadoEnemigos[i];
            tablero[enemigo.getPosicionActual().getCoordenadaFila()][enemigo.getPosicionActual().getCoordenadaCol()] = ' ';
            listadoEnemigos[i].moverse();
            tablero[enemigo.getPosicionActual().getCoordenadaFila()][enemigo.getPosicionActual().getCoordenadaCol()] = 'E';
        }

    }
}
