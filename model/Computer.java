package model;


import lombok.Data;

@Data

public class Computer {
	
	public static int generateOption() {

        int num = (int) (Math.random() * 5) + 1;

        return num;
	}
	
}