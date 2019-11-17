package _03_To_Do_List;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
public class ToDoList implements ActionListener{
	/*
	 * Create a program with five JButtons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks JButton is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task JButton is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list JButton is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list JButton is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	public static void main(String[] args) {
		new ToDoList().createUI();
		
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	ArrayList<String> tasks = new ArrayList<String>();
	void createUI() {
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.setText("add");
		view.setText("view");
		remove.setText("remove");
		save.setText("save");
		load.setText("load");
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/newFile.txt"));
			String line = br.readLine();
			while(line != null){
				if(line.length() < 4) {
					continue;
				}
				
				System.out.println(line);
				tasks.add(line.substring(3));
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	String createMessage() {
		String message = "";
		for (int i = 0; i < tasks.size(); i++) {
			message = message + (i+1) + ". " + tasks.get(i) + "\n";
		}
		return message;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String message = createMessage();
		
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			String task = JOptionPane.showInputDialog(panel, "Give a task");
			tasks.add(task);
		}
		if(e.getSource() == view) {
			JOptionPane.showMessageDialog(null, message);
		}
		if(e.getSource() == remove) {
			String in = JOptionPane.showInputDialog("Remove which task(number)\n"  + message);
			tasks.remove(Integer.parseInt(in) - 1);
		}
		if(e.getSource() == save) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/newFile.txt");
				fw.write(message);
				fw.close();
			} catch (IOException d) {
				d.printStackTrace();
			}
		}
		if(e.getSource() == load) {
			String fileName = "";
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName = jfc.getSelectedFile().getAbsolutePath();
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				String line = br.readLine();
				tasks.clear();
				while(line != null){
					System.out.println(line);
					tasks.add(line.substring(3));
					line = br.readLine();
				}
				
				br.close();
				message = createMessage();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
}

	



