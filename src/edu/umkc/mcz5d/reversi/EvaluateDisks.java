package edu.umkc.mcz5d.reversi;

public class EvaluateDisks {
	private int player;
	private EvaluationMethod evalMethod;
	private enum EvaluationMethod{
		VALID_MOVES_AND_TOTAL_SCORE,VALID_MOVES_AND_SIDE_COUNT,VALID_MOVES_AND_CORNERS
	}
	
	public EvaluateDisks(){
		player = 1;
		evalMethod = EvaluateDisks.EvaluationMethod.VALID_MOVES_AND_CORNERS;
	}
	
	public EvaluateDisks(int player, EvaluationMethod evalMethod){
		this.player = player;
		this.evalMethod = evalMethod;
		
	}


}
