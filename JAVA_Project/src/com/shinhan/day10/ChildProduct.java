package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//상속
@Getter
@Setter
@NoArgsConstructor

public class ChildProduct<K, V, P> extends Product<K, V> {

	P price;

	public ChildProduct(K kind, V model, P price) {
		super(kind, model);
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("model:").append(getModel()).append("\nkind:").append(getKind()).append("\nprice:").append(price);
				
				
				return builder.toString();
	}
	
	
	
}
