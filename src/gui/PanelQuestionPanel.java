package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.ComponentRBQuestion.ButtonCommunicatorAdapter;
import interfaces.CustomButtonCommunicator;
import interfaces.QuestionType;
import model.Questions;
import utilities.Utils;

public class PanelQuestionPanel extends JPanel {
	
	
	private JTextArea label;	
    private PanelTitlePanel titlePanel;
	private CustomButtonCommunicator buttonCommunicator;
    
	public PanelQuestionPanel() {		
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));			
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Utils.DARKBLUE);
		
		titlePanel = new PanelTitlePanel();
		add(new PanelTitlePanel());	
	}

	public void displayQuestion(Questions questions) {
		// Question		
		label = new JTextArea(questions.getQuestion(),0,0);
		Font font = new Font(Font.MONOSPACED, Font.BOLD, 30);
		label.setLineWrap(true);
		label.setWrapStyleWord(true);
		label.setOpaque(false);
		label.setEditable(false);
		label.setForeground(new Color(255, 255, 255));			
		label.setMaximumSize(new Dimension(Utils.DIMENSION.width,180));
		label.setBorder(new EmptyBorder(0,40,0,40));
		//label.setBorder(BorderFactory.createEtchedBorder());
		label.setFont(font);	
		
		add(Box.createRigidArea(new Dimension(0,40)));
		add(label);		
		add(Box.createRigidArea(new Dimension(0,20)));						
	}

	public void RBclicked(String userAnswer){
		buttonCommunicator.buttonClicked(userAnswer);
	}
	
	public void setButtonCommunicator(CustomButtonCommunicator buttonCommunicator ){
		this.buttonCommunicator = buttonCommunicator;
	}
	/*
	 * @Override protected void paintComponent(Graphics grphcs) {
	 * super.paintComponent(grphcs); Graphics2D g2d = (Graphics2D) grphcs;
	 * g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	 * RenderingHints.VALUE_ANTIALIAS_ON); GradientPaint gp = new
	 * GradientPaint(0, 0, new Color(131,58,180), 0, getHeight(), new
	 * Color(253,29,29)); //GradientPaint gPaint = new GradientPaint(0,new
	 * Color(115,3,192))
	 * 
	 * g2d.setPaint(gp); g2d.fillRect(0, 0, getWidth(), getHeight());
	 * 
	 * }
	 */

}
