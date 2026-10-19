# CLAUDE.md — Java (PPOO · Prof. André Carvalho · PUC-Campinas)

Contexto: disciplina Paradigma e Programação Orientada a Objetos (Eng. Software). Todo código Java aqui deve seguir **o padrão ensinado pelo professor**. Na prova, método "fora do padrão ensinado" perde ponto (1,5 por método canônico errado, faltando ou desnecessário). Na dúvida, imite os arquivos de referência: `5) Pilha`, `7) Conjunto`, `9) classe abstrata Agenda`, `6) Arvore`.

## Regras gerais
- Java puro, sem frameworks, sem `java.util` (List, ArrayList, Objects, etc.): tudo com vetores. Exceções: `java.util.regex` e `java.lang.reflect` (Clonador).
- Erros **sempre** com `throw new Exception ("Mensagem")`, nunca com `return`, `print` ou `System.exit`. Só `Exception` genérica. Métodos que podem falhar declaram `throws Exception`.
- Mensagens curtas, **sem acento**, padrão "Coisa adjetivo": `"Modelo ausente"`, `"Capacidade invalida"`, `"Elemento repetido"`, `"Elemento inexistente"`, `"Nada a remover"`, `"Informacao ausente"`, `"Agenda cheia"`.
- Validar **no início** do método (null, faixa, vazio/cheio) e só depois executar.
- Atributos `private` (ou `protected` quando houver herança). Sempre usar `this.` explicitamente.
- Variável de exceção se chama `erro`: `catch (Exception erro)`.

## Estilo de código
- Chaves no estilo Allman (`{` em linha própria). Espaço antes do parêntese: `public void inclua (X x) throws Exception`.
- Nomes em português. Métodos que agem usam verbo no imperativo/subjuntivo: `inclua`, `remova`, `guardeUmItem`, `recupereUmItem`, `removaUmItem`, `registreContato`, `descarteContato`, `redimensioneSe`, `revele`, `adiante`, `retroceda`.
- Predicados: `isVazia`, `isCheia`, `isAindaComTracinhos`, `temOItem`. Getters/setters: `getQtdElementos`, `setNome`.
- Booleano direto: `return this.ultimo==-1;` (sem if/else retornando true/false).
- Laço infinito: `for (;;) // forever`.
- Pacotes em minúsculas (`conjunto`, `conjunto.ordenado`, `agenda.desordenada`). Construtor **nunca** tem `void`.

## Construtor e setters
O construtor delega aos setters, que validam:
```java
public Aluno (byte idade, String nome, Data nascimento) throws Exception
{
    this.setIdade      (idade);
    this.setNome       (nome);
    this.setNascimento (nascimento);
}
```
- Construtor padrão (sem parâmetros) com valor default (ex.: capacidade 10 ou 50), ou `this(15);`.
- **Cópia defensiva** de atributos que são objetos mutáveis: no setter `this.nascimento = (Data)na.clone();` e no getter `return (Data)this.nascimento.clone();`. Atribuir a referência direto é "sem noção em último grau".

## Métodos canônicos (o núcleo da nota)
Implementar **quando houver necessidade e aplicabilidade**: `toString`, `equals`, `hashCode`, construtor de cópia + `clone`, `compareTo`. Todos com `@Override` (menos o construtor de cópia).

**toString**: retorna String legível; não imprime nada.

**equals** (sempre esta sequência):
```java
@Override
public boolean equals (Object obj)
{
    if (obj==this) return true;
    if (obj==null) return false;
    if (obj.getClass()!=this.getClass()) return false;

    Fracao fra = (Fracao)obj;

    if (this.numerador  !=fra.numerador  ) return false;
    if (this.denominador!=fra.denominador) return false;
    // objetos: if (!this.nome.equals(fra.nome)) return false;
    // vetores: comparar elemento a elemento até qtd/ultimo
    return true;
}
```

**hashCode**:
```java
@Override
public int hashCode ()
{
    int ret=666; // qualquer positivo

    ret = ret*7 /*primo*/ + ((Integer)this.numerador  ).hashCode();
    ret = ret*7 /*primo*/ + ((Integer)this.denominador).hashCode();
    // double -> ((Double)this.x).hashCode(); byte -> ((Byte)this.x).hashCode()
    // objetos -> this.nome.hashCode(); vetores -> laço somando cada elemento

    if (ret<0) ret=-ret;
    return ret;
}
```

