package edu.umkc.mcz5d.reversi;

import android.R.string;

public class LogicForOne {
	private static int SCALE = 8;
	private static String direction;

	public boolean validMoveToColor(int[][] map, int x, int y, int color) {
		boolean result = false;
		// Condition: left
		if (doesExist(x - 1, y) && map[x - 1][y] != 0 && map[x - 1][y] != color) {
			// the opposite color
			int nextX = x - 1;
			int nextY = y;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0 && map[nextX][nextY] != color) {
				nextX--;// move left
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX) {
				// valid move and will change the color of all pieces between
				// (x,y) and (nextX,nextY)
				// call changeColor method
				direction = "left";
				changeColor(map,x,y,nextX,nextY,"left",color);
				result = true;
			}
		}
		// Condition: upper left
		if (doesExist(x - 1, y - 1) && map[x - 1][y - 1] != 0 && map[x - 1][y - 1] != color) {
			// the opposite color
			int nextX = x - 1;
			int nextY = y - 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX--;// move left
				nextY--;// move up
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX&&y!=nextY) {
				// valid move and will change the color of all pieces between
				// (x,y) and (nextX,nextY)
				// call changeColor method
				direction = "upperLeft";
				changeColor(map,x,y,nextX,nextY,"upperLeft",color);
				result = true;
			}
		}
		// Condition: up
		if (doesExist(x, y - 1) && map[x][y - 1] != 0 && map[x][y - 1] != color) {
			// the opposite color
			int nextX = x;
			int nextY = y - 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextY--;// move up
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&y!=nextY) {
				// valid move and will change the color of all pieces between
				// (x,y) and (nextX,nextY)
				// call changeColor method
				direction = "up";
				changeColor(map,x,y,nextX,nextY,"up",color);
				result = true;
			}
		}
		// Condition: upper right
		if (doesExist(x + 1, y - 1) && map[x + 1][y - 1] != 0 && map[x + 1][y - 1] != color) {
			// the opposite color
			int nextX = x + 1;
			int nextY = y - 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX++;
				nextY--;// move up
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX&&y!=nextY) {
				// valid move and will change the color of all pieces between
				// (x,y) and (nextX,nextY)
				// call changeColor method
				direction = "upperRight";
				changeColor(map,x,y,nextX,nextY,"upperRight",color);
				result = true;
			}
		}
		// Condition: right
		if (doesExist(x + 1, y) && map[x + 1][y] != 0 && map[x + 1][y] != color) {
			// the opposite color
			int nextX = x + 1;
			int nextY = y;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX++;
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX) {
				// valid move and will change the color of all pieces between
				// (x,y) and (nextX,nextY)
				// call changeColor method
				direction = "right";
				changeColor(map,x,y,nextX,nextY,"right",color);
				result = true;
			}
		}
		// Condition: right corner
		if (doesExist(x + 1, y + 1) && map[x + 1][y + 1] != 0 && map[x + 1][y + 1] != color) {
			// the opposite color
			int nextX = x + 1;
			int nextY = y + 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX++;
				nextY++;
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX&&y!=nextY) {
				// valid move and will change the color of all pieces between
				// (x,y) and (nextX,nextY)
				// call changeColor method
				direction = "rightCorner";
				changeColor(map,x,y,nextX,nextY,"rightCorner",color);
				result = true;
			}
		}
		// Condition: down
		if (doesExist(x, y + 1) && map[x][y + 1] != 0 && map[x][y + 1] != color) {
			// the opposite color
			int nextX = x;
			int nextY = y + 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextY++;
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&y!=nextY) {
				// valid move and will change the color of all pieces between
				// (x,y) and (nextX,nextY)
				// call changeColor method
				direction = "down";
				changeColor(map,x,y,nextX,nextY,"down",color);
				result = true;
			}
		}
		// Condition: left corner
		if (doesExist(x - 1, y + 1) && map[x - 1][y + 1] != 0 && map[x - 1][y + 1] != color) {
			// the opposite color
			int nextX = x - 1;
			int nextY = y + 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX--;
				nextY++;
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX&&y!=nextY) {
				// valid move and will change the color of all pieces between
				// (x,y) and (nextX,nextY)
				// call changeColor method
				direction = "leftCorner";
				changeColor(map,x,y,nextX,nextY,"leftCorner",color);
				result = true;
			}
		}
		return result;

	}

	public boolean doesExist(int x, int y) {
		if (x < 0 || y < 0) {
			return false;
		}
		if (x >= SCALE || y >= SCALE) {
			return false;
		}

		return true;
		
	}
	
	public void changeColor(int [][] map, int x, int y, int nextX, int nextY, String direction, int color){
		switch(direction){
		case"left":{
			for(int i = x-1; i > nextX ; i--){
				map[i][y] = color;
			}
		}break;
		case"upperLeft":{
			for(int i = x-1, j = y-1; i > nextX; i--,j--){
				if(j>nextY){
					map[i][j] = color;
				}
			}
		}break;
		case"up":{
			for(int i = y-1; i > nextY ; i--){
				map[x][i] = color;
			}
		}break;
		case"upperRight":{
			for(int i = x+1, j = y-1; i < nextX ; i++,j--){
				
				if(j>nextY){
					map[i][j] = color;
				}
				
			}
		}break;
		case"right":{
			for(int i = x+1; i < nextX ; i++){
				map[i][y] = color;
			}
		}break;
		case"rightCorner":{
			for(int i = x+1, j=y+1; i < nextX ; i++,j++){
				if(j < nextY){
					map[i][j] = color;
				}
				
			}
		}break;
		case"down":{
			for(int i = y+1; i < nextY ; i++){
				map[x][i] = color;
			}
		}break;
		case"leftCorner":{
			for(int i = x-1, j=y+1; i > nextX ; i--, j++){
				if(j < nextY){
					map[i][j] = color;
				}
				
			}
		}break;
		}
	}
	
	public boolean gameOver(int[][] map){
		boolean result = true;
		for(int i=0; i<SCALE; i++){
			for(int j=0;j<SCALE; j++){
				if(map[i][j] == 0){
					result = false;
				}
			}
		}
		return result;
	}
	
	public boolean validMove(int[][] map, int x, int y, int color) {
		boolean result = false;
		// Condition: left
		if (doesExist(x - 1, y) && map[x - 1][y] != 0 && map[x - 1][y] != color) {
			// the opposite color
			int nextX = x - 1;
			int nextY = y;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0 && map[nextX][nextY] != color) {
				nextX--;// move left
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX) {
				
				result = true;
			}
		}
		// Condition: upper left
		if (doesExist(x - 1, y - 1) && map[x - 1][y - 1] != 0 && map[x - 1][y - 1] != color) {
			// the opposite color
			int nextX = x - 1;
			int nextY = y - 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX--;// move left
				nextY--;// move up
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX&&y!=nextY) {
				
				result = true;
			}
		}
		// Condition: up
		if (doesExist(x, y - 1) && map[x][y - 1] != 0 && map[x][y - 1] != color) {
			// the opposite color
			int nextX = x;
			int nextY = y - 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextY--;// move up
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&y!=nextY) {
				
				result = true;
			}
		}
		// Condition: upper right
		if (doesExist(x + 1, y - 1) && map[x + 1][y - 1] != 0 && map[x + 1][y - 1] != color) {
			// the opposite color
			int nextX = x + 1;
			int nextY = y - 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX++;
				nextY--;// move up
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX&&y!=nextY) {
				
				result = true;
			}
		}
		// Condition: right
		if (doesExist(x + 1, y) && map[x + 1][y] != 0 && map[x + 1][y] != color) {
			// the opposite color
			int nextX = x + 1;
			int nextY = y;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX++;
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX) {
				
				result = true;
			}
		}
		// Condition: right corner
		if (doesExist(x + 1, y + 1) && map[x + 1][y + 1] != 0 && map[x + 1][y + 1] != color) {
			// the opposite color
			int nextX = x + 1;
			int nextY = y + 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX++;
				nextY++;
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX&&y!=nextY) {
				
				result = true;
			}
		}
		// Condition: down
		if (doesExist(x, y + 1) && map[x][y + 1] != 0 && map[x][y + 1] != color) {
			// the opposite color
			int nextX = x;
			int nextY = y + 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextY++;
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&y!=nextY) {
				
				result = true;
			}
		}
		// Condition: left corner
		if (doesExist(x - 1, y + 1) && map[x - 1][y + 1] != 0 && map[x - 1][y + 1] != color) {
			// the opposite color
			int nextX = x - 1;
			int nextY = y + 1;
			// next position does exist; not empty; not the same color;
			while (doesExist(nextX, nextY) && map[nextX][nextY] != 0
					&& map[nextX][nextY] != color) {
				nextX--;
				nextY++;
			}

			if (doesExist(nextX, nextY) && map[nextX][nextY] == color&&x!=nextX&&y!=nextY) {
				
				result = true;
			}
		}
		return result;

	}


}
