import greenfoot.*;
import java.util.List;
import java.*;
/**
 * Write a description of class BalaInimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaInimigo extends Actor
{
    int xbala,ybala;  
    int vidas;
    /**
     * Act - do whatever the BalaInimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BalaInimigo(){
        
    }   
    public void act() 
    {                      
        mover(xbala,ybala+1);//o +1 no ybala serve para a bala se mover para frente
        if(foundProtagonista() == true){                      
              getWorld().removeObject(this);
            
        }else  if(foundBala() == true){
            killBala();       
        }else if (getY() == 9){
            acharParede();
        }
    }
    
    public void mover(int x,int y){    
        setLocation(x,y);//método para ir se movimentando a bala
        SetXY(x,y);      
    } 
    
     public void SetXY(int x, int y){//pega os valores do inimigo no mapa e coloca nas variaveis xbala e ybala
        xbala=x;
        ybala=y;   
    }
    
    public void acharParede()
    {
        if  (getY() == 9)        
        {           
            Greenfoot.delay(0);
            getWorld().removeObject(this);
        }
    }
      
    public boolean foundProtagonista()
    {                       
        Actor Protagonista = getOneObjectAtOffset(0,0, Protagonista.class);  
        Space space=(Space)getWorld();// não sei explicar .-. pq ta funcionando desse jeito e.e
        Protagonista protagonista=space.retornaProtagonista();
        if (Protagonista != null){
             protagonista.tirarVida();
            return true;   
        }
        return false;
    }
    
    public boolean foundBala()
    {                   
        Actor Bala = getOneObjectAtOffset(0,0, Bala.class);
        if (Bala != null){
            return true;   
        }
        return false;
    }
    
   
    public void killBala(){  
        Actor Bala = getOneObjectAtOffset(0,0, Bala.class);  
        if (foundBala() == true){
            getWorld().removeObject(Bala);
            getWorld().removeObject(this);
        }
    }  
    
    
}
