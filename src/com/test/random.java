package com.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;

public class random {

	public static void main(String a[]) throws IOException{
		Random dsRand = new Random();
		StringBuffer sb = new StringBuffer();
		for(int j=0;j<4;j++){
			for(int i=0;i<40;i++){
				
				sb.append(dsRand.nextInt(61));
				sb.append(" ");
			}
		    sb.append("\n\n");
		    for(int i=0;i<40;i++){
				
				sb.append(dsRand.nextInt(61));
				sb.append(" ");
			}
		    sb.append("\n\n");
	     for(int i=0;i<40;i++){
				
				sb.append(dsRand.nextInt(61));
				sb.append(" ");
			}
	     sb.append("\n\n");
	     for(int i=0;i<40;i++){
				
				sb.append(dsRand.nextInt(61)+20);
				sb.append(" ");
			}
	     sb.append("\n\n");
		}
	 FileOutputStream fd = new FileOutputStream(new File("D:/Users/ZGM/Desktop/data.txt"));
	Writer fdd = new BufferedWriter(new FileWriter(new File("D:/Users/ZGM/Desktop/ghfh.txt")));
	fdd.write("dfsfsdfsfsfsdf");
	fdd.close();
	fd.close();
	/* OutputStreamWriter out = new OutputStreamWriter(fd);
	 out.write(sb.toString());
	 out.close();*/
	}

}
