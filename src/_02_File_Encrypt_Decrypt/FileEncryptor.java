package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JOptionPane;
import javax.swing.text.Utilities;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static  void main(String[] args) {
		String dj = JOptionPane.showInputDialog("Write a message");
		try {
			FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/newFile.txt");
			
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			*/
			
			fw.write(dj);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}
}
