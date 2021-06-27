package com.jhs.exam.exam2.util;

import java.util.Random;

public class random {
	
	public String getRand() {
		String temp = "";
        Random rnd = new Random();
        for (int i = 0; i < 3; i++) {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
                temp+=((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                 temp+=((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                // 0-9
                 temp+=((rnd.nextInt(10)));
                break;
            }
        }
        System.out.println(temp);
        return temp;
	}
        
}