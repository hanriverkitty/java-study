package prob5;

import java.util.Arrays;

public class MyStack02{
	private Object[] buffer;
	private int size;
	private int idx=-1;
	
	public MyStack02(int size) {
		this.size=size;
		buffer = new Object[size];
	}
	public void push(Object string) {
		if (idx+1>=size) {
			Object temp[] = new String[size*2];
			for(int i=0;i<size;i++) {
				temp[i]=buffer[i];
			}
			buffer=temp;
			size=size*2;
		}
		idx++;
		buffer[idx]=string;
		
		
		
	}
	public Object pop() throws MyStackException{
		if(idx==-1) {
			throw new MyStackException();
		}
		Object popString = buffer[idx];
		idx--;
		if(idx<0) idx=-1;
		return popString;
		
	}
	
	public boolean isEmpty() {
		if(idx==-1) {
			return true;
		}else {
			return false;
		}
	}
	
}