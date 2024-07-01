import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @your_name (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    public static int score = 0;
    private SimpleTimer timer;
    private Label timerLabel;
    private final int TIME_LIMIT = 60; // 60 seconds time limit

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld() {    
        // Create a new world with 800x800 cells with a cell size of 1x1 pixels.
        super(800, 800, 1);
        score = 0;
        prepare();
        
        timer = new SimpleTimer();
        timer.mark();
        timerLabel = new Label("Time: 60", 40);
        addObject(timerLabel, getWidth() / 2, 20);
    }
    
    public void act() {
        showText("Score = " + score, 50, 25);
        
        if (score >= 3) {
            addObject(new Home(), 775, 25);
        }
        
        updateTimer();
    }
    
    private void updateTimer() {
        if (timer.millisElapsed() >= TIME_LIMIT * 1000) {
            showGameOver();
            Greenfoot.stop();
        } else {
            int timeLeft = TIME_LIMIT - (int)(timer.millisElapsed() / 1000);
            timerLabel.setValue("Time: " + timeLeft);
        }
    }

    private void showGameOver() {
        Label gameOverLabel = new Label("Game Over", 60);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2);
    }

    private void prepare() { 
        int y = 25;
        int x = 25;        
        int[][] maze = 
            {
                {0, 1, 0, 1, 0, 2, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 0, 1, 2, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 0, 3, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {1, 1, 4, 1, 0, 1, 1, 0, 1, 1, 4, 0, 0, 1, 0, 0},
                {0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 2},
                {0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}
            };
        for (int i = 0; i < maze.length; i++) {
            x = 25;
            for (int j = 0; j < maze[i].length; j++) {  
                if (maze[i][j] == 1) {
                    addObject(new Wall(), x, y);
                } else if (maze[i][j] == 2) {
                    addObject(new Food(), x, y);
                } else if (maze[i][j] == 3) {
                    addObject(new Enemy(), x, y);
                } else if (maze[i][j] == 4) {
                    addObject(new Bomb(), x, y);
                }  
                x += 50;
            }
            y += 50;
        }
        addObject(new Person(), 25, 775); // Place the person at the bottom left corner
    }
}
