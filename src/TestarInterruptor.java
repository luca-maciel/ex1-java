class Interruptor{
    boolean ligado = false;

    void pressionar(){
        this.ligado = !this.ligado;
    }
    void verificarLampada(){
        if (this.ligado == true){
            System.out.println("A lâmpada está acesa.");
        }
        else{
            System.out.println("A lâmpada está apagada.");
        }
    }
}

public class TestarInterruptor {
    public static void main(String[] args){
        Interruptor lampadaTeste = new Interruptor();
        lampadaTeste.pressionar(); // liga a lampada
        lampadaTeste.verificarLampada();
        lampadaTeste.pressionar(); // desliga
        lampadaTeste.verificarLampada();
    }
}
