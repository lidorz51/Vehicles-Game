package graphics;

import java.awt.Graphics;

public interface IDrawable {
	 public final static String PICTURE_PATH = "C:\\Users\\lidor\\Desktop\\Yoav Yung id-203127329 ,Lidor zaguri id-205622814\\images\\";
	 public void loadImages(String nm);
	 public void drawObject (Graphics g);
	 public String getColor();

}
