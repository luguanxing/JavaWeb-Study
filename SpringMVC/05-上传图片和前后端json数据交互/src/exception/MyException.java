package exception;

public class MyException extends Exception {
	
	private String myMsg;

	public MyException(String myMsg) {
		super();
		this.myMsg = myMsg;
	}

	public String getMyMsg() {
		return myMsg;
	}

	public void setMyMsg(String myMsg) {
		this.myMsg = myMsg;
	}
	
}
