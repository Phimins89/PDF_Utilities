package com.kbc.efs;

import java.io.IOException;

public class PDFReader {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
//	 PDFUtil pdfUtil = new PDFUtil();
//	 pdfUtil.getPageCount("c:/sample.pdf"); //returns the page count
	 
		PDFComparatorUtil pdfutil = new PDFComparatorUtil();
		pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
		
		String file1="P:\\My Documents\\Desktop\\TEST\\test1.pdf";
		String file2="P:\\My Documents\\Desktop\\TEST\\test2.pdf";
		 
		// compares the pdf documents &amp; returns a boolean
		// true if both files have same content. false otherwise.
		// Default is CompareMode.TEXT_MODE
//		pdfutil.compare(file1, file2);
//		 
//		// compare the 3rd page alone
//		pdfUtil.compare(file1, file2, 3, 3);
//		 
//		// compare the pages from 1 to 5
//		pdfUtil.compare(file1, file2, 1, 5);
		 
		//if you need to store the result
		pdfutil.highlightPdfDifference(true);
		pdfutil.setImageDestinationPath("P:\\My Documents\\Desktop\\TEST");
		pdfutil.compare(file1, file2);
	}
	}


