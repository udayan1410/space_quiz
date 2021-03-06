package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.ietf.jgss.Oid;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.glass.ui.Cursor;

import interfaces.CustomButtonCommunicator;
import utilities.Utils;

public class CustomButton extends JLabel {

	private CustomButton customButton;
	private CustomButtonCommunicator buttonCommunicator;

	public CustomButton(String title) {
		title = title.toUpperCase();
		LineBorder line = new LineBorder(Color.white, 2, true);
		customButton = this;
		new JLabel();
		setText(title);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setMinimumSize(new Dimension(460, 60));
		setMaximumSize(new Dimension(460, 60));
		setOpaque(false);
		setBorder(line);
		setForeground(Color.white);
		
		setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		setAlignmentX(Component.CENTER_ALIGNMENT);

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// setBackground(Utils.DARKBLUE);
				customButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// setBackground(Utils.SKYBLUE);
				playSound();
				customButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
				setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				buttonCommunicator.buttonClicked(customButton.getText());
			}
		});

	}

	public void setButtonCommunicator(CustomButtonCommunicator buttonCommunicator) {
		this.buttonCommunicator = buttonCommunicator;
	}

	public CustomButton getCustomButtom() {
		return this;
	}

	public void setSize(Dimension dimension) {
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setPreferredSize(dimension);
	}

	public void playSound() {
		try {
			if (Utils.gameSound) {
				InputStream in = new FileInputStream("./Sounds/pop.wav");
				InputStream bufferedIn = new BufferedInputStream(in);
				AudioInputStream as = AudioSystem.getAudioInputStream(bufferedIn);
				Clip clip = AudioSystem.getClip();
				clip.open(as);
				clip.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
