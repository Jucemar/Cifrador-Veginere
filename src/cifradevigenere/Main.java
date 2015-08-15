package cifradevigenere;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guiche-03
 */
public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("--------Programa cifra de Vigenere--------");
		System.out.print("Digite 1 para cifrar ou 2 para decifrar: ");
		System.out.println("");
		int n = teclado.nextInt();		
		CifraDeVigenere c = new CifraDeVigenere();
		if (n == 1) {
			c.cifrar();
		} else {
			c.decifrar();
		}
		}
}
