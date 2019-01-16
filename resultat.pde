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

void resultat() {

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

    //Etoiles de départ (avec le rect.)

    a=0.53;
    float ar=0.60;
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
    a=0.1;
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
    a=0.33;

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

    if (mousePressed && mouseX<ro+250 && mouseX>ro+150 && mouseY>ra+315 && mouseY<ra+345) {      //Bouton reset (Résultat)
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

    if (mousePressed && mouseX<ro+110 && mouseX>ro+60 && mouseY>ra+310 && mouseY<ra+350) {      //Bouton home (résultat)
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

    if (mousePressed && mouseX<ro+340 && mouseX>ro+290 && mouseY>ra+300 && mouseY<ra+350) {      //Bouton chansons (résultat)
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

void price() {
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

