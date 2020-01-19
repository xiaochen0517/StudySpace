package com.lxc.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/identcode")
public class IdentCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);

        //字符集
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefgjijklmnopqrstuvwxyz";

        //随机数
        Random ran = new Random();

        //绘制验证码
        for (int i = 0; i < 4; i++) {
            //获取随机字符
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            //获取随机色
            Color randomColor = getRandomColor(ran);
            g.setColor(randomColor);
            //设置字体
            Font font = new Font("宋体", Font.BOLD, height / 2);
            g.setFont(font);
            //写入验证码
            g.drawString(ch + "", (i == 0) ? width / 4 * i + 2 : width / 4 * i, height - height / 4);
        }

        //干扰线
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            Color randomColor = getRandomColor(ran);
            g.setColor(randomColor);
            g.drawLine(x1, x2, y1, y2);
        }

        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    private Color getRandomColor(Random random) {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
