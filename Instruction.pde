int page=0;
boolean tap=true;
boolean top=false;

void instruction() {

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

  fill(#5596B1);
  textSize(15);
  if (page==0) {
    textSize(30);
    fill(14, 101, 126);
    text(" Bienvenue dans Java Tiles.", 150, 190);
    textSize(15);
    fill(#5596B1);
    text("Le but de jeu est de suivre une chanson choisie en appuyant sur la touche qui correspond à la note au bon moment, afin de récolter le plus haut score possible.", 90, 230, 500, 400);
    if (theme<2) {
      text("Il y a quatres touches différentes pour quatres types de notes : Vert, Rouge, Jaune, Bleu. ", 90, 320, 500, 400);
    } else {
      text("Il y a quatres touches différentes pour quatres types de notes. ", 90, 320, 500, 400);
    }
    text("Vous pouvez choisir quelles touches vous souhaitez utiliser, celles par défaut étant Q, S, D et F.", 90, 390, 500, 400);
    text("Les points vous permettront d'obtenir de l'experience et des Java Coins, la monnaie necessaire pour débloquer de nouvelles chansons ainsi que des élements cosmétiques.", 90, 450, 500, 400);
  }
  if (page==1) {
    text("Pour jouer, appuyez sur Play puis choisissez votre chanson. Ensuite, appuyez à nouveau sur Play pour lancer le jeu. ", 90, 230, 500, 500);
    text("Pendant le partie, vous pouvez mettre la chanson en pause en appuyant sur P, ou bien quitter la partie et revenir au menu principal en appuyant sur X.", 90, 290, 500, 500);
    text("Vous pouvez aussi réinitialiser la chanson en appuyant sur R.", 90, 380, 500, 500);
    text("ATTENTION : Ne pas rester appuyé sur les touches lorsque vous jouez.", 90, 430, 500, 500);
  }
  if (page==2) { 
    text("Lorsque vous appuyez sur une touche, le contour de celle ci devient blanc pour indiquer sur quelle touche vous appuyez.", 90, 230, 500, 500);
    text("Cependant il est possible qu'elle ne change pas de couleur, les points seront tout de même comptés si la touche est appuyée au bon moment. ", 90, 300, 500, 500);
  }
  if (page==3) {
    text("Dans la page Option, vous pouvez choisir le theme (les couleurs) utilisé, certains étant bloqués, les touches avec lesquelles vous voulez jouer, ainsi qu'une option permettant d'afficher ou non le conseil au début de chaque chanson.", 90, 230, 500, 500);
    text("Vous avez aussi la possibilité de réinitialiser votre progression", 90, 380, 500, 500);
    text("ATTENTION ! Cela effacera vos scores, votre expérience et vos Java Coins, et bloquera tous les élements que vous avez débloqués", 90, 430, 500, 500);
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

void mouseReleased() {
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

void keyReleased() {
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

