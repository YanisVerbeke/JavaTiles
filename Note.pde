class Note {      //Les notes qui tombent, dans l'ordre vert rouge jaune bleue, 
  int x;
  float y;
  color c;

  Note(int coordX, color couleur, float coordY) {
    x= coordX;
    c=couleur;
    y=coordY;
  }

  void display() {      //Affichage des notes
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

  void Point() {
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

