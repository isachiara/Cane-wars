import greenfoot.*;

/**
 * Write a description of class Inimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo extends Naves
{ 
    /**
     * Act - do whatever the Inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int auxiliar = 0;
    int mover=1;  
    int pontos=5;
    public void act() 
    {      
        Mover();        
        // Add your action code here.
        int i = auxiliar;
        //i=//getRandomNumber(auxiliar);
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
    public void Morrer(){
    Space space=(Space)getWorld();
    Protagonista prot=space.retornaProtagonista();
    prot.pontuação=prot.pontuação+pontos;
    prot.Pontos();
    getWorld().removeObject(this);
    
    }
    
    }
    
    
    
    

