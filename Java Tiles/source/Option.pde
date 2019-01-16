boolean unotice=false;      //Masquer le conseil
int theme=4, selecTouche=0;
int tea=410;
int coffee=270;
color couleurNote1, couleurNote2, couleurNote3, couleurNote4; 

void option() {

  fill(0);
  stroke(0);
  rect(0, 0, 700, 700);  
  textSize(70);
  fill(0, 0, 255);
  text("Java Tiles", 196, height/5);
  cursor(ARROW);

  fill(0);
  stroke(75, 0, 0);
  rect(70, 170, 560, 435); 

  exp=int(infos[2]);
  jc=int(infos[3]);
  textSize(17);
  fill(250, 250, 155);
  text("Expérience : " +exp, 35, 30);
  fill(255, 250, 0);
  text("Java coins : " +jc, 35, 60);

  textSize(30);
  text("THEME", 290, 230);
  noStroke();                              //Changer les couleurs ici et dans Play (Touche)
  fill(#00FF00);              //Theme 1
  rect(100, 250, 20, 40);
  fill(#FF0000);
  rect(120, 250, 20, 40);
  fill(#FFFF00);
  rect(140, 250, 20, 40);
  fill(#0000FF);
  rect(160, 250, 20, 40);
  fill(#FF0000);              //Theme 2
  rect(230, 250, 20, 40);
  fill(#FFFF00);
  rect(250, 250, 20, 40);
  fill(#0081FF);
  rect(270, 250, 20, 40);
  fill(#973EFF);
  rect(290, 250, 20, 40);
  fill(#8FF5F2);              //Theme 3
  rect(370, 250, 20, 40);
  fill(#FAACE3);
  rect(390, 250, 20, 40);
  fill(#F5E8A6);
  rect(410, 250, 20, 40);
  fill(#D9F074);
  rect(430, 250, 20, 40);
  fill(#D4AF37);              //Theme 4
  rect(500, 250, 80, 40);

  noFill();                                                        //Cadre autour du theme choisi
  if (theme==0) stroke(255, 0, 0); 
  else stroke(0);
  rect(100, 250, 80, 40);
  if (theme==1) stroke(255, 0, 0); 
  else stroke(0);
  rect(230, 250, 80, 40);
  if (theme==2) stroke(255, 0, 0);   
  else stroke(0);
  rect(370, 250, 80, 40);
  if (theme==3) stroke(255, 0, 0); 
  else stroke(0);
  rect(500, 250, 80, 40);
  if (mousePressed) {
    if (mouseX>100 && mouseX<180 && mouseY>250 && mouseY<290) theme=0;      //Selection du theme
    if (mouseX>230 && mouseX<310 && mouseY>250 && mouseY<290) theme=1;
    if (mouseX>370 && mouseX<450 && mouseY>250 && mouseY<290) theme=2;
    if (mouseX>500 && mouseX<580 && mouseY>250 && mouseY<290) theme=3;
    saveinfo();
  }

  if (selecTouche==0) stroke(255, 0, 0);                                 //Cadre autour des touches choisi
  else stroke(255);
  rect(110, 370, 140, 50);
  if (selecTouche==1) stroke(255, 0, 0); 
  else stroke(255);
  rect(280, 370, 140, 50);
  if (selecTouche==2) stroke(255, 0, 0); 
  else stroke(255);
  rect(450, 370, 140, 50);

  if (mousePressed) {
    if (mouseX>110 && mouseX<250 && mouseY>370 && mouseY<420 && mousePressed) selecTouche=0;      //Selection des touches
    if (mouseX>280 && mouseX<420 && mouseY>370 && mouseY<420 && mousePressed) selecTouche=1;
    if (mouseX>450 && mouseX<590 && mouseY>370 && mouseY<420 && mousePressed) selecTouche=2;
    saveinfo();
  }

  text("Touches", 280, 350);
  textSize(20);
  text("Q | S | D | F          J | K | L | M          S | D | K | L", 120, 400);


  noFill();
  textSize(20);
  if (!unotice) {                        //Option affichage conseil
    stroke(255, 0, 0);
    if (mouseX>250 && mouseX<360 && mouseY>470 && mouseY<510) fill(100); 
    else fill(0);
    rect(250, 470, 110, 40);
    stroke(255);
    if (mouseX>420 && mouseX<600 && mouseY>470 && mouseY<510) fill(100); 
    else fill(0);
    rect(420, 470, 180, 40);
  }
  if (unotice) {
    stroke(255);
    if (mouseX>250 && mouseX<360 && mouseY>470 && mouseY<510) fill(255); 
    else fill(0);
    rect(250, 470, 110, 40);
    stroke(255, 0, 0);
    if (mouseX>420 && mouseX<600 && mouseY>470 && mouseY<510) fill(255); 
    else fill(0);
    rect(420, 470, 180, 40);
  }
  if (mouseX>250 && mouseX<360 && mouseY>470 && mouseY<510 && mousePressed) unotice=false;
  if (mouseX>420 && mouseX<600 && mouseY>470 && mouseY<510 && mousePressed) unotice=true;
  fill(160);
  text("Conseil :             Afficher               Ne pas afficher", 100, 500);      //

  fill(0);
  stroke(160);
  if (mouseX>130 && mouseX<580 && mouseY>540 && mouseY<590) fill(200);
  rect(130, 540, 450, 50);
  fill(255, 0, 0);
  textSize(30);
  text("REINITIALISER    !", 250, 575);
  noFill();
  stroke(255, 0, 0);
  triangle(510, 580, 475, 580, 490, 545);

  if (mouseX>130 && mouseX<580 && mouseY>540 && mouseY<590 && mousePressed) {     // Rénitialiser                A FAIRE DEMANDER
    theme=0;
    selecTouche=0;
    unotice=false;
    output = createWriter("songsave.txt");
    output.println(infos[0]);
    output.println(infos[1]);
    output.println(0);
    output.println(0);
    output.println(infos[4]);
    output.println(infos[5]);
    output.println(infos[1]);
    output.println(infos[7]);
    output.println(infos[8]);
    output.println(infos[9]);
    for (int i=0; i<10; i++) {
      output.println(infos[i*4+10]);
      output.println(infos[(i*4)+1+10]);
      output.println(0);
      output.println(0);
    }
    output.flush();
    output.close();

    infos=loadStrings("songsave.txt");
  }

  noFill();
  fill(couleur);
  strokeWeight(2);
  stroke(12, 15, 255);
  rect(304, 619, 88, 37, 50);
  smooth();
  noFill();
  fill(remplissage);
  textSize(35);
  text("Back", 310, 650);
  if (mouseX>304 && mouseX<396 && mouseY>619 && mouseY<656)
  {
    couleur=0;
    remplissage=255;
  } else
  {
    couleur=255;
    remplissage=0;
  }

  if (mouseX>304 && mouseX<396 && mouseY>619 && mouseY<656) {
    cursor(HAND);
  } else {
    cursor(ARROW);
  }  
  stroke(0);
}

