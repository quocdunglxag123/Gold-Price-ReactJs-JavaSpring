package com.goldprice.goldprice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class test {
	public static void main(String[] args) throws IOException {
		List<Person> persons = new ArrayList<>();

	    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\quocd\\Downloads\\Book1.csv"));
	 
	    br.readLine(); // Not read Next Line

	    String line = br.readLine(); //Read nextLine
	    while (line != null && !line.isEmpty()) {
	    	
	    	//Check Line Is Empty Null
	        String[] per = line.replace(""", "").split(",");
	        //String[] perDetail = per[0].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
		   	System.out.println(Arrays.asList(per).get(0));

	        //Set To Person
	        Person person = new Person();
	        person.setFirst_name(per[0]);
	        person.setLast_name(per[1]);
	        person.setLicense_number(per[2]);
	        person.setSite_number(Integer.parseInt(per[3]));
	        
	        persons.add(person);// Add Person To List
	   
	        line = br.readLine();//Read nextLine
	    }        
	    
	}
}