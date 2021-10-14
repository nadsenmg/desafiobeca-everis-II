package br.com.nadsen.gerenciadorsaques.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoConta {
	PESSOA_FISICA(5), PESSOA_JURIDICA(50), GOVERNAMENTAL(250);
	
	private int qtdSaques;
	
	
	
}