**Construtor de cópia + clone** (a classe faz `implements Cloneable`):
```java
public Fracao (Fracao modelo) throws Exception
{
    if (modelo==null) throw new Exception ("Modelo ausente");

    this.numerador   = modelo.numerador;
    this.denominador = modelo.denominador;
    // vetor: this.v = new Tipo [modelo.v.length]; copiar elemento a elemento
    // (nunca this.v = modelo.v, porque os dois passariam a compartilhar o vetor)
}

@Override
public Object clone ()
{
    Fracao ret=null;

    try
    {
        ret = new Fracao (this);
    }
    catch (Exception erro)
    {} // this nunca é null, não dá erro

    return ret;
}
```
`clone` é **public**, retorna **Object** e **não** declara `throws CloneNotSupportedException`. Em herança, cada subclasse tem seu próprio construtor de cópia (`super(modelo);`) e seu próprio `clone`.

**compareTo**: só se a classe tiver ordem natural (`implements Comparable<Classe>`). Retorna negativo, 0 ou positivo. Ex.: Horario compara o total de segundos; Fracao compara o valor real. Número complexo não tem ordem, então não tem compareTo.

## Estruturas de dados genéricas (Pilha, Conjunto, Árvore)
- Genérico `<X>` (ou `<X extends Comparable<X>>` quando ordena). Vetor: `this.elem = (X[])new Object [cap];`.
- Guardar e devolver **clones** quando o item for `Cloneable`, usando `Clonador<X>` (reflexão):
  `if (x instanceof Cloneable) this.elem[pos]=this.clonador.clone(x); else this.elem[pos]=x;`
- Redimensionamento: cheio, então `redimensioneSe(2*length)`; ao remover, se `length>capacidadeInicial && qtd<=length/4`, então `redimensioneSe(length/2)`. Ao remover, anular a posição liberada (`= null`).
- Busca `ondeEsta`: sequencial na versão desordenada, binária na ordenada. Retorna `Object[]{achou, posicao}` ou int codificado (`pos+1` se achou, `-(pos+1)` com o local de inserção se não achou).
- Inserção ordenada: desloca os elementos para a direita a partir do fim; remoção: desloca para a esquerda.
- Herança: classe-base (abstrata ou não) com atributos `protected`; a subclasse chama `super(...)` e sobrescreve só o que muda (`ondeEsta`, `toString`).
- Árvore: classe interna `private class No` com `esq/info/dir`; recursão com método `private` que recebe `No` mais um `public` de mesmo nome que chama com `this.raiz`.

## Programa de teste (Main)
Cada classe feita deve ser testada **completamente** (todos os métodos, inclusive os casos de erro):
```java
public static void main (String[] args)
{
    try
    {
        // testes
    }
    catch (Exception erro)
    {
        System.err.println (erro.getMessage());
    }
}
```
Entrada pelo teclado com a classe `Teclado` do professor (`Teclado.getUmInt()`, `getUmChar()`...).

## Erros que já aconteceram (não repetir)
- `return Objects.equals(this, obj);` ou `Objects.hash(this)` causam recursão infinita e fogem do padrão.
- `public void Horario (...)` com `void` deixa de ser construtor.
- Conversão de segundos: `minuto = (total%3600)/60` e `segundo = total%60` (não `total%3600`).
- No construtor de cópia, copiar cada campo do campo certo (`this.m = modelo.m`, não `modelo.h`).
- `clone` `protected` com `throws CloneNotSupportedException` está fora do padrão.
- Faltar `if (ret<0) ret=-ret;` no hashCode, ou faltar validação de `null` no parâmetro.

## Modo prova
Quando eu pedir para "agir como professor" ou simular prova: enunciado no formato do simulado (itens a, b, c... com pontuação, "erros devem ser sinalizados com o lançamento de exceções", 80 min). Na correção, apontar cada desvio deste padrão e descontar como o professor descontaria. Se o enunciado estiver ambíguo, perguntar antes de assumir.
