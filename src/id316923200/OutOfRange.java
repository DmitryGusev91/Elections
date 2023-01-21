package id316923200;
//NAME: Dmitry Gusev
//ID:316923200
public class OutOfRange extends Exception {
	private String msg;

	public OutOfRange(String msg) {
		setMsg(msg);
		
	}

	public String getMessage() {
		return msg;
	}

	public boolean setMsg(String msg) {
		if (this.msg!=null&&this.msg.equals(msg))
			return false;
		else
			this.msg = msg;
		return true;
	}
}
