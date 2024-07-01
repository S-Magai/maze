import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SimpleTimer class to measure elapsed time.
 */
public class SimpleTimer {
    private long lastMark = System.currentTimeMillis();
    
    public void mark() {
        lastMark = System.currentTimeMillis();
    }
    
    public long millisElapsed() {
        return System.currentTimeMillis() - lastMark;
    }
}
