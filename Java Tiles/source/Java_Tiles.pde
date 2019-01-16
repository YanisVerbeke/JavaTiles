//Jeu de rythme réalisé par Samuel Sylverius et Yanis Verbeke, 2018
import ddf.minim.*;
Minim minim;
AudioPlayer Close;
AudioPlayer Lions;
AudioPlayer Communication;
AudioPlayer StayAway;
AudioPlayer HowLong;
AudioPlayer Livette;
float vitesse=5.69;
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
  "Débutant", "Guitariste", "Master", "GuitarMaster", "Guitar Hero"
};
int songnumber=0;
int taille=40;    //Taille des touches, et réferences pour les notes
int menu = 0;
int choix = 0;
int index=0;
int couleur=255;  
int remplissage=0;

void setup() {
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
  theme=int(infos[7]);
  selecTouche=int(infos[8]);
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

void draw() { 
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

    exp=int(infos[2]);
    jc=int(infos[3]);

    fill(153, 217, 234);    //Expérience
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
    text("Réalisé par Yanis Verbeke (                       ) et ", 380, 690);
    if (mouseX>510 && mouseX<585 && mouseY>678 && mouseY<695) {
      text("Ouais je fais ma pub je suis comme ça ;)", 450, 675);
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
        //Cela a sert de défiler les étoiles pour la 2eme fois
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

void mouseMoved() {
  if (Hold == true) {
    move=true;
  }
}

void keyPressed() {
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

