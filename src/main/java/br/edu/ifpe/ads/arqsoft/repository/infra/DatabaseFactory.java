package br.edu.ifpe.ads.arqsoft.repository.infra;

public class DatabaseFactory {

		public static DatabasePostgreSQL getPostgreDBConection(){
		
			return new DatabasePostgreSQL();
		}
}
