package Aula02;
public class Caneta {
    public String modelo;
    public String cor;
    private float ponta;
    protected byte carga;
    private boolean tampada;
    final String nome = "Lucas Leonel "; 

    public Caneta (String m, String c, float p){ //método construtor
        this.cor = c;
        this.modelo = m;
        this.setPonta(p);
        this.tampar();
    }   

    public String getModelo (){
        return this.modelo;
    }

    public void setModelo(String m){
        this.modelo = m;
    }

    public float getPonta(){
        return this.ponta;
    }

    public void setPonta(float p){
        this.ponta = p;
    }



    public void status(){
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Cor: " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println("Tampada: " + this.tampada);
    }

    public void rabiscar(){
        if (this.tampada == true){
            System.out.println("Nao tem como rabiscar, tá com a tampa");
        }
        else{
            System.out.println("Rabiscou, fdp");
        }
        }
    protected void tampar(){
        this.tampada=true;//this é uma referencia ao objeto que está chamando, ou melhor, a instancia
    }
    protected void destampar(){
        this.tampada = false;
     }
}
