package com.lxc.util;

import java.awt.*;
import java.util.Random;

public class ColorUtils {

    public static Color getRandomColor(Random random) {
        //获取随机颜色
        int colorIndex = random.nextInt(3);
        switch (colorIndex) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.RED;
            case 3:
                return Color.YELLOW;
            default:
                return Color.MAGENTA;
        }
    }
}
