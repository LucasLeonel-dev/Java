package Aula02;
public class Main{
    public static void main (String[] arguments){
        System.out.println("Hello world");
        Caneta c1 = new Caneta("Bic","Azul", 0.5f); //instancia do objeto caneta, precisa dos argumentos pq o construtor força isso pra ter que fazer só 1 vez
        // ai n precisaria escrever tudo isso aqui em baixo dps do new 
        c1.modelo = "Bic";
        c1.cor = "Azul"; //pode mexer pq é public, se fosse private (como ponta) daria erro
        c1.carga = 90; //pode mexer (mesmo sendo protected) pq vc está trabalhando dentro de uma instancia da classe
         //posso mexer na variavel private através de um método de um instancia, invés de mexer diretamente
        c1.status();

        c1.setModelo("Bic"); //metodo acessor (setter) modelo, mas só faz sentido usar isso se for pra uma variavel private 
        c1.getModelo();//getter modelo, mas só faz sentido usar isso se for pra uma variavel private 
        c1.setPonta(0.5f);//setter ponta, mas só faz sentido usar isso se for pra uma variavel private 
        c1.getPonta();//getter ponta, mas só faz sentido usar isso se for pra uma variavel private 

    }
}