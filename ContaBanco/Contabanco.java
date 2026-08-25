package ContaBanco;
public class Contabanco {

    public int numConta; 
    protected String tipo; 
    private String dono; 
    private float saldo; 
    private Boolean status;

    public void ContaBanco(){
        this.setDono(dono);
        this.setSaldo(0);
        this.setStatus(false);
    }
    public void setNumConta(int n){
        this.numConta = n;
    }

    public int getNumConta(){
        return this.numConta;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setDono(String dono){
        this.dono = dono;
    }

    public String getDono(){
        return this.dono;
    }

    public void setSaldo(float saldo){
        this.saldo = saldo; 
    }

    public float getSaldo(){
        return this.saldo; 
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

    public Boolean isStatus(){
        return this.status;
    }

    public void abrirConta(String tipo){
        this.setTipo(tipo);
        this.setStatus(true);
        if (tipo=="CC") {
            this.setSaldo(50);
        } else if(tipo =="CP"){
            this.setSaldo(150);
        }
    }
    public void fecharConta(){
        if (this.getSaldo() > 0) System.out.println("Conta não pode ser fechada pois ainda tem dinheiro");
        else if(this.getSaldo()< 0) System.out.println("Conta não pode ser fechada, saldo negativo");
        else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso");
        }

    }
    public void depositar(float valor){
        if (this.isStatus()){
            this.setSaldo(this.getSaldo() + valor); //pega o valor e soma com o argumento
            System.out.println("Deposito realizado com sucesso de "+ this.getDono() + "no valor de = " + valor);
        }
        else{
            System.out.println("Impossivel depositar em uma conta fechada");
        }

    }
    public void sacar(float valor){
        if (this.isStatus()){
            if(this.getSaldo() > valor){
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque realizado na conta de " + this.getDono());
            }else  System.out.println("Saldo insuficiente para saque");
        }else System.out.println("Conta está fechada, impossível realizar saque.");
    }

    public void pagarMensal(){
        
    
    }
}
