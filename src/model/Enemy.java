package model;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Random;

public class Enemy {
    //Declaration of attributes

    private TypeEnemy tipoEnemigo;
    private String subTypeEnemy,nameEnemy;
    private int restScore, sumScore;

    public String getNameEnemy(){
        return nameEnemy;
    }
    public void setNameEnemy(String nameEnemy){
        this.nameEnemy = nameEnemy;
    }


    private double positionEnemyX, positionEnemyY;
    //Declaraction of getters and setters


    public String getSubTypeEnemy(){
        return subTypeEnemy;
    }
    public TypeEnemy getTipoEnemigo(){
        return tipoEnemigo;
    }
    public void setTipoEnemigo(TypeEnemy tipoEnemigo){
        this.tipoEnemigo = tipoEnemigo;
    }
    public double getPositionEnemyY(){
        return positionEnemyY;
    }
    public void setPositionEnemyY(double positionEnemyY){
        this.positionEnemyY = positionEnemyY;
    }
    public void setSubTypeEnemy(String subTypeEnemy){
        this.subTypeEnemy = subTypeEnemy;
    }
    public int getRestScore(){
        return restScore;
    }
    public void setRestScore(int restScore){
        this.restScore = restScore;
    }
    public int getSumScore(){
        return sumScore;
    }
    public void setSumScore(int sumScore){
        this.sumScore = sumScore;
    }

    public double getPositionEnemyX(){
        return positionEnemyX;
    }
    public void setPositionEnemyX(double positionEnemyX){
        this.positionEnemyX = positionEnemyX;
    }
    public double getPositionEnemyy(){
        return positionEnemyY;
    }
    public void setPositionEnemyy(double positionEnemyy){
        this.positionEnemyY = positionEnemyy;
    }

    //constructors
    public Enemy(String subTypeEnemy, int restScore, int sumScore,  TypeEnemy prmTipoEnemigo, String nameEnemy){
        this.tipoEnemigo = prmTipoEnemigo;
        this.subTypeEnemy = subTypeEnemy;
        this.restScore = restScore;
        this.sumScore = sumScore;
        this.positionEnemyX = (Math.random() * 1280);
        this.positionEnemyY = (Math.random() * 720);
        this.nameEnemy = nameEnemy;
    }
}
