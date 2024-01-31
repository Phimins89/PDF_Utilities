package com.pdf.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Extractor {
	
	File Directory = new File("P:\\PDF_Testing\\");
	
	ArrayList<String> accNum   = new ArrayList<String>();
	ArrayList<String> accType  = new ArrayList<String>();
    ArrayList<String> custName = new ArrayList<String>();
    ArrayList<String> closingBalance = new ArrayList<String>();
    
	File[] listOfFiles = Directory.listFiles(); {
	
		
		
		custName.add(0,"Customer Name");
		accType.add(0,"Account Type");
		accNum.add(0,"Account Number");
		closingBalance.add(0,"Closing Balance");
		   Logger.getLogger("org.apache.pdfbox").setLevel(java.util.logging.Level.OFF);	
		 for (int i = 0; i < 60; i++) {
	//	for (int i = 0; i < 5; i++) {

			 if (listOfFiles[i].isFile()) {
				 try {
					
					 PDDocument document = PDDocument.load(listOfFiles[i]);
		    			//Instantiate PDFTextStripper class
		    		 PDFTextStripper pdfStripper = new PDFTextStripper();
		    			//Retrieving text from PDF document
		    		 String[] text = pdfStripper.getText(document).split("\\n");
		    		 int counter = 0;	
		    		 
		    		  		 
		    	//	 System.out.println(custName);
		    		 for(int k=0;k<text.length;k++){
		    			
		    			 text[k] = text[k].trim();
		    	//		 System.out.println("line " + k + " " +text[k]); 
		    			 
		    			 if (k == 0){
			    			 if(text[0].matches("\\d{8}")){
			    				 accNum.add(text[k]);
			    				 custName.add(text[3]);
			    				 k++;
			    			} else{
			    			 // (text[k].matches("Mr.*|Ms.*|Miss.*|Mrs.*|.*&.*|.*and.*|.*Ltd")){
			    				 custName.add(text[k]);
			    				 k++;
			    			}	
		    			 }
		    		
		    			 if(text[k].matches(".*Fixed.*|.*Demand.*|.*CONFIG.*|.*Deposit Account.*|.*Affinity Plus.*|.*Savings Account.*|.*Saver Account.*")){
		    				 accType.add(text[k]);
		    			 }
		    			 if(text[k].matches("\\d{8}")){
		    				 accNum.add(text[k]);
		    			 }
		    			 if (k > 39 || k <45){
		    				 //if(text[k].matches("\\d\\d\\s\\S\\S\\S\\s\\d\\d\\d\\d")){
		    				 if(text[k].contains("Credit") || text[k].contains("Interest")){
		    					 	 System.out.println(" ERMAGHERD : " + text[k]);
		    			 
		    				 }
		    			 }
		    			 if(text[k].contains("(v/d")){
		    				 text[k] = text[k+1];
		    			} 
		    			 if(text[k].contains("Balance    ") && counter < 1){
		    				 closingBalance.add(text[k-1].substring(text[k-1].lastIndexOf(" ")));
		    				 counter++;
		    			 }
		    			 if(k == text.length-1){
		    				 counter = 0;
		    			 }
		    		 
		    		 }
		    	 }
		    	 catch (IOException e) {
		    	 // TODO Auto-generated catch block
		    		 e.printStackTrace();
		    	 }
		     }
		 }
		
		//	 System.out.println("Closing Balance : " + closingBalance.size());
		//	 System.out.println(custName);
		//	 System.out.println("Account Numbers : " + accNum.size());
		//	 System.out.println("Account Type : " + accType.size());
	}
		 
	
		 
		 
	private List<String> distinctCustNames = new ArrayList<String>(new LinkedHashSet<String>(custName));	 
	
//	 System.out.println(accNum);
	

	public List<String> getCustNames() {
		// TODO Auto-generated method stub
	return distinctCustNames;
		
	}

	
}
	


	
	
	
