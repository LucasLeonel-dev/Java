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
    public void setVolume(byte vol){
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fecharMenu'");
    }

    @Override
    public void maisVolume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maisVolume'");
    }

    @Override
    public void menosVolume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'menosVolume'");
    }

    @Override
    public void ligarMudo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ligarMudo'");
    }

    @Override
    public void desligarMudo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desligarMudo'");
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pause'");
    }


}
