package model.exceptions;

/*Exception = o compilador te obriga a tratar , ou seja, o try-catch no Application e uso da clausula throws Classe de tratamento de erro,
 * ex: throws DomainException na assinatura do m�todo da classe Reservation nos m�todos que usarem o tratamento das exce��es.
RuntimeException = o compilador n�o te obriga a tratar, ou seja, o try-catch no Application e n�o precisa usar a clausula throws nas
classes de tratamento de erro na assinautura do m�todo*/

public class DomainException extends RuntimeException{

	/*DomainException: por que essa classe � do tipo SERIALIZABLE e precisa ter um n�mero de vers�o.
	 * Classes Serializable quer dizer que podem ser convertidas em bytes e assim trafegar em redes, 
	 * ser gravados em arquivos e etc. Padr�o da linguagem Java*/
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
