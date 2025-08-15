package bk.tales;

public class Card {

    Shapes shape;
    String value;

    public Card(Shapes newShape, String newValue){
        shape = newShape;
        value = newValue;
    }

    public Shapes getShape(){
        return shape;
    }

    public String value(){
        return value;
    }
}
