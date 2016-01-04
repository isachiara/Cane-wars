import greenfoot.*;
import java.util.List;
import java.lang.String;
/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
public class Space extends World
{
   private int bossRound = 10;
   private int numeroInimigos = 5;
   private int tempoAux = 0;
   private int tempo = 0;
   int rounds = 0;
   int protX;
   int protY;
   Protagonista protagonista = new Protagonista();
   GreenfootSound bgSound = new GreenfootSound("what is love 8 bit.mp3");
   GreenfootSound Morte = new GreenfootSound("CholaMais_8bit.mp3");
   GreenfootSound BossSound = new GreenfootSound("Gym Battle vs. Turkey.mp3");
   GreenfootSound Victory = new GreenfootSound ("Victory.mp3");
   Chefe boss = new Chefe();
   Vidas vida = new Vidas();
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
        tempoAux++;
        mostrarPontuacao();
        contarTempo();
        mostrarVida();
        mostrarRound();
        protagonistaMorto();
        if(rounds < bossRound)
        {
            rounds();
        }
        else 
        {
            FinalRound();
        }
   }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
   private void prepare()  
    {
        bgSound.play();
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
   
   public void FinalRound()
   {
        bgSound.stop();
        List numeroObjetos = getObjects(Chefe.class);
        
        if(rounds > bossRound)
        {
          BossSound.stop();
          Victory.play();
          showText("Você Venceu! ^^",4,4);
          showText(""+tempo+"s", 4,5);
          Greenfoot.stop(); 
        }
        else if(numeroObjetos.isEmpty())
        {  
             BossSound.playLoop();
             
             for(int i = 0; i < 1; i++)
             {
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight() - 7);
                 if(y != 0){
                           addObject(boss, x, y);
                        }
                        else
                        {
                           y++;
                           addObject(boss, x, y);
                        }
             }
        }
   }
    
   public int posicaoProtagonistaX(int x)
   {
       protX=x;   
       return x;
   }
    
   public int posicaoProtagonistaY(int y)
   {
       protY=y;    
       return y;
   }
    
   public Protagonista retornaProtagonista(){
      List<Protagonista> objetos=getObjectsAt(protX,protY,Protagonista.class);
      if(objetos.isEmpty())
      {
         return null;
      }
      Protagonista prot=objetos.get(0);   
      return prot;
   } 
    
   public Inimigo retornaInimigo(int x,int y){
      List <Inimigo> objetos=getObjectsAt(x,y,Inimigo.class);
      if(objetos.isEmpty())
      {
         return null;
      }
      Inimigo inimigo=objetos.get(0);
      return inimigo;
   }
   
   public Chefe retornaBoss(int x,int y)
   {
      List <Chefe> objetos=getObjectsAt(x,y,Chefe.class);
      if(objetos.isEmpty())
      {
         return null;
      }
      Chefe chefe=objetos.get(0);
      return chefe;
   }
   
   public void mostrarVida()
   {
      Protagonista protagonista= this.protagonista;
      Vidas vida= this.vida;
      int lives= protagonista.lives;
      GreenfootImage img3=new GreenfootImage("3lives.png");
      GreenfootImage img2=new GreenfootImage("2lives.png");    
      GreenfootImage img1=new GreenfootImage("lives.png");
      if(lives == 3)
      {           
          addObject(vida,8,0);          
          vida.setImage(img3);        
      }
      else if(lives == 2)
      {                                
          removeObject(vida);           
          img3.clear();   
          addObject(vida,8,0);          
          vida.setImage(img2);       
      }
       else if(lives == 1)
      {                            
          removeObject(vida);
          img2.clear();    
          addObject(vida,8,0);          
          vida.setImage(img1);         
      }
      else
      {
          removeObject(vida);
          img1.clear();          
      }
   }
   
   public void mostrarPontuacao()
   {
      Protagonista protagonista= this.protagonista;
      int pontuacao= protagonista.pontuação;
      String stringPontuacao= ""+pontuacao;
      showText(stringPontuacao, 0, 0);     
   }
   
   public void mostrarRound()
   {
      String Round;
      if(rounds < bossRound)
      {
         Round= "Round "+(rounds+1);
         showText(Round, 4, 0);
      }
      else
      {
         Round= "King M";
         showText(Round, 4, 0);
      }
   }
   
   public void protagonistaMorto()
   {  
      Protagonista protagonista= this.protagonista;
      int lives= protagonista.lives;
      if(lives == 0)
      {
          BossSound.stop();
          bgSound.stop();
          Morte.play();
          showText("Você Perdeu!", 5, 5);
          Greenfoot.stop();
      }
   }
   
    public void contarTempo()
   {
      if(tempoAux == 6)
      {
         tempoAux = 0;
         tempo++;
         String mostraTempo = ""+tempo+"s";
         showText(mostraTempo, 1, 0);
      }
   }
}
