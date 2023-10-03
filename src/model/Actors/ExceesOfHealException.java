package model.Actors;

public class ExceesOfHealException extends Exception{
    public ExceesOfHealException(){
        super("Превышено количество лечений");
    }
}
