import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Label class that allows you to display a textual value on screen.
 */
public class Label extends Actor {
    private GreenfootImage image;
    private String text;
    private int fontSize;

    public Label(String text, int fontSize) {
        this.text = text;
        this.fontSize = fontSize;
        updateImage();
    }

    public void setValue(String value) {
        this.text = value;
        updateImage();
    }

    private void updateImage() {
        image = new GreenfootImage(text, fontSize, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(image);
    }
}
