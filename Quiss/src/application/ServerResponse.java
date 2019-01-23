package application;

import java.io.Serializable;

public class ServerResponse implements Serializable{
	private static final long serialVersionUID = -7771641421746968949L;
	private int n=0;
	private String[] args;
	public ServerResponse(int n,String[] args) {
		this.setN(n);
		this.setArgs(args);
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String[] getArgs() {
		return args;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}
}
