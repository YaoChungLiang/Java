package com.antra;
import com.antra.Criteria;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class assignment2 extends JFrame{
	private int FRAME_WIDTH = 1100, FRAME_HEIGHT = 400;
	private JLabel folderPathLabel, includeSubLabel, extensionLabel;
	private String folderPath = System.getProperty("user.dir"), includeSub = "Yes", extension = "java";
	private JTextField folderPathTF, includeSubTF, extensionTF;
	private JButton searchButton;
	static StringBuilder resultText = new StringBuilder();
	final int folderPathWidth = 50, includeSubWidth = 3, extensionWidth = 10;
	final static int AREA_ROWS = 15, AREA_COLUMNS = 70;
	static JFrame frame;
	private JTextArea textArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
	private String[] includeOptions = new String[] {"Yes","No"};
	private JComboBox<String> options;
	
	public static void main(String[] args) {
        frame = new assignment2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
	}
	
	assignment2(){
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		createLabelTextField();
		createListener();
		createPanel();
	}
	
	public void createPanel() {
		JPanel panel = new JPanel();
		
		JPanel panelUp = new JPanel();
		JPanel panelDown = new JPanel();
		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		JPanel panelCenter = new JPanel();
		
		panelNorth.add(folderPathLabel);
		panelNorth.add(folderPathTF);
		panelCenter.add(includeSubLabel);
//		panelCenter.add(includeSubTF);
		
		options = new JComboBox<>(includeOptions);
		panelCenter.add(options);
		
		panelSouth.add(extensionLabel);
		panelSouth.add(extensionTF);
		panelUp.add(panelNorth, BorderLayout.NORTH);
		panelUp.add(panelCenter, BorderLayout.CENTER);
		panelUp.add(panelSouth, BorderLayout.SOUTH);
		
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
		panelDown.add(scrollPane);
		panel.add(panelUp);
		panel.add(searchButton);
		panel.add(panelDown);
		add(panel);
//		add(scrollPane);
	}
	
	public void createLabelTextField(){
		folderPathLabel = new JLabel("Target folder: ");
		folderPathTF = new JTextField(folderPathWidth);
		folderPathTF.setText(folderPath);
		
		includeSubLabel = new JLabel("Want to include subdiretories? ");
		includeSubTF = new JTextField(includeSubWidth);
		includeSubTF.setText(includeSub);
		
		extensionLabel = new JLabel("extension: ");
		extensionTF = new JTextField(extensionWidth);
		extensionTF.setText(extension);
	}
	
	
	public void createListener() {
		searchButton = new JButton("Search files/folders");
		searchButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	     	 	textArea.setText(" ");
	    	 	textArea.setText("");
				folderPath = folderPathTF.getText();
//				includeSub = includeSubTF.getText();
				includeSub = (String) options.getSelectedItem();
				extension = extensionTF.getText();
				Criteria criteria = new Criteria(folderPath,includeSub, extension);
				count(criteria);
	          }
	       });
	}
	
	public void count(Criteria criteria) {

		String folderPath = criteria.getFolderPath();
		String includeSub = criteria.getIncludeSubFolder().toLowerCase();
		String extension = criteria.getExtension().toLowerCase();
		
		Path path = Paths.get(folderPath);
		if(Files.notExists(path)) {
			JOptionPane.showMessageDialog(frame, "No such folder path, please retype again");
			return;
		}
		
		
		if(includeSub.equals("y")|| includeSub.equals("yes")) {
			listf(folderPath, true, extension);
		}else if(includeSub.equals("n")|| includeSub.equals("no")) {
			listf(folderPath, false, extension);
		}else {
			JOptionPane.showMessageDialog(frame, "type 'yes' or 'no' to indicate the inclusion of subdirs");
			return;
		}
		
		textArea.setText(resultText.toString());
	}
	
	public static void listf(String directoryName, boolean sub, String ext) {
	    File directory = new File(directoryName);

	    // Get all files from a directory.
	    File[] fList = directory.listFiles();
	    int numOfFiles = 0, numOfDirs = 0;
	    if(fList != null) {
	        for (File file : fList) {      
	            if (file.isFile()) {
	            	if(!ext.equals("") || !ext.equals("*")) {
	            		if(file.getName().toLowerCase().endsWith("." + ext)) {
	            			numOfFiles++;
	            		}
	            	}else {
	            		numOfFiles++;
	            	}
	                
	            }else if (file.isDirectory()) {
	            	if(sub) {
	            		listf(file.getAbsolutePath(), sub, ext);
	            	}
	            	if(ext.equals("") || ext.equals("*"))
	            		numOfDirs++;
	            }
	        }
	    	resultText.append("There are " + numOfFiles + " file(s) and " + numOfDirs + " folder(s) inside " + directory + " with extension " + ext);
	    	resultText.append("\n");
	    }
	}
}
