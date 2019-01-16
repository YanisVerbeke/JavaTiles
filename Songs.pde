float a=0.33;
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

void songs() {

  if (state=="song") {

    background(162);
    //#0F0A31   #FFF0F0    #000D34
    for (int i=0; i<16; i++) {
      stroke(0, 0, 50, 200-i*12.5);
      line(0, 50+i, 700, 50+i);
    }

    if (cb1==false) {
      c=c-5;
    }
    if (cb2==false) {
      c1=c1-5.5;
    }
    if (cb3==false) {
      c2=c2-6;
    }

    if (c<=464.0) cb1=true;
    if (c1<=542.0) cb2=true;
    if (c2<=620.0) cb3=true;

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

    for (int i = int (debutList); i < idb; i = i + 110) {

      int i_tmp = i;
      if (i_tmp < 0)
      {  
        i_tmp = -i_tmp;
      }

      int j=int ((i_tmp-debutListe)/110);
      fill(255);
      stroke(0, 0, 35);
      strokeWeight(2);

      if (mouseX<675 && mouseX>25 && mouseY>i && mouseY<i+100) {
        if (j<12) {
          if (int(blok[j+1])==0) {
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
        rect(25, int (debutList)+110*j, 650, 100);
        strokeWeight(1);
      }
      if (j<12) {
        if (int(blok[j+1])==0) {
          fill(136, 130, 130);
        } else {
          fill(255);
        }
      }
      stroke(0, 0, 35);
      strokeWeight(2);
      rect(25, i, 650, 100);
    }
    ac=int(610-debutList);
    ab=int(60-debutList);
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

    for (int b = int (debutListe); b < 1100; b = b+ 110) {
      int b_tmp = b;
      if (b_tmp < 0)
      {  
        b_tmp = -b_tmp;
      }
      int j=int ((b_tmp-debutListe)/110);

      if (j<10) {
        int d = int(infos[2+j*4+10]);

        if (j<10) {
          textSize(30);
          fill(0);
          text(infos[j*4+10], 40, b);
        }

        if (soo==false) {
          so=so+0.5;
        }
        if (so==40) {
          soo=true;
        }

        if (int(blok[j])==1) {
          textSize(22);
          fill(0);
          text(infos[(j*4)+1+10], so, b+30);
        }

        if (int(blok[j])==0) {
          textSize(22);
          fill(0);
          text("(Songs)", 40, b+30);
        }

        if (int(blok[j])==0) {
          textSize(15);
          fill(0);
          text("Il vous faut 300 JC pour la débloquer", 400, b-15);
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
          text("Débloquer", 515, b+25);
        }

        if (mousePressed) {
          if (mouseX<610 && mouseX>495 && mouseY>b+7 && mouseY<b+32 && int(blok[j])==0) {
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
            text("Voulez-vous vraiment la débloquer ?", 200, 330);

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

        if (int(blok[j])==1) {

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

    if (int(blok[choix])==1) {
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

void mousePressed() {
  if (state == "song" && playon==false) {
    if (mouseX<680 && mouseX>10 && mouseY>debutList && mouseY<700) {
      int y = int((mouseY - debutList) / 110);

      num=y+1;
      songnumber=y;
    }
  }
}

void mouseWheel(MouseEvent event) {
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

