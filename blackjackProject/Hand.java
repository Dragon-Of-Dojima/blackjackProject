import java.util.ArrayList;

public class Hand  {

  protected ArrayList<Card> cardlist;
  protected int handValue;
  
  public Hand(){
    cardlist = new ArrayList<Card>();
    handValue = getScore();
  }
  
  public String getHand(){
    return cardlist.toString();
  }
  
  public int getSize(){
    return cardlist.size();
  }
  

  public void deal(Card c){
    cardlist.add(c);
  }
  
  public int getScore(){
    if (isEmpty()){
      return 0;
    }
    else{
    int sum = 0;
    int aces = 0;
    
    for (Card c : cardlist){
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
  }
  
  public boolean isEmpty(){
    if (cardlist.size() == 0){
      return true;
    }
    else{
      return false;}
  }
  
  
  
  public static void main(String[] args){
    Hand e = new Hand();
    e.deal(new Card());
    e.deal(new Card());
    e.deal(new Card());
    e.getHand();
    System.out.println(e.getSize());
    //System.out.println(e.getScore(e.h));
    System.out.println(e.getScore());
    Hand f = new Hand();
    f.deal(new Card());
    f.deal(new Card());
    f.getHand();
    System.out.println(f.getScore());
    
  }

}