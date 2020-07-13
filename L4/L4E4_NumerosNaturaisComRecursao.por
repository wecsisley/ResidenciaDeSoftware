programa
{
	
	funcao inicio()
	{
		escreveNvezes(0, 50)
	}
	funcao escreveNvezes(inteiro numeros, inteiro quantidade){

		enquanto(quantidade >= 1){
			escreva(numeros++ + "   ")
			numeros = numeros
			quantidade = quantidade -1
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 238; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */