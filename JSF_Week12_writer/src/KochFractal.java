/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Observable;

/**
 *
 * @author Peter Boots
 */
public class KochFractal extends Observable {

    private Writer writer = new Writer();
    private int level = 1;      // The current level of the fractal
    private int nrOfEdges = 3;  // The number of edges in the current level of the fractal
    private float hue;          // Hue value of color for next edge
    private boolean cancelled;  // Flag to indicate that calculation has been cancelled 

    private void drawKochEdge(double ax, double ay, double bx, double by, int n) {
        try{
            if (!cancelled) {
                if (n == 1) {
                    hue = hue + 1.0f / nrOfEdges;
                    Edge e = new Edge(ax, ay, bx, by, Color.hsb(hue * 360.0, 1.0, 1.0));
                    writer.binaireBuffered(e, true);
                    writer.writeTextNotBuffered(e.getString(), true);
                    writer.writeTextBuffered(e.getString(), true);
                    writer.binaireNotBuffered(e, true);
                } else {
                    double angle = Math.PI / 3.0 + Math.atan2(by - ay, bx - ax);
                    double distabdiv3 = Math.sqrt((bx - ax) * (bx - ax) + (by - ay) * (by - ay)) / 3;
                    double cx = Math.cos(angle) * distabdiv3 + (bx - ax) / 3 + ax;
                    double cy = Math.sin(angle) * distabdiv3 + (by - ay) / 3 + ay;
                    final double midabx = (bx - ax) / 3 + ax;
                    final double midaby = (by - ay) / 3 + ay;
                    drawKochEdge(ax, ay, midabx, midaby, n - 1);
                    drawKochEdge(midabx, midaby, cx, cy, n - 1);
                    drawKochEdge(cx, cy, (midabx + bx) / 2, (midaby + by) / 2, n - 1);
                    drawKochEdge((midabx + bx) / 2, (midaby + by) / 2, bx, by, n - 1);
                }
            }
        } catch(IOException iox) {
            iox.printStackTrace();
        }
    }

    public void generateLeftEdge() {
        hue = 0f;
        cancelled = false;
        drawKochEdge(0.5, 0.0, (1 - Math.sqrt(3.0) / 2.0) / 2, 0.75, level);
    }

    public void generateBottomEdge() {
        hue = 1f / 3f;
        cancelled = false;
        drawKochEdge((1 - Math.sqrt(3.0) / 2.0) / 2, 0.75, (1 + Math.sqrt(3.0) / 2.0) / 2, 0.75, level);
    }

    public void generateRightEdge() {
        hue = 2f / 3f;
        cancelled = false;
        drawKochEdge((1 + Math.sqrt(3.0) / 2.0) / 2, 0.75, 0.5, 0.0, level);
    }

    public void cancel() {
        cancelled = true;
    }

    public void setLevel(int lvl) {
        level = lvl;
        nrOfEdges = (int) (3 * Math.pow(4, level - 1));
        generateLeftEdge();
        generateRightEdge();
        generateBottomEdge();
    }

    public int getLevel() {
        return level;
    }

    public int getNrOfEdges() {
        return nrOfEdges;
    }
}
