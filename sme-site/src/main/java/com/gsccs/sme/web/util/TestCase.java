package com.gsccs.sme.web.util;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
	
	public static void main(String[] args) {
		List<String> testlist = new ArrayList<>();
		
		testlist.add("1");
		testlist.add("2");
		testlist.add("3");
		testlist.add("4");
		
		int desc = 1;
		if (desc==1){
			System.out.println("desc "+desc);
			for(int i=testlist.size()-1;i>=0;i--){
				System.out.println(testlist.get(i));
			}
		}else{
			System.out.println("desc "+desc);
			for(int i=0;i<testlist.size();i++){
				System.out.println(testlist.get(i));
			}
		}
		
		
	}

}
