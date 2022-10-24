package model;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Level{
    //variables
    private Player[] jugadoresNivel;
    private int contEnemigos, contTesoros;
    private Difficulty dificultad;
    private Enemy[] enemigos;
    private Enemy[] validarEmemigos;
    private Treasure[] tesoros;
    private int idLevel,puntosWin;

    //Declaration of getters and setters

    public Enemy[] getEnemigos(){
        return enemigos;
    }
    public int getContEnemigos(){
        return contEnemigos;
    }
    public void setContEnemigos(int contEnemigos){
        this.contEnemigos = contEnemigos;
    }
    public int getContTesoros(){
        return contTesoros;
    }
    public void setContTesoros(int contTesoros){
        this.contTesoros = contTesoros;
    }
    public Player getJugadoresNivel(int posicion){
        return jugadoresNivel[posicion];
    }
    public void setJugadoresNivel(Player[] jugadoresNivel){
        this.jugadoresNivel = jugadoresNivel;
    }
    public void setEnemigos(Enemy[] enemigos){
        this.enemigos = enemigos;
    }
    public Treasure[] getTesoros(){
        return tesoros;
    }
    public void setTesoros(Treasure[] tesoros){
        this.tesoros = tesoros;
    }
    public int getIdLevel(){
        return idLevel;
    }
    public void setIdLevel(int idLevel){
        this.idLevel = idLevel;
    }
    public Difficulty getDificultad(){
        return dificultad;
    }
    public void setDificultad(Difficulty dificultad){
        this.dificultad = dificultad;
    }
    public int getPuntosWin(){
        return puntosWin;
    }
    public void setPuntosWin(int puntosWin){
        this.puntosWin = puntosWin;
    }
    //constructor
    public Level( int idLevel,  int prmPuntosWin){
        this.enemigos = new Enemy [25];
        this.tesoros = new Treasure [50];
        this.idLevel = idLevel;
        this.puntosWin = prmPuntosWin;
        this.validarEmemigos = new Enemy [25];
        this.jugadoresNivel = new Player [20];
        inicializarVecValidarEnemigos();
    }
    //methods
    public void asignacionDificultad(){
        int contPuntosTesoros =0, contPuntosEnemigos =0;
        for (int i = 0; i < enemigos.length; i++){
            contPuntosEnemigos = contPuntosEnemigos + enemigos[i].getSumScore();
        }
        for (int i = 0; i < tesoros.length; i++){
            contPuntosTesoros = contPuntosTesoros + tesoros[i].getPuntos();
        }
        if (contPuntosEnemigos == contPuntosTesoros){
            this.dificultad = Difficulty.MEDIUM;
        }else if (contPuntosEnemigos < contPuntosTesoros){
            this.dificultad = Difficulty.LOW;
        }else{
            this.dificultad = Difficulty.HIGH;
        }

    }

    public int contEnemigos(){
        for (int i = 0; i < enemigos.length; i++){
            if (enemigos[i] != null){
                contEnemigos = contEnemigos+1;
            }
        }
        return contEnemigos;
    }
    public boolean estaDisponibleEnemigo(Enemy[] vecValidar, int Posicion){
        if (vecValidar[Posicion] == null){
            return true;
        }else{
            return false;
        }
    }
    public void mostrarEspaciosLibres(){
        for (int i = 0; i < enemigos.length; i++){
            if (enemigos[i]==null){
                System.out.println("Position "+ i + ".----------empty---------");

            }else{
                System.out.println("Position "+i+".-----"+enemigos[i].getNameEnemy()+"-----");
            }
        }
    }
    public void inicializarVecValidarEnemigos(){
        for (int i = 0; i < validarEmemigos.length; i++){
            validarEmemigos[i] = new Enemy("--", 00, 1, TypeEnemy.JEFE,"--");
        }
    }
    public int contTesoros(){
        for (int i = 0; i < tesoros.length; i++){
            if (tesoros[i] != null){
                contTesoros = contTesoros +1;
            }
        }
        return contTesoros;
    }
    public boolean registrarEnemigo(int posicion, String prmSubTipo,int prmRestScore , int prmSumScore, TypeEnemy prmTipEnemy,String prmNameEnemy){
        if (estaDisponibleEnemigo(enemigos, posicion)==true){
            if (enemigoExiste(prmTipEnemy, prmSubTipo) == false){
                enemigos[posicion] = new Enemy(prmSubTipo, prmRestScore, prmSumScore, prmTipEnemy, prmNameEnemy);
                this.validarEmemigos[posicion].setTipoEnemigo(enemigos[posicion].getTipoEnemigo());
                return true;
            }
        }
        return false;
    }
    public boolean enemigoExiste(TypeEnemy prmTipEnemigo, String prmSubTipo){
        for (int i = 0; i < enemigos.length; i++){
            if (validarEmemigos[i].getTipoEnemigo().equals(prmTipEnemigo) && validarEmemigos[i].getSubTypeEnemy().equals(prmSubTipo)){
                return true;
            }
        }
        return false;
    }public boolean registrarTesoros(String prmUrl, String prmNombre, int prmPuntosWin,int posicion){
        for (int i = 0; i < tesoros.length; i++){
            if (tesoros[i] == null){
                tesoros[i] = new Treasure(prmUrl, prmNombre, prmPuntosWin);
                this.contTesoros = this.contTesoros + 1;
                return true;
            }
        }return false;

    }
    public void mostrarEspaciosLibresTesoros(){
        for (int i = 0; i < tesoros.length; i++){
            if (tesoros[i]==null){
                System.out.println("Position "+ i + ".------------empty----------");

            }else{
                System.out.println("Position "+i+".---"+tesoros[i].getNombre()+"---");
            }
        }
    }
    public void mostrarEspaciosLibresEnemigos(){
        for (int i = 0; i < enemigos.length; i++){
            if (enemigos[i]==null){
                System.out.println("Position "+ i + ".------empty-------");

            }else{
                System.out.println("Position "+i+".---"+enemigos[i].getNameEnemy()+"------");
            }
        }
    }
    public void agregarJugador(int posicion, Player prmJugador){
        this.jugadoresNivel[posicion] = prmJugador;
    }
    public int buscarJugadoresPosicion(String prmNickName){

        for (int i = 0; i < jugadoresNivel.length; i++){
            if (jugadoresNivel[i]!=null){
                if (jugadoresNivel[i].getNickname().equals(prmNickName)){
                    return i;
                }
            }

        }return -1;
    }
    public void eliminarJugador(String prmNickName){

        for (int i = 0; i < jugadoresNivel.length; i++){
            if (jugadoresNivel[i]!=null){
                if (jugadoresNivel[i].getNickname().equals(prmNickName)){
                    jugadoresNivel[i] = null;
                }
            }

        }
    }
    public void mostrarTesorosSeguido(){
        for (int i = 0; i < tesoros.length; i++){
            if (tesoros[i]!=null){
                System.out.print(" , " + tesoros[i].getNombre() + ",");
            }
        }

    }
    public void mostrarEnemigosSeguido(){
        for (int i = 0; i < tesoros.length; i++){
            if (enemigos[i]!=null){
                System.out.print(" , " + enemigos[i].getNameEnemy() + ",");
            }
        }

    }
    public int tesorosIguales(String prmNombreTesoro){
        int cont = 0;
        for (int i = 0; i < tesoros.length; i++){
            if (tesoros[i]!=null) {
                if (tesoros[i].getNombre() == prmNombreTesoro){
                    cont = cont+1;
                }
            }
        }return cont;
    }
    public int tipoEnemigoIgual(TypeEnemy prmTipoEnemigo){
        int cont = 0;
        for (int i = 0; i < enemigos.length; i++){
            if (enemigos[i]!=null) {
                if (enemigos[i].getTipoEnemigo()== prmTipoEnemigo){
                    cont = cont+1;
                }
            }
        }return cont;
    }
    public Enemy enemigoConMasPuntos(){
        Enemy aux;
        for(int i = 0; i < enemigos.length; i++){
			for(int j=i+1; j < enemigos.length; j++){
                if (enemigos[i]!=null && enemigos[j] != null){
                    if(enemigos[i].getSumScore() < enemigos[j].getSumScore()){
                        aux = enemigos[i];
                        enemigos[i] = enemigos[j];
                        enemigos[j] = aux;
                    }

                }

			}
		}
        return enemigos[0];
    }
    public boolean encontrarPuntaje(int prmPutos){
        for (int i = 0; i < enemigos.length; i++){
            if (enemigos[i]!=null){
                if (enemigos[i].getSumScore() == prmPutos){
                    return true;
                }
            }
        }return false;

    }
    public int contarCaracterNombreEnemigo(){
        int cont =0;
        for (int i = 0; i < enemigos.length; i++){
            if (enemigos[i]!=null){
                cont= cont+contarCaracter(enemigos[i].getNameEnemy());
            }
        }return cont;
    }
    public  int contarCaracter(String word){
        int counter = 0;
          for (int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) != 'a' && word.charAt(i) != 'e' && word.charAt(i) != 'i' && word.charAt(i) != 'o' && word.charAt(i) != 'u' )
            {
                counter++;
            }
        }
          return counter;
    }
    public Treasure tesosroMasRepetido(){
        Treasure aux;
        for(int i = 0; i < tesoros.length; i++){
			for(int j=i+1; j < tesoros.length; j++){
                if (tesoros[i]!=null && tesoros[j] != null){
                    if(tesoros[i].getNombre().equals(tesoros[j].getNombre())){
                        aux = tesoros[i];
                        tesoros[i] = tesoros[j];
                        tesoros[j] = aux;
                    }
                }
			}
		}
        return tesoros[0];
    }
}
