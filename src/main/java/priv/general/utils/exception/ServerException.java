package priv.general.utils.exception;

public class ServerException extends Exception {

	private static final long serialVersionUID = 5793885814237431471L;

	public ServerException() {
		super("服务器异常！");
	}
	
	public ServerException(String message) {
		super(message);
	}
	
}