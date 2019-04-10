package com.yiwei.ywt.framework.web;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码生成器. <p />
 * <p/>
 * Created by czy on 15/9/23.
 */
public final class VerifyCode {

    public final static String VERIFY_CODE_SESSION_KEY = "WEB_VERIFY_CODE";

    private static final String[] RANDTEXTARRAY = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "2", "3",
            "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private BufferedImage image;

    private String code;

    public VerifyCode(int width, int height) {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = this.image.getGraphics();
        graphics.setColor(getRandColor(200, 250));
        graphics.fillRect(0, 0, width, height);
        Random rdd = new Random();
        StringBuilder buffer = new StringBuilder();
        graphics.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int xxx = rdd.nextInt(width);
            int yyy = rdd.nextInt(height);
            int xll = rdd.nextInt(12);
            int yll = rdd.nextInt(12);
            graphics.drawLine(xxx, yyy, xxx + xll, yyy + yll);
        }
        // 验证码
        graphics.setFont(new Font("Courier New", Font.BOLD, 24));
        for (int i = 0; i < 4; i++) {
            buffer.append(RANDTEXTARRAY[rdd.nextInt(RANDTEXTARRAY.length)]);
            graphics.setColor(new Color(20 + rdd.nextInt(110), 20 + rdd.nextInt(110), 20 + rdd.nextInt(110)));
            graphics.drawString(buffer.charAt(i) + "", 5 + i * 18, 25);
        }
        // 干扰线
        for (int i = 0; i < 5; i++) {
            graphics.setColor(new Color(rdd.nextInt(200), rdd.nextInt(200), rdd.nextInt(200)));
            graphics.drawLine(rdd.nextInt(width), rdd.nextInt(height), rdd.nextInt(width), rdd.nextInt(height));
        }
        this.code = buffer.toString();
    }

    private Color getRandColor(int fcc, int bcc) {
        Random random = new Random();
        if (fcc > 255) {
            fcc = 255;
        }
        if (bcc > 255) {
            bcc = 255;
        }
        int rrr = fcc + random.nextInt(bcc - fcc);
        int ggg = fcc + random.nextInt(bcc - fcc);
        int bbb = fcc + random.nextInt(bcc - fcc);
        return new Color(rrr, ggg, bbb);
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getCode() {
        return code;
    }
}
