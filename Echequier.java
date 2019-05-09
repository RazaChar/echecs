public class Echequier
{
  private Piece[] cases;

  public Echequier()
  {
    this.cases=new Piece[64];

    //Pièces blanches :
    this.cases[0]=new Tour(false,1,0,0);
    this.cases[1]=new Cavalier(false,1,1,0);
    this.cases[2]=new Fou(false,1,2,0);
    this.cases[3]=new Dame(false,1,3,0);
    this.cases[4]=new Roi(false,1,4,0);
    this.cases[5]=new Fou(false,1,5,0);
    this.cases[6]=new Cavalier(false,1,6,0);
    this.cases[7]=new Tour(false,1,7,0);

    for(int i=0;i<8;i++)
    {
      this.cases[i]=new Pion(false,1,i,1);
    }

    //Pièces noirs :
    this.cases[63]=new Tour(false,0,0,7);
    this.cases[62]=new Cavalier(false,0,1,7);
    this.cases[61]=new Fou(false,0,2,7);
    this.cases[60]=new Dame(false,0,3,7);
    this.cases[59]=new Roi(false,0,4,7);
    this.cases[58]=new Fou(false,0,5,7);
    this.cases[57]=new Cavalier(false,0,6,7);
    this.cases[56]=new Tour(false,0,7,7);

    for(int i=55;i>47;i--)
    {
      this.cases[i]=new Pion(false,0,i,6);
    }
  }

  //les méthodes set et get sont appelé sur un échequier
  public Piece get_case(int x,int y)
  {
    return this.cases[x+y*8];
  }

  public void set_case(int x,int y,Piece p)//cette méthode est utilisé pour les méthodes manger
  {
    p.set_x(x);
    p.set_y(y);
    this.cases[x+y*8]=p;
  }

  public void set_case(int x,int y)//met null dans la case
  {
    this.cases[x+y*8]=null;
  }





  public boolean mouv_valide(Piece p,int dest_x,int dest_y)//vérifier si Piece p est nécessaire en fonction du p
  {
    if (!(p.mouv_possible(dest_x,dest_y)))
    {
      return false;
    }

    if(this.manger_possible(p,dest_x,dest_y))
    {
      return true;
    }

    //en fonction de la direction, faire une boucle while x!=dest_x... pour parcourir la distance
    //et vérifier qu'il n'y a pas de pièce sur la route qui bloque le passage.

    //faire un if TYPE OBJECT cavalier pour faire d'une façcon différente

    int[] tab=p.direction(dest_x,dest_y);
    int x=p.get_x();
    int y=p.get_y();

    while(x!=dest_x && y!=dest_y)//vérifier cette condition après l'ajout de la classe cavalier
    {
      x=x+tab[0];
      y=y+tab[1];

      if(this.cases[x+y*8]!=null) //vérifier ce que le this pointe
      {
        return false;
      }
    }
    return true;
  }

  public boolean manger_possible(Piece p,int x,int y)
  {
    if(this.cases[x+y*8]!=null)
    {
      if(this.cases[x+y*8].get_couleur()!=p.get_couleur())
      {
        return true;
      }
    }
    return false;
  }

  public void manger(Piece p,int x,int y)
  {
    int x_sup=p.get_x();
    int y_sup=p.get_y();

    this.set_case(x,y,p);

    this.set_case(x_sup,y_sup);
  }

  public Piece x_y_to_piece(int x,int y)
  {
    return this.cases[x+y*8];
  }

  public roque_possible(Roi r,Tour t)
  {
    return r.get_etat() && t.get_etat();
  }

  public roque(Roi r,Tour t)
  {
    
  }


}
