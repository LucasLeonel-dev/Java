
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TesteCasePilha01 { 

	@Test
	void test01() { 
		//teste basico de pilha. 
		// Construir Pilha (tam>0 V1.2), push (valor inteiro V2.1) 
		// seguido de pop (S1.1)
		
		//arrange - prepara��o do teste
		Pilha p = new Pilha(5); //constroi pilha (V1.2)

		//action - duas chamadas  aos m�todos da pilha
		//assert - j� faz a primeira asser�ao
		assertTrue(p.push(10)); //aqui 1a chamada (V2.1) e 1a asser��o (S2.1)
		RetornoPilha ret = p.pop(); 
		
		//segundo assert (verifica��o valor esperado vs. valor real)
		assertEquals(10, ret.valor); //S1.1 - campo valor do topo da pilha
		assertEquals(true, ret.vazia); //S1.1 - vampo vazio = true			
	}

	@Test
	void test02() { 
		//testa push em pilha cheia (estouro de overflow da pilha)
		
		//prepara��o do teste
		Pilha p = new Pilha(2); //pilha tamanho 2 (V1.2)
		
		//chamada do m�todos e asser��o
		//enche a pilha e tenta fazer mais um push()
		assertEquals(true, p.push(10)); //aqui 1a chamada (V2.1) e 1a asser��o (S2.1), j� testados no test01
		assertTrue(p.push(20)); //aqui 2a chamada (V2.1) e 2a asser��o (S2.1), j� testados no test01
		assertFalse(p.push(30)); //aqui 3a chamada (V2.1) e 3a asser��o (S2.2) 
	}

	@Test 
	void test03(){ 
		Pilha p = new Pilha(); //caso teste de valor default, V1.1
		assertTrue(p.push(3)); // V1.1 - L2.1 (true)
		RetornoPilha ret = p.pop(); 
		
		assertTrue(p.isEmpty());
		assertTrue(ret.vazia); // S1.1 (true)

		ret = p.pop();
		assertTrue(ret.vazia); //S1.3 retorno de lista ja vazia

		assertTrue(p.push(1)); // L2.1 - S2.1,limite de valores do tamanho da pilha default 
		assertTrue(p.push(2));
		assertTrue(p.push(3));
		assertTrue(p.push(4));
		assertTrue(p.push(5));
		assertTrue(p.push(6));
		assertTrue(p.push(7));
		assertTrue(p.push(8));
		assertTrue(p.push(9));
		assertTrue(p.push(10));

		assertFalse(p.push(11)); // L2.2 - S2.2, além do limite de valores no caso default
	}

	@Test 
	void test04(){
		Pilha p =new Pilha(3);

		assertTrue(p.push(10)); //V2.1, L2.1 aceota numeros positivos
		assertTrue(p.push(-22)); //V2.1, L2.2, aceita numeros negativos 
	}
	/*
	@Test 
	void test05(){ // teste de caso de invalidez, I2.3
		Pilha p = new Pilha();
		
		assertFalse(p.push('a')); // V2.1, I2.1 - I2.2 nao aceita valores float, somente double , nem null, I2.3 porem aceita valores char
	}
	*/

	@Test 
	void test06(){
		Pilha p = new Pilha(0);

		assertFalse(p.push(1)); //V1.1, caso de teste para valor 0 no tamanho do pilha
	}
}