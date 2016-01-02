import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
public class Space extends World
{       
    private int rounds = 0;
    private int numeroInimigos = 5;
    private int pontos = 0;
    int protX;
    int protY;
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
         
        super(10,10, 60);  // o tamanho no space estava me atrapalhando de trabalhar entao o alterei brevemente
        prepare();           
    }
    
    public void act()
    {
       rounds();
      
       //pontos();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
   private void prepare()  
    {   

        //Greenfoot.playSound("star wars imperial march.mp3");
        Protagonista protagonista = new Protagonista();
        addObject(protagonista, 5, 14);         
        for(int i = 0; i < numeroInimigos; i++)
        {
            Inimigo inimigo = new Inimigo();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight() - 7);
            if(testeInimigos(x, y) == false){
                    
                    if(y != 0){
                    addObject(inimigo, x, y);
               }
               else
               {
                   y++;
                   addObject(inimigo, x, y);
               }
               
            }
            else
            {
             i--;
             x = Greenfoot.getRandomNumber(getWidth());
             y = Greenfoot.getRandomNumber(getHeight() - 7);
            }
        }
      
    }

    
    public boolean testeInimigos(int x, int y)
    {
        List inimigos = getObjectsAt(x, y, Inimigo.class);
        if(inimigos.isEmpty())
        {
            return false;
        }
        return true;
    }
    
        public void rounds()
    {
        List numeroObjetos = getObjects(Inimigo.class);
        if(numeroObjetos.isEmpty())
        {
            rounds++;
           
           for(int i = 0; i < numeroInimigos; i++)
         {
            Inimigo inimigo = new Inimigo();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight() - 7);
            if(testeInimigos(x, y) == false){
                    
                    if(y != 0){
                    addObject(inimigo, x, y);
               }
               else
               {
                   y++;
                   addObject(inimigo, x, y);
               }
               
            }
            else
            {
             i--;
             x = Greenfoot.getRandomNumber(getWidth());
             y = Greenfoot.getRandomNumber(getHeight() - 7);
            }
         }
         }
     }
    public int posicaoProtagonistaX(int x){
        protX=x;    
            return x;
    }
    
    public int posicaoProtagonistaY(int y){
            protY=y;    
            return y;
    }
    
    public Protagonista retornaProtagonista(){// esse metodo retorna o protagonista que está no space
    List<Protagonista> objetos=getObjectsAt(protX,protY,Protagonista.class);
    if(objetos.isEmpty()){
    
         return null;
    }
    Protagonista prot=objetos.get(0);  
    return prot;
    } 
    
    public Inimigo retornaInimigo(int x,int y){
    List <Inimigo> objetos=getObjectsAt(x,y,Inimigo.class);
            if(objetos.isEmpty()){
    
                return null;
    }
    Inimigo inimigo=objetos.get(0);
    return inimigo;
    }
   
    }
