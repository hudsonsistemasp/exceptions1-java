package model.exceptions;

/*Exception = o compilador te obriga a tratar , ou seja, o try-catch no Application.
RuntimeException = o compilador não te obriga a tratar, ou seja, o try-catch no Application*/

public class DomainException extends RuntimeException{

	/*DomainException: por que essa classe é do tipo SERIALIZABLE e precisa ter um número de versão.
	 * Classes Serializable quer dizer que podem ser convertidas em bytes e assim trafegar em redes, 
	 * ser gravados em arquivos e etc. Padrão da linguagem Java*/
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
