void affichage() {    //Mise en place des notes selon le fichier texte join, les 1 sont des notes, les 2 seront plus longue mais pas encore programmées et les 3 pour afficher la fiche

    if (songnumber==0) {
    vitesse=5.69;
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
    vitesse=4.4;
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
    vitesse=7.11;
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
    vitesse=4.22;
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
    vitesse=4.09;
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

