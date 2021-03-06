package utilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import gui.ComponentFIBQuestion;
import gui.ComponentINTQuestion;
import gui.ComponentRBQuestion;
import gui.ComponentTFQuestion;
import gui.PanelQuestionPanel;
import interfaces.QuestionType;
import model.Questions;

public class Utils {

	public static final Integer COUNTDOWN_INTEGER = 40;
	public static Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
	public static boolean gameMusic = true;
	public static boolean gameSound = true;

	public static PanelQuestionPanel getQuestionPanel(Questions questions) {
		PanelQuestionPanel questionPanel = null;

		switch (questions.getQuestionType()) {
		case "RB":
			questionPanel = new ComponentRBQuestion(questions);
			break;

		case "FIB":
			questionPanel = new ComponentFIBQuestion(questions);
			break;

		case "TF":
			questionPanel = new ComponentTFQuestion(questions);
			break;
		case "INT":
			questionPanel = new ComponentINTQuestion(questions);
			break;
		}

		return questionPanel;
	}

	public static final Font getFont(String fontName) {
		try {
			File font_file = new File("./Fonts/" + fontName + ".ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
			Font font2 = font.deriveFont(16f);
			return font2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getQType(Questions questions) {
		String type = "";

		switch (questions.getQuestionType()) {
		case "Radio Button":			
			type="RB";
			break;

		case "True or False":			
			type="TF";
			break;

		case "Interactive":			
			type="INT";
			break;

		case "Fill in the Blanks":
			type="FIB";	
			break;

		default:
			break;
		}

		return type;

	}

}
