package com.andresimiquelli.tinnovaveiculos.utils;

public class CalcDecada {

	public static int getStart(int ano) {
		String anoConvertido = String.valueOf(ano);
		String decadaString = anoConvertido.substring(0,3)+"0";
		
		return Integer.valueOf(decadaString);
	}
	
	public static int getEnd(int ano) {
		String anoConvertido = String.valueOf(ano);
		String decadaString = anoConvertido.substring(0,3)+"9";
		
		return Integer.valueOf(decadaString);
	}
}
