package Encapsulamento;

public interface Controlador { // declaração da interface para comportar metodos abstratos 
    public abstract void ligar(); //método abstrato 
    public abstract void desligar(); 
    public abstract void abrirMenu();
    public abstract void fecharMenu();
    public abstract void maisVolume();
    public abstract void menosVolume();
    public abstract void ligarMudo();
    public abstract void desligarMudo();
    public abstract void play();
    public abstract void pause();
}

