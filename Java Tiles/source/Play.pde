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
color cc1=#00FF00, cc2=#FF0000, cc3=#FFFF00, cc4=#0000FF;

void play() {

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
  if (theme==1) stroke(#B40000);
  if (theme==2) stroke(#7092BE); //(112, 146, 190);
  if (theme==3) stroke(#A78F2A);
  line(447, 0, 447, 700);
  if (theme==0) stroke(255, 0, 0, 70);
  if (theme==1) stroke(#CECB00);
  if (theme==2) stroke(#7092BE);
  if (theme==3) stroke(#A78F2A);
  line(515, 0, 515, 700);
  if (theme==0) stroke(255, 255, 0, 70);
  if (theme==1) stroke(#0099CE);
  if (theme==2) stroke(#7092BE);
  if (theme==3) stroke(#A78F2A);
  line(587, 0, 587, 700);
  if (theme==0) stroke(0, 0, 255, 70);
  if (theme==1) stroke(#7100CE);
  if (theme==2) stroke(#7092BE);
  if (theme==3) stroke(#A78F2A);
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

  best=int(infos[((num*4)-1+10)]);

  if (expe==true) {
    exp=int(infos[2]);
    expe=false;
  }

  if (jcs==true) {
    jc=int(infos[3]);
    jcs=false;
  }

//  if (downKeys['a']) {
//    finish=true; // C'est le fiche résultat qui apparait à la fin!
//    start=false;
//  }

  if (resultat==true && exper==true) {
    exp=exp+pts;
    jc=jc+pts/180;
    exper=false;
  }


  metoil=int(infos[((num*4)-2+10)]);

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
  text("Expérience : " +exp, 35, 30);
  fill(255, 250, 0);
  text("Java coins : " +jc, 35, 60);

  noStroke();

  if ((((mousePressed && mouseX>139 && mouseX<259 && mouseY>448 && mouseY<519) && libre==true) || (downKeys[' '])) && ficheresultat==false && !start) start=true;
  affichage();
  libre=false;
  fbest=int(infos[((num*4)-1+10)]);
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

  if (((downKeys['x'] || downKeys['X']) || retour==true) && !conseil) {    //Ferme le programme si appuyé
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
    text("Appuyer sur Play ou Espace pour démarrer", 350, 320);
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

  //Fiche Résultat
  resultat();
}

void saveinfo() {

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

void touche() {        //Permet que les touches deviennent blanches quand on appuie
  if (theme==0) {                  //Changer les couleurs ici et dans Option
    couleurNote1=#00FF00;
    couleurNote2=#FF0000;
    couleurNote3=#FFFF00;
    couleurNote4=#0000FF;
  }
  if (theme==1) {
    couleurNote1=#FF0000;
    couleurNote2=#FFFF00;
    couleurNote3=#0081FF;
    couleurNote4=#973EFF;
  }
  if (theme==2) {
    couleurNote1=#8FF5F2;
    couleurNote2=#FAACE3;
    couleurNote3=#F5E8A6;
    couleurNote4=#D9F074;
  }
  if (theme==3) {
    couleurNote1=#D4AF37;
    couleurNote2=#D4AF37;
    couleurNote3=#D4AF37;
    couleurNote4=#D4AF37;
  }

  if (theme==4) {
    couleurNote1=int(random(#000000, #FFFFFF));
    couleurNote2=int(random(#000000, #FFFFFF));
    couleurNote3=int(random(#000000, #FFFFFF));
    couleurNote4=int(random(#000000, #FFFFFF));
  }
  //#3F48CC

  if (touche1) {
    cc1=#FFFFFF;
  } else cc1=couleurNote1;
  fill(cc1);
  rect(420, 593, taille+14, taille+13);

  if (touche2) {
    cc2=#FFFFFF;
  } else cc2=couleurNote2;
  fill(cc2);
  rect(490, 593, taille+14, taille+13);

  if (touche3) {
    cc3=#FFFFFF;
  } else cc3=couleurNote3;
  fill(cc3);
  rect(560, 593, taille+14, taille+13);

  if (touche4) {
    cc4=#FFFFFF;
  } else cc4=couleurNote4;
  fill(cc4);
  rect(630, 593, taille+14, taille+13);
}

