package jaca;

import java.util.ArrayList;
import java.util.List;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import java.util.Iterator;

import jaca.analysis.*;
import jaca.node.*;

public class Semantico extends DepthFirstAdapter {

	LinkedHashMap<Integer, LinkedList<LinkedHashMap<Integer, Simbolo>>> class_hash = new LinkedHashMap<Integer, LinkedList<LinkedHashMap<Integer, Simbolo>>>();
	LinkedHashMap<Integer, ArrayList<String>> familia = new LinkedHashMap<Integer, ArrayList<String>>();
	LinkedList<LinkedHashMap<Integer, Simbolo>> table;
	LinkedList<LinkedHashMap<Integer, Simbolo>> temp_table = null;
	private Boolean toPrintTable = true;
	
	public void setPrint() {
		this.toPrintTable = !this.toPrintTable;
	}
	
	private void printSymbolTable() {
		
		if (this.toPrintTable) {
			
			System.out.print('\n');
			
			String identation = "  ";
			int counter = table.size();
			Integer scope_number = 0;
			
			for (LinkedHashMap<Integer, Simbolo> scope : this.table) {
				System.out.println('\n' + identation + "\t\t" + "ABRIU UM NOVO ESCOPO " + scope_number.toString());
				
				counter--;
				for (Map.Entry<Integer, Simbolo> symbol : scope.entrySet()) {
					
					System.out.println(identation
							+ "________________________________________\n");

					System.out.println('\t' + identation + symbol.getValue().getTipo()
							+ " | " + symbol.getValue().getNome()
							+ " | " + symbol.getValue().getValor());
					
				
				}
				
				if(counter > 0) {
					
					identation = identation + "\t";
					
					System.out.println("\n" + identation + "\t\t | ");
					System.out.println(identation + "\t\t | ");
					System.out.println(identation + "\t\t\\ /");
					
				}
				
				scope_number++;
				
			}
			
			System.out.print('\n');
			
		}
	}
	
	public int hash(String key)
	{
		int temp = 0;
		for (char c : key.toCharArray())
		{
			temp = (temp * 16 + c) % 211;
		}
		return temp;
	}

