/*-------URI 1256 - Tabelas Hash--------
 * Autora: Ana Laura Fernandes
 * -------------------------------------*/
import java.util.*;
import java.io.*;
class Celula
{
	//atributos
	protected Celula prox;
	protected int elemento;

	//construtor
	public Celula()
	{
		this(0);
	}
	public Celula(int x)
	{
		this.elemento = x;
		this.prox = null;
	}
}
class Lista extends Celula
{
	//atributos
	protected Celula primeiro, ultimo;
	
	//construtor
	public Lista()
	{
		this.primeiro = new Celula();
		this.ultimo = this.primeiro;
	}
}
class Hash extends Lista
{
	//atributos
	private Lista[] tabela;
	private int tamanho;

	//construtor
	public Hash(int tamanho)
	{
		this.tabela = new Lista[tamanho];
		for(int i = 0; i < tamanho; i++)
		{
			tabela[i] = new Lista();
		}
		this.tamanho = tamanho;
	}
	public int hash(int x)
	{
		return x%tamanho;
	}
	public void inserir(int x)
	{
		int pos = hash(x);
		tabela[pos].ultimo.prox = new Celula(x);
		tabela[pos].ultimo = tabela[pos].ultimo.prox;
	}
	public void mostrar()
	{
		for(int i = 0; i < tamanho; i++)
		{
			System.out.printf("%d -> ", i);
			for(Celula j = tabela[i].primeiro.prox; j != null; j = j.prox)
			{
				System.out.printf("%d -> ", j.elemento);
			}
			System.out.println("\\");
		}
	}
}
public class URI1256
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(leitor.readLine());
		int i = 0;
		while(i < casos)
		{
			String []entrada = leitor.readLine().split(" ");
			int tamanho = Integer.parseInt(entrada[0]);
			int chaves = Integer.parseInt(entrada[1]);
			Hash tabela = new Hash(tamanho);
			entrada = leitor.readLine().split(" ");
			for(int j = 0; j < chaves; j++)
			{
				tabela.inserir(Integer.parseInt(entrada[j]));
			}
			tabela.mostrar();
			i++;
			if(i < casos)
			{
				System.out.println("");
			}
		}
	}
}
	
