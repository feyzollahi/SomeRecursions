import java.util.HashMap;
import java.util.Map;

public class Htree {

    // plot an H, centered on (x, y) of the given side length
    public static void drawH(double x, double y, double size) {

        // compute the coordinates of the 4 tips of the H
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;

        // draw the 3 line segments of the H
        StdDraw.line(x0, y0, x0, y1);    // left  vertical segment of the H
        StdDraw.line(x1, y0, x1, y1);    // right vertical segment of the H
        StdDraw.line(x0,  y, x1,  y);    // connect the two vertical segments of the H
    }

    // plot an order n H-tree, centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;
        Map<String, String> details = new HashMap<>();
        details.put("size", String.valueOf(size));
        details.put("n", String.valueOf(n));
        details.put("x", String.valueOf(x));
        details.put("y", String.valueOf(y));
        Log log = new Log(n, details);
        log.write();
        drawH(x, y, size);


        // compute x- and y-coordinates of the 4 half-size H-trees
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;

        details.put("description", "H drawn!! but children remain!! children of this level will draw 4 tree with size: " + String.valueOf(size/2) +
                " with coordinates: " + "(" + x0 + "," + y0 + ") and "+ "(" + x0 + "," + y1 + ")" +
                        " and "+ "(" + x1 + "," + y0 + ") and "+ "(" + x1 + "," + y1 + ")" );
        log.setDetails(details);
        log.write();
        // recursively draw 4 half-size H-trees of order n-1
        draw(n-1, x0, y0, size/2);    // lower left  H-tree
        draw(n-1, x0, y1, size/2);    // upper left  H-tree
        draw(n-1, x1, y0, size/2);    // lower right H-tree
        draw(n-1, x1, y1, size/2);    // upper right H-tree
    }

    // reads an integer command-line argument n and plots an order n H-tree
    public static void main(String[] args) {
        int n = 6;
        Log.levelsNumber = n;
        Log.levelDefaultAsc = false;
        double x = 0.5, y = 0.5;   // center of H-tree
        double size = 0.5;         // side length of H-tree
        draw(n, x, y, size);
    }
}

