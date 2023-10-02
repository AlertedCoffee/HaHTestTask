package model;

public class ExceesOfHealException extends Exception{
    public ExceesOfHealException(){
        super("Превышено количество лечений");
    }
}
