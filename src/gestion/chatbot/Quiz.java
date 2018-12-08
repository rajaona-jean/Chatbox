package gestion.chatbot;

import org.json.JSONArray;
import org.json.JSONObject;

import gestion.*;
import gestion.base.BotInvalide;
import gestion.base.Saisie;

public class Quiz extends Bot{

	public void lancer() throws BotInvalide{
		int questionNumber;
		int answersLenght = 0;
		int goodAnswerNb = 0;
		float finalScore=0;
		String goodAnswer;
		String userAnswer;
		String answers[]; 
		Saisie netResponse = new Saisie();

		questionNumber = saisie.getInt();

		if(Integer.valueOf(questionNumber) >= 1 ) {
			String rep = netResponse.getUrlResponse("https://opentdb.com/api.php?amount="+questionNumber);
			JSONObject tables = new JSONObject(rep);
			JSONArray table = tables.getJSONArray("results");
			for (int i=0;i<table.length();i++) {

				// Recuperation de la question et des réponses
				JSONObject qr = table.getJSONObject(i);  // question/réponse
				JSONArray badAnswers = qr.getJSONArray("incorrect_answers");

				answersLenght = badAnswers.length()+1;
				answers = new String[answersLenght];

				for(int j = 0; j<answersLenght-1;j++) {
					answers[j]=badAnswers.getString(j);
				}
				answers[answersLenght-1] = qr.getString("correct_answer");

				this.msg = qr.getString("question");

				// Affichage des questions et reponse			
				prompt.shown("[quiz] "+ this.msg);
				goodAnswer = String.valueOf(shuffleTabl(answers));
				prompt.showTabl(answers);
				prompt.show(saisie.getUserName());

				userAnswer=saisie.getLine();					

				if(userAnswer.equals("@stop")==true)
					break;

				if(userAnswer.equals(goodAnswer) == true) {
					goodAnswerNb++;
					prompt.shown("[quiz] Bonne réponse !");
				}
				else {
					prompt.shown("[quiz] Mauvaise réponse ! La bonne réponse était: "+answers[Integer.valueOf(goodAnswer)]);
				}

			}
			finalScore = goodAnswerNb/questionNumber * 100;
			prompt.shown("[quiz] Score final: "+finalScore+" % de bonnes réponses"+" ("+goodAnswerNb+"/"+questionNumber+")");
		}
	}

}
