package ie.tudublin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.lang.model.element.Element;
import javax.swing.border.Border;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	ArrayList<Note> notes = new ArrayList<Note>();

	public float border;
	
	public void settings()
	{
		size(500, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
		
	}

	public void loadScore()
	{

		for(int j = 0;j < score.length();j++)
		{
			if(score.charAt(j) != '2')
			{	
				if(j + 1 < score.length() && score.charAt(j+1) == '2'){
					notes.add(new Note(score.charAt(j),2));
				}else{
					notes.add(new Note(score.charAt(j),1));
				}
			}
		} 
		
		for(int i = 0;i<notes.size();i++)
		{
			if(score.charAt(i) != '2')
			{
				System.out.println(notes.get(i) + "     Crotchet");
			}else{
				System.out.println(notes.get(i) + "     Quaver");
			}
			
		}
		 
	}

	public void printScore()
	{

		for(int i = 0;i<notes.size();i++)
		{
			System.out.println(notes.get(i) + " ");
		}

	}

	public void setup() 
	{
		loadScore();
		border = width * 0.3f;
	}

	public void draw()
	{
		background(255);
		lines();
		
	}

	void drawNotes()
	{
		for(int i = 0;i < notes.size();i++)
		{
			float x = map(i,0,5,border,width - border);
			float y = map(i,0,5,border,height - border);
			stroke(0);
			circle(x, y, 100);

		}
		
	}

	public void lines()
	{
		background(255);

		for(int i = 0 ; i <=5 ; i++)
		{ 	
			
			float x = map(i,0,5,border,width - border);
			stroke(0);
			line(border,x,height-border,x);
		}
	}
}
