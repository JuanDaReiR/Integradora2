package model;

public class Player{
    private Level[] niveles;
    private String nickname, nombre;
    private int numeroVidas,puntajeInicial,nivelActual;

    public int getNivelActual(){
        return nivelActual;
    }
    public void setNivelActual(int nivelActual){
        this.nivelActual = nivelActual;
    }
    public Level[] getNiveles(){
        return niveles;
    }
    public void setNiveles(Level[] niveles){
        this.niveles = niveles;
    }
    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getNumeroVidas(){
        return numeroVidas;
    }
    public void setNumeroVidas(int numeroVidas){
        this.numeroVidas = numeroVidas;
    }
    public int getPuntajeInicial(){
        return puntajeInicial;
    }
    public void setPuntajeInicial(int puntajeInicial){
        this.puntajeInicial = puntajeInicial;
    }

    public Player(String nickname, String nombre, Level[] prmNiveles){
        this.nickname = nickname;
        this.nombre = nombre;
        this.niveles = new Level[prmNiveles.length];
        this.numeroVidas = 5;
        this.puntajeInicial = 10;

        niveles = prmNiveles;
    }

    public void validarNivel(){
        for (int i = 0; i < niveles.length; i++){
            if (this.puntajeInicial >= niveles[i].getPuntosWin()){
                this.nivelActual = i+1;
            }
        }
    }
}
