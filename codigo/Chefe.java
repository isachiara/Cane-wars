import greenfoot.*;

/**
 * Write a description of class Chefe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chefe extends Naves
{
    /**
     * Act - do whatever the Chefe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int pontos = 150;
    int lives = 5;
    int mover = 2;
    int auxiliar = 0;
    
    public void act() 
    {
        
        Mover();
        int i = auxiliar;
        if(i==12){
            Atirar();
            auxiliar=0;
        }
        i=auxiliar+1;
        auxiliar = i;
    }
    
    public void Mover(){
        move(mover);
         if (getX()==9){
             mover=-1;
        }
        if(getX()==0){
             mover=1;
        }
    }
    
    public void Atirar(){
        BalaInimigo bala_Inimigo = new BalaInimigo();        
        getWorld().addObject(bala_Inimigo,getX(),getY());
        bala_Inimigo.SetXY(getX(),getY());
    }
    
    public void tirarVida()
    {
       if(lives>0){
         --lives;
       }
       
       if (lives == 0){     
           Morrer();        
       }        
    }
    
    public void Morrer(){
       Space space=(Space)getWorld();
       Protagonista prot=space.retornaProtagonista();
       prot.pontuação=prot.pontuação+pontos;
       space.rounds++;
       getWorld().removeObject(this);
    }
}