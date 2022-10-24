package model;

public class Treasure{
    //Variables
    private String url, nombre;
    private double positionX, positionY;
    private int puntos;

    //gett  and setts
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public double getPositionX(){
        return positionX;
    }
    public void setPositionX(double positionX){
        this.positionX = positionX;
    }
    public double getPositionY(){
        return positionY;
    }
    public void setPositionY(double positionY){
        this.positionY = positionY;
    }
    public int getPuntos(){
        return puntos;
    }
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    //constructor
    public Treasure(String url, String nombre, int puntos){
        this.url = url;
        this.nombre = nombre;
        this.puntos = puntos;
        this.positionX = (Math.random() * 1280);
        this.positionY = (Math.random() * 720);
    }
}
