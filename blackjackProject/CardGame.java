import java.util.Scanner;
import java.util.ArrayList;

public class CardGame{
  
  //private ArrayList<Card> playerHand;
  
  //ArrayList<Card> hand = new ArrayList<Card>();

  
  public static ArrayList<Card> dealIn(ArrayList<Card> hand){
    
    Card a = new Card();
    Card b = new Card();
    
    hand.add( a);
    
    if(!b.equals(a))
      hand.add(b);
    
    return hand;
  }
  
//  public ArrayList<Card> dealInDealer(){
//    Card d = new Card();
//    Card e = new Card();
//    
//    if(!playerHand.contains(d)){
//      dealerHand.add(d);
//    }
//    if((!playerHand.contains(e)) && (!dealerHand.contains(e))){
//      dealerHand.add(e);
//    }
//    return dealerHand;
//  }
  
  
//    public static int calcScore(ArrayList<Card> hand){
//    int sum = 0;
//    for (Card c : hand){
//        sum += c.getCardValue().getNumeric();
//      }    
//    return sum;
//  }
    
  
  public static int calcScore(ArrayList<Card> hand){
    
    int sum = 0;
    int aces = 0;
    
    for (Card c : hand){
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
    return sum;
  }
  
  public static void hit(ArrayList<Card> hand){
    Card c = new Card();
    if (!hand.contains(c)){
      hand.add(c);
    }
  }
  
  public static boolean isBusted(ArrayList<Card> hand){
    if(calcScore(hand) > 21)
      return true;
    else{
      return false;
    }
  }
  
  public static void printDealerHand(ArrayList<Card> hand){
    for (int i = 1; i < hand.size(); i++){
      System.out.print(hand.get(i));
    }
  }
  
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to Blackjack!");
    ArrayList<Card> playerhand = new ArrayList<Card>();
    ArrayList<Card> dealerhand = new ArrayList<Card>();
    dealIn(playerhand);
    dealIn(dealerhand);
    
    
    System.out.println(playerhand);
    
    while (!isBusted(playerhand)){
      System.out.println("Your score is " + calcScore(playerhand) + ". Hit or stay?");
      String hOrS = in.nextLine();
      
      if (hOrS.equalsIgnoreCase("hit")){
        hit(playerhand);
        System.out.println(playerhand);
        
      }
      if (hOrS.equalsIgnoreCase("stay")){
        
        break;
        
      }
    }
    
    
    
  }

}