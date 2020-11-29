package com.deepak.data.structures.Iterators;

import java.util.Iterator;

public class InOrderIterator<T> implements Iterator<T> {


	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public T next() {
		return null;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove not supported!!");
	}

}
