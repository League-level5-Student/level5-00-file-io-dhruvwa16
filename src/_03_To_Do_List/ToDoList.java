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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String message = "";
		for (int i = 0; i < tasks.size(); i++) {
			message = message + (i+1) + ". " + tasks.get(i) + "\n";
		}
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
			
		}
	}
	
}

	



