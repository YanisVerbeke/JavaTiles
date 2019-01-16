void fichiers() {
  if (songnumber==0) {  
    song = new int[fichier.length][4];
    for (int i=0; i<fichier.length; i++) {
      String tab[]=split(fichier[i], " ");
      for (int j=0; j<4; j++) {
        song[i][j]=int(tab[j]);
      }
    }
  }

  if (songnumber==1) { 
    song2 = new int[fichier2.length][4];
    for (int i=0; i<fichier2.length; i++) {
      String tab[]=split(fichier2[i], " ");
      for (int j=0; j<4; j++) {
        song2[i][j]=int(tab[j]);
      }
    }
  }

  if (songnumber==2) {
    song4 = new int[fichier4.length][4];
    for (int i=0; i<fichier4.length; i++) {
      String tab[]=split(fichier4[i], " ");
      for (int j=0; j<4; j++) {
        song4[i][j]=int(tab[j]);
      }
    }
  }

  if (songnumber==3) {
    song3 = new int[fichier3.length][4];
    for (int i=0; i<fichier3.length; i++) {
      String tab[]=split(fichier3[i], " ");
      for (int j=0; j<4; j++) {
        song3[i][j]=int(tab[j]);
      }
    }
  }
  if (songnumber==4) {
    song5 = new int[fichier5.length][4];
    for (int i=0; i<fichier5.length; i++) {
      String tab[]=split(fichier5[i], " ");
      for (int j=0; j<4; j++) {
        song5[i][j]=int(tab[j]);
      }
    }
  }
  if (songnumber==5) {
    song6 = new int[fichier6.length][4];
    for (int i=0; i<fichier6.length; i++) {
      String tab[]=split(fichier6[i], " ");
      for (int j=0; j<4; j++) {
        song6[i][j]=int(tab[j]);
      }
    }
  }
}

