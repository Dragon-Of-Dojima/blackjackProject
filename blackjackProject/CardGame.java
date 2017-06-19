import java.util.Scanner;
import java.util.ArrayList;

public class CardGame{
  
  //private ArrayList<Card> playerHand;
  
  //ArrayList<Card> hand = new ArrayList<Card>();

  
  public static ArrayList<Card> dealIn(ArrayList<Card> hand){
    
    Card a = new Card();
    Card b = new Card();
    
    hand.add(a);
    
    while(hand.size() < 2){
    if(!b.equals(a)){
      hand.add(b);
    }
    else dealIn(hand);
    }
    return hand;
  }    
    
  
  
//  public static ArrayList<Card> dealInDealer(ArrayList<Card> hand){
//    Card c = new Card();
//    Card d = new Card();
//    
//    if
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
    if (!c.isIn(hand)){
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
  
//  public static void printDealerHand(ArrayList<Card> hand){
//    for (int i = 1; i < hand.size(); i++){
//      System.out.print(hand.get(i));
//    }
//  }
  
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to Blackjack!\n");
    ArrayList<Card> playerhand = new ArrayList<Card>();
    ArrayList<Card> dealerhand = new ArrayList<Card>();
    dealIn(playerhand);
    
    for (int i = 0; i < 2; i++){
      Card a = new Card();
      if(!a.isIn(dealerhand)){
        dealerhand.add(a);
      }
    }
    
   
    System.out.println("DEALER HAND: [hidden]" + " and " + dealerhand.get(1));
    //System.out.println("TEST DEALER HAND: " + dealerhand);
    System.out.println("Your hand: " + playerhand);
    
    
    while(!isBusted(playerhand)){
      System.out.println("Your score is " + calcScore(playerhand) + ". Hit or stay?");
      String hOrS = in.nextLine();
      
      
      if (hOrS.equalsIgnoreCase("hit")){
        
        hit(playerhand);
        System.out.println("YOUR HAND : " + playerhand);
        
        if(isBusted(playerhand)){
          System.out.println("DEALER HAND: " + dealerhand);
          System.out.println("Your score is " + calcScore(playerhand) + "! YOU LOSE");
          break;
        }
        //System.out.println(playerhand);
        
      }
      if (hOrS.equalsIgnoreCase("stay")){
        
        while(calcScore(dealerhand) <= 17){
        Card n = new Card();
        if(!n.isIn(dealerhand)){
          dealerhand.add(n);
        }
      }
        
        
      }
      
      
      if(isBusted(dealerhand) || (!isBusted(playerhand) && (calcScore(playerhand) > calcScore(dealerhand)))){
        System.out.println("DEALER HAND: " + dealerhand);
        System.out.println("YOUR HAND: " + playerhand);
        System.out.println("YOU WIN");
        break;
      }
      else if (isBusted(dealerhand) || (!isBusted(playerhand) && (calcScore(playerhand) < calcScore(dealerhand)))) {
        System.out.println("DEALER HAND: " + dealerhand);
        System.out.println("YOU LOSE");
        break;
      
      }
      else{
        System.out.println("DEALER HAND: " + dealerhand);
        System.out.println("PUSH");
        break;
      }
    }
    
    
    
  }

}