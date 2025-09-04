package chapter08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HighestColoredTower {
    public static void main(String[] args) {
        Tower tower = getTower();
        int highestTowerHeight = tower.highestTowerIterative();
        System.out.println(highestTowerHeight);

        highestTowerHeight = tower.build();
        System.out.println(highestTowerHeight);
    }

    private static Tower getTower() {
        ColoredBox c1 = new ColoredBox("RED", 14, 20);
        ColoredBox c2 = new ColoredBox("PURPLE", 10, 7);
        ColoredBox c3 = new ColoredBox("YELLOW", 1, 10);
        ColoredBox c4 = new ColoredBox("PURPLE", 10, 3);
        ColoredBox c5 = new ColoredBox("PURPLE", 7, 5);
        ColoredBox c6 = new ColoredBox("PURPLE", 5, 7);
        ColoredBox c7 = new ColoredBox("PURPLE", 2, 18);

        List<ColoredBox> boxes = new ArrayList<>();
        boxes.add(c1);
        boxes.add(c2);
        boxes.add(c3);
        boxes.add(c4);
        boxes.add(c5);
        boxes.add(c6);
        boxes.add(c7);

        return new Tower(boxes);
    }

}

class Tower {
    List<ColoredBox> boxes;

    public Tower(List<ColoredBox> boxes) {
        this.boxes = boxes;
    }

    public int highestTowerIterative() {
        // sort the boxes by height;
        //boxes.sort(Comparator.comparingInt(o -> o.width));
        Collections.sort(boxes, new Comparator<ColoredBox>() {
            @Override
            public int compare(ColoredBox b1, ColoredBox b2) {
                return Integer.compare(b2.width, b1.width);
            }
        });
        int maxHeight = 0;

        for (int i = 0; i < boxes.size(); i++) {
            ColoredBox boxi = boxes.get(i);
            int towerHt = boxi.height;
            for (int j = i + 1; j < boxes.size(); j++) {
                ColoredBox boxj = boxes.get(j);
                if (boxi.canBeNext(boxj)) {
                    towerHt += boxi.height + boxj.height;
                }
            }
            maxHeight = Math.max(towerHt, maxHeight);
           // System.out.println(" max until now: " + maxHeight);
        }

        return maxHeight;
    }

    public int build() {

        if (boxes == null) {
            return -1;
        }

        // sorting boxes by width (you can do it by height as well)
        Collections.sort(boxes, new Comparator<ColoredBox>() {
            @Override
            public int compare(ColoredBox b1, ColoredBox b2) {
                return Integer.compare(b2.width, b1.width);
            }
        });

        // the boxes after sorting them descending by width
        //boxes.forEach(System.out::println);

        // place each box as the base (bottom box) and
        // try to arrange the rest of the boxes
        int highest = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = build(boxes, i);

            highest = Math.max(highest, height);
        }

        return highest;
    }

    // plain recursion
    private int build(List<ColoredBox> boxes, int base) {

        ColoredBox current = boxes.get(base);

        int highest = 0;
        // since the boxes are sorted we don't look in [0, base + 1)
        for (int i = base + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeNext(current)) {

                int height = build(boxes, i);
                highest = Math.max(height, highest);
            }
        }

        highest = highest + current.height;

        return highest;
    }

    static int buildTower(List<ColoredBox> boxes, int base) {
        ColoredBox currentBox = boxes.get(base);
        int towerHeight = 0, maxHeight = 0;

        for (int i = base + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeNext(currentBox)) {
                towerHeight = buildTower(boxes, i);
                maxHeight = Math.max(maxHeight, towerHeight);
            }
        }
        maxHeight += currentBox.height;
        return maxHeight;
    }
}

class ColoredBox {
    String color;
    int width;
    int height;

    public ColoredBox(String color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public boolean canBeNext(ColoredBox box) {
        if (box == null) {
            return false;
        }
        boolean b = (box.width > this.width) && (box.height > this.height)
                && !(box.color.equals(this.color));

        //System.out.println("comparing : box: " + box + " with the box: " + this  + " result : " + b);

        return b;
    }

    public String toString() {
        return "Colored Box [ color = " + this.color + ", width = " + this.width + " height = " + height + "]";
    }
}