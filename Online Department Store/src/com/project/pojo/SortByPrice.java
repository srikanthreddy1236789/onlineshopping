package com.project.pojo;
import java.util.Map.Entry;
import java.util.*;

public class SortByPrice implements Comparator<Map.Entry<Integer, Product>> {

	@Override
	public int compare(Entry<Integer, Product> o1, Entry<Integer, Product> o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.getValue().getSellingPrice(), o2.getValue().getSellingPrice());
	}

}


