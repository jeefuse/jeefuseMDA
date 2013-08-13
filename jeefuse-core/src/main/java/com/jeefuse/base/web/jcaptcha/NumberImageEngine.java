package com.jeefuse.base.web.jcaptcha;

import java.awt.Font;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FunkyBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.RandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

/**
 * 生成数字验证码.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class NumberImageEngine extends ListImageCaptchaEngine {
	final private int minWordLength = 4;
	final private int maxWordLength = 5;
	final private int fontSize = 18;
	final private int imageWidth = 100;
	final private int imageHeight = 30;

	@Override
	protected void buildInitialFactories() {
		// 随机生成的字符
		WordGenerator wgen = new RandomWordGenerator("123456789");
		RandomRangeColorGenerator cgen = new RandomRangeColorGenerator(new int[] { 0, 100 }, new int[] { 0, 100 },
				new int[] { 0, 100 });
		// 文字显示的个数
		TextPaster textPaster = new RandomTextPaster(minWordLength, maxWordLength, cgen, true);
		// 图片的大小
		BackgroundGenerator backgroundGenerator = new FunkyBackgroundGenerator(imageWidth, imageHeight);
		// 字体格式
		Font[] fontsList = new Font[] { new Font("Arial", 0, fontSize), new Font("Tahoma", 0, fontSize),
				new Font("Verdana", 0, fontSize), };
		// 文字的大小
		FontGenerator fontGenerator = new RandomFontGenerator(fontSize, fontSize, fontsList);
		WordToImage wordToImage = new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster);
		this.addFactory(new GimpyFactory(wgen, wordToImage));

	}

}
