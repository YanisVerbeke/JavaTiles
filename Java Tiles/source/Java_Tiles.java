import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Java_Tiles extends PApplet {

//Jeu de rythme r\u00e9alis\u00e9 par Samuel Sylverius et Yanis Verbeke, 2018

Minim minim;
AudioPlayer Close;
AudioPlayer Lions;
AudioPlayer Communication;
AudioPlayer StayAway;
AudioPlayer HowLong;
AudioPlayer Livette;
float vitesse=5.69f;
boolean[] downKeys=new boolean[256]; 
int[][] song;
int[][] song2;
int[][] song3;
int[][] song4;
int[][] song5;
int[][] song6;
String fichier[];
String fichier2[];
String fichier3[];
String fichier4[];
String fichier5[];
String fichier6[];
ArrayList<Note> notes;    //Stockage de toutes les notes une par une et de n'importe quelle couleur dans une liste d'objets
boolean touche1;
boolean touche2;
boolean touche3;
boolean touche4;
boolean start=false;
boolean hasPressed = false;
boolean Hold = true;
boolean move=false;
boolean songpage=false;
boolean cieletoile=true;
String state="intro";
String stateTemporary="intro";
String title[] = {
  "D\u00e9butant", "Guitariste", "Master", "GuitarMaster", "Guitar Hero"
};
int songnumber=0;
int taille=40;    //Taille des touches, et r\u00e9ferences pour les notes
int menu = 0;
int choix = 0;
int index=0;
int couleur=255;  
int remplissage=0;

public void setup() {
  size(700, 700);
  background(0);
  infos=loadStrings("songsave.txt");
  frameRate(45);
  fichier=loadStrings("Close.txt");
  fichier2=loadStrings("Lions.txt");
  fichier3=loadStrings("Communication.txt");
  fichier4=loadStrings("Stay Away.txt");
  fichier5=loadStrings("How Long.txt");
  fichier6=loadStrings("Livette.txt");
  theme=PApplet.parseInt(infos[7]);
  selecTouche=PApplet.parseInt(infos[8]);
  notes = new ArrayList<Note>();
  minim = new Minim(this);
  Close = minim.loadFile("Close.mp3");
  Lions = minim.loadFile("Lions.mp3");
  Communication = minim.loadFile("Communication.mp3");
  StayAway = minim.loadFile("Stay Away.mp3");
  HowLong = minim.loadFile("How Long.mp3");
  Livette = minim.loadFile("Livette.mp3");
  textSize(70);
  fill(255);
  text("Java Tiles", 196, height/5);
  textSize(60);
  fill(255);
  text("Play", 290, 350);
  background(0);
}

public void draw() { 
  if (state=="intro") {
    fill(0);
    stroke(0);
    rect(0, 0, 700, 700);

    //      for (int i=0; i<500; i=i+1) {
    //        int x=int(random(700));
    //        int y=int(random(700));
    //        stroke(255, 255, 0);
    //        point(x, y);
    //      }

    textSize(70);
    fill(255);
    stroke(12, 15, 255);
    text("Java Tiles", 196, height/5+25);

    noFill();
    ellipse(345, 330, 140, 80);
    textSize(60);
    fill(255);
    stroke(12, 15, 255);
    text("Play", width/2-60, 350);

    exp=PApplet.parseInt(infos[2]);
    jc=PApplet.parseInt(infos[3]);

    fill(153, 217, 234);    //Exp\u00e9rience
    noStroke();
    rect(30, 17, 170, 30, 17); // a faire progresser

    noFill();
    strokeWeight(4);
    stroke(0, 130, 210);
    rect(30, 17, 170, 30, 40);

    noFill();    //Niveau
    strokeWeight(2);
    stroke(245, 0, 245);
    rect(10, 600, 225, 90, 7);

    price();

    textSize(24);
    fill(255, 0, 0);
    text(title[titre], 23, 633);
    fill(255, 255, 255);
    text(title[titre], 22, 632);
    textAlign(RIGHT);
    textSize(18);
    fill(0, 239, 0);
    if (exp<5000000) {
      text("Niv "+niv, 218, 627);
    } else {
      text("Niv "+niv, 223, 627);
    }
    textAlign(LEFT);

    noFill();
    strokeWeight(1);
    stroke(0, 255, 0);
    rect(164, 607, 60, 28, 7);

    stroke(12, 15, 255);
    textSize(17);
    fill(250, 250, 70);
    text("Exp : " +exp, 43, 38);
    textSize(20);
    fill(205, 200, 0);
    text("Java coins : " +jc, 22, 670);

    noFill();
    rect(207, 407, 285, 55);
    rect(254, 505, 193, 60);

    textSize(50);  
    fill(255, 0, 0);
    text("Instructions", 207, 450);

    textSize(50);
    fill(255, 0, 0);
    text("Options", 254, 550);

    textSize(10);
    fill(255);
    text("R\u00e9alis\u00e9 par Yanis Verbeke (                       ) et ", 380, 690);
    if (mouseX>510 && mouseX<585 && mouseY>678 && mouseY<695) {
      text("Ouais je fais ma pub je suis comme \u00e7a ;)", 450, 675);
      if (mousePressed && !hasPressed) link("https://twitter.com/EraserErased");
      fill(255, 0, 0);
    } else fill(255);
    text("@EraserErased", 512, 690);
    if (mouseX>603 && mouseX<685 && mouseY>678 && mouseY<695) {
      if (mousePressed && !hasPressed) link("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
      fill(255, 0, 0);
    } else fill(255);
    text("Samuel Sylverius", 603, 690);

    println(mouseX);
    println(mouseY);
    strokeWeight(3); // Bouton Exit
    stroke(255);
    fill(255, 0, 0);
    ellipse(670, 30, 30, 30);

    strokeWeight(3);
    fill(255);
    line(670, 10, 670, 20);

    if ( ( (mouseX - 670)*(mouseX - 670) + (mouseY - 30)*(mouseY - 30) ) <= (15*15) ) {
      textSize(17);
      fill(255);
      text("Exit", 620, 34);
    }
    if (mousePressed) {
      if ( ( (mouseX - 670)*(mouseX - 670) + (mouseY - 30)*(mouseY - 30) ) <= (15*15) ) {
        exit();
      }
    }

    if (mouseX<470 && mouseX>230 && mouseY>407 && mouseY<462 || mouseX<447 && mouseX>254 && mouseY>505 && mouseY<565) {
      cursor(HAND);
    } else {
      cursor(ARROW);
    }
  } else if (state=="song") {
    songs();
  } else if (state=="play") {
    play();
  } else if (state=="instructions") {
    instruction();
  } else if (state=="settings") {
    option();
  } 

  if (keyPressed == false) {
    if (state == "song") {   
      songpage=false;
    }
  }

  if (mousePressed) {
    if (state == "intro") {
      if (mouseX<409 && mouseX>289 && mouseY>298 && mouseY<369) {
        stateTemporary="song";
        //Cela a sert de d\u00e9filer les \u00e9toiles pour la 2eme fois
        cb1=false;
        cb2=false;
        cb3=false;
        c=814;
        c1=927;
        c2=1040;
        soo = false;
        so=-150;
      }
      if (mouseX<492 && mouseX>207 && mouseY>407 && mouseY<462) {
        stateTemporary="instructions";
      } else if (mouseX<447 && mouseX>254 && mouseY>505 && mouseY<565) {
        stateTemporary="settings";
      }
    } else if (state == "instructions") {
      if (mouseX>304 && mouseX<396 && mouseY>619 && mouseY<656) {
        stateTemporary="intro";
      }
    } else if (state == "settings") { 
      if (mouseX>304 && mouseX<396 && mouseY>619 && mouseY<656) {
        stateTemporary="intro";
      }
    } else if (state == "song") {
      if (mouseX<675 && mouseX>25 && mouseY>debutList && mouseY<700 && bloc==false) {
        stateTemporary="play";
        if (unotice==false) {
          conseil=true;
        }
        chansonfini=false;    
        fichiers();
      }
    } else if (state == "play") {
      if (mouseX>45 && mouseX<100 && mouseY>455 && mouseY<510 && ficheresultat==false) {
        Close.pause(); 
        Close.rewind();
        Lions.pause();
        Lions.rewind();
        Communication.pause();
        Communication.rewind();
        StayAway.pause();
        StayAway.rewind();
        HowLong.pause();
        HowLong.rewind();
        Livette.pause();
        Livette.rewind();
        pts=0;
        state="intro";
        stateTemporary="intro";
        notes.clear();
        start=false;
        resultat=false;
        playon=false;

        if (songnumber==0) {
          start=false;
          Close.rewind();
          Close.pause();
        }

        if (songnumber==1) {
          start=false;
          Lions.rewind();
          Lions.pause();
        }

        if (songnumber==2) {
          start=false;
          StayAway.rewind();
          StayAway.pause();
        }

        if (songnumber==3) {
          start=false;
          Communication.rewind();
          Communication.pause();
        }
        if (songnumber==4) {
          HowLong.pause();
          HowLong.rewind();
        }
        if (songnumber==5) {
          Livette.pause();
          Livette.rewind();
        }
      }
    }

    hasPressed = true;
  } else {

    if (hasPressed) {
      if (state != stateTemporary) {
        state = stateTemporary;
      }
      hasPressed = false;
    }
  }

  if (menu==0 && state == "intro") {
    for (int i=0; i<255; i=i+17) {
      stroke(i, 0, 0);
      noFill();
      ellipse(345, 330, 141+i/17, 81+i/17);
    }
    stroke(0, 0, 255);
    noFill();
    ellipse(345, 330, 140, 80);
  }

  if (menu==1 && state == "intro") {
    fill(185, 175, 175);
    rect(207, 407, 285, 55);
    textSize(50);
    fill(255, 0, 0);
    text("Instructions", 207, 450);
  }

  if (menu==2 && state == "intro") {
    fill(185, 175, 175);
    rect(254, 505, 193, 60);
    textSize(50);
    fill(255, 0, 0);
    text("Options", 254, 550);
  }

  if (state == "intro" && keyPressed == true) {
    if (menu==0 && key == ENTER) {
      stateTemporary="song";
      songpage=true;
      hasPressed = true;
    } else if (menu==1 && key == ENTER) {
      stateTemporary="instructions";
      instruction();
      hasPressed = true;
    } else if (menu==2 && key == ENTER) {
      stateTemporary="settings";
      option();
      hasPressed = true;
    }
  } else if (state == "play" && keyPressed == true) {
    if (downKeys['x'] || downKeys['X'] || key == BACKSPACE && !conseil) {
      retour=true;
      hasPressed = true;
    }
  } else if (state == "instructions" && keyPressed == true) {
    if (downKeys['x'] || downKeys['X'] || key == BACKSPACE) {
      stateTemporary="intro";
      hasPressed = true;
    }
  } else if (state == "settings" && keyPressed == true) {
    if (downKeys['x'] || downKeys['X'] || key == BACKSPACE) {
      stateTemporary="intro";
      hasPressed = true;
    }
  } else if (state == "song" && keyPressed == true) {
    if (downKeys['x'] || downKeys['X'] || key == BACKSPACE) {
      stateTemporary="intro";
      hasPressed = true;
    }
  }

  if (state == "intro") {
    if (mouseX<409 && mouseX>289 && mouseY>298 && mouseY<369 && keyPressed == false && Hold != true) {
      menu=0;
      move=false;
    } 
    if (mouseX<409 && mouseX>289 && mouseY>298 && mouseY<369 && keyPressed == true && Hold != true) {
      Hold = true;
    } else if (mouseX<492 && mouseX>207 && mouseY>407 && mouseY<462 && keyPressed == false  && Hold != true) {
      menu=1;
      move=false;
    } 
    if (mouseX<492 && mouseX>207 && mouseY>407 && mouseY<462 && keyPressed == true && Hold != true) {
      Hold = true;
    } else if (mouseX<447 && mouseX>254 && mouseY>505 && mouseY<565 && keyPressed == false  && Hold != true) {
      menu=2;
      move=false;
    }
    if (mouseX<447 && mouseX>254 && mouseY>505 && mouseY<565 && keyPressed == true && Hold != true) {
      Hold = true;
    }
    if (move == true) {
      Hold = false;
    }
  }
}

public void mouseMoved() {
  if (Hold == true) {
    move=true;
  }
}

public void keyPressed() {
  if (state == "intro") {
    if (key == CODED) {
      if (keyCode == DOWN) {
        menu++;
        if (menu>2) menu=0;
      }
      if (keyCode == UP) {
        menu--;
        if (menu<0) menu=2;
      }
    }
  }
  if (state == "song") {
    if (key == CODED) {
      if (keyCode == DOWN) {
        if (choix<9) {
          choix++;
          if (choix>=ch) {
            ava=true;
          }
        }
      }
      if (keyCode == UP) {
        if (choix>0) {
          choix--;
          if (choix<bh && bh!=1) {
            rec=true;
          }
          if (bh==1) {
            debutList=60;
            debutListe=110;
          }
          ava=false;
        }
      }
    }

    if (state == "settings") {
    }

    if (keyCode == java.awt.event.KeyEvent.VK_PAGE_UP && debutListe<=-240) {
      avan=true;
    } else if (keyCode == java.awt.event.KeyEvent.VK_PAGE_UP && debutListe>=-240) {
      debutList=60;
      debutListe=110;
    } else if (keyCode == java.awt.event.KeyEvent.VK_PAGE_DOWN && debutList>=-100) {
      recu=true;
    } else if (keyCode == java.awt.event.KeyEvent.VK_PAGE_DOWN && debutList<=-100) {
      debutList=-410;
      debutListe=-360;
    }
  }

  if (key<256) {
    downKeys[key]=true;
  }
}

public void affichage() {    //Mise en place des notes selon le fichier texte join, les 1 sont des notes, les 2 seront plus longue mais pas encore programm\u00e9es et les 3 pour afficher la fiche

    if (songnumber==0) {
    vitesse=5.69f;
    depart=55510;
    while (notes.size ()<=fichier.length) {
      for (int j=0; j<fichier.length; j++) {
        if (song[j][0]==1) notes.add(new Note(430, couleurNote1, (j*30)-depart)); 
        if (song[j][1]==1) notes.add(new Note(500, couleurNote2, (j*30)-depart)); 
        if (song[j][2]==1) notes.add(new Note(570, couleurNote3, (j*30)-depart)); 
        if (song[j][3]==1) notes.add(new Note(640, couleurNote4, (j*30)-depart));
      }
    }
  }

  if (songnumber==1) {
    vitesse=4;
    depart=57050;
    while (notes.size ()<=fichier2.length) {
      for (int j=0; j<fichier2.length; j++) {
        if (song2[j][0]==1) notes.add(new Note(430, couleurNote1, (j*30)-depart)); 
        if (song2[j][1]==1) notes.add(new Note(500, couleurNote2, (j*30)-depart)); 
        if (song2[j][2]==1) notes.add(new Note(570, couleurNote3, (j*30)-depart)); 
        if (song2[j][3]==1) notes.add(new Note(640, couleurNote4, (j*30)-depart));
      }
    }
  }

  if (songnumber==2) {
    vitesse=4.4f;
    depart=47880;
    while (notes.size ()<=fichier4.length) {
      for (int j=0; j<fichier4.length; j++) {
        if (song4[j][0]==1) notes.add(new Note(430, couleurNote1, (j*30)-depart)); 
        if (song4[j][1]==1) notes.add(new Note(500, couleurNote2, (j*30)-depart)); 
        if (song4[j][2]==1) notes.add(new Note(570, couleurNote3, (j*30)-depart)); 
        if (song4[j][3]==1) notes.add(new Note(640, couleurNote4, (j*30)-depart));
      }
    }
  }

  if (songnumber==3) {
    vitesse=7.11f;
    depart=57260;
    while (notes.size ()<=fichier3.length) {
      for (int j=0; j<fichier3.length; j++) {
        if (song3[j][0]==1) notes.add(new Note(430, couleurNote1, (j*30)-depart)); 
        if (song3[j][1]==1) notes.add(new Note(500, couleurNote2, (j*30)-depart)); 
        if (song3[j][2]==1) notes.add(new Note(570, couleurNote3, (j*30)-depart)); 
        if (song3[j][3]==1) notes.add(new Note(640, couleurNote4, (j*30)-depart));
      }
    }
  }
  if (songnumber==4) {
    vitesse=4.22f;
    depart=60860;
    while (notes.size ()<=fichier5.length) {
      for (int j=0; j<fichier5.length; j++) {
        if (song5[j][0]==1) notes.add(new Note(430, couleurNote1, (j*30)-depart)); 
        if (song5[j][1]==1) notes.add(new Note(500, couleurNote2, (j*30)-depart)); 
        if (song5[j][2]==1) notes.add(new Note(570, couleurNote3, (j*30)-depart)); 
        if (song5[j][3]==1) notes.add(new Note(640, couleurNote4, (j*30)-depart));
      }
    }
  }
  if (songnumber==5) {
    vitesse=4.09f;
    depart=38300;
    while (notes.size ()<=fichier6.length) {
      for (int j=0; j<fichier6.length; j++) {
        if (song6[j][0]==1) notes.add(new Note(430, couleurNote1, (j*30)-depart)); 
        if (song6[j][1]==1) notes.add(new Note(500, couleurNote2, (j*30)-depart)); 
        if (song6[j][2]==1) notes.add(new Note(570, couleurNote3, (j*30)-depart)); 
        if (song6[j][3]==1) notes.add(new Note(640, couleurNote4, (j*30)-depart));
      }
    }
  }
}

public void fichiers() {
  if (songnumber==0) {  
    song = new int[fichier.length][4];
    for (int i=0; i<fichier.length; i++) {
      String tab[]=split(fichier[i], " ");
      for (int j=0; j<4; j++) {
        song[i][j]=PApplet.parseInt(tab[j]);
      }
    }
  }

  if (songnumber==1) { 
    song2 = new int[fichier2.length][4];
    for (int i=0; i<fichier2.length; i++) {
      String tab[]=split(fichier2[i], " ");
      for (int j=0; j<4; j++) {
        song2[i][j]=PApplet.parseInt(tab[j]);
      }
    }
  }

  if (songnumber==2) {
    song4 = new int[fichier4.length][4];
    for (int i=0; i<fichier4.length; i++) {
      String tab[]=split(fichier4[i], " ");
      for (int j=0; j<4; j++) {
        song4[i][j]=PApplet.parseInt(tab[j]);
      }
    }
  }

  if (songnumber==3) {
    song3 = new int[fichier3.length][4];
    for (int i=0; i<fichier3.length; i++) {
      String tab[]=split(fichier3[i], " ");
      for (int j=0; j<4; j++) {
        song3[i][j]=PApplet.parseInt(tab[j]);
      }
    }
  }
  if (songnumber==4) {
    song5 = new int[fichier5.length][4];
    for (int i=0; i<fichier5.length; i++) {
      String tab[]=split(fichier5[i], " ");
      for (int j=0; j<4; j++) {
        song5[i][j]=PApplet.parseInt(tab[j]);
      }
    }
  }
  if (songnumber==5) {
    song6 = new int[fichier6.length][4];
    for (int i=0; i<fichier6.length; i++) {
      String tab[]=split(fichier6[i], " ");
      for (int j=0; j<4; j++) {
        song6[i][j]=PApplet.parseInt(tab[j]);
      }
    }
  }
}

int page=0;
boolean tap=true;
boolean top=false;

public void instruction() {

  fill(130, 49, 4);
  rect(0, 0, 700, 700); 
  // Indicateur
  fill(120, 39, 4);
  stroke(0);
  rect(70, 150, 560, 440, 5);

  if (page==0) {
    fill(72);
  }
  if (page==1 || page==2 || page==3) {
    fill(172);
  } //fill(222)
  beginShape();
  vertex(88, 559);
  vertex(113, 542);
  vertex(113, 552);
  vertex(148, 552);
  vertex(148, 566);
  vertex(113, 566);
  vertex(113, 576);
  endShape(CLOSE);

  if (page==3) {
    fill(72);
  }
  if (page==0 || page==1 || page==2) {
    fill(172);
  }
  beginShape();
  vertex(608, 559);
  vertex(583, 542);
  vertex(583, 552);
  vertex(548, 552);
  vertex(548, 566);
  vertex(583, 566);
  vertex(583, 576);
  endShape(CLOSE);

  textSize(70);
  fill(255);
  text("Java Tiles", 196, height/7);

  fill(0xff5596B1);
  textSize(15);
  if (page==0) {
    textSize(30);
    fill(14, 101, 126);
    text(" Bienvenue dans Java Tiles.", 150, 190);
    textSize(15);
    fill(0xff5596B1);
    text("Le but de jeu est de suivre une chanson choisie en appuyant sur la touche qui correspond \u00e0 la note au bon moment, afin de r\u00e9colter le plus haut score possible.", 90, 230, 500, 400);
    if (theme<2) {
      text("Il y a quatres touches diff\u00e9rentes pour quatres types de notes : Vert, Rouge, Jaune, Bleu. ", 90, 320, 500, 400);
    } else {
      text("Il y a quatres touches diff\u00e9rentes pour quatres types de notes. ", 90, 320, 500, 400);
    }
    text("Vous pouvez choisir quelles touches vous souhaitez utiliser, celles par d\u00e9faut \u00e9tant Q, S, D et F.", 90, 390, 500, 400);
    text("Les points vous permettront d'obtenir de l'experience et des Java Coins, la monnaie necessaire pour d\u00e9bloquer de nouvelles chansons ainsi que des \u00e9lements cosm\u00e9tiques.", 90, 450, 500, 400);
  }
  if (page==1) {
    text("Pour jouer, appuyez sur Play puis choisissez votre chanson. Ensuite, appuyez \u00e0 nouveau sur Play pour lancer le jeu. ", 90, 230, 500, 500);
    text("Pendant le partie, vous pouvez mettre la chanson en pause en appuyant sur P, ou bien quitter la partie et revenir au menu principal en appuyant sur X.", 90, 290, 500, 500);
    text("Vous pouvez aussi r\u00e9initialiser la chanson en appuyant sur R.", 90, 380, 500, 500);
    text("ATTENTION : Ne pas rester appuy\u00e9 sur les touches lorsque vous jouez.", 90, 430, 500, 500);
  }
  if (page==2) { 
    text("Lorsque vous appuyez sur une touche, le contour de celle ci devient blanc pour indiquer sur quelle touche vous appuyez.", 90, 230, 500, 500);
    text("Cependant il est possible qu'elle ne change pas de couleur, les points seront tout de m\u00eame compt\u00e9s si la touche est appuy\u00e9e au bon moment. ", 90, 300, 500, 500);
  }
  if (page==3) {
    text("Dans la page Option, vous pouvez choisir le theme (les couleurs) utilis\u00e9, certains \u00e9tant bloqu\u00e9s, les touches avec lesquelles vous voulez jouer, ainsi qu'une option permettant d'afficher ou non le conseil au d\u00e9but de chaque chanson.", 90, 230, 500, 500);
    text("Vous avez aussi la possibilit\u00e9 de r\u00e9initialiser votre progression", 90, 380, 500, 500);
    text("ATTENTION ! Cela effacera vos scores, votre exp\u00e9rience et vos Java Coins, et bloquera tous les \u00e9lements que vous avez d\u00e9bloqu\u00e9s", 90, 430, 500, 500);
  }

  noFill();
  fill(couleur);
  strokeWeight(2);
  stroke(100, 100, 255);
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
  if (state=="instructions") {
    if (mouseX>304 && mouseX<396 && mouseY>619 && mouseY<656) {
      cursor(HAND);
    } else {
      cursor(ARROW);
    }

    if ( ( (mouseX - 120)*(mouseX - 120) + (mouseY - 559)*(mouseY - 559) ) <= (40*40) ) {
      cursor(HAND);
    } else {
      cursor(ARROW);
    }

    if ( ( (mouseX - 576)*(mouseX - 576) + (mouseY - 559)*(mouseY - 559) ) <= (40*40) ) {
      cursor(HAND);
    } else {
      cursor(ARROW);
    }
  }
}

public void mouseReleased() {
  if ( ( (mouseX - 120)*(mouseX - 120) + (mouseY - 559)*(mouseY - 559) ) <= (40*40) ) {
    if (page==0) {
      tap=true;
    } else {
      tap=false;
    }
    if (tap!=true) {
      page--;
    }
  } else if ( ( (mouseX - 576)*(mouseX - 576) + (mouseY - 559)*(mouseY - 559) ) <= (40*40) ) {
    if (page==3) {
      top=true;
    } else {
      top=false;
    }
    if (top!=true) {
      page++;
    }
  }
}

public void keyReleased() {
  if (key == CODED) {
    if (keyCode == LEFT) {
      if (page==0) {
        tap=true;
      } else {
        tap=false;
      }
      if (tap!=true) {
        page--;
      }
    }
    if (keyCode == RIGHT) {
      if (page==3) {
        top=true;
      } else {
        top=false;
      }
      if (top!=true) {
        page++;
      }
    }
  }
  if (key<256) {
    downKeys[key]=false;
  }
}

class Note {      //Les notes qui tombent, dans l'ordre vert rouge jaune bleue, 
  int x;
  float y;
  int c;

  Note(int coordX, int couleur, float coordY) {
    x= coordX;
    c=couleur;
    y=coordY;
  }

  public void display() {      //Affichage des notes
    fill(c);
    stroke(0);
    rect(x, y, taille-5, taille-5);
    if (start && !pause) {
      y+=vitesse;
      if (songnumber==0) {
        Close.play();
      }
      if (songnumber==1) {
        Lions.play();
      }
      if (songnumber==2) {
        StayAway.play();
      }
      if (songnumber==3) {
        Communication.play();
      }
      if (songnumber==4) {
        HowLong.play();
      }
      if (songnumber==5) {
        Livette.play();
      }
    }
  }

  public void Point() {
    if (selecTouche==0) {
      if (downKeys['q'] || downKeys['Q']) touche1=true;
      if (frameCount%20==0) touche1=false;
      if (downKeys['s'] || downKeys['S']) touche2=true;
      if (frameCount%20==0) touche2=false;
      if (downKeys['d'] || downKeys['D']) touche3=true;
      if (frameCount%20==0) touche3=false;
      if (downKeys['f'] || downKeys['F']) touche4=true;
      if (frameCount%20==0) touche4=false;
    }
    if (selecTouche==1) {
      if (downKeys['j'] || downKeys['J']) touche1=true;
      if (frameCount%20==0) touche1=false;
      if (downKeys['k'] || downKeys['K']) touche2=true;
      if (frameCount%20==0) touche2=false;
      if (downKeys['l'] || downKeys['L']) touche3=true;
      if (frameCount%20==0) touche3=false;
      if (downKeys['m'] || downKeys['M']) touche4=true;
      if (frameCount%20==0) touche4=false;
    }
    if (selecTouche==2) {
      if (downKeys['s'] || downKeys['S']) touche1=true;
      if (frameCount%20==0) touche1=false;
      if (downKeys['d'] || downKeys['D']) touche2=true;
      if (frameCount%20==0) touche2=false;
      if (downKeys['k'] || downKeys['K']) touche3=true;
      if (frameCount%20==0) touche3=false;
      if (downKeys['l'] || downKeys['L']) touche4=true;
      if (frameCount%20==0) touche4=false;
    }

    if (selecTouche==0) {
      if (x==430 && (downKeys['q'] || downKeys['Q']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['q']=false;
        downKeys['Q']=false;
      }
      if (x==500 && (downKeys['s'] || downKeys['S']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['s']=false;
        downKeys['S']=false;
      }
      if (x==570 && (downKeys['d'] || downKeys['D']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['d']=false;
        downKeys['D']=false;
      }
      if (x==640 && (downKeys['f'] || downKeys['F']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['f']=false;
        downKeys['F']=false;
      }
    }

    if (selecTouche==1) {
      if (x==430 && (downKeys['j'] || downKeys['J']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['j']=false;
        downKeys['J']=false;
      }
      if (x==500 && (downKeys['k'] || downKeys['K']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['k']=false;
        downKeys['K']=false;
      }
      if (x==570 && (downKeys['l'] || downKeys['L']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['l']=false;
        downKeys['L']=false;
      }
      if (x==640 && (downKeys['m'] || downKeys['M']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['m']=false;
        downKeys['M']=false;
      }
    }

    if (selecTouche==2) {
      if (x==430 && (downKeys['s'] || downKeys['S']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['s']=false;
        downKeys['S']=false;
      }
      if (x==500 && (downKeys['d'] || downKeys['D']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['d']=false;
        downKeys['D']=false;
      }
      if (x==570 && (downKeys['k'] || downKeys['K']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['k']=false;
        downKeys['K']=false;
      }
      if (x==640 && (downKeys['l'] || downKeys['L']) && y>580 && y<630 && !pause) {
        if (y>600 && y<606) {
          pts+=66;
        } else {
          if (y>590 && y<618) {
            pts+=44;
          } else {
            if (y>580 && y<630) {
              pts+=22;
            }
          }
        }
        downKeys['l']=false;
        downKeys['L']=false;
      }
    }
  }
}

boolean unotice=false;      //Masquer le conseil
int theme=4, selecTouche=0;
int tea=410;
int coffee=270;
int couleurNote1, couleurNote2, couleurNote3, couleurNote4; 

public void option() {

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

  exp=PApplet.parseInt(infos[2]);
  jc=PApplet.parseInt(infos[3]);
  textSize(17);
  fill(250, 250, 155);
  text("Exp\u00e9rience : " +exp, 35, 30);
  fill(255, 250, 0);
  text("Java coins : " +jc, 35, 60);

  textSize(30);
  text("THEME", 290, 230);
  noStroke();                              //Changer les couleurs ici et dans Play (Touche)
  fill(0xff00FF00);              //Theme 1
  rect(100, 250, 20, 40);
  fill(0xffFF0000);
  rect(120, 250, 20, 40);
  fill(0xffFFFF00);
  rect(140, 250, 20, 40);
  fill(0xff0000FF);
  rect(160, 250, 20, 40);
  fill(0xffFF0000);              //Theme 2
  rect(230, 250, 20, 40);
  fill(0xffFFFF00);
  rect(250, 250, 20, 40);
  fill(0xff0081FF);
  rect(270, 250, 20, 40);
  fill(0xff973EFF);
  rect(290, 250, 20, 40);
  fill(0xff8FF5F2);              //Theme 3
  rect(370, 250, 20, 40);
  fill(0xffFAACE3);
  rect(390, 250, 20, 40);
  fill(0xffF5E8A6);
  rect(410, 250, 20, 40);
  fill(0xffD9F074);
  rect(430, 250, 20, 40);
  fill(0xffD4AF37);              //Theme 4
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

  if (mouseX>130 && mouseX<580 && mouseY>540 && mouseY<590 && mousePressed) {     // R\u00e9nitialiser                A FAIRE DEMANDER
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

PrintWriter output;
int R=50;
int T1=5;
int T2=45;
int pts=0;
int best;
int metoil;
int jc;
int etoil=0;
int exp=0;
int tra=0;
int ro=-400;
int ra=205;
int depart=55510;
int nombredenote;
float m1;
float m2;
float m3;
boolean jcs=true;
boolean expe=true;
boolean exper=true;
boolean resulmessager=false;
boolean transparence=false;
boolean conseil=false;
boolean finish=false;
boolean resultat=false;
boolean apparait=false;
boolean disparait=false;
boolean toucheclavier=false;
boolean retour=false;
boolean pause=false;
boolean free=false;
boolean libre=true;
boolean libere=false;
int cc1=0xff00FF00, cc2=0xffFF0000, cc3=0xffFFFF00, cc4=0xff0000FF;

public void play() {

  background(0);
  touche();
  affichage();

  fill(0);
  stroke(0);
  rect(0, 0, 700, 700);  

  textSize(70);
  fill(255, 0, 0);
  text("Java Tiles", 50, height/5);

  if (!pause && start) {
    noFill();
    stroke(255, 0, 0);
    rect(139, 460, 120, 56, 10);
    textSize(35);
    fill(150, 150, 255);
    text("Replay", 142, 498);
  }



  if (!start || pause) {
    //fill(0);
    noFill();
    stroke(255, 0, 0);
    rect(139, 448, 120, 71, 10);
    textSize(60);
    fill(150, 150, 255);
    text("Play", 140, 500);
    textSize(20);
    fill(255);
    text("(Espace)", 160, 540);
  }

  noFill();
  stroke(250, 0, 0);
  rect(396, -1, 303, 700);


  //Indice de la longueur de la chanson  

  float si=0;

  if (songnumber == 0) si = map(Close.position(), 0, Close.length(), 11, 678);
  if (songnumber == 1) si = map(Lions.position(), 0, Lions.length(), 11, 678);
  if (songnumber == 2) si = map(StayAway.position(), 0, StayAway.length(), 11, 678);
  if (songnumber == 3) si = map(Communication.position(), 0, Communication.length(), 11, 678);
  if (songnumber == 4) si = map(HowLong.position(), 0, HowLong.length(), 11, 678);
  if (songnumber == 5) si = map(Livette.position(), 0, Livette.length(), 11, 678);


  strokeWeight(1);
  stroke(250, 0, 100);
  noFill();
  rect(387, 10, 5, 680);
  fill(150, 150, 255);
  rect(391, 689, -3, -si);


  if (start) {
    stroke(255, 0, 0);
    noFill();

    //Bouton Menu
    beginShape();
    vertex(75, 445);
    vertex(100, 470);
    vertex(100, 510);
    vertex(45, 510);
    vertex(45, 470);
    vertex(75, 445);
    endShape(CLOSE);

    fill(255);
    textSize(50);

    //Bouton Pause
    if (!pause) {
      noFill();
      rect(300, 455, 55, 55, 10);
      text("P", 310, 500);
    }

    //Bouton Replay(en Pause)
    if (pause) {
      noFill();
      rect(300, 455, 55, 55, 10);
      text("R", 310, 500);
    }

    text("X", 58, 500);
  }

  strokeWeight(5);          //Lignes dirrectrices
  if (theme==0) stroke(0, 255, 0, 70);
  if (theme==1) stroke(0xffB40000);
  if (theme==2) stroke(0xff7092BE); //(112, 146, 190);
  if (theme==3) stroke(0xffA78F2A);
  line(447, 0, 447, 700);
  if (theme==0) stroke(255, 0, 0, 70);
  if (theme==1) stroke(0xffCECB00);
  if (theme==2) stroke(0xff7092BE);
  if (theme==3) stroke(0xffA78F2A);
  line(515, 0, 515, 700);
  if (theme==0) stroke(255, 255, 0, 70);
  if (theme==1) stroke(0xff0099CE);
  if (theme==2) stroke(0xff7092BE);
  if (theme==3) stroke(0xffA78F2A);
  line(587, 0, 587, 700);
  if (theme==0) stroke(0, 0, 255, 70);
  if (theme==1) stroke(0xff7100CE);
  if (theme==2) stroke(0xff7092BE);
  if (theme==3) stroke(0xffA78F2A);
  line(658, 0, 658, 700);
  strokeWeight(1);
  stroke(0);

  textSize(45);
  fill(205, 205, 245);
  textAlign(CENTER);
  text(infos[(num-1)*4+10], 200, 245);

  textSize(25);
  fill(255, 255, 0);
  text("Score : "+pts, 200, 330);

  best=PApplet.parseInt(infos[((num*4)-1+10)]);

  if (expe==true) {
    exp=PApplet.parseInt(infos[2]);
    expe=false;
  }

  if (jcs==true) {
    jc=PApplet.parseInt(infos[3]);
    jcs=false;
  }

//  if (downKeys['a']) {
//    finish=true; // C'est le fiche r\u00e9sultat qui apparait \u00e0 la fin!
//    start=false;
//  }

  if (resultat==true && exper==true) {
    exp=exp+pts;
    jc=jc+pts/180;
    exper=false;
  }


  metoil=PApplet.parseInt(infos[((num*4)-2+10)]);

  if (etoil>=metoil) {
    metoil=etoil;
  }

  if (songnumber==0) {
    nombredenote=788;
  }
  if (songnumber==1) {
    nombredenote=869;
  }
  if (songnumber==2) {
    nombredenote=753;
  }
  if (songnumber==3) {
    nombredenote=818;
  }
  if (songnumber==4) {
    nombredenote=1126;
  }
  if (songnumber==5) {
    nombredenote=294;
  }

  float m1 = map(17, 0, 100, 0, nombredenote*64);
  float m2 = map(43, 0, 100, 0, nombredenote*64);
  float m3 = map(70, 0, 100, 0, nombredenote*64);

  if (pts<m1) {
    etoil=0;
  }
  if (pts>=m1 && pts<m2) {
    etoil=1;
  }
  if (pts>=m2 && pts<m3) {
    etoil=2;
  }
  if (pts>=m3) {
    etoil=3;
  }

  //Ne pas l'afficher
  textSize(22);
  fill(5, 250, 5);
  text("Meilleur score :" +best, 200, 600);
  //A replacer
  textSize(17);
  fill(250, 250, 155);
  textAlign(LEFT);
  text("Exp\u00e9rience : " +exp, 35, 30);
  fill(255, 250, 0);
  text("Java coins : " +jc, 35, 60);

  noStroke();

  if ((((mousePressed && mouseX>139 && mouseX<259 && mouseY>448 && mouseY<519) && libre==true) || (downKeys[' '])) && ficheresultat==false && !start) start=true;
  affichage();
  libre=false;
  fbest=PApplet.parseInt(infos[((num*4)-1+10)]);
  for (int i = 0; i < notes.size (); i++) {
    Note N = notes.get(i);      //On stock le tableau dans une seule variable pour l'afficher
    N.display();
    N.Point();
  }

  if (start && !pause && !mousePressed) {
    libere=true;
    libre=false;
  }

  if (!start && !mousePressed) {
    libere=false;
    libre=true;
  }

  if (pause) {
    libere=false;
  }


  stroke(0);

  touche();
  fill(couleurNote1);            //Affichage des touches
  rect(427, 600, taille, taille);
  fill(couleurNote2);
  rect(497, 600, taille, taille);
  fill(couleurNote3);
  rect(567, 600, taille, taille);
  fill(couleurNote4);
  rect(637, 600, taille, taille);
  fill(255);
  textSize(20);

  if (((downKeys['x'] || downKeys['X']) || retour==true) && !conseil) {    //Ferme le programme si appuy\u00e9
    Close.pause(); 
    Close.rewind();
    Lions.pause();
    Lions.rewind();
    Communication.pause();
    Communication.rewind();
    StayAway.pause();
    StayAway.rewind();
    HowLong.pause();
    HowLong.rewind();
    Livette.pause();
    Livette.rewind();
    pts=0;
    tra=0;
    state="intro";
    stateTemporary="intro";
    fill(0);
    notes.clear();                       //RESET
    start=false;
    resultat=false;
    songpage=true;
    playon=false;
    retour=false;
  }

  if ((downKeys['c'] || downKeys['C']) && conseil) {
    conseil=false;
    ficheresultat=false;
  }

  if (downKeys['r'] || downKeys['R'] || ((mousePressed && mouseX<139+120 && mouseX>139 && mouseY>460 && mouseY<460+56) && libere==true)) {
    Close.pause(); 
    Close.rewind();
    Lions.pause();
    Lions.rewind();
    Communication.pause();
    Communication.rewind();
    StayAway.pause();
    StayAway.rewind();
    HowLong.pause();
    HowLong.rewind();
    Livette.pause();
    Livette.rewind();
    notes.clear();
    pts=0;
    start=false;
    libere=false;
    libre=false;
  }

  if (pause && !mousePressed) {
    free=true;
  }

  if (!pause && !mousePressed) {
    free=false;
  }

  if ((mousePressed && mouseX<355 && mouseX>300 && mouseY>455 && mouseY<455+55) && free==true) {      
    Close.pause(); 
    Close.rewind();
    Lions.pause();   
    Lions.rewind();
    Communication.pause();
    Communication.rewind();
    StayAway.pause();
    StayAway.rewind();
    HowLong.pause();
    HowLong.rewind();
    Livette.pause();
    Livette.rewind();
    notes.clear();
    start=false;
    libere=false;
    libre=false;
  }


  if (ficheresultat==false) {
    if (((downKeys['p'] || downKeys['P']) || (mousePressed && mouseX<356 && mouseX>300 && mouseY>455 && mouseY<510)) && !pause && start && free==false) pause=true;
    if (downKeys[' '] && pause && start || (mousePressed && mouseX>139 && mouseX<259 && mouseY>448 && mouseY<519)) pause=false;
    if (pause && start) {
      Close.pause();
      Lions.pause();
      Communication.pause();
      StayAway.pause();
      HowLong.pause();
      Livette.pause();
      fill(255, 0, 0);
      textSize(30);
      text("PAUSE", 150, 425);
    }
  }

  if (songnumber == 0 && Close.length()-Close.position()<=500 && start) {
    finish=true;
    start=false;
    Close.rewind();
    Close.pause();
  }
  if (songnumber == 1 && Lions.length()-Lions.position()<=500 && start) {
    finish=true;
    start=false;
    Lions.rewind();
    Lions.pause();
  }
  if (songnumber == 2 && StayAway.length()-StayAway.position()<=300 && start) {
    finish=true;
    start=false;
    StayAway.rewind();
    StayAway.pause();
  }
  if (songnumber == 3 && Communication.length()-Communication.position()<=500 && start) {
    finish=true;
    start=false;
    Communication.rewind();
    Communication.pause();
  }
  if (songnumber == 4 && HowLong.length()-HowLong.position()<=500 && start) {
    finish=true;
    start=false;
    HowLong.pause();
    HowLong.rewind();
  }
  if (songnumber == 5 && Livette.length()-Livette.position()<=500 && start) {
    finish=true;
    start=false;
    Livette.pause();
    Livette.rewind();
  }

  if (conseil==true) {
    ficheresultat=true;
    rect(150, 300, 400, 100, 20);
    textSize(15);
    textAlign(CENTER);    
    fill(167, 167, 0);
    text("Appuyer sur Play ou Espace pour d\u00e9marrer", 350, 320);
    text("Et X pour quitter sans sauvegarder", 350, 350);
    text("Appuyez sur C pour fermer ce conseil", 350, 380);
    textAlign(LEFT); 
    stroke(0);
    line(525, 307, 535, 317);
    line(525, 317, 535, 307);
  }
  if (mousePressed) {
    if (mouseX<535 && mouseX>525 && mouseY>307 && mouseY<317) {
      ficheresultat=false;
      conseil=false;
    }
  }

  for (int i=0; i<5; i++) {
    stroke(0, 0, 50, 200-i*50);
    line(0, R+i, 700, R+i);
  }
  R=R-1;

  fill(222, 222, 222);
  rect(-1, H, 701, 51);
  H=H-1;

  for (int i = 140; i < 700; i = i + 140) {
    stroke(245, 0, 0);
    line(i, T1, i, T2);
  }
  T1--;
  T2--;

  //Fiche R\u00e9sultat
  resultat();
}

public void saveinfo() {

  output = createWriter("songsave.txt");
  output.println(infos[0]);
  output.println(infos[1]);
  output.println(exp);
  output.println(jc);
  output.println(infos[4]);
  output.println(infos[5]);
  for (int i=0; i<10; i++) {
    String[] blok = split(infos[6], ' ');
    if (tj==i) {
      output.print(1+ " ");
    } else {
      output.print(blok[i]+ " ");
    }
  }
  output.println(" ");
  output.println(theme);
  output.println(selecTouche);
  output.println(infos[9]);
  for (int i=0; i<10; i++) {
    output.println(infos[i*4+10]);
    output.println(infos[(i*4)+1+10]);
    if ((i+1)==num) {
      output.println(metoil);
      output.println(pts);
    } else {
      output.println(infos[((i+1)*4)-2+10]);
      output.println(infos[((i+1)*4)-1+10]);
    }
  }
  output.flush();
  output.close();
}

public void touche() {        //Permet que les touches deviennent blanches quand on appuie
  if (theme==0) {                  //Changer les couleurs ici et dans Option
    couleurNote1=0xff00FF00;
    couleurNote2=0xffFF0000;
    couleurNote3=0xffFFFF00;
    couleurNote4=0xff0000FF;
  }
  if (theme==1) {
    couleurNote1=0xffFF0000;
    couleurNote2=0xffFFFF00;
    couleurNote3=0xff0081FF;
    couleurNote4=0xff973EFF;
  }
  if (theme==2) {
    couleurNote1=0xff8FF5F2;
    couleurNote2=0xffFAACE3;
    couleurNote3=0xffF5E8A6;
    couleurNote4=0xffD9F074;
  }
  if (theme==3) {
    couleurNote1=0xffD4AF37;
    couleurNote2=0xffD4AF37;
    couleurNote3=0xffD4AF37;
    couleurNote4=0xffD4AF37;
  }

  if (theme==4) {
    couleurNote1=PApplet.parseInt(random(0xff000000, 0xffFFFFFF));
    couleurNote2=PApplet.parseInt(random(0xff000000, 0xffFFFFFF));
    couleurNote3=PApplet.parseInt(random(0xff000000, 0xffFFFFFF));
    couleurNote4=PApplet.parseInt(random(0xff000000, 0xffFFFFFF));
  }
  //#3F48CC

  if (touche1) {
    cc1=0xffFFFFFF;
  } else cc1=couleurNote1;
  fill(cc1);
  rect(420, 593, taille+14, taille+13);

  if (touche2) {
    cc2=0xffFFFFFF;
  } else cc2=couleurNote2;
  fill(cc2);
  rect(490, 593, taille+14, taille+13);

  if (touche3) {
    cc3=0xffFFFFFF;
  } else cc3=couleurNote3;
  fill(cc3);
  rect(560, 593, taille+14, taille+13);

  if (touche4) {
    cc4=0xffFFFFFF;
  } else cc4=couleurNote4;
  fill(cc4);
  rect(630, 593, taille+14, taille+13);
}

float a=0.33f;
float c=814;
float c1=927;
float c2=1040;
boolean cb1=false;
boolean cb2=false;
boolean cb3=false;
boolean Holdy = false;
boolean soo = false;
boolean ava = false;
boolean rec = false;
boolean avan = false;
boolean recu = false;
boolean playon = false;
boolean bloc = false;
boolean jca = false;
boolean jouer = false;
boolean debloque = false;
String[] infos;
int H=-1;
int ac;
int ab;
int ch;
int bh;
int idb=770;
int num;
int tj;
float debutList = 60;
float debutListe = 110;
float so=-150;

public void songs() {

  if (state=="song") {

    background(162);
    //#0F0A31   #FFF0F0    #000D34
    for (int i=0; i<16; i++) {
      stroke(0, 0, 50, 200-i*12.5f);
      line(0, 50+i, 700, 50+i);
    }

    if (cb1==false) {
      c=c-5;
    }
    if (cb2==false) {
      c1=c1-5.5f;
    }
    if (cb3==false) {
      c2=c2-6;
    }

    if (c<=464.0f) cb1=true;
    if (c1<=542.0f) cb2=true;
    if (c2<=620.0f) cb3=true;

    H=-1;
    R=50;
    T1=5;
    T2=45;
    // String[] infos;
    String[] blok = split(infos[6], ' ');

    if (debutList<-390) {
      idb=650;
    } else {
      idb=770;
    }

    for (int i = PApplet.parseInt (debutList); i < idb; i = i + 110) {

      int i_tmp = i;
      if (i_tmp < 0)
      {  
        i_tmp = -i_tmp;
      }

      int j=PApplet.parseInt ((i_tmp-debutListe)/110);
      fill(255);
      stroke(0, 0, 35);
      strokeWeight(2);

      if (mouseX<675 && mouseX>25 && mouseY>i && mouseY<i+100) {
        if (j<12) {
          if (PApplet.parseInt(blok[j+1])==0) {
            bloc=true;
          } else {
            bloc=false;
          }
        }
      }

      if (mouseX<675 && mouseX>25 && mouseY>i && mouseY<i+100 && keyPressed == false && Holdy != true) {
        stroke(0, 0, 255);
        strokeWeight(4);
        rect(25, i, 650, 100);
        strokeWeight(1);
      } else if (choix==j && Holdy != true) {
        stroke(0, 0, 255);
        strokeWeight(4);
        rect(25, PApplet.parseInt (debutList)+110*j, 650, 100);
        strokeWeight(1);
      }
      if (j<12) {
        if (PApplet.parseInt(blok[j+1])==0) {
          fill(136, 130, 130);
        } else {
          fill(255);
        }
      }
      stroke(0, 0, 35);
      strokeWeight(2);
      rect(25, i, 650, 100);
    }
    ac=PApplet.parseInt(610-debutList);
    ab=PApplet.parseInt(60-debutList);
    bh=(ab/110)+1;
    ch=(ac/110)+1;

    if (choix>=ch && ava==true) {
      debutList=debutList-100;
      debutListe=debutListe-100;
      ava=false;
    }

    if (choix<bh && bh!=1 && rec==true) {
      debutList=debutList+100;
      debutListe=debutListe+100;
      rec=false;
    }

    if (avan==true) {
      debutList=debutList+300;
      debutListe=debutListe+300;
      avan=false;
    }
    if (recu==true) {
      debutList=debutList-300;
      debutListe=debutListe-300;
      recu=false;
    }

    if (ch==9 & choix==9) {
      debutList=-410;
      debutListe=-360;
    }

    for (int b = PApplet.parseInt (debutListe); b < 1100; b = b+ 110) {
      int b_tmp = b;
      if (b_tmp < 0)
      {  
        b_tmp = -b_tmp;
      }
      int j=PApplet.parseInt ((b_tmp-debutListe)/110);

      if (j<10) {
        int d = PApplet.parseInt(infos[2+j*4+10]);

        if (j<10) {
          textSize(30);
          fill(0);
          text(infos[j*4+10], 40, b);
        }

        if (soo==false) {
          so=so+0.5f;
        }
        if (so==40) {
          soo=true;
        }

        if (PApplet.parseInt(blok[j])==1) {
          textSize(22);
          fill(0);
          text(infos[(j*4)+1+10], so, b+30);
        }

        if (PApplet.parseInt(blok[j])==0) {
          textSize(22);
          fill(0);
          text("(Songs)", 40, b+30);
        }

        if (PApplet.parseInt(blok[j])==0) {
          textSize(15);
          fill(0);
          text("Il vous faut 300 JC pour la d\u00e9bloquer", 400, b-15);
          if (mouseX<610 && mouseX>495 && mouseY>b+7 && mouseY<b+32) {
            stroke(255, 0, 0);
            fill(220);
          } else {
            stroke(155, 0, 0);
            fill(200);
          }
          rect(495, b+7, 110, 25);
          textSize(15);
          fill(0);
          text("D\u00e9bloquer", 515, b+25);
        }

        if (mousePressed) {
          if (mouseX<610 && mouseX>495 && mouseY>b+7 && mouseY<b+32 && PApplet.parseInt(blok[j])==0) {
            debloque=true;
            tj=j;
          }
        }
        if (debloque==true) {
          bloc=true;
          stroke(166, 20);
          fill(0, 20);
          rect(0, 0, 700, 700);

          stroke(166);
          fill(250);
          if (jc>=300) { 
            rect(150, 300, 400, 120, 20);
            textSize(17);
            fill(0);
            text("Voulez-vous vraiment la d\u00e9bloquer ?", 200, 330);

            fill(255);
            if (mouseX<300 && mouseX>255 && mouseY>370 && mouseY<400) {
              stroke(0, 155, 0);
            } else {
              stroke(166);
            }
            rect(250, 370, 50, 30, 10);
            if (mouseX<450 && mouseX>300 && mouseY>370 && mouseY<400) {
              stroke(155, 0, 0);
            } else {
              stroke(166);
            }
            rect(400, 370, 50, 30, 10);
            textSize(15);
            fill(0, 255, 0);
            text("Oui", 263, 390);
            fill(255, 0, 0);
            text("Non", 411, 390);
          }
          if (jc<300) {
            
            rect(150, 350, 400, 100, 20);
            textSize(15);
            textAlign(CENTER);    
            fill(167, 167, 0);
            text("Vous n'avez pas assez de Java Coins", 350, 400);
            textAlign(LEFT); 
            stroke(0);
            line(525, 357, 535, 367);
            line(525, 367, 535, 357);
          } 


          if (mousePressed) {
            if (jc>=300) {
              if (mouseX<300 && mouseX>250 && mouseY>370 && mouseY<400) {
                if (jca==false) {
                  jc=jc-300;
                  jca=true;
                  saveinfo();
                  infos=loadStrings("songsave.txt");
                }
                debloque=false;
              }
              if (mouseX<450 && mouseX>400 && mouseY>370 && mouseY<400) {
                debloque=false;
              }
            }
            if (jc<300) {
              if (mouseX<535 && mouseX>525 && mouseY>357 && mouseY<367) {
                debloque=false;
                
              }
            }
          } 
          if (!mousePressed) {
            jca=false;
          }
        }

        stroke(0);

        if (PApplet.parseInt(blok[j])==1) {

          if (d==3 || d==2 || d==1) {
            fill(255, 0, 0);
          }
          if (d==0) {
            noFill();
          }
          beginShape();
          vertex(0*a+c, -100*a+b);
          vertex(22*a+c, -31*a+b);
          vertex(95*a+c, -31*a+b);
          vertex(36*a+c, 11*a+b);  
          vertex(59*a+c, 81*a+b);
          vertex(0*a+c, 38*a+b);
          vertex(-59*a+c, 81*a+b);
          vertex(-36*a+c, 11*a+b);
          vertex(-95*a+c, -31*a+b);
          vertex(-22*a+c, -31*a+b);
          endShape(CLOSE);   

          if (d==1) {
            noFill();
          }
          beginShape();
          vertex(0*a+c1, -100*a+b);
          vertex(22*a+c1, -31*a+b);
          vertex(95*a+c1, -31*a+b);
          vertex(36*a+c1, 11*a+b);
          vertex(59*a+c1, 81*a+b);
          vertex(0*a+c1, 38*a+b);
          vertex(-59*a+c1, 81*a+b);
          vertex(-36*a+c1, 11*a+b);
          vertex(-95*a+c1, -31*a+b);
          vertex(-22*a+c1, -31*a+b);
          endShape(CLOSE);

          if (d==2) {
            noFill();
          }
          beginShape();
          vertex(0*a+c2, -100*a+b);
          vertex(22*a+c2, -31*a+b);
          vertex(95*a+c2, -31*a+b);
          vertex(36*a+c2, 11*a+b);
          vertex(59*a+c2, 81*a+b);
          vertex(0*a+c2, 38*a+b);
          vertex(-59*a+c2, 81*a+b);
          vertex(-36*a+c2, 11*a+b);
          vertex(-95*a+c2, -31*a+b);
          vertex(-22*a+c2, -31*a+b);
          endShape(CLOSE);
        }
      }
    }

    fill(222, 222, 222);
    rect(-1, -1, 701, 51);

    for (int i = 140; i < 700; i = i + 140) {
      stroke(245, 0, 0);
      line(i, 5, i, 45);
    }

    for (int i=0; i<5; i++) {
      stroke(0, 0, 50, 200-i*50);
      line(0, 50+i, 700, 50+i);
    }

    if (PApplet.parseInt(blok[choix])==1) {
      jouer=true;
    } else {
      jouer=false;
    }

    if (keyPressed == true && songpage==false) {
      if (key == ENTER && jouer==true) {

        songnumber=choix;
        num=choix+1;

        state="play";
        stateTemporary="play";

        fichiers();
        play();
        playon=true;

        if (unotice==false) {
          conseil=true;
        }
        chansonfini=false;    
        fichiers();

        jouer=true;
      }
    }
  }

  if (playon==true) {
    play();
  }
}

public void mousePressed() {
  if (state == "song" && playon==false) {
    if (mouseX<680 && mouseX>10 && mouseY>debutList && mouseY<700) {
      int y = PApplet.parseInt((mouseY - debutList) / 110);

      num=y+1;
      songnumber=y;
    }
  }
}

public void mouseWheel(MouseEvent event) {
  if (state == "song") {
    float e = -event.getCount();
    if (debutList<=60 && debutList>=-410) {
      debutList = debutList + 10*e;
      debutListe = debutListe + 10*e;
    }
    if (debutList>=-410) {
      if (debutList<=80 && e<0) {
        debutList = debutList + 10*e;
        debutListe = debutListe + 10*e;
      } 

      if (debutList>=80 && e<0) {
        debutList = debutList + 10*e;
        debutListe = debutListe + 10*e;
      }
    }
    if (debutList<=-420 && e==1) {
      debutList = debutList + 10*e;
      debutListe = debutListe + 10*e;
    }
  }
}

boolean ficheresultat=false;
boolean psjc=false;
boolean chansonfini=false;
boolean fin=false;
boolean homesick=false;
boolean songsong=false;
boolean bsjc=true;
int fbest;
int sjc;
int niv;
int titre;

public void resultat() {

  if (finish==true) {
    ficheresultat=true;
    transparence=true;
    apparait=true;
    resultat=true;

    finish=false;
  }

  if (transparence==true) {
    fill(0, tra);
    stroke(0);
    rect(0, 0, 700, 700);
  }

  if (resultat==true) {

    fill(255, 250, 219);
    stroke(255, 255, 0);
    rect(ro, ra, 400, 400);

    //Etoiles de d\u00e9part (avec le rect.)

    a=0.53f;
    float ar=0.60f;
    int cp=ro+70;
    int cp1=ro+200;
    int cp2=ro+330;
    int b=ra+10;
    int b1=ra+20;

    strokeWeight(4);
    stroke(255, 225, 0);

    if (etoil==3 || etoil==2 || etoil==1) {
      fill(255, 255, 0);
    }
    if (etoil==0) {
      fill(255, 250, 219);
    }

    beginShape();
    vertex(0*a+cp, -100*a+b1);
    vertex(22*a+cp, -31*a+b1);
    vertex(95*a+cp, -31*a+b1);
    vertex(36*a+cp, 11*a+b1);
    vertex(59*a+cp, 81*a+b1);
    vertex(0*a+cp, 38*a+b1);
    vertex(-59*a+cp, 81*a+b1);
    vertex(-36*a+cp, 11*a+b1);
    vertex(-95*a+cp, -31*a+b1);
    vertex(-22*a+cp, -31*a+b1);
    endShape(CLOSE);

    if (etoil==1) {
      fill(200);
    }

    beginShape();
    vertex(0*ar+cp1, -100*ar+b);
    vertex(22*ar+cp1, -31*ar+b);
    vertex(95*ar+cp1, -31*ar+b);
    vertex(36*ar+cp1, 11*ar+b);
    vertex(59*ar+cp1, 81*ar+b);
    vertex(0*ar+cp1, 38*ar+b);
    vertex(-59*ar+cp1, 81*ar+b);
    vertex(-36*ar+cp1, 11*ar+b);
    vertex(-95*ar+cp1, -31*ar+b);
    vertex(-22*ar+cp1, -31*ar+b);
    endShape(CLOSE);

    if (etoil==2) {
      fill(200);
    }

    beginShape();
    vertex(0*a+cp2, -100*a+b1);
    vertex(22*a+cp2, -31*a+b1);
    vertex(95*a+cp2, -31*a+b1);
    vertex(36*a+cp2, 11*a+b1);
    vertex(59*a+cp2, 81*a+b1);
    vertex(0*a+cp2, 38*a+b1);
    vertex(-59*a+cp2, 81*a+b1);
    vertex(-36*a+cp2, 11*a+b1);
    vertex(-95*a+cp2, -31*a+b1);
    vertex(-22*a+cp2, -31*a+b1);
    endShape(CLOSE);

    strokeWeight(1);

    // Le texte :

    textSize(30);
    fill(0, 0, 255);
    textAlign(CENTER);
    text("GOOD JOB", ro+200, ra+100);

    textSize(17);
    textAlign(LEFT);
    if (metoil>etoil) {
      if (pts>fbest) {
        fill(0, 135, 0);
        text("Best:", ro+275, ra+240);
      } else {
        fill(0, 135, 0);
        text("Best:", ro+275, ra+160);
      }
    }
    textSize(20);
    fill(255, 0, 0);
    if (pts<best) {
      text("Score: " + pts, ro+20, ra+160);
      textSize(17);
      text("Meilleur Score: " + best, ro+20, ra+190);
    } 
    if (pts==fbest) {
      text("Votre score: " + pts, ro+20, ra+160);
      fill(255, 255, 0);
      text( pts, ro+145, ra+160);
    }
    if (pts>fbest) {
      textSize(22);
      fill(255, 255, 0);
      textAlign(CENTER);
      text("Votre nouveau meilleur", 350, ra+160);
      text("score : " + pts, 350, ra+190);
      fill(255, 0, 0);
      text("Votre nouveau meilleur", 351, ra+160);
      text("score : " + pts, 351, ra+190);
    }

    if (bsjc==true) {
      sjc=pts/180;
    }

    textSize(17);
    textAlign(LEFT);
    fill(125, 120, 0);
    text("Java coins : " +sjc, ro+20, ra+240);
    fill(200);
    bsjc=false;

    fill(200);
    a=0.1f;
    int aze=ro+330;
    int ytr=ra+155;

    if (pts>fbest) {
      ytr=ra+235;
    }

    // Etoile(s) meilleurs

    stroke(240, 172, 0);
    if (metoil==3 || metoil==2 || metoil==1) {
      fill(255, 255, 0);
    }
    if (metoil==0) {
      fill(255);
    }
    if (metoil>etoil) {
      beginShape();
      vertex(0*a+aze, -100*a+ytr);
      vertex(22*a+aze, -31*a+ytr);
      vertex(95*a+aze, -31*a+ytr);
      vertex(36*a+aze, 11*a+ytr);
      vertex(59*a+aze, 81*a+ytr);
      vertex(0*a+aze, 38*a+ytr);
      vertex(-59*a+aze, 81*a+ytr);
      vertex(-36*a+aze, 11*a+ytr);
      vertex(-95*a+aze, -31*a+ytr);
      vertex(-22*a+aze, -31*a+ytr);
      endShape(CLOSE);

      if (metoil==1) {
        noFill();
      }

      aze=ro+355;

      beginShape();
      vertex(0*a+aze, -100*a+ytr);
      vertex(22*a+aze, -31*a+ytr);
      vertex(95*a+aze, -31*a+ytr);
      vertex(36*a+aze, 11*a+ytr);
      vertex(59*a+aze, 81*a+ytr);
      vertex(0*a+aze, 38*a+ytr);
      vertex(-59*a+aze, 81*a+ytr);
      vertex(-36*a+aze, 11*a+ytr);
      vertex(-95*a+aze, -31*a+ytr);
      vertex(-22*a+aze, -31*a+ytr);
      endShape(CLOSE);

      if (metoil==2) {
        noFill();
      }
      aze=ro+380;

      beginShape();
      vertex(0*a+aze, -100*a+ytr);
      vertex(22*a+aze, -31*a+ytr);
      vertex(95*a+aze, -31*a+ytr);
      vertex(36*a+aze, 11*a+ytr);
      vertex(59*a+aze, 81*a+ytr);
      vertex(0*a+aze, 38*a+ytr);
      vertex(-59*a+aze, 81*a+ytr);
      vertex(-36*a+aze, 11*a+ytr);
      vertex(-95*a+aze, -31*a+ytr);
      vertex(-22*a+aze, -31*a+ytr);
      endShape(CLOSE);
    }
    a=0.33f;

    //Bouton Replay

    stroke(255, 0, 0);
    fill(234, 217, 223);
    if (mouseX<ro+250 && mouseX>ro+150 && mouseY>ra+315 && mouseY<ra+345) {
      fill(200, 200, 215);
    }
    rect(ro+150, ra+315, 100, 30);
    textAlign(CENTER);
    fill(140, 100, 42);
    text("Rejouer", ro+200, ra+335);
    textAlign(LEFT);

    if (mousePressed && mouseX<ro+250 && mouseX>ro+150 && mouseY>ra+315 && mouseY<ra+345) {      //Bouton reset (R\u00e9sultat)
      apparait=false;
      disparait=true;
      conseil=false;
      Close.pause(); 
      Close.rewind();
      Lions.pause();
      Lions.rewind();
      Communication.pause();
      Communication.rewind();
      StayAway.pause();
      StayAway.rewind();
      HowLong.pause();
      HowLong.rewind();
      Livette.pause();
      Livette.rewind();
      notes.clear();
      start=false;
      libere=false;
      libre=false;
      saveinfo();
      infos=loadStrings("songsave.txt");
    }

    //Bouton Menu

    fill(170, 170, 255);
    stroke(255, 0, 0);

    if (mouseX<ro+110 && mouseX>ro+60 && mouseY>ra+310 && mouseY<ra+350) {
      fill(210, 210, 255);
    }

    beginShape();
    vertex(ro+85, ra+300);
    vertex(ro+110, ra+320);
    vertex(ro+110, ra+350);
    vertex(ro+60, ra+350);
    vertex(ro+60, ra+320);
    vertex(ro+85, ra+300);
    endShape(CLOSE);

    if (mousePressed && mouseX<ro+110 && mouseX>ro+60 && mouseY>ra+310 && mouseY<ra+350) {      //Bouton home (r\u00e9sultat)
      apparait=false;
      disparait=true;
      if (pts>=best) {
        best=pts;
        saveinfo();
        infos=loadStrings("songsave.txt");
      }
      libre=false;
      Close.pause(); 
      Close.rewind();
      Lions.pause();
      Lions.rewind();
      Communication.pause();
      Communication.rewind();
      StayAway.pause();
      StayAway.rewind();
      HowLong.pause();
      HowLong.rewind();
      Livette.pause();
      Livette.rewind();
      pts=0;
      state="intro";
      stateTemporary="intro";
      notes.clear();    
      homesick=true;
      transparence=false;
      ficheresultat=false;
      resultat=false;
      start=false;
      ro=-400;
      ra=205;
    }

    //Bouton List chanson

    noFill();
    noStroke();
    rect(ro+290, ra+300, 50, 50);

    if (mouseX<ro+340 && mouseX>ro+290 && mouseY>ra+300 && mouseY<ra+350) {
      fill(0, 0, 255);
    }

    for (int i=0; i<40; i=i+15) {
      stroke(0);
      fill(0);
      rect(ro+290, ra+305+i, 50, 10);
    }

    if (mousePressed && mouseX<ro+340 && mouseX>ro+290 && mouseY>ra+300 && mouseY<ra+350) {      //Bouton chansons (r\u00e9sultat)
      apparait=false;
      disparait=true;
      if (pts>=best) {
        best=pts;
        saveinfo();
        infos=loadStrings("songsave.txt");
      }
      libre=false;
      Close.pause(); 
      Close.rewind();
      Lions.pause();
      Lions.rewind();
      Communication.pause();
      Communication.rewind();
      StayAway.pause();
      StayAway.rewind();
      HowLong.pause();
      HowLong.rewind();
      Livette.pause();
      Livette.rewind();
      pts=0;
      state="intro";
      stateTemporary="song";
      notes.clear();
      homesick=true;
      transparence=false;
      ficheresultat=false;
      resultat=false;
      start=false;
      ro=-400;
      ra=205;
    }

    output = createWriter("songsave.txt");
    output.println(infos[0]);
    output.println(infos[1]);
    output.println(exp);
    output.println(jc);
    output.println(infos[4]);
    output.println(infos[5]);
    output.println(infos[6]);
    output.println(infos[7]);
    output.println(infos[8]);
    output.println(infos[9]);
    for (int i=0; i<10; i++) {
      output.println(infos[i*4+10]);
      output.println(infos[(i*4)+1+10]);
      if ((i+1)==num) {
        output.println(metoil);
        output.println(best);
      } else {
        output.println(infos[((i+1)*4)-2+10]);
        output.println(infos[((i+1)*4)-1+10]);
      }
    }
    output.flush();
    output.close();

    infos=loadStrings("songsave.txt");
  }

  price();

  if (apparait==true) {
    if (tra<156) {   
      tra=tra+12;
    }
    if (ra>150) {
      ra=ra-1;
    }
    if (ro<150) {
      ro=ro+10;
    }
  }

  if (disparait==true) {
    if (ra<=205) {
      ra=ra+1;
    }
    if (ro<=700) {
      ro=ro+10;
    }
    if (tra>0) {
      tra=tra-12;
    }
    if (ra>=204) {
      fin=true;
    }
  }

  if (fin==true) {
    if (pts>=best) {
      best=pts;
      saveinfo();
      infos=loadStrings("songsave.txt");
    }
    pts=0;
    tra=0;
    bsjc=true;
    transparence=false;
    ficheresultat=false;
    resultat=false;
    disparait=false;
    exper=true;
    ro=-400;
    ra=205;
    fin=false;
  }
}

public void price() {
  if (exp<5000) { 
    niv=1; 
    titre=0;
  }
  if (exp>=5000 && exp<15000) { 
    niv=2;  
    titre=1;
  }
  if (exp>=15000 && exp<35000) niv=3;
  if (exp>=35000 && exp<55000) niv=4;
  if (exp>=55000 && exp<800000) niv=5;
  if (exp>=800000 && exp<1200000) { 
    niv=6; 
    titre=2;
  }
  if (exp>=1200000 && exp<1500000) niv=7;
  if (exp>=1500000 && exp<2500000) niv=8;
  if (exp>=2500000 && exp<5000000) { 
    niv=9; 
    titre=3;
  }
  if (exp>=5000000 && exp<35000000) niv=10;
  if (exp>=35000000 && exp<100000000) niv=11;
  if (exp>100000000) {
    niv=12; 
    titre=4;
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Java_Tiles" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
