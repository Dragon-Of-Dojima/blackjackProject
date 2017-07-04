import java.util.ArrayList;

public class Hand extends ArrayList{

  protected ArrayList<Card> h;
  protected int handValue;
  
  public Hand(){
    h = new ArrayList<Card>();
    handValue = getScore();
  }
  
  public void getHand(){
    System.out.println(h);
  }
  

  public void add(Card c){
    h.add(c);
  }
  
  public int getScore(){
    int sum = 0;
    int aces = 0;
    
    for (Card c : h){
      if (c.getCardValue().getFace().equals("A")){
        aces++;
      }
      else{
        sum += c.getCardValue().getNumeric();
      }
    }
    while (aces > 0){
      aces--;
      if(sum <= 10){
        sum+=11;
      }
      else{
        sum+=1;
      }
    }
    handValue = sum;
    return handValue;
  }
  
  
  
  public static void main(String[] args){
    Hand e = new Hand();
    e.add(new Card());
    e.add(new Card());
    e.add(new Card());
    e.getHand();
    //System.out.println(e.getScore(e.h));
    System.out.println(e.getScore());
    Hand f = new Hand();
    f.add(new Card());
    f.add(new Card());
    f.getHand();
    System.out.println(f.getScore());
    
  }

}