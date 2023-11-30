package builderdesignpattern;

public class Client {
    public static void main(String[] args) {
        
        Director director = new Director();
        director.makeSUV();
    }
}
