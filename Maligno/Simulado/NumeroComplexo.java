package Simulado;

import java.util.Objects;

public class NumeroComplexo {
    private double num1;
    private double num2;

    public NumeroComplexo (double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;  
    }

    public NumeroComplexo maisQue (NumeroComplexo outro)//usa as instancias da classe Numero Complexo
    {
        double a = this.num1 + outro.num1;
        double b = this.num2 + outro.num2;
        return new NumeroComplexo(a , b); // cria  uma nova instancia da soma 
    }

    public NumeroComplexo menorQue (NumeroComplexo outro){
        double a = this.num1 - outro.num1;
        double b = this.num2 - outro.num2;
        return new NumeroComplexo(a, b);
    }

    public NumeroComplexo vezesQue (NumeroComplexo outro){
        double a = this.num1 * outro.num1;
        double b = this.num2 * outro.num2; 
        return new NumeroComplexo(a, b);
    }

    public NumeroComplexo divididoPor (NumeroComplexo outro){
        double a = this.num1 / outro.num1; 
        double b = this.num2 / outro.num2;
        return new NumeroComplexo(a, b);
    }

    @Override
    public String toString() {
        if (num2>=0){
            return num1 + "+" + num2 + "i";
        } else{
            return num1 + "-" + Math.abs(num2) + "i";
        }
    }

    @Override
    public int hashCode() {
        int retorno = 1; 
        retorno = retorno * 7 /*numero primo pq ai nao vao ter numeros iguais*/
        + ((Double)this.num1).hashCode(); //numero diferente dá um hash diferente, mas numero igual tem hash igual por conta de ter o this.num 
        retorno = retorno * 7 + ((Double)this.num2).hashCode();
        //faz com que todos fiquem com o msm hash 
        if(retorno<0) retorno =-retorno; //se for negativo soma um numero negativo para que vire 0 
        return retorno;
    }

    @Override
    public boolean equals(Object obj) {//assinatura é Object pois se mudasse nao seria mais Override, seria criar um método novo 
        if(this == obj){ //atalho de performance, se for o mesmo objeto na memória, já retorna true sem comparar campos
            return true;
        }
        if (obj==null || this.getClass()!= obj.getClass()){ //descarta null e objetos de outra classe
            return false; 
        }
        NumeroComplexo outro = (NumeroComplexo) obj; //instancia do obj(Objeto) da classe numeroComplexo 
        return num1 == outro.num1 && num2 == outro.num2; 
    }
}
