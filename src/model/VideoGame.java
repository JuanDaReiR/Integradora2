package model;

import java.util.Random;
import java.util.Scanner;

import javax.swing.text.Position;

public class VideoGame{
    private Enemy[] valEnemigos;
    private int contTesoros;
    private Treasure[] valTreasures;
    private Level[] niveles;
    private Player[] jugadores;
    private String[] validadoStrings ;
     Scanner teclado = new Scanner(System.in);

    public VideoGame(){
        this.niveles = new Level[10];
        this.jugadores = new Player[20];
        this.validadoStrings =  new  String[20];
        this.valTreasures =  new  Treasure[50];
        this.valEnemigos = new Enemy[25];
        inicializarVecValidar();
        llenarVectorNiveles();
        inicializarVecValidarEnemigos();
        //initialize VecValidarTesoros();
    }
    
    public void desplegarMenu(){
        int validar =0;
        boolean bandera = true ;

        do {
            System.out.println("------------------------------------------------");
            System.out.println("---------------------MENU-----------------------");
            System.out.println("------------------------------------------------");
            System.out.println("------------------------------------------------");
            System.out.println("1.--Create a player----------------------------");
            System.out.println("2.--Register enemy---------------------------");
            System.out.println("3.--Register treasure-------------------------");
            System.out.println("4.--Modify a player's score----------");
            System.out.println("5.--Increase level for one player-----------");
            System.out.println("6.--Report of treasures and enemies of a level---");
            System.out.println("7.--Amount of a treasure in total--------------");
            System.out.println("8.--Full amount of an enemy in all levels----");
            System.out.println("9.--Most repeated treasure on all levels-------------");
            System.out.println("10.-Enemy with highest score and its level-----------------");
            System.out.println("11.-Number of consonants in enemy names------");
            System.out.println("12.-Top 5 players---------------------------------------------");
            System.out.println("13.-Exit---------------------------------------------");
            validar =Integer.parseInt(teclado.nextLine());

            switch (validar) {
                case 1:

                    String varNombre,varNickname="";
                    System.out.println("Type the name of the player");
                    varNombre = teclado.nextLine();
                    System.out.println("Type the NickName of the player");
                    varNickname = teclado.nextLine();
                    System.out.println("Enter the position in which you want to create the player");
                    mostrarEspaciosLibres();
                    int posicion = Integer.parseInt(teclado.nextLine());
                    if (registrarJugador(varNombre, varNickname, posicion, jugadores) == true) {
                        System.out.println("the player "+ varNickname +" was successfully added");
                        iniciarJugadoresPrimer(posicion);
                        System.out.println("---------------------------------------------------");
                    }else{
                        System.out.println("The player "+ varNickname + "could not register in the position "+ posicion);
                        System.out.println("Please check the data (NickName and position) and try again");
                    }

                    break;
                case 2:
                    if (contarEnemigos()>25) {
                        System.out.println("You have already reached the full capacity of enemies");
                    }else{
                        System.out.println("Enter the level in which you want to add the enemy");
                        mostrarEspaciosLibresLevel();
                        posicion = Integer.parseInt(teclado.nextLine());
                        System.out.println("Enter the name of the enemy");
                        String prmNameEnemy = teclado.nextLine();
                        System.out.println("Enter the sub type of the enemy");
                        String prmSubTipo = teclado.nextLine();
                        System.out.println("Enter the points you score when you win");
                        int prmSumScore = Integer.parseInt(teclado.nextLine());
                        System.out.println("Enter the points you score when you lose");
                        int prmResScore = Integer.parseInt(teclado.nextLine());
                        if (niveles[posicion].registrarEnemigo(posicion, prmSubTipo, prmResScore, prmSumScore, tipoEnemigo(), prmNameEnemy)==true){
                            System.out.println("The enemy "+prmNameEnemy+"successfully registered at the level "+posicion);
                            System.out.print("there are enemys registered");
                            niveles[posicion].mostrarEspaciosLibresEnemigos();
                            teclado.nextLine();
                        }else{
                            System.out.println("The player "+ prmNameEnemy + "could not register in the position "+ posicion);
                            System.out.println("Please check the data (NickName and position) and try again");
                            teclado.nextLine();
                        }
                    }

                    break;
                case 3:
                    if (contarTesoros()<= 50) {
                        System.out.println("Enter the level at which you want to add the treasure");
                        mostrarEspaciosLibresLevel();
                        posicion = Integer.parseInt(teclado.nextLine());
                        System.out.println("Enter the nme of the treasure");
                        String prmNombre = teclado.nextLine();
                        System.out.println("Enter the URL of the treasure");
                        String prmUrl = teclado.nextLine();
                        System.out.println("Enter the score of the treasure");
                        int prmPuntos = Integer.parseInt(teclado.nextLine());
                        if (niveles[posicion].registrarTesoros(prmUrl, prmNombre, prmPuntos, posicion)==true){
                            System.out.println("The reasure " + prmNombre + "of the level " + posicion);
                            System.out.println("Register correctly, these are the treasures of this level");
                            System.out.println("");
                            niveles[posicion].mostrarEspaciosLibresTesoros();
                            teclado.nextLine();
                        }else{
                            System.out.println("The treasure " + prmNombre + "of the level " + posicion);
                            System.out.println("Registered incorrectly, these are the treasures of this level");
                            niveles[posicion].mostrarEspaciosLibresTesoros();
                            teclado.nextLine();
                        }

                    }else{
                        System.out.println("All possible treasures have already been registered");
                    }
                    break;
                case 4:
                    System.out.println("Enter the number of the player whose score you want to modify");
                    mostrarEspaciosLibres();
                    posicion = Integer.parseInt(teclado.nextLine());
                    System.out.println("enter the new score of the player");
                    int prmPuntaje = Integer.parseInt(teclado.nextLine());
                    jugadores[posicion].setPuntajeInicial(prmPuntaje);
                    System.out.println("Score modify succesfully");
                    teclado.nextLine();
                    break;
                case 5:

                    mostrarEspaciosLibres();
                    System.out.println("enter the position of the user you want to level up");
                    int posicionJugador = Integer.parseInt(teclado.nextLine());
                    mostrarEspaciosLibresLevel();
                    System.out.println("enter the position of the level to which you want to climb");
                    int posicionNivel = Integer.parseInt(teclado.nextLine());

                    IncrementarNivel(posicionNivel, posicionJugador);
                    System.out.println("the updated position table is");
                    mostrarJugadoresPorNivel();
                    break;
                case 6:
                    mostrarEspaciosLibresLevel();
                    System.out.println("Enter the level of which you want to know the treasures and enemies");
                    posicion = Integer.parseInt(teclado.nextLine());
                    niveles[posicion].mostrarTesorosSeguido();
                    System.out.println("");
                    niveles[posicion].mostrarEnemigosSeguido();
                    teclado.nextLine();
                    break;
                case 7:
                    System.out.println("Enter the name o f the treasure you wish to count");
                    String prmNombreTesoro = teclado.nextLine();
                    System.out.println("there " + contarTotalTesoros(prmNombreTesoro + " treasures with the name of:  " +prmNombreTesoro));


                    break;
                case 8:
                    TypeEnemy tn = tipoEnemigo();
                    System.out.print("The quantity of  " + tn + " is:  "+contarTotalTipoEnmigos(tn));

                    break;
                case 9:
                    System.out.println("The most repeated treasure is: " + VecTesorosMasRepetidosPorNivel());
                    teclado.nextLine();
                    break;
                case 10:
                    VecEnemigoConMasPuntos();

                    System.out.println("The enemy  "+masPuntosEnemigos().getNameEnemy()+" is the one with the most points and is on the level: "+uBicarNivel());
                    break;
                case 11:
                    System.out.println("there " + contarConsonantes() +" in the names of enemies");
                    teclado.nextLine();
                    break;
                case 12:
                    topPlayers();
                    System.out.println("players organized");
                    mostrarEspaciosLibres();
                    teclado.nextLine();
                    break;
                case 13:
                    bandera=false;
                    break;
                default:
                    break;
            }

        } while (bandera);

    }
    public boolean validarJugadorExistente(String prmNickname) {

        for (int i = 0; i < validadoStrings.length; i++) {

                if (validadoStrings[i].equals(prmNickname)) {
                    return true;
                }
        }return false;

    }
    public void mostrarEspaciosLibres() {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i]==null) {
                System.out.println("Position "+ i + ".------------------------empty----------------------");

            }else{
                System.out.println("Position "+i+".--------------------"+jugadores[i].getNickname()+"---------------"+jugadores[i].getPuntajeInicial());
            }
        }
    }
    public boolean estaDisponibleJugador(Player[] vecValidar, int Posicion) {
        if (vecValidar[Posicion] == null) {
            return true;
        }else{
            return false;
        }
    }
    public boolean estaDisponibleNivel(Level[] vecValidar, int Posicion) {
        if (vecValidar[Posicion] == null) {
            return true;
        }else{
            return false;
        }
    }
    public boolean registrarJugador(String prmNombre, String prmNickName,int Posicion, Player[] vecPlayers) {
        if (estaDisponibleJugador(vecPlayers, Posicion)==true) {
            if (validarJugadorExistente(prmNickName)==false) {
                this.jugadores[Posicion] = new Player(prmNickName, prmNombre, niveles);
                niveles[Posicion].agregarJugador(Posicion, new Player(prmNickName, prmNombre, this.niveles));
                this.validadoStrings[Posicion]=vecPlayers[Posicion].getNickname();
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    public void inicializarVecValidar() {
        for (int i = 0; i < validadoStrings.length; i++) {
            this.validadoStrings[i]="-";
        }
    }
    public void i() {
        for (int i = 0; i < validadoStrings.length; i++) {
            System.out.println(validadoStrings[i]);
        }
    }

    public void mostrarEspaciosLibresLevel() {
        for (int i = 0; i < niveles.length; i++) {
            if (niveles[i]==null) {
                System.out.println("Position "+ i + ".------------------------empty----------------------");

            }else{
                System.out.println("Position "+i+".---"+niveles[i].getIdLevel()+"-----Points to win----------"+ niveles[i].getPuntosWin()+"-------------");
            }
        }
    }
    public void llenarVectorNiveles() {
        int contLevel = 5;
        for (int i = 0; i < niveles.length; i++) {
            niveles[i] = new Level(i, contLevel);
            contLevel = contLevel + 10;
        }
    }
    public TypeEnemy tipoEnemigo() {
        int val =0;
        boolean bandera2 = true;
        do {
            System.out.println("choose the type of enemy");
            System.out.println("1.--"+TypeEnemy.ABSTRACTO+"---------");
            System.out.println("2.--"+TypeEnemy.JEFE+"---------");
            System.out.println("3.--"+TypeEnemy.MAGICO+"---------");
            System.out.println("4.--"+TypeEnemy.OGRO+"---------");
            System.out.println("------------------------------");
            val = Integer.parseInt(teclado.nextLine());


            switch (val) {
                case 1:
                        return TypeEnemy.ABSTRACTO;

                case 2:
                        return TypeEnemy.JEFE;
                case 3:
                        return TypeEnemy.MAGICO;
                case 4:
                        return TypeEnemy.OGRO;

                default:
                    break;
            }

        } while (bandera2 = true);

        return TypeEnemy.ABSTRACTO;
    }

    public int contarEnemigos() {
        int contEnemigos = 0;
        for (int i = 0; i < niveles.length; i++) {
            contEnemigos = contEnemigos+niveles[i].contEnemigos();
        }
        return contEnemigos;
    }
    public int contarTesoros() {

        for (int i = 0; i < niveles.length; i++) {
            this.contTesoros = this.contTesoros+niveles[i].getContTesoros();
        }
        return contTesoros;
    }
    public void IncrementarNivel(int prmNivel, int prmJugador) {
        if (jugadores[prmJugador].getPuntajeInicial() >= this.niveles[prmNivel].getPuntosWin()) {
            niveles[prmNivel].agregarJugador(prmNivel, jugadores[prmJugador]);
        }else{
            int h = this.niveles[prmNivel].getPuntosWin()-jugadores[prmJugador].getPuntajeInicial();
            System.out.println("You don't have the necessary points, you're missing "+ h + "points to pass");
        }
    }
    public void iniciarJugadoresPrimer(int prmPosicion) {

            if (jugadores[prmPosicion]!=null) {
                if (niveles[0].getJugadoresNivel(prmPosicion)==null){
                    niveles[0].agregarJugador(prmPosicion, jugadores[prmPosicion]);
                }


            }
    }
    public void mostrarJugadoresPorNivel() {
        for (int i = 0; i < niveles.length; i++) {
            for (int j = 0; j < jugadores.length; j++) {
                if (jugadores[j]!=null) {
                    if (niveles[i].buscarJugadoresPosicion(jugadores[j].getNickname() )!= -1) {
                        System.out.println("The player" + jugadores[j].getNickname() +" is in the level  "  );
                    }

                }
            }
        }
    }


    public int contarTotalTesoros(String prmNombreTesoro) {
        int cont =0;
        for (int i = 0; i < niveles.length; i++) {
            cont = cont + niveles[i].tesorosIguales(prmNombreTesoro);

        }return cont;
    }
    public int contarTotalTipoEnmigos(TypeEnemy prmTipoEnemigo) {
        int cont =0;
        for (int i = 0; i < niveles.length; i++) {
            cont = cont + niveles[i].tipoEnemigoIgual(prmTipoEnemigo);

        }return cont;
    }
    public void topPlayers() {
        Player aux;
        for(int i = 0; i < jugadores.length; i++){
			for(int j=i+1; j < jugadores.length; j++){
				if(jugadores[i].getPuntajeInicial() < jugadores[j].getPuntajeInicial()){
					aux = jugadores[i];
					jugadores[i] = jugadores[j];
					jugadores[j] = aux;
				}
			}
		}
    }
    public void VecEnemigoConMasPuntos() {

        for (int i = 0; i < niveles.length; i++) {
            if (niveles[i].enemigoConMasPuntos()!=null){
                valEnemigos[i] = niveles[i].enemigoConMasPuntos();
            }

        }

    }
    public void inicializarVecValidarEnemigos() {
        for (int i = 0; i < valEnemigos.length; i++) {
            valEnemigos[i] = new Enemy("---", 00, 1, TypeEnemy.JEFE,"--");
        }
    }
    public Enemy masPuntosEnemigos() {
        Enemy aux;
        for(int i = 0; i < valEnemigos.length; i++){
			for(int j=i+1; j < valEnemigos.length; j++){

                    if(valEnemigos[i].getSumScore() < valEnemigos[j].getSumScore()){
                        aux = valEnemigos[i];
                        valEnemigos[i] = valEnemigos[j];
                        valEnemigos[j] = aux;
                    }



			}
		}return valEnemigos[0];
    }
    public int uBicarNivel(){
        for (int i = 0; i < niveles.length; i++) {
            if (niveles[i].encontrarPuntaje(masPuntosEnemigos().getSumScore()) == true) {
                return i;
            }
        }return -1;
    }
    public int contarConsonantes() {
        int cont = 0;
        for (int i = 0; i < niveles.length; i++) {
            cont = cont + niveles[i].contarCaracterNombreEnemigo();
        }return cont;
    }
    public void VecTesorosMasRepetidos() {

        for (int i = 0; i < niveles.length; i++) {
            if (niveles[i].tesosroMasRepetido()!=null){
                valTreasures[i] = niveles[i].tesosroMasRepetido();
            }

        }

    }
    public Treasure ordenarTesorosRepetidos() {
        Treasure aux;
        for(int i = 0; i < valTreasures.length; i++){
			for(int j=i+1; j < valTreasures.length; j++){
                if (valTreasures[i]!=null && valTreasures[j] != null) {
                    if(valTreasures[i].getNombre().equals(valTreasures[j].getNombre())){
                        aux = valTreasures[i];
                        valTreasures[i] = valTreasures[j];
                        valTreasures[j] = aux;
                    }

                }

			}
		}return valTreasures[0];
    }
    public void inicializarVecValidarTesoros() {
        int cont = 0;
        for (int i = 0; i < valEnemigos.length; i++) {
            cont = cont+1;
            valTreasures[i] = new Treasure("--",Double.toString(Math.random() * 1280) , 0);
        }
    }

    public Treasure tesoroMasRepetidoPorNivel(int index) {
        int masRepetido = 0;
        int indexMasRepetido = -1;
        int numTesoros = niveles[index].getContTesoros();

        if(numTesoros == 0){
            return null;
        }

        for(int i = 0; i < numTesoros; i++) {
            int contador = 0;
            for(int j = 0; j < numTesoros; j++) {
                if(niveles[index].getTesoros()[i].getNombre().equals(niveles[index].getTesoros()[j].getNombre())) {
                    contador++;
                }
            }
            if(contador > masRepetido) {
                masRepetido = contador;
                indexMasRepetido = i;
            }
        }
        return niveles[index].getTesoros()[indexMasRepetido];
    }

    public String VecTesorosMasRepetidosPorNivel() {
        for (int i = 0; i < niveles.length; i++) {
            if (tesoroMasRepetidoPorNivel(i)!=null){
                valTreasures[i] = tesoroMasRepetidoPorNivel(i);
            }

        }

        int contAux = 0;
        for(int i = 0; i < valTreasures.length; i++){
            if(valTreasures[i] != null){
                break;
            }else{
                contAux++;
            }
        }

        if(contAux == valTreasures.length){
            return "No treasures";
        }

        int masRepetido = 0;
        int indexMasRepetido = -1;
        int numTesoros = valTreasures.length;

        for(int i = 0; i < numTesoros; i++){
            int contador = 0;
            if(valTreasures[i] == null){
                continue;
            }
            for(int j = 0; j < numTesoros; j++){
                if(valTreasures[j] == null){
                    continue;
                }
                if(valTreasures[i].getNombre().equals(valTreasures[j].getNombre())){
                    contador++;
                }
            }
            if(contador > masRepetido){
                masRepetido = contador;
                indexMasRepetido = i;
            }
        }

        
        return valTreasures[indexMasRepetido].getNombre();
    }
}
