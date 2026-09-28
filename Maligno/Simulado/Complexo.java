package Simulado;

public class Complexo{
    private double a; 
    private double b; 

    public Complexo(double num1, double num2){
        this.a  =num1;
        this.b = num2;
    }

    public Complexo maisQue(Complexo outro) throws Exception{
        if (outro == null){
            throw new Exception("Complexo Ausente"); //precisa de um objeto de exceção, Exception é uma classe, então você a instancia 
        }
        double num1= this.a + outro.a;
        double num2 = this.b + outro.b;
        return new Complexo(num1, num2); //precisa do new pq eu estou devolvendo uma nova instancia com os resultados, e nao alterando uma como um setter ou getter
        //dica ja esta no fato do retorno ter que ser um objeto (nesse caso Complexo)
    }

    public Complexo menosQue(Complexo outro) throws Exception{
        if(outro==null){
            throw new Exception("Complexo ausente");
        }
            double num1 = this.a - outro.a;
            double num2 = this.b - outro.b;

            return new Complexo(num1, num2);
    }

    public Complexo vezesQue(Complexo outro) throws Exception{
        if(outro == null){
            throw new Exception("Complexo ausente");
        }

        double num1= (this.a * outro.a) - (this.b*outro.b);
        double num2 = (this.a * outro.b) + (outro.a * this.b);

        return new Complexo(num1, num2);
    }

    public Complexo divididoPor (Complexo outro) throws Exception{
        if(outro ==null){
            throw new Exception("Complexo Ausente");
        }

        double divisor = (outro.a *outro.a ) + (outro.b* outro.b);
        if(divisor ==0){
            throw new Exception("Divisor igual a 0");
        }

        double num1 = ((this.a*outro.a)+ (outro.b*this.b))/ divisor;
        double num2 = ((this.b*outro.a) - (this.a* outro.b)) / divisor; //mais um () para nao realizar a divisao antes da soma/subtrção 

        return new Complexo(num1, num2);
    }

    @Override
    public String toString() {
    if(this.b <0){//so pra ficar bonito no print 
        return this.a + "-" + (-this.b) + "i";
    }
    return this.a + "+" + this.b + "i"; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;

        Complexo outro = (Complexo) obj;

        return ( (this.a == outro.a) && (outro.b == this.b) ); //compara e retorna true ou false segundo as comparações
    }

    @Override
    public int hashCode() {
        int retorno = 1; 

        retorno = retorno * 7 + Double.hashCode(this.a);
        retorno = retorno * 7 + Double.hashCode(this.b);

        if (retorno<0) retorno =-retorno; //se o retorno for ser negativo a gente faz virar positivo ( - com - = + )

        return retorno;
    }
}