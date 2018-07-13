package com.nelioalves.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	public static List<Integer> decodeIntList(String listaSeparadaPorVirgula) {
		String[] strings = listaSeparadaPorVirgula.split(",");
		List<Integer> listaFinal = new ArrayList<>();
		for (int i=0; i<strings.length; i++) {
			listaFinal.add(Integer.parseInt(strings[i]));
		}
		
		return listaFinal;
		/*
		
		//O código acima é equivalente ao escrito abaixo em Lambda
		  
		return Arrays.asList(listaSeparadaPorVirgula.split(","))
				.stream().map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());
		 */
	}
	
	public static String decodeParam(String param) {
		try {
			return URLDecoder.decode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			 return "";
		}
	}
}
