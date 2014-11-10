// mesh
// based on this work
// Title: Blob Grid
// http://www.openprocessing.org/sketch/64363#
// http://www.asymptoticdesign.org/
// This work is licensed under a Creative Commons 3.0 License.
// (Attribution - NonCommerical - ShareAlike)
// http://creativecommons.org/licenses/by-nc-sa/3.0/

int rows = 10;
int columns = 10;

PVector [][] mesh;

void setup(){
    size(500,500);
  mesh = new PVector[columns+1][rows+1];
initialize();
}

void draw(){
background(128);
update();
show();
if(frameCount == 100){
  saveFrame("img.png");
  exit();
}
}


void initialize(){
  println(height);
  for(int i = 0; i < columns+1; i++){
  // println("i = " + i);
    for (int j = 0; j < rows+1; j++) {
  // println("j = " + j);
      mesh[i][j] = new PVector(i*(width/columns), j*(height/rows));
    }
  }
}

void show(){
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

void update(){
    for(int i = 0; i < columns+1; i++){
    for (int j = 0; j < rows+1; j++) {

      mesh[i][j].x += random(-0.5,0.5);
      mesh[i][j].y += random(-0.5,0.5);
    }
  }
}
