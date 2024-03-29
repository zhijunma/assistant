package com.cn.assistant.entity;

import javax.swing.*;
import java.awt.*;

public class SoftIcons {

	public Image[] SLEEP_IMG = new Image[36];

	public Image[] WAIT_IMG = new Image[8];

	public Image[] SPEAK_IMG = new Image[10];

	public Image[] DANCE_IMG = new Image[73];

	public Image[] JUMP_IMG = new Image[8];

	public static final Image DIALOG_IMG = new ImageIcon("image/win/dialog.png").getImage();

	public static final Image DIALOG_IMG2 = new ImageIcon("image/win/dialog2.png").getImage();

	public static final Image ICON_IMG = new ImageIcon("image/icon/icon.png").getImage();

	public SoftIcons(){

		for(int i=0;i<36;i++){
			SLEEP_IMG[i] = new ImageIcon("image/sleep/sleep"+i+".png").getImage();
		}

		for(int i=0;i<8;i++){
			WAIT_IMG[i] = new ImageIcon("image/wait/wait"+i+".png").getImage();
		}

		for(int i=0;i<10;i++){
			SPEAK_IMG[i] = new ImageIcon("image/speak/speak"+i+".png").getImage();
		}

		for(int i=0;i<73;i++){
			DANCE_IMG[i] = new ImageIcon("image/dance/dance0"+i+".png").getImage();
		}

		for(int i=0;i<8;i++){
			JUMP_IMG[i] = new ImageIcon("image/jump/jump00"+i+".png").getImage();
		}

	}

}
