package model.exceptions;

/*Exception = o compilador te obriga a tratar , ou seja, o try-catch no Application.
RuntimeException = o compilador n�o te obriga a tratar, ou seja, o try-catch no Application*/

public class DomainException extends RuntimeException{

	/*DomainException: por que essa classe � do tipo SERIALIZABLE e precisa ter um n�mero de vers�o.
	 * Classes Serializable quer dizer que podem ser convertidas em bytes e assim trafegar em redes, 
	 * ser gravados em arquivos e etc. Padr�o da linguagem Java*/
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
