package com.java.swing.horoscope;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Datas {
	Scanner input;
	private int mark = 1;
	private int month;
	private int day;

	ArrayList<String> list = new ArrayList<String>();

	Datas() {
		month = 0;
		day = 0;
	}

	Datas(int month, int day) {
		this.month = month;
		this.day = day;
		markNum();
		match();
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	/**
	 * @Description 
	 * ˮƿ:1 
	 * ˫��:2 
	 * ����:3 
	 * ��ţ:4 
	 * ˫��:5 
	 * ��з:6 
	 * ʨ��:7 
	 * ��Ů:8 
	 * ��ƽ:9 
	 * ��Ы:10 
	 * ����:11 
	 * Ħ��:12
	 */
	public void match() {
		try {
			input = new Scanner(new File("D:\\Java\\Eclipse\\Horoscopes\\src\\com\\java\\swing\\horoscope\\data.txt"));
			while (input.hasNext()) {
				String s = input.nextLine();
				if (s.equals("" + mark)) {
					for (int i = 0; i < 3; i++) {
						list.add(input.nextLine());
						// System.out.println(list.get(i));
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void markNum() {
		switch (month) {
		case 1:
			if (day >= 20)
				mark = 1;
			else
				mark = 12;
			break;
		case 2:
			if (day <= 18)
				mark = 1;
			else
				mark = 2;
			break;
		case 3:
			if (day <= 20)
				mark = 2;
			else
				mark = 3;
			break;
		case 4:
			if (day <= 20)
				mark = 3;
			else
				mark = 4;
			break;
		case 5:
			if (day <= 20)
				mark = 4;
			else
				mark = 5;
			break;
		case 6:
			if (day <= 21)
				mark = 5;
			else
				mark = 6;
			break;
		case 7:
			if (day <= 22)
				mark = 6;
			else
				mark = 7;
			break;
		case 8:
			if (day <= 22)
				mark = 7;
			else
				mark = 8;
			break;
		case 9:
			if (day <= 22)
				mark = 8;
			else
				mark = 9;
			break;
		case 10:
			if (day <= 18)
				mark = 9;
			else
				mark = 10;
			break;
		case 11:
			if (day <= 22)
				mark = 10;
			else
				mark = 11;
			break;
		case 12:
			if (day <= 21)
				mark = 11;
			else
				mark = 12;
			break;
		}
	}
}