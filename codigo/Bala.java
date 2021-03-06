import greenfoot.*;

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.List;
public class Bala extends Actor
{
    int xbala,ybala;
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Bala(){ 
         
    }    
    
    public void act() 
    {              
        mover(xbala,ybala-1);  
        foundEnemy();  
        if (foundBoss()==true){
        killBoss();
        getWorld().removeObject(this);
        }    
        else {
        DeleteAtWorldEdge();
        }             
    }
    
    public void mover(int x,int y){    
        setLocation(x,y);
        SetXY(x,y);     
    } 
    
    public void SetXY(int x, int y){
        xbala=x;
        ybala=y;   
    }
    
    public void DeleteAtWorldEdge()
    {
        if  (getY() == 1)        
        {           
            Greenfoot.delay(1);
            getWorld().removeObject(this);         
        }
    }
      
    public boolean foundEnemy()
    {                   
        Actor inimigo = getOneObjectAtOffset(0,0, Inimigo.class);
        Space space=(Space)getWorld();
        Inimigo inimigos=space.retornaInimigo(getX(),getY());
        if (inimigo != null){
            inimigos.Morrer();
            return true;   
        }
        return false;
    }
    
    public boolean foundBoss()
    {                   
        Actor boss = getOneObjectAtOffset(0,0, Chefe.class);        
        if (boss != null){            
                     
            return true;             
        }
        return false;
    }  
    
    public void killBoss(){
        Space space=(Space)getWorld();
        Chefe chefes =space.retornaBoss(getX(),getY());
        chefes.tirarVida();  
    }
}