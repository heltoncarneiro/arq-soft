package br.edu.ifpe.ads.arqsoft.teste;

import br.edu.ifpe.ads.arqsoft.repository.infra.Database;
import br.edu.ifpe.ads.arqsoft.repository.infra.DatabasePostgreSQL;

public class ConnectioTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new DatabasePostgreSQL();
		
		System.out.println(db.connect() != null? "Conectado" : "Não conectou");
	}

}
