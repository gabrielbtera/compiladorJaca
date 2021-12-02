package jaca;

import java.util.ArrayList;
import java.util.List;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import java.util.*;

import jaca.analysis.*;
import jaca.node.*;


public class Semantico extends DepthFirstAdapter {

	LinkedHashMap<Integer, LinkedList<LinkedHashMap<Integer, Simbolo>>> class_hash = new LinkedHashMap<Integer, LinkedList<LinkedHashMap<Integer, Simbolo>>>();
	LinkedHashMap<Integer, ArrayList<String>> familia = new LinkedHashMap<Integer, ArrayList<String>>();
	LinkedList<LinkedHashMap<Integer, Simbolo>> table;
	LinkedList<LinkedHashMap<Integer, Simbolo>> temp_table = null;

	public int hash(String key)
	{
		int temp = 0;
		for (char c : key.toCharArray())
		{
			temp = (temp * 16 + c) % 211;
		}
		return temp;
	}

	public boolean check_id_call_exp(PExp node, String func_arg)
	{
		LinkedHashMap<Integer, Simbolo> tabela;
		AAIdCallExp id_call = (AAIdCallExp) node;
		String nome = id_call.getDir().toString();
		int pos = hash(nome);
		if (id_call.getEsq() != null)
		{
			Iterator<LinkedHashMap<Integer, Simbolo>> it = table.descendingIterator();
			String nome_id = id_call.getEsq().toString();
			int pos_id = hash(nome_id);
			Simbolo simbolo = null;
			while (it.hasNext())
			{
				tabela = (LinkedHashMap<Integer, Simbolo>) it.next();
				if (tabela.containsKey(pos_id))
				{
					simbolo = tabela.get(pos_id);
					break;
				}
			}
			if (simbolo != null)
			{
				String nome_classe = simbolo.getTipo();
				int pos_classe = hash(nome_classe);
				if (class_hash.containsKey(pos_classe))
				{
					tabela = class_hash.get(pos_classe).getFirst();
				}
				else
				{
					System.out.println(nome_classe + "não é uma classe");
					return false;
				}
			}
			else
			{
				System.out.println(nome_id + "não foi declarado");
				return false;
			}
		}
		else
		{
			tabela = table.getFirst();
		}
		if (tabela.containsKey(pos))
		{
			if (tabela.get(pos).getValor().equals(func_arg))
			{
				return true;
			}
			else if (tabela.get(pos).getValor().equals("R") && (func_arg.equals("int ") || func_arg.equals("bool ") || func_arg.equals("real ")))
			{
				return true;
			}
		}
		return false;
	}

	public boolean check_id_exp(PExp node, String func_arg)
	{
		AAIdExp arg = (AAIdExp) node;
		String nome_arg = arg.toString();
		int pos_arg = hash(nome_arg);
		LinkedHashMap<Integer, Simbolo> tabela;
		Iterator<LinkedHashMap<Integer, Simbolo>> it = table.descendingIterator();
		while (it.hasNext())
		{
			tabela = (LinkedHashMap<Integer, Simbolo>) it.next();
			if (tabela.containsKey(pos_arg))
			{
				if (tabela.get(pos_arg).getTipo().equals(func_arg))
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void inStart(Start node)
	{
		System.out.println("-------------------------------------------------");
		System.out.println("Iniciando análise semântica...");
		System.out.println("-------------------------------------------------");
	}

	@Override
	public void outStart(Start node)
	{
	    System.out.println("-------------------------------------------------");
	    System.out.println("Fim da análise semântica");
	    System.out.println("-------------------------------------------------");
	}

	@Override
	public void inAAProgramaPrograma(AAProgramaPrograma node)
	{
		//Adicionar a classe _IO e os seus métodos no início do programa
		String nome = "_IO ";
		int pos = hash(nome);
		class_hash.put(pos, new LinkedList<LinkedHashMap<Integer, Simbolo>>());
		table = (LinkedList<LinkedHashMap<Integer, Simbolo>>) class_hash.get(pos);
		table.add(new LinkedHashMap<Integer, Simbolo>());
		pos = hash("print ");
		Simbolo sym_print = new Simbolo("func", "print ", "P", new ArrayList<String>());
		sym_print.addParametro("Dummy");
		table.getLast().put(pos, sym_print);
		pos = hash("read ");
		table.getLast().put(pos, new Simbolo("func", "read ", "R", new ArrayList<String>()));
		System.out.println("Classe _IO importada");
	}

	@Override
	public void outAARelacaoRelacao(AARelacaoRelacao node)
	{
		String filha = node.getEsq().toString();
		String pai = node.getDir().toString();
		int pos = hash(filha);
		if (familia.containsKey(pos))
		{
			familia.get(pos).add(pai);
		}
		else
		{
			familia.put(pos, new ArrayList<String>());
			familia.get(pos).add(pai);
		}
	}

	@Override
	public void inAADefClasseDefClasse(AADefClasseDefClasse node)
	{
		String nome = node.getNome().toString();
		int pos = hash(nome);
		class_hash.put(pos, new LinkedList<LinkedHashMap<Integer, Simbolo>>());
		System.out.println("Nova classe");
		System.out.println("Abriu um novo escopo");
		table = (LinkedList<LinkedHashMap<Integer, Simbolo>>) class_hash.get(pos);
		table.add(new LinkedHashMap<Integer, Simbolo>());
		if (familia.containsKey(pos))
		{
			ArrayList<String> pais = familia.get(pos);
			for (String pai : pais)
			{
				pos = hash(pai);
				if (class_hash.containsKey(pos))
				{
					LinkedHashMap<Integer, Simbolo> tabela = class_hash.get(pos).getFirst();
					for (Integer key : tabela.keySet())
					{
						Simbolo atual = tabela.get(key);
						nome = atual.getNome();
						pos = hash(nome);
						table.getFirst().put(pos, atual);
					}
				}
				else
				{
					System.out.println("O pai " + pai + "de " + nome + "não foi declarado");
				}
			}
		}
	}

}
