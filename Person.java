import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @your_name (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor {
    public void act() {
        // Add your action code here.
        moveAround();
        hitEnemy();
        hitFood();
        hitBomb(); // Check for bomb collision
    }
    
    public boolean hitHome() {
        return isTouching(Home.class);
    }
    
    public boolean hitWall() {
        return isTouching(Wall.class);
    }
    
    public void hitEnemy() {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            getWorld().removeObject(enemy);
            MyWorld.score--;
        }
    }
    
    public void hitFood() {
        Actor food = getOneIntersectingObject(Food.class);
        if (food != null) {
            getWorld().removeObject(food);
            MyWorld.score++;
        }
    }
    
    public void hitBomb() {
        Actor bomb = getOneIntersectingObject(Bomb.class);
        if (bomb != null) {
            Greenfoot.stop(); // End the game
            getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }
    
    public boolean hitEdge() {
        int x = getX();
        int y = getY();
        return x <= 10 || x >= 790 || y <= 15 || y >= 785;
    }
    
    public void moveAround() {
        int dx = 0;
        int dy = 0;
        
        if (Greenfoot.isKeyDown("up")) {
            dy = -1;
        }
        if (Greenfoot.isKeyDown("down")) {
            dy = 1;
        }
        if (Greenfoot.isKeyDown("right")) {
            dx = 1;
        }
        if (Greenfoot.isKeyDown("left")) {
            dx = -1;
        }
        
        if (dx != 0 || dy != 0) {
            int oldX = getX();
            int oldY = getY();
            setLocation(oldX + dx, oldY + dy);
            
            if (hitWall() || hitEdge()) {
                setLocation(oldX, oldY);
            } else if (hitHome()) {
                World level2 = new FishWorld();
                Greenfoot.setWorld(level2);
            }
        }
    }
}
