package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comentario;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Comentario c1 = new Comentario("Você tem uma viagem!");
		Comentario c2 = new Comentario("Uau, isso é demais");
		Post p1 = new Post(sdf.parse("18/10/2021 13:05:44"), "Viagem para Nova Zelandia",
				"Vou visitar este país maravilhoso!", 12);
		p1.addComentario(c1);
		p1.addComentario(c2);

		Comentario c3 = new Comentario("Boa noite galera");
		Comentario c4 = new Comentario("May the Force be with you");
		Post p2 = new Post(sdf.parse("20/10/2021 22:15:35"), "Boa noite", "Até amanhã", 5);
		p2.addComentario(c3);
		p2.addComentario(c4);

		System.out.println(p1);
		System.out.println(p2);

	}
}
