package Simulado;

public class Fracao implements Comparable<Fracao>{
    private int n;
    private int d;


    public Fracao (int numerador, int denominador) throws Exception{
        if(denominador == 0 ){
            throw new Exception("Denominador não pode ser igual a 0");
        }
        
        this.n = numerador;
        this.d = denominador;
    }

    public Fracao mais(Fracao outro)throws Exception{
        if (outro == null){
            throw new Exception("Fracao deve ter alguma entrada");
        }

        int numerador = (this.n * outro.d) + (outro.n * this.d);
        int denominador = this.d* outro.d;

        return new Fracao(numerador, denominador);
    }

    public Fracao menos (Fracao outro) throws Exception{
        if (outro == null){
            throw new Exception("Fracao deve ter alguma entrada");
        }

        int numerador = (this.n * outro.d) - (outro.n * this.d); 
        int denominador = this.d * outro.d;

        return new Fracao(numerador, denominador);
    }

    public Fracao vezes (Fracao outro) throws Exception{
        if (outro == null){
            throw new Exception("Fracao deve ter alguma entrada");
        }

        int numerador = this.n * outro.n ;
        int denominador = this.d * outro.d;

        return new Fracao(numerador, denominador);
    }

    public Fracao divididoPor(Fracao outro)throws Exception{
        if (outro == null){
            throw new Exception("Fracao deve ter alguma entrada");
        }

        if(outro.n == 0){
            throw new Exception("Numerador nao pode ser igual a 0 no caso de fracao");
        }

        int numerador = this.n * outro.d;
        int denominador = this.d * outro.n;

        return new Fracao(numerador, denominador);
    }

    @Override
    public String toString() {
        return n + "/" + d;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Fracao outra = (Fracao) obj;

        return ((this.n == outra.n) && (this.d == outra.d));
    }

    @Override
    public int hashCode() {
        int ret = 1;

        ret = ret * 7 + Integer.hashCode(this.d); //tem que acompanhar o tipo de "d" e "n", por isso Integer antes do hashCode
        ret = ret * 7 + Integer.hashCode(this.n);

        if(ret <0) ret = -ret; //tem que garantir que vai ser positivo, para isso que serve essa linha 

        return ret;
    }

    @Override
    public int compareTo(Fracao o) {
        return Double.compare((double) this.n / this.d, (double) o.n/o.d); /*faz a divisao da fração de this em double para dar valor quebrado
        tipo (1/2), depois faz a divisao do outro, virgula serve para o compare de this com outro(o), e Double.compare pq tem os double lá dentro
        do compare, mas o retorno de compare continua sendo um int*/
    }
}