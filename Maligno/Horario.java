import javax.imageio.plugins.tiff.ExifParentTIFFTagSet;

public class Horario
{
    private byte hora, minuto, segundo;

    public void Horario (byte hora, byte minuto, byte segundo) throws Exception //construtor para set dados, precisa de uma função pois os dados sao private
    {
        this.setHora(hora);
        this.setMinuto(minuto);
        this.setSegundo(segundo);
    }

    public void setHora (byte hora) throws Exception
    {
        if (hora<0 || hora>23)throw new Exception ("Hora invalida!");
        this.hora = hora;
    }

    public void setMinuto (byte minuto) throws Exception
    {
        if (minuto<0 || minuto>59) throw new Exception("Minuto invalido");
        this.minuto = minuto;
    }

    public void setSegundo (byte segundo) throws Exception //sem isso nao inicializa os erros para a função 
    {
        if (segundo<0 || segundo>59) throw new Exception("segundo invalido");
        this.segundo= segundo;
    }

    public byte getHora () throws Exception 
    {
        if (hora<0 || hora>23)throw new Exception ("Hora invalida!");
        return hora;
        //não precisa comparar com null, pois tipos primitivos(letra minuscula), não podem ser null
    }

    public byte getMinuto ()
    {
        return minuto;
    }

    public byte getSegundo ()
    {
        return segundo; 
    }

    public void adiante (int qtdSegundos) throws Exception
    {
        final int totalSegundos = this.hora*3600 + this.minuto*60 + this.segundo + qtdSegundos;
        /*transformo no numero total de segundos e adiciono a qtd de segundos no final, dessa forma
        não preciso fica colocando if's e else que aumentam mt o raciocinio do código */
        this.hora = (byte) ((totalSegundos / 3600) %24); // %24 garante que as horas resetem, se o horario for menor que 24, seu resto é ele mesmo (exemplo 23/24, nao chega a dar 1, ent o resto é 23)
        this.minuto = (byte) (totalSegundos%3600); //tem que ser o resto, pq é a mesma coisa que subtrair 
        this.segundo= (byte)/*transforma os dados em byte invés de int antes de atribuir */ (totalSegundos % 60); 
    }

    public void retroceda (int qtdSegundos) throws Exception
    {
        int totalSegundos = this.hora*3600 + this.minuto*60 +this.segundo - qtdSegundos;
        
        totalSegundos = totalSegundos % 86400; //número de segundos em 1 dia 
        if (totalSegundos <0){
            totalSegundos += 86400; // to criando o dia do zero pq o fdp voltou o dia inteiro 
        }

        this.hora = (byte) ((totalSegundos /3600));
        this.minuto = (byte) (totalSegundos%3600);
        this.segundo = (byte) (totalSegundos%60);

    }

    //public Horario getHorarioFuturo (int qtdSegundos) throws Exception // nao altera o this
    {
        // faça
    }

    //public Horario getHorarioPassado (int qtdSegundos) throws Exception // nao altera o this
    {
        // faça
    }

    // faça também toString, equals e hashCode
}