import greenfoot.*;

/**
 * Write a description of class Protagonista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class Protagonista extends Naves
{
    /**
     * Act - do whatever the Protagonista wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int lives=3;
    int aux;     
    int TempodeTiro=0;
    int pontuação=0;
    public Protagonista()
    {           
       
    }
    
    public void act() 
    {
        Mover();
        darPosicao();
        if(Greenfoot.isKeyDown("space")){
            Atirar();
        }        
    } 
    
    public void darPosicao()
    {
       Space space=(Space)getWorld();    
       space.posicaoProtagonistaX(getX());
       space.posicaoProtagonistaY(getY());    
        
    }
    
    public void Mover()
    {       
        if(Greenfoot.isKeyDown("right")){   
            move(1);
            
       }    
        if(Greenfoot.isKeyDown("left")){   
            move(-1);
            
       }    
    }
    
    public void Atirar()
    {
        if (TempodeTiro>0)
        {
            TempodeTiro=TempodeTiro-1;
        }
        else if (Greenfoot.isKeyDown("space"))
        {
            Bala bala=new Bala();        
            getWorld().addObject(bala,getX(),getY());
            bala.SetXY(getX(),getY()); 
            TempodeTiro=2;
        }
    }    

     public void tirarVida()// vai matando devagar o personagem
     {
        if(lives>0){
           --lives;   
        }
        if(lives==0){     
           Morrer();        
        }   
    }  
    
    public void Morrer()
    {
        getWorld().removeObject(this);
    }
}
