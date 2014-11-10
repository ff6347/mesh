import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class mesh extends PApplet {

// mesh
//
int rows = 10;
int columns = 10;

PVector [][] mesh;

public void setup(){
    size(500,500);
  mesh = new PVector[columns+1][rows+1];
initialize();
}


public void initialize(){
  println(height);
  for(int i = 0; i < columns+1; i++){
  println("i = " + i);
    for (int j = 0; j < rows+1; j++) {
  println("j = " + j);
      mesh[i][j] = new PVector(i*(width/columns), j*(height/rows));
    }
  }
}

public void show(){
  for(int c = 0; c < columns;c++){
    for(int r = 0; r < rows; r++){
    beginShape();
    vertex(mesh[c][r].x, mesh[c][r].y);
    vertex(mesh[c+1][r].x, mesh[c+1][r].y);
    vertex(mesh[c+1][r+1].x, mesh[c+1][r+1].y);
    vertex( mesh[c][r+1].x, mesh[c][r+1].y);
    endShape(CLOSE);
    }
  }
}

public void update(){
    for(int i = 0; i < columns+1; i++){
    for (int j = 0; j < rows+1; j++) {

      mesh[i][j].x += random(-0.5f,0.5f);
      mesh[i][j].y += random(-0.5f,0.5f);
    }
  }
}
public void draw(){
background(128);
update();
show();
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "mesh" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
