package Encapsulamento;

public class ControleRemoto implements Controlador{ //tenho que anotar sobre esse implements para linkar à interface 
    //Atributos 
    private byte volume; 
    private boolean ligado; 
    private boolean tocando; 

    public void controleRemoto(){
        this.volume = 50;
        this.ligado = false; 
        this.tocando = false; 
    }

    public byte getVolume(){
        return this.volume;
    }
    public void setVolume(int vol){
        this.volume = vol;
    }  

    public boolean isLigado (){
        return this.ligado;
    }
    public void setLigado (boolean ligar){
        this.ligado = ligar;
    }

    public boolean isTocando (){
        return this.tocando;
    }
    public void setTocando(boolean tocar){
        this.tocando = tocar;
    }

    @Override /*pois estou pegando o metodo de outro arquivo, ou seja o estou sobrescrevendo ja que eu to mexendo nele, pra isso
    preciso do override para avisar que eu estou atualizando um método ja existente (pode ser de uma biblioteca tb, n precisa ser nessariamente meu)*/
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
       System.out.println("Esta ligado ?");
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu");
    }

    @Override
    public void maisVolume() {
        if (this.isLigado()){
            this.setVolume(this.getVolume() + 5);
        }
    }

    @Override
    public void menosVolume() {
        if (this.isLigado()){
            this.setVolume(this.getVolume() -5 );
        }
    }

    @Override
    public void ligarMudo() {
        if(this.isLigado() && this.getVolume() > 0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if (this.isLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if (this.isLigado() && !(this.isTocando())){
            this.setTocando(true);
        }
    }

    @Override
    public void pause() {
        if (this.isLigado() && !(this.isTocando())){
            this.setTocando(false);
        }
    }


}
