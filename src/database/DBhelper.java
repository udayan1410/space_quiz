package database;

import java.sql.*;

import model.QuestionCategory;
import model.Questions;
import model.RadioButtonQuestions;

import java.util.*;

public class DBhelper {
	private static DBhelper dbhelper;
	private Connection connection;
	private Statement statement;
	private static List<Questions> fullList;
	
	public DBhelper() {		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/space_quiz","root","");	
			statement = connection.createStatement();						
		}catch(Exception e){e.printStackTrace();}
	}
		
	public static DBhelper getReference(){
		if(dbhelper == null)
			dbhelper = new DBhelper();		
		return dbhelper;
	}
	
	public List<Questions> populateList(){
		List<Questions> qList = new ArrayList();
		try{
		ResultSet rs = statement.executeQuery("SELECT * FROM qnapool natural Join qinfo;");
		
		while(rs.next()){					
			Integer id = Integer.parseInt(rs.getString(1));
			String question = rs.getString(2);
			String answer = rs.getString(3);
			String qType = rs.getString(4);
			String qDifficulty= rs.getString(5);
			
			if(qType.equalsIgnoreCase("RB")){
				RadioButtonQuestions radioButtonQuestions = new RadioButtonQuestions();
				radioButtonQuestions.setOptionsArray(answer.split("/"));
				radioButtonQuestions.setId(id);
				radioButtonQuestions.setQuestion(question);
				radioButtonQuestions.setQuestionType(qType);
				radioButtonQuestions.setQuestionDifficulty(qDifficulty);
				qList.add(radioButtonQuestions);
			}
			else				
				qList.add(new Questions(id,question,answer,qType,qDifficulty));						
		}
		}catch(Exception e){e.printStackTrace();}
		
		return qList;
	}
		
	public Questions getByTypeAndDifficulty(QuestionCategory category){
		Questions questions=null;
		
		for(int i=0;i<fullList.size();i++){
			if(fullList.get(i).getQuestionType().equalsIgnoreCase(category.getqType()) && fullList.get(i).getQuestionDifficulty().equalsIgnoreCase(category.getqDifficulty())){
				questions = fullList.remove(i);
				break;
			}
		}
		return questions;
	}
	
}
