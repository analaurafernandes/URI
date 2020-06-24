/*-----------------------1068 - Balanço de Parenteses -------------------------
 * Autora: Ana Laura Fernandes de Oliveira
 * ----------------------------------------------------------------------------*/
import java.util.*;
import java.io.*;
public class URI1068
{
	public static boolean parenteses(String entrada)
	{
		//declarar variaveis
		int totalParenteses = 0;
		int tamanho = entrada.length();
		int i = 0;
		int j = 0;
		boolean resp = false;
		//se o total de parenteses ficar negativo, significa que algum parentese fechou antes de outro ter aberto, logo estaria errado
		while(i < tamanho && totalParenteses >= 0)
		{
			//para o balanco de parenteses estar correto, a medida que um abre o outro fecha, logo total = +1 - 1 = 0.
			if(entrada.charAt(i) == '(')
			{
				totalParenteses++;
			}
			else if(entrada.charAt(i) == ')')
			{
				totalParenteses--;
			}
			i++;
		}
		//se o total final for diferente de zero significa que a expressao algebrica nao esta balanceada em termos de parenteses
		if(totalParenteses == 0)
		{
			resp = true;
		}
		return resp;
	}

	public static void main(String[] args) throws Exception
	{
		//declarar variaveis
		String entrada = "";
		boolean resp;
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		//ler entrada
		entrada = leitor.readLine();
		while(entrada != null)
		{
			resp = parenteses(entrada);
			if(resp == true)
			{
				System.out.println("correct");
			}
			else
			{
				System.out.println("incorrect");
			}
			entrada = leitor.readLine();			
		}
	}
}
