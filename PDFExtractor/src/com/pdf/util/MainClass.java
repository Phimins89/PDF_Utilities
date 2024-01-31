package com.pdf.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		Extractor ex = new Extractor();
			   
	    PrintWriter out = new PrintWriter(new File( "P:\\PDF_Testing\\filename.csv")); 
	    
	    Logger.getLogger("org.apache.pdfbox").setLevel(java.util.logging.Level.OFF);
	    
	    StringBuilder sb = new StringBuilder();
	    System.out.println("Customer Name : " + ex.getCustNames().size());
	    try {
	    	for(int i=0;i < ex.getCustNames().size();i++){
	    		System.out.println("Customer Name : " + ex.getCustNames().get(i));
	    		String row = ex.getCustNames().get(i) + ',' + ex.accNum.get(i) + ',' + ex.accType.get(i) + ',' + '"' + ex.closingBalance.get(i) + '"';
	        	sb.append(row);
	    		sb.append('\n'); 
	    	}
		out.write(sb.toString());
		}finally{
			out.close();
		}
      
    }

}
