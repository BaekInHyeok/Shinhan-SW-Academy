package com.shinhan.day07.lab;

interface Volume {

	void volumeUp(int level);

	void volumeDown(int level);
}

class Speaker implements Volume {

	int VolLevel;

	@Override
	public void volumeUp(int level) {
		// TODO Auto-generated method stub
		VolLevel += level;
		if (VolLevel > 100)
			VolLevel = 100;

		System.out.println(getClass().getSimpleName() + " 볼륨을 올립니다. " + VolLevel);
	}

	@Override
	public void volumeDown(int level) {
		// TODO Auto-generated method stub

		VolLevel -= level;
		if (VolLevel < 0)
			VolLevel = 0;

		System.out.println(getClass().getSimpleName() + " 볼륨을 내립니다. " + VolLevel);
	}

}

class Radio implements Volume {

	int VolLevel;

	@Override
	public void volumeUp(int level) {
		// TODO Auto-generated method stub

		VolLevel += level;
		System.out.println(getClass().getSimpleName() + " 볼륨을 올립니다. " + VolLevel);
	}

	@Override
	public void volumeDown(int level) {
		// TODO Auto-generated method stub

		VolLevel -= level;
		if (VolLevel < 0)
			VolLevel = 0;
		System.out.println(getClass().getSimpleName() + " 볼륨을 내립니다. " + VolLevel);
	}

}

class TV implements Volume {

	int VolLevel;

	@Override
	public void volumeUp(int level) {
		// TODO Auto-generated method stub
		VolLevel += level;
		System.out.println(getClass().getSimpleName() + " 볼륨을 올립니다. " + VolLevel);
	}

	@Override
	public void volumeDown(int level) {
		// TODO Auto-generated method stub
		VolLevel -= level;
		System.out.println(getClass().getSimpleName() + " 볼륨을 내립니다. " + VolLevel);

	}

}

public class VolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Volume은 Interface or abstract class로 만들 수 있다.
		// abstract class였다면 상속받아서 Speaker, Radio, TV
		// interface였다면 implements
		Volume[] v = new Volume[3];
		v[0] = new Speaker();
		v[1] = new Radio();
		v[2] = new TV();

		for (int i = 0; i < v.length; i++) {
			for (int j = 1; j <= 3; j++) {
				v[i].volumeUp(200);
			}
			for (int j = 1; j <= 3; j++) {
				v[i].volumeDown(300);
			}
		}

	}

}
