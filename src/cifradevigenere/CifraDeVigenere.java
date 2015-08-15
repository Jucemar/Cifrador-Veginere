package cifradevigenere;

import java.util.HashMap;
import java.util.Scanner;

public class CifraDeVigenere {
	HashMap<String, Integer> alfabeto_key;
	HashMap<Integer, String> key_alfabeto;
	String txtLimpo;
	String chave;
	Scanner teclado;
	String chaveExtendida;
	String txtCifrado;
	int[] idsChaveEstendida;
	int[] idsTxtLimpo;
	int[] idsTxtCifrado;

	public CifraDeVigenere() {

		teclado = new Scanner(System.in);
		alfabeto_key = new HashMap<String, Integer>();
		key_alfabeto = new HashMap<Integer, String>();
		alfabeto_key.put("a", 0);
		alfabeto_key.put("b", 1);
		alfabeto_key.put("c", 2);
		alfabeto_key.put("d", 3);
		alfabeto_key.put("e", 4);
		alfabeto_key.put("f", 5);
		alfabeto_key.put("g", 6);
		alfabeto_key.put("h", 7);
		alfabeto_key.put("i", 8);
		alfabeto_key.put("j", 9);
		alfabeto_key.put("k", 10);
		alfabeto_key.put("l", 11);
		alfabeto_key.put("m", 12);
		alfabeto_key.put("n", 13);
		alfabeto_key.put("o", 14);
		alfabeto_key.put("p", 15);
		alfabeto_key.put("q", 16);
		alfabeto_key.put("r", 17);
		alfabeto_key.put("s", 18);
		alfabeto_key.put("t", 19);
		alfabeto_key.put("u", 20);
		alfabeto_key.put("v", 21);
		alfabeto_key.put("w", 22);
		alfabeto_key.put("x", 23);
		alfabeto_key.put("y", 24);
		alfabeto_key.put("z", 25);

		key_alfabeto.put(0, "a");
		key_alfabeto.put(1, "b");
		key_alfabeto.put(2, "c");
		key_alfabeto.put(3, "d");
		key_alfabeto.put(4, "e");
		key_alfabeto.put(5, "f");
		key_alfabeto.put(6, "g");
		key_alfabeto.put(7, "h");
		key_alfabeto.put(8, "i");
		key_alfabeto.put(9, "j");
		key_alfabeto.put(10, "k");
		key_alfabeto.put(11, "l");
		key_alfabeto.put(12, "m");
		key_alfabeto.put(13, "n");
		key_alfabeto.put(14, "o");
		key_alfabeto.put(15, "p");
		key_alfabeto.put(16, "q");
		key_alfabeto.put(17, "r");
		key_alfabeto.put(18, "s");
		key_alfabeto.put(19, "t");
		key_alfabeto.put(20, "u");
		key_alfabeto.put(21, "v");
		key_alfabeto.put(22, "w");
		key_alfabeto.put(23, "x");
		key_alfabeto.put(24, "y");
		key_alfabeto.put(25, "z");

	}

	public void decifrar() {
		System.out.print("Digite o texo cifrado: ");
		txtCifrado = teclado.nextLine();
		System.out.print("Digite a chave usada: ");
		chave = teclado.nextLine();
		chaveExtendida = chave;

		if (chave.length() < txtCifrado.length()) {
			int tamanho = txtCifrado.length() - chave.length();
			int qtde = tamanho / chave.length();
			for (int i = 0; i < qtde; i++) {
				chaveExtendida = chaveExtendida + chave;
			}
		}

		if (chaveExtendida.length() < txtCifrado.length()) {
			int qtde2 = txtCifrado.length() - chaveExtendida.length();
			String resto = chave.substring(0, qtde2);
			chaveExtendida = chaveExtendida + resto;
		}

		idsChaveEstendida = converterParaInteiro(chaveExtendida);
		idsTxtCifrado = converterParaInteiro(txtCifrado);

		idsTxtLimpo = new int[idsTxtCifrado.length];

		for (int i = 0; i < idsTxtCifrado.length; i++) {
			idsTxtLimpo[i] = (idsTxtCifrado[i] - idsChaveEstendida[i] + 26) % 26;
		}

		txtLimpo = converterParaString(idsTxtLimpo);

		System.out.println("Texto limpo: " + txtLimpo);

	}

	public void cifrar() {

		System.out.print("Digite o texo limpo: ");
		txtLimpo = teclado.nextLine();
		System.out.print("Digite a chave a ser usada: ");
		chave = teclado.nextLine();
		chaveExtendida = chave;

		if (chave.length() < txtLimpo.length()) {
			int tamanho = txtLimpo.length() - chave.length();
			int qtde = tamanho / chave.length();
			for (int i = 0; i < qtde; i++) {
				chaveExtendida = chaveExtendida + chave;
			}
		}

		if (chaveExtendida.length() < txtLimpo.length()) {
			int qtde2 = txtLimpo.length() - chaveExtendida.length();
			String resto = chave.substring(0, qtde2);
			chaveExtendida = chaveExtendida + resto;
		}

		txtLimpo = txtLimpo.toLowerCase();
		txtLimpo = txtLimpo.trim();

		idsChaveEstendida = converterParaInteiro(chaveExtendida);
		idsTxtLimpo = converterParaInteiro(txtLimpo);

		idsTxtCifrado = new int[txtLimpo.length()];

		for (int i = 0; i < idsTxtLimpo.length; i++) {
			idsTxtCifrado[i] = (idsTxtLimpo[i] + idsChaveEstendida[i]) % 26;
		}

		txtCifrado = converterParaString(idsTxtCifrado);

		System.out.println("Texto cifrado: " + txtCifrado);

	}

	public int[] converterParaInteiro(String s) {
		int[] resultado = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			String str = s.charAt(i) + "";
			resultado[i] = alfabeto_key.get(str);
		}
		return resultado;
	}

	public String converterParaString(int[] n) {
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < n.length; i++) {
			resultado.append(key_alfabeto.get(n[i]));
		}
		return resultado.toString();
	}

}
