package Simulado;

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
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
}
