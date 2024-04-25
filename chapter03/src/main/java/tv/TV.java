package tv;

public class TV {
	private int volume;		// 0 ~ 10
	private int channel;	// 1 ~ 255
	private boolean power;
	
	public TV() {
		channel = 7;
		volume = 20;
		power = false;
	}
	
	public TV(int channel, int volume, boolean power) {
		this.volume = volume;
		this.channel = channel;
		this.power = power;
	}
	
	public int getVolume() {
		return volume;
	}

	public int getChannel() {
		return channel;
	}
	
	public String isPower() {
		if(this.power) {
			return "켜진 상태";
		}else {
			return "꺼진 상태";
		}
	}
	
	public void power(boolean on) {
		if(on) {
			this.power=true;
			System.out.println("TV가 켜졌습니다");
		}else {
			this.power=false;
			System.out.println("TV가 꺼졌습니다");
		}
	}

	public void channel(int channel) {
		if(channel==0) {
			this.channel=255;
		}else if(channel>255){
			channel=1;
		}
		
	}
	public void channel(boolean up) {
		if(up) {
			if(this.channel==255) this.channel=0;
			this.channel+=1;
		}else {
			if(this.channel==1) this.channel=256;
			this.channel-=1;
		}
	}
	
	public void volume(int volume) {
		if(volume>100) {
			this.volume=0;
		}
	}
	
	public void volume(boolean up) {
		if(up) {
			if(this.volume==100) this.volume=-1;
			this.volume+=1;
		}else {
			if(this.volume==0) this.volume=101;
			this.volume-=1;
		}
	}

	public void status() {
		System.out.println("TV: "+isPower() + ", 채널: "+channel+", 볼륨: "+volume);
	}
}
