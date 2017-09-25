package entity;

import java.util.Date;

public class Comentario {
	private Date data; // Data que o comentario foi inserido
	private String comentario;

	public Comentario(String comentario, Pessoa responsavel) {
		super();
		this.data = new Date();
		this.comentario = comentario;
	}

}
