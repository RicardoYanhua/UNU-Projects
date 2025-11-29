package Util.Shadow;

import Util.Shadow.ShadowRenderer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

//  Create By Raven
public class ShadowIn {

    private static ShadowIn instance;

    private ShadowIn() {
    }

    public static ShadowIn getInstance() {
        if (instance == null) {
            instance = new ShadowIn();
        }
        return instance;
    }

    public BufferedImage createShadowIn(Component com, int border, int radius) {
        return createShadowIn(com.getWidth(), com.getHeight(), border, radius, com.getBackground());
    }

    private Shape splite(int width, int height) {
        Path2D.Float p = new Path2D.Float();
        p.moveTo(width, 0);
        p.lineTo(width, height);
        p.lineTo(0, height);
        return p;
    }

    public BufferedImage createShadowIn(int width, int height, int border, int radius, Color color) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = border;
        int y = border;
        int size = radius;
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, border, border);
        Shape s = new RoundRectangle2D.Double(x, y, width - border * 2, height - border * 2, size, size);
        Area area = new Area(new Rectangle(0, 0, width - border, height - border));
        area.subtract(new Area(s));
        area.subtract(new Area(splite(width, height)));
        g2.drawImage(new ShadowRenderer(border, 0.4f, new Color(39,41,52)).createShadow(createImage(width, height, area)), -border, -border, null);
        //  White
        Shape s_w = new RoundRectangle2D.Double(x, y, width - border * 2, height - border * 2, size, size);
        Area area_w = new Area(new Rectangle(0, 0, width, height));
        area_w.subtract(new Area(s_w));
        area_w.intersect(new Area(splite(width, height)));
        g2.drawImage(new ShadowRenderer(border, 1f, new Color(130, 130, 130)).createShadow(createImage(width, height, area_w)), -border, -border, null);
        g2.fill(area);
        g2.fill(area_w);

        //g2.setColor(new Color(250,250,250));
        //g2.drawRoundRect(x, y, (width - border * 2)-1, (height - border * 2)-1, radius, radius);

        g2.setComposite(AlphaComposite.Clear);
        Shape cut = new RoundRectangle2D.Double(x, y, width - border * 2, height - border * 2, size, size);
        Area bg = new Area(new Rectangle(0, 0, width, height));
        bg.subtract(new Area(cut));
        g2.fill(bg);
        g2.dispose();

        return img;
    }

    private BufferedImage createImage(int width, int height, Area area) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(area);

        return img;
    }

    public static enum ShadowType {
        IN_SHADOW
    }
}
