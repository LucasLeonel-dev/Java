package Simulado;

public class Horario implements Cloneable, Comparable<Horario>{
    private byte h;
    private byte m;
    private byte s;

    public Horario(byte horas, byte minutos, byte segundos)throws Exception{
        if( (0>horas || horas>23) || (0>minutos|| minutos>59) ||( 0>segundos || segundos> 59)){
            throw new Exception("Dados invalidos");
        }

        this.h = horas;
        this.m = minutos;
        this.s = segundos;
    }

    public void adiantar (byte k)throws Exception{
        if(k<=0) throw new Exception("Dado nao pode ser negativo");
        long t = h*3600 + m*60 + s; //faz virar o total de segundos para deixar conta mais facil 
        t += k; // adiciona K 
        t = t % 86400; 
        /* 86400 é o número total de segundos em 1 dia, numero total atual ou hora atual (t) 
        tem que ser mod de 86400*/

        /*voce pega o resto pq se nao tiver passado um dia o resto vai ser 0, se tiver passado um dia ele vai dar o resto do que
        seria as horas consequentes desse dia seguinte pela divisao ser pelo numero de segundo totais de um dia */

        this.h = (byte) (h/3600);
        t=t%3600; // pega oque sobrou dps de tirar as horas para dividir entre minutos e segundos 
        this.m = (byte)(h/60);
        this.s = (byte)(h%60); // pega oq sobrou dps de tirar os minutos 
    }

    public void atrasar (byte k)throws Exception{
        if(k<=0) throw new Exception("Dado nao pode ser negativo");
        long t = this.h* 3600 + this.m *60 + this.s;
        t -= k;
        t %= 86400; // ve qual o horario e se precisa voltar um dia ou nao 
        if (t<0){
            t+= 86400; //caso precise voltar um dia eu zero, ou criando do zero, depende de como interpretar
        }

        this.h = (byte) (t/3600);
        t %= 3600;
        this.m = (byte)(t/60);
        this.s = (byte)(t%60);
    }

    public int diferencaPara (Horario hor)throws Exception{
        int meuT = this.h* 3600 + this.m *60 + this.s;
        int outroT = hor.h* 3600 + hor.m *60 + hor.s; 

        return meuT - outroT; 
    }

    public int somadoCom (Horario hor)throws Exception{
        int meuT = this.h* 3600 + this.m *60 + this.s;
        int outroT = hor.h* 3600 + hor.m *60 + hor.s; 

        return meuT + outroT;
    }

    @Override
    public String toString() {
        return (this.h<10? "0":"") + this.h + ":" + (this.m <10? "0":"") + this.m + (this.s <10? "0":"");
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false; 
        if(this.getClass()!=obj.getClass()) return false; 

        Horario newHora = (Horario) obj;
        
        return ((this.h == newHora.h) && (this.m == newHora.m) && (this.s == newHora.s));
    }

    @Override
    public int hashCode() {
        int ret = 1; 

        ret = ret * 13 + Byte.hashCode(h);
        ret = ret * 13 + Byte.hashCode(m);
        ret = ret * 13 + Byte.hashCode(s);

        if (ret<0) ret = -ret;
        return ret;
    }

    @Override
    public int compareTo(Horario o) {
        long totalThis = this.h * 3600 + this.m*60 + this.s;
        long totalO = o.h * 3600 + o.m*60 + o.s;
        return Long.compare(totalThis, totalO);
    }

    public Horario (Horario modelo) throws Exception{
        if(modelo == null) throw new Exception("Modelo vazio");

        this.h = modelo.h;
        this.m = modelo.h;
        this.s = modelo.s;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Horario retorno = null;

        try {
            retorno = new Horario(this);
        } catch (Exception e) 
        {}//this nunca é null, nao tem como dar erro 
        return retorno;
    }  
}