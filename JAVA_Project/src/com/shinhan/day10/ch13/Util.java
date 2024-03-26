package com.shinhan.day10.ch13;

public class Util {

	public static <A,B> B getValue(Pair<A, B> p, B b){
		if(p.getKey()==b) {
			return p.getValue();
		}else {
			return null;
		}
	}
	
	public static <P extends Pair<K,V>K,V> V getValue2(P pair, K k){
		if(pair.getKey().equals(k)) {
			return pair.getValue();
		}
		return null;
	}
}