	public boolean check_id_call_exp(PExp node, String func_arg) {
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
				
				if (class_hash.containsKey(pos_classe)) {
					tabela = class_hash.get(pos_classe).getFirst();
				} else {
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
			else if (tabela.get(pos).getValor().equals("R") && (func_arg.equals("bool ") || func_arg.equals("real ")))
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
		//Adicionar a classe _ES e os seus métodos no início do programa
		String nome = "_ES ";
		int pos = hash(nome);
		
		class_hash.put(pos, new LinkedList<LinkedHashMap<Integer, Simbolo>>());
		
		table = (LinkedList<LinkedHashMap<Integer, Simbolo>>) class_hash.get(pos);
		table.add(new LinkedHashMap<Integer, Simbolo>());
		
		pos = hash("imprime ");
		Simbolo sym_print = new Simbolo("func", "imprime ", "P", new ArrayList<String>());
		sym_print.addParametro("Dummy");
		table.getLast().put(pos, sym_print);
		
		this.printSymbolTable();
		
		pos = hash("lê ");
		table.getLast().put(pos, new Simbolo("func", "lê ", "R", new ArrayList<String>()));
		
		this.printSymbolTable();
		
		System.out.println("Classe " + nome +  " importada");
		
	}

	@Override
	public void outAARelacaoRelacao(AARelacaoRelacao node)
	{
		String filha = node.getEsq().toString();
		String pai = node.getDir().toString();
		int pos = hash(filha);
		
		if (familia.containsKey(pos)) {
			familia.get(pos).add(pai);
		} else {
			
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
						
						this.printSymbolTable();
						
					}
				}
				else
				{
					System.out.println("O pai " + pai + "de " + nome + "não foi declarado");
				}
			}
		}
	}

	@Override
	public void outAAIdExp(AAIdExp node)
	{
		Iterator<LinkedHashMap<Integer, Simbolo>> it = table.descendingIterator();
		int pos = hash(node.toString());
		while (it.hasNext())
		{
			LinkedHashMap<Integer, Simbolo> tabela = (LinkedHashMap<Integer, Simbolo>) it.next();
			if (tabela.containsKey(pos))
			{
				Simbolo simbolo = tabela.get(pos);
				switch (simbolo.getTipo()) {
					case "bool ":
						node.replaceBy(new AABooleanoExp());
						break;
					case "real ":
						node.replaceBy(new AANumeroExp());
						break;
					default:
						break;
				}
				return;
			}
		}
		System.out.println(node.toString() + "não encontrado");
	}

	@Override
	public void caseAACallComando(AACallComando node)
	{
		boolean flag = true;
		inAACallComando(node);
		if (node.getEsq() != null)
		{
			flag = false;
			Iterator<LinkedHashMap<Integer, Simbolo>> it = table.descendingIterator();
			String nome = node.getEsq().toString();
			int pos = hash(nome);
			Simbolo simbolo = null;
			while (it.hasNext())
			{
				LinkedHashMap<Integer, Simbolo> tabela = (LinkedHashMap<Integer, Simbolo>) it.next();
				if (tabela.containsKey(pos))
				{
					simbolo = tabela.get(pos);
					break;
				}
			}
			if (simbolo != null)
			{
				nome = simbolo.getTipo();
				pos = hash(nome);
				temp_table = class_hash.get(pos);
				flag = true;
			}
			else
			{
				System.out.println(nome + "não é uma classe");
			}
		}
		if (node.getDir() != null && flag)
		{
			node.getDir().apply(this);
		}
		outAACallComando(node);
	}

	@Override
	public void caseAAIdCallExp(AAIdCallExp node)
	{
		inAAIdCallExp(node);
		if (node.getEsq() != null)
		{
			Iterator<LinkedHashMap<Integer, Simbolo>> it = table.descendingIterator();
			String nome = node.getEsq().toString();
			int pos = hash(nome);
			Simbolo simbolo = null;
			while (it.hasNext())
			{
				LinkedHashMap<Integer, Simbolo> tabela = (LinkedHashMap<Integer, Simbolo>) it.next();
				if (tabela.containsKey(pos))
				{
					simbolo = tabela.get(pos);
					break;
				}
			}
			if (simbolo != null)
			{
				nome = simbolo.getTipo();
				pos = hash(nome);
				temp_table = class_hash.get(pos);
			}
			else
			{
				System.out.println(nome + "não é uma classe");
			}
		}
		else
		{
			temp_table = null;
		}
		if (node.getDir() != null)
		{
			node.getDir().apply(this);
		}
		outAAIdCallExp(node);
	}

	@Override
	public void outAAIdCallExp(AAIdCallExp node)
	{
		if (node.getDir() instanceof AANumeroExp)
		{
			node.replaceBy(new AANumeroExp());
		}
		else if (node.getDir() instanceof AABooleanoExp)
		{
			node.replaceBy(new AABooleanoExp());
		}
	}

	@Override
	public void outAAChamadaExp(AAChamadaExp node)
	{
		LinkedHashMap<Integer, Simbolo> tabela;
		if (temp_table != null)
		{
			tabela = temp_table.getFirst();
			temp_table = null;
		}
		else
		{
			tabela = table.getFirst();
		}
		String nome = node.getEsq().toString();
		int pos = hash(nome);
		if (tabela.containsKey(pos))
		{
			Simbolo func = tabela.get(pos);
			List<PExp> copy = new ArrayList<PExp>(node.getDir());
			int len_copy = copy.size();
			String valor;
			if (func.getTipo().equals("func"))
			{
				valor = func.getValor();
			}
			else
			{
				valor = func.getTipo();
			}
			if (valor.equals("P"))
			{
				if (len_copy != 1)
				{
					System.out.println(nome + "recebe apenas 1 parâmetro");
				}
				else if (len_copy == 1 && !(copy.get(0) instanceof AABooleanoExp || copy.get(0) instanceof AANumeroExp))
				{
					System.out.println(nome + "deve receber um inteiro, um número real ou um booleano");
				}
				return;
			}
			else if (valor.equals("R"))
			{
				if (len_copy != 0)
				{
					System.out.println(nome + "recebe nenhum parâmetro");
				}
				return;
			}
			int len_par = func.numParametros();
			if (len_copy != len_par)
			{
				System.out.println(nome + "tem " + len_par + " paramêtros, mas está recebendo " + len_copy + " parâmetros");
			}
			for (int i = 0; i < len_copy; i++)
			{
				if (func.getParametro(i).equals("bool") &&
					copy.get(i) instanceof AABooleanoExp)
				{
					continue;
				}
				else if (func.getParametro(i).equals("real") &&
					copy.get(i) instanceof AANumeroExp)
				{
					continue;
				}
				else if (copy.get(i) instanceof AAIdCallExp)
				{
					if (check_id_call_exp(copy.get(i), func.getParametro(i) + " "))
					{
						continue;
					}
				}
				else if (copy.get(i) instanceof AAIdExp)
				{
					if (check_id_exp(copy.get(i), func.getParametro(i) + " "))
					{
						continue;
					}
				}
				else
				{
					System.out.println("Erro em id_call");
				}
				System.out.println((i + 1) + "-ésimo parâmetro de tipo inválido");
				return;
			}
			if (func.getTipo().equals("func"))
			{
				if (func.getValor().equals("real "))
				{
					node.replaceBy(new AANumeroExp());
				}
				else if (func.getValor().equals("bool "))
				{
					node.replaceBy(new AABooleanoExp());
				}
			}
		}
		else
		{
			System.out.println("Função " + nome + "não encontrada");
		}
	}

	@Override
	public void caseAAChamadaExp(AAChamadaExp node)
	{
		inAAChamadaExp(node);
		LinkedList<LinkedHashMap<Integer, Simbolo>> temp = null;
        List<PExp> copy = new ArrayList<PExp>(node.getDir());
		if (copy.size() > 0)
		{
			temp = temp_table;
			temp_table = null;
		}
        for(PExp e : copy)
        {
			e.apply(this);
		}
		if (temp != null)
		{
			temp_table = temp;
		}
		outAAChamadaExp(node);
	}

	@Override
	public void caseAAIdAtribExp(AAIdAtribExp node)
	{
		inAAIdAtribExp(node);
		outAAIdAtribExp(node);
	}

	@Override
	public void outAAIdAtribExp(AAIdAtribExp node)
	{
		String nome = ((AAIdExp) node.getEsq()).toString();
		Iterator<LinkedHashMap<Integer, Simbolo>> it = table.descendingIterator();
		int pos = hash(nome);
		while (it.hasNext())
		{
			LinkedHashMap<Integer, Simbolo> tabela = (LinkedHashMap<Integer, Simbolo>) it.next();
			if (tabela.containsKey(pos))
			{
				String tipo = tabela.get(pos).getTipo();
				pos = hash(tipo);
				if (class_hash.containsKey(pos))
				{
					LinkedHashMap<Integer, Simbolo> temp_table = class_hash.get(pos).getLast();
					pos = hash(node.getDir().toString());
					if (temp_table.containsKey(pos))
					{
						Simbolo simbolo = temp_table.get(pos);
						switch (simbolo.getTipo()) {
							case "bool ":
								node.replaceBy(new AABooleanoExp());
								break;
							case "real ":
								node.replaceBy(new AANumeroExp());
								break;
							default:
								break;
						}
					}
					return;
				}
				else
				{
					System.out.println("Classe não encontrada");
				}
			}
		}
		System.out.println("Não declarado");
	}

	@Override
	public void caseAAPinicializacaoPinicializacao(AAPinicializacaoPinicializacao node)
	{
		inAAPinicializacaoPinicializacao(node);
        outAAPinicializacaoPinicializacao(node);
	}

	@Override
	public void caseAADecConsDec(AADecConsDec node)
	{
		inAADecConsDec(node);
		outAADecConsDec(node);
		
		this.printSymbolTable();
	}

	@Override
	public void outAADecConsDec(AADecConsDec node)
	{
		String tipo = node.getEsq().toString();
		List<PPinicializacao> copy = new ArrayList<PPinicializacao>(node.getDir());
		
		for (int i = 0; i < copy.size(); i++) {
			String[] nome_val = copy.get(i).toString().split("\\s+");
			int pos = hash(nome_val[0] + " ");
			Simbolo novo = new Simbolo(tipo, nome_val[0] + " ", nome_val[1] + " ");
			novo.setCons(true);
			table.getLast().put(pos, novo);
			
			this.printSymbolTable();
        }
	}

	@Override
	public void caseAADecVarDec(AADecVarDec node)
	{
		inAADecVarDec(node);
		outAADecVarDec(node);	
	}

	@Override
	public void outAADecVarDec(AADecVarDec node)
	{
		String tipo = node.getEsq().toString();
		List<PExp> copy = new ArrayList<PExp>(node.getDir());
		for (int i = 0; i < copy.size(); i++)
        {
			String[] nome_val = copy.get(i).toString().split("\\s+");
			int pos = hash(nome_val[0] + " ");
			table.getLast().put(pos, new Simbolo(tipo, nome_val[0] + " "));
			
			this.printSymbolTable();
        }
	}

	@Override
	public void caseAADecObjDec(AADecObjDec node)
	{
		inAADecObjDec(node);
		outAADecObjDec(node);
	}

	@Override
	public void outAADecObjDec(AADecObjDec node)
	{
		String tipo = node.getEsq().toString();
		int pos = hash(tipo);
		if (class_hash.containsKey(pos))
		{
			List<PExp> copy = new ArrayList<PExp>(node.getDir());
			for (int i = 0; i < copy.size(); i++)
			{
				String[] nome_val = copy.get(i).toString().split("\\s+");
				pos = hash(nome_val[0] + " ");
				table.getLast().put(pos, new Simbolo(tipo, nome_val[0] + " "));
				
				this.printSymbolTable();
			}
		}
		else
		{
			System.out.println("A classe " + tipo + "não existe");
		}
	}

	@Override
	public void inAADecFuncaoComDec2(AADecFuncaoComDec2 node) {
		String nome = node.getEsqn().toString();
		String valor = node.getEsq().toString();
		int pos = hash(nome);
		
		System.out.println("Abriu uma nova função");
		
		table.getLast().put(pos, new Simbolo("func", nome, valor, new ArrayList<String>()));
		this.printSymbolTable();
		
		Simbolo func = table.getLast().get(pos);
		table.add(new LinkedHashMap<Integer, Simbolo>());
		List<PParametro> copy = new ArrayList<PParametro>(node.getMid());
		
		for (int i = 0; i < copy.size(); i++) {
			
			String[] nome_val = copy.get(i).toString().split("\\s+");
			pos = hash(nome_val[1] + " ");
			
			table.getLast().put(pos, new Simbolo(nome_val[0] + " ", nome_val[1] + " "));
			
			this.printSymbolTable();
	
			func.addParametro(nome_val[0]);
        
		}
	}

	@Override
	public void outAADecFuncaoComDec2(AADecFuncaoComDec2 node) {
		table.removeLast();
	
	}

	@Override
	public void caseAADecFuncaoComDec2(AADecFuncaoComDec2 node)
	{
		inAADecFuncaoComDec2(node);
		
		if (node.getDir() != null)
		{
			node.getDir().apply(this);
		}
		
		outAADecFuncaoComDec2(node);
		
	}

	@Override
	public void inAADecProcedimentoComDec2(AADecProcedimentoComDec2 node)
	{
		String nome = node.getEsq().toString();
		int pos = hash(nome);
		table.getLast().put(pos, new Simbolo("procedimento", nome, new ArrayList<String>()));
		
		this.printSymbolTable();
		
		Simbolo proc = table.getLast().get(pos);
		System.out.println("Abriu um novo procedimento");
		table.add(new LinkedHashMap<Integer, Simbolo>());
		List<PParametro> copy = new ArrayList<PParametro>(node.getMid());
		for (int i = 0; i < copy.size(); i++)
        {
			String[] nome_val = copy.get(i).toString().split("\\s+");
			pos = hash(nome_val[1] + " ");
			table.getLast().put(pos, new Simbolo(nome_val[0] + " ", nome_val[1] + " "));
			
			this.printSymbolTable();
			
			proc.addParametro(nome_val[0]);
		}
	}

	@Override
	public void outAADecProcedimentoComDec2(AADecProcedimentoComDec2 node)
	{
		table.removeLast();
	}

	@Override
	public void caseAADecProcedimentoComDec2(AADecProcedimentoComDec2 node)
	{
		inAADecProcedimentoComDec2(node);
		
		if (node.getDir() != null)
		{
			node.getDir().apply(this);
		}
		
		outAADecProcedimentoComDec2(node);
		
	}

	@Override
	public void inAABlocoComando(AABlocoComando node)
	{
		String nome = node.getEsq().toString();
		int pos = hash(nome);
		table.getLast().put(pos, new Simbolo("bloco", nome));
		
		this.printSymbolTable();
		System.out.println("Abriu um novo bloco");
		
		table.add(new LinkedHashMap<Integer, Simbolo>());
	}

	@Override
	public void outAABlocoComando(AABlocoComando node)
	{
		table.removeLast();
		this.printSymbolTable();
	}

	@Override
	public void inAABlocoExpExp(AABlocoExpExp node)
	{
		String nome = node.getEsq().toString();
		int pos = hash(nome);
		table.getLast().put(pos, new Simbolo("bloco_exp", nome));
		
		this.printSymbolTable();
		
		System.out.println("Abriu um novo bloco de exp");
		table.add(new LinkedHashMap<Integer, Simbolo>());
	}

	@Override
	public void outAABlocoExpExp(AABlocoExpExp node)
	{
		table.removeLast();
	}

	@Override
	public void caseAAAtribComando(AAAtribComando node)
	{
		inAAAtribComando(node);
		if (node.getEsq() != null)
		{
			String nome = node.getEsq().toString();
			String tipo = null;
			int pos = hash(nome);
			Iterator<LinkedHashMap<Integer, Simbolo>> it = table.descendingIterator();
			while (it.hasNext())
			{
				LinkedHashMap<Integer, Simbolo> tabela = (LinkedHashMap<Integer, Simbolo>) it.next();
				if (tabela.containsKey(pos))
				{
					Simbolo decla = tabela.get(pos);
					if (decla.getCons())
					{
						System.out.println("Não é possível modificar o valor de uma constante");
						return;
					}
					tipo = decla.getTipo();
					break;
				}
			}
			if (tipo == null)
			{
				System.out.println(nome + "não está declarado");
			}
			else
			{
				if (node.getDir() != null)
				{
					node.getDir().apply(this);
					if (node.getDir() instanceof AAIdCallExp)
					{
						if (!(check_id_call_exp(node.getDir(), tipo)))
						{
							System.out.println("Erro de atribuição no lado direito");
							System.out.println(((AAIdCallExp) node.getDir()).toString() + tipo);
						}
					}
					else if (node.getDir() instanceof AAIdExp)
					{
						if (!(check_id_exp(node.getDir(), tipo)))
						{
							System.out.println("Erro de atribuição no lado direito");
							System.out.println(((AAIdExp) node.getDir()).toString() + tipo);
						}
					}
					else if (tipo.equals("real ") && !(node.getDir() instanceof AANumeroExp))
					{
						System.out.println("O lado direito da operação não é um número");
					}
					else if (tipo.equals("bool ") && !(node.getDir() instanceof AABooleanoExp))
					{
						System.out.println("O lado esquerdo da operação não é um booleano");
					}
				}
			}
		}
		outAAAtribComando(node);
	}

	@Override
	public void outAASomaExp(AASomaExp node)
	{
		if (node.getEsq() instanceof AANumeroExp &&
			node.getDir() instanceof AANumeroExp)
		{
			node.replaceBy(new AANumeroExp());
		}
		else
		{
			System.out.println("Erro semântico de soma em " + node.toString());
		}
	}

	@Override
	public void outAASubtExp(AASubtExp node)
	{
		if (node.getEsq() instanceof AANumeroExp &&
			node.getDir() instanceof AANumeroExp)
		{
			node.replaceBy(new AANumeroExp());
		}
		else
		{
			System.out.println("Erro semântico de subtração em " + node.toString());
		}
	}

	@Override
	public void outAAMultiExp(AAMultiExp node)
	{
		if (node.getEsq() instanceof AANumeroExp &&
			node.getDir() instanceof AANumeroExp)
		{
			node.replaceBy(new AANumeroExp());
		}
		else
		{
			System.out.println("Erro semântico de multiplicação em " + node.toString());
		}
	}

	@Override
	public void outAADivExp(AADivExp node)
	{
		if (node.getEsq() instanceof AANumeroExp &&
			node.getDir() instanceof AANumeroExp)
		{
			node.replaceBy(new AANumeroExp());
		}
		else
		{
			System.out.println("Erro semântico de divisão em " + node.toString());
		}
	}

	@Override
	public void outAAModExp(AAModExp node)
	{
		if (node.getEsq() instanceof AANumeroExp &&
			node.getDir() instanceof AANumeroExp)
		{
			node.replaceBy(new AANumeroExp());
		}
		else
		{
			System.out.println("Erro semântico de módulo em " + node.toString());
		}
	}

	@Override
	public void outAAIgualExp(AAIgualExp node)
	{
		if ((node.getEsq() instanceof AANumeroExp &&
			node.getDir() instanceof AANumeroExp) ||
			(node.getEsq() instanceof AABooleanoExp &&
			node.getDir() instanceof AABooleanoExp))
		{
			node.replaceBy(new AABooleanoExp());
		}
		else
		{
			System.out.println("Erro semântico de igualdade em " + node.toString());
		}
	}

	@Override
	public void outAAMenorExp(AAMenorExp node)
	{
		if (node.getEsq() instanceof AANumeroExp &&
			node.getDir() instanceof AANumeroExp)
		{
			node.replaceBy(new AABooleanoExp());
		}
		else
		{
			System.out.println("Erro semântico de menor que em " + node.toString());
		}
	}
	
	@Override
	public void outAAMenorIgualExp(AAMenorIgualExp node)
	{
		if (node.getEsq() instanceof AANumeroExp &&
			node.getDir() instanceof AANumeroExp)
		{
			node.replaceBy(new AABooleanoExp());
		}
		else
		{
			System.out.println("Erro semântico de menor/igual que em " + node.toString());
		}
	}

	@Override
	public void outAAOrExp(AAOrExp node)
	{
		if (node.getEsq() instanceof AABooleanoExp &&
			node.getDir() instanceof AABooleanoExp)
		{
			node.replaceBy(new AABooleanoExp());
		}
		else
		{
			System.out.println("Erro semântico de ou em " + node.toString());
		}
	}

	@Override
	public void outAAAndExp(AAAndExp node)
	{
		if (node.getEsq() instanceof AABooleanoExp &&
			node.getDir() instanceof AABooleanoExp)
		{
			node.replaceBy(new AABooleanoExp());
		}
		else
		{
			System.out.println("Erro semântico de e em " + node.toString());
		}
	}

	@Override
	public void outAANegativoExp(AANegativoExp node)
	{
		if (node.getExp() instanceof AANumeroExp)
		{
			node.replaceBy(new AANumeroExp());
		}
		else
		{
			System.out.println("Erro semântico de negação em " + node.toString());
		}
	}

	@Override
	public void outAANegacaoExp(AANegacaoExp node)
	{
		if (node.getExp() instanceof AABooleanoExp)
		{
			node.replaceBy(new AABooleanoExp());
		}
		else
		{
			System.out.println("Erro semântico de negação em " + node.toString());
		}
	}

	@Override
	public void outAASeCondExp(AASeCondExp node)
	{
		if (!(node.getEsq() instanceof AABooleanoExp))
			System.out.println("A expressão " + node.toString() + "deve ter como resultado um booleano!");
	}

	@Override
	public void outAACondComando(AACondComando node)
	{
		if (!(node.getEsq() instanceof AABooleanoExp))
			System.out.println("A expressão " + node.toString() + "deve ter como resultado um booleano!");
	}

	@Override
	public void outAACondElseComando(AACondElseComando node)
	{
		if (!(node.getEsq() instanceof AABooleanoExp))
			System.out.println("A expressão " + node.toString() + "deve ter como resultado um booleano!");
	}

	@Override
	public void outAAContCondElseComando(AAContCondElseComando node)
	{
		if (!(node.getEsq() instanceof AABooleanoExp))
			System.out.println("A expressão " + node.toString() + "deve ter como resultado um booleano!");
	}

}
