package com.sist.server;
import java.io.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	FileReader fis=
        			new FileReader("C:\\javaDev\\javaStudy\\20200113-최종프로젝트\\src\\com\\sist\\server\\Server.java");
        	String s="";
        	int i=0;
        	while((i=fis.read())!=-1)
        	{
        		// -1 => EOF
        		s+=String.valueOf((char)i);
        	}
        	
        	System.out.println(s);
        }catch(Exception ex) {}
	}

}
