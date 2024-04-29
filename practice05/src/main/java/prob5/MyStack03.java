package prob5;

import java.lang.reflect.Array;

public class MyStack03<T>{
	private T[] buffer;
	private int size;
	private int idx=-1;
	
	public MyStack03(/*Class<?> klass,*/int size) {
		this.size=size;
		buffer = (T[]) new Object[size];
		// buffer = (T[])Array.newInstance(getClass(),size);
	}
	public void push(T string) {
		if (idx+1>=size) {
			T temp[] = (T[]) new String[size*2];
			for(int i=0;i<size;i++) {
				temp[i]=buffer[i];
			}
			buffer=temp;
			size=size*2;
		}
		idx++;
		buffer[idx]=string;
		
		
		
	}
	public T pop() throws MyStackException{
		if(idx==-1) {
			throw new MyStackException();
		}
		T popString = buffer[idx];
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