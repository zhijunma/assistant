package com.cn.assistant.service;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Posthtml {

	public static String getDocument(String url) {
		String text = "";
		try {
			// ���ñ��뼯
			org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
			// ��ȡdiv�е��ı���Ϣ
			Elements divs = doc.select("div[class=v]");
			for (org.jsoup.nodes.Element link : divs) {
				text += link.text() + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return text;
	}
}
