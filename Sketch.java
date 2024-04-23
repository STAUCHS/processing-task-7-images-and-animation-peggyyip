import processing.core.PApplet;
import processing.core.PImage;
/**
* Processing Task 7 - Animate 2 objects and 1 shape
* @author: P. Yip
*/
public class Sketch extends PApplet {
  PImage imgBananaDundun;
  PImage imgSkyBackground;
  PImage imgOriginalDundun;

  // X and Y coordinate for images
  float fltBananaX = 0;
  float fltBananaY = 0;

  float fltSkyBackgroundX = 0;
  float fltSkyBackgroundY = 0;

  float fltSquareX = 100;
  float fltSquareY = 100;

  float fltOriginalX;
  float fltOriginalY;
  float fltOriginalRadius;
  float fltOriginalRadian;

  // Speed for images
  float fltBananaSpeedX = random(1, 5);
  float fltBananaSpeedY = random(1, 5);

  float fltSquareXSpeed = random(5, 8);
  float fltSquareYSpeed = random(5, 8);

  double dblOriginalSpeed = 0.2;

  // Define colours
  int black = color(0);
  int blue = color(112, 161, 194);  

  public void settings() {
    size(500, 500);
  }

  public void setup() {
    background(black);

    // Load images
    imgBananaDundun = loadImage("Bananadundun.png");
    imgSkyBackground = loadImage("Skybackground.jpg");
    imgOriginalDundun = loadImage("Originaldundun.png");

    // Edit image sizes
    imgBananaDundun.resize(imgBananaDundun.width / 2, imgBananaDundun.height / 2);
    imgSkyBackground.resize(imgSkyBackground.width * 3, imgSkyBackground.height * 4);
    imgOriginalDundun.resize(imgOriginalDundun.width / 3, imgOriginalDundun.height / 3);

    // Define variables for circular motion
    fltOriginalX = width / 3;
    fltOriginalY = height / 3;
    fltOriginalRadius = 150;
    fltOriginalRadian = 50;
  }

  public void draw() {
    background(black);

    // Draw image background
    image(imgSkyBackground, fltSkyBackgroundX, fltSkyBackgroundY);

    // Draw Banana dundun and move
    image(imgBananaDundun, fltBananaX, fltBananaY);

    fltBananaX += fltBananaSpeedX;
    fltBananaY += fltBananaSpeedY;

    // Fix edge collision
    if (fltBananaX > width - imgBananaDundun.width || fltBananaX < 0) {
      fltBananaSpeedX *= -1;
  }

    if (fltBananaY > height - imgBananaDundun.height || fltBananaY < 0) {
      fltBananaSpeedY *= -1;
  }

    // Draw original dundun and have it move in a circle
    float fltUpdatedOriginalX = fltOriginalX + cos(fltOriginalRadian) * fltOriginalRadius;
    float fltUpdatedOriginalY = fltOriginalY + sin(fltOriginalRadian) * fltOriginalRadius;

    image(imgOriginalDundun, fltUpdatedOriginalX, fltUpdatedOriginalY);

    // Fix edge collision
    if (fltUpdatedOriginalX < 0 || fltUpdatedOriginalX > width || fltUpdatedOriginalY < 0 || fltUpdatedOriginalY > height) {
      dblOriginalSpeed *= -1;
  }

    fltOriginalRadian += dblOriginalSpeed;

    // Draw shape and move
    noStroke();
    fill(blue);
    square(fltSquareX, fltSquareY, 100);
    
    fltSquareX += fltSquareXSpeed;
    fltSquareY += fltSquareYSpeed;

    // Fix edge collision
    if (fltSquareX > width - 100 || fltSquareX < 0) {
      fltSquareXSpeed *= -1;
    }
    
    if (fltSquareY > height - 100 || fltSquareY < 0) {
      fltSquareYSpeed *= -1;
      }
    }
  }
