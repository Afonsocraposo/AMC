package GUI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import Tipos_de_dados.BN;

public class Read_BN {
	
	public static void main(String[] args) {
		String filename="breast cancer.BN";
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis=new FileInputStream(filename);
			ois=new ObjectInputStream(fis);
			BN bayesnet=(BN)ois.readObject();
			ois.close();
			fis.close();
		}
		catch(FileNotFoundException e) {
			
		}
		catch(IOException e1) {
		} 
		catch (ClassNotFoundException e) {
		}
	}
	
	
}
