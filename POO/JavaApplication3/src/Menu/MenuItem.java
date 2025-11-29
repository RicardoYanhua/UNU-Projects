package Menu;

import System.SystemColor;
import Util.Shadow.ShadowRenderer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MenuItem extends JPanel {

    private final List<EventMenuSelected> events = new ArrayList<>();
    private final int index;

    public MenuItem(ModelMenuItem item, int index, MigLayout layout) {
        this.index = index;
        init(item);

    }

    private void init(ModelMenuItem item) {
        setOpaque(false);
        setForeground(new Color(245, 249, 250));
        setLayout(new MigLayout("wrap,fillx,inset 0", "[fill]", "[fill,35!]"));
        Item menu = new Item(true, 0);
        menu.setGoogleIcon(item.getIcon());
        menu.setText("  " + item.getMenuName());
        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(menu.getMainColor());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!menu.isSelected()) {
                    setForeground(new Color(245, 249, 250));
                }
            }
        });
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                runEvent(index);

            }
        });

        add(menu);
    }

    public void addEvent(EventMenuSelected event) {
        this.events.add(event);
    }

    private void runEvent(int index) {
        for (EventMenuSelected evnet : events) {
            evnet.menuSelected(index);
        }
    }

    public int getIndex() {
        return index;
    }

    public void clearSelected() {
        setForeground(new Color(245, 249, 250));
        for (Component com : getComponents()) {
            Item item = (Item) com;
            item.setSelected(false);
        }
    }

    public void setSelectedIndex(int index) {
        for (Component com : getComponents()) {
            Item item = (Item) com;
            if (item.isMainMenu()) {
                item.setSelected(true);
                setForeground(item.getMainColor());
            }
            if (item.getIndex() == index) {
                item.setSelected(true);
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        createShadow(g);

        super.paintComponent(g);

    }

    /*
    private void createShadow(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;

        int s_s = 11;
        int s_w = 18;

        BufferedImage img = new BufferedImage(s_w, s_w, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillOval(0, 0, s_w, s_w);
        ShadowRenderer render = new ShadowRenderer(s_s, 0.9f, SystemColor.MAIN_COLOR_1);
        g2.drawImage(render.createShadow(img), 6, 7, null);
    }
     */
    private void createShadow(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;

        BufferedImage img = new BufferedImage(13, 13, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setColor(getBackground());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillOval(0, 0, 13, 13);
        ShadowRenderer render = new ShadowRenderer(11, 0.7f, SystemColor.MAIN_COLOR_1);
        g2.drawImage(render.createShadow(img), 11, 0, null);
    }
}
