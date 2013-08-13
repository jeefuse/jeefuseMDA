package com.jeefuse.base.utils.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 图片调整大小
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ImageResize {

	public static BufferedImage resize(BufferedImage source, int ptargetW, int ptargetH) {
		// targetW，targetH分别表示目标长和宽
		int tempW = ptargetW;
		int tempH = ptargetH;
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) tempW / source.getWidth();
		double sy = (double) tempH / source.getHeight();
		// 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
		// 则将下面的if else语句注释即可
		if (sx > sy) {
			sx = sy;
			tempW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			tempH = (int) (sy * source.getHeight());
		}
		if (type == BufferedImage.TYPE_CUSTOM) { // handmade
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(tempW, tempH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else {
			target = new BufferedImage(tempW, tempH, type);
		}
		Graphics2D g = target.createGraphics();
		// smoother than exlax:
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

	/**
	 * 图片超出指定大小时转换成指定大小.
	 * 
	 * @param fromFilePath
	 *            源路径
	 * @param saveToFilePath
	 *            保存路径
	 * @param width
	 *            指定长度
	 * @param hight
	 *            指定高度
	 * @throws Exception
	 */
	public static void resizeIfExceed(String fromFilePath, String saveToFilePath, int width, int hight) throws Exception {
		BufferedImage srcImage;
		String imgType = "JPEG";
		if (fromFilePath.toLowerCase().endsWith(".png")) {
			imgType = "PNG";
		}
		File fromFile = new File(fromFilePath);
		srcImage = ImageIO.read(fromFile);
		int srcW = srcImage.getWidth();
		int srch = srcImage.getHeight();
		if (srcW != width || srch != hight) {
			srcImage = resize(srcImage, width, hight);
		}
		File saveFile = new File(saveToFilePath);
		ImageIO.write(srcImage, imgType, saveFile);

	}

	public static void resize(String fromFilePath, String saveToFilePath, int width, int hight) throws Exception {
		BufferedImage srcImage;
		String imgType = "JPEG";
		if (fromFilePath.toLowerCase().endsWith(".png")) {
			imgType = "PNG";
		}
		File saveFile = new File(saveToFilePath);
		File fromFile = new File(fromFilePath);
		srcImage = ImageIO.read(fromFile);
		if (width > 0 || hight > 0) {
			srcImage = resize(srcImage, width, hight);
		}
		ImageIO.write(srcImage, imgType, saveFile);

	}

}
