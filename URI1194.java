/*-----------------URI 1194---------------
 * Autora: Ana Laura Fernandes de Oliveira
 * -------------------------------------*/
import java.io.*;
import java.util.*;

class No
{
	//atributos
	protected No esq;
	protected No dir;
	protected char elemento;

	//construtor
	public No(char x)
	{
		this.elemento = x;
		this.esq = this.dir = null;
	}
	public No()
	{
		this(' ');
	}
}
class Arvore extends No
{
	//atributo
	private No raiz;
	
	//construtor
	public Arvore()
	{
		this.raiz = null;
	}
	//metodo para saber se letra esta antes ou depois da raiz
	public boolean antes(String prefixa, char letra, No pai)
	{	
		boolean resp = true;
		
		//ver se letra aparece antes do pai na string prefixa
		for(int i = 0; i < prefixa.length(); i++)
		{
			if(prefixa.charAt(i) == pai.elemento)
			{
				resp = false;
			}
			else if(prefixa.charAt(i) == letra)
			{
				i = prefixa.length();
			}
		}
		return resp;
	}
	//inserir na arvore
	public void inserir(String infixa, String prefixa, int j)
	{
		//enquanto todas as letras da string infixa nao tiverem sido inseridas na arvore, continuar a insercao
		if(j < infixa.length())
		{
			raiz = inserir(infixa, prefixa, raiz, j);
			inserir(infixa, prefixa, ++j);
		}
	}
	public No inserir(String infixa, String prefixa, No i, int j)
	{
		if(j < infixa.length())
		{
			if(i == null)
			{
				i = new No(infixa.charAt(j));
			}
			//se a letra a ser inserida vier antes que a letra do no pai dela na prefixa, inserir no no a esq do pai
			else if(antes(prefixa, infixa.charAt(j), i))
			{
				i.esq = inserir(infixa, prefixa, i.esq, j);
			}
			//se a letra a ser inserida vier depois que a letra do no pai dela na prefixa, inserir no no a dir do pai
			else
			{
				i.dir = inserir(infixa, prefixa, i.dir, j);
			}
		}
		return i;
	}
	//metodo mostrar posfixo
	public void mostrar()
	{
		mostrar(raiz);
		System.out.println("");
	}
	public void mostrar(No i)
	{
		if(i != null)
		{
			mostrar(i.esq);
			mostrar(i.dir);
			System.out.printf("%c", i.elemento);
		}
	}
}
public class URI1194
{
	public static void main(String[] args) throws Exception
	{
		//declarar variaveis e receber entradas
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(leitor.readLine());
		String infixa;
		String prefixa;
		String posfixa;
		String entrada;
		for(int i = 0; i < casos; i++)
		{
			entrada = leitor.readLine();
			String []aux = entrada.split(" ");
			infixa = aux[1];
			prefixa = aux[2];
			Arvore arv = new Arvore();
			arv.inserir(infixa, prefixa, 0);
			arv.mostrar();
		}
	}
}
