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
      if(!b.equiv(a)){
        hand.add(b);
      }
      else dealIn(hand);
    }
    return hand;
  }
  
  public static ArrayList<Card> dealInDealer(ArrayList<Card> dealerhand){
    ArrayList<Card> playerhand = new ArrayList<Card>();
    ArrayList<Card> playerhandDelt = dealIn(playerhand);
    
    while(dealerhand.size() < 2){
      Card a = new Card();
      if((!a.isIn(playerhandDelt)) && (!a.isIn(dealerhand))){
        dealerhand.add(a);
      }
    }return dealerhand;
    
  } 
  
  
  
  
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
  
  public static void hit(ArrayList<Card> hand,ArrayList<Card> hand2){
    Card c = new Card();
    if ((!c.isIn(hand)) && (!c.isIn(hand2))){
      hand.add(c);
    }
    else{hit(hand,hand2);}
  }
  
  
  
  public static boolean isBusted(ArrayList<Card> hand){
    if(calcScore(hand) > 21)
      return true;
    else{
      return false;
    }
  }
  
  public static boolean noBusted(ArrayList<Card> player, ArrayList<Card> dealer){
    if ((!isBusted(player)) && (!isBusted(dealer)))
      return true;
    else{
      return false;
    }
  }
  
  
  public static void main(String[] args){
    
    System.out.println("Welcome to Blackjack!\n");
    ArrayList<Card> playerhand = new ArrayList<Card>();
    ArrayList<Card> dealerhand = new ArrayList<Card>();
    dealIn(playerhand);
    dealInDealer(dealerhand);
    
    //System.out.println("DEALER HAND: [hidden]" + " and " + dealerhand.get(1));
    System.out.println("TEST DEALER HAND: " + dealerhand);
    System.out.println("Your hand: " + playerhand);
    
    boolean playerStillIn = true;
    Scanner in = new Scanner(System.in);
//    System.out.println("Hit or stay? Press \"H\" for hit, \"S\" for stay");
//    String choice = in.next();
    
    while((playerStillIn) && (!isBusted(playerhand))){
      System.out.println("Hit or stay? Press \"H\" for hit, \"S\" for stay");
      String choice = in.next();
      if(choice.equalsIgnoreCase("h")){
        hit(playerhand, dealerhand);
        System.out.println("YOUR HAND: " + playerhand);
        System.out.println("YOUR SCORE: " + calcScore(playerhand));
      }
      else{
        playerStillIn = false;
      }
    }
    
    if (isBusted(playerhand)){
      System.out.println("BUSTED! YOU LOSE!!");
      //System.out.println("YOUR HAND: " + playerhand + ". YOUR SCORE: " + calcScore(playerhand));
    }
    else{ 
      while((calcScore(dealerhand) < 17) && (noBusted(playerhand,dealerhand))){
        hit(dealerhand,playerhand);
        //System.out.println("DEALER HAND: " + dealerhand);
      }
      
      if(isBusted(dealerhand)){
        System.out.println("DEALER HAND: " + dealerhand + " and SCORE: " + calcScore(dealerhand));
        System.out.println("YOUR HAND: " + playerhand + " and SCORE: " + calcScore(playerhand) );
        System.out.println("YOU WIN");
      }
      
      else if ((calcScore(playerhand) < calcScore(dealerhand))) {
        System.out.println("DEALER HAND: " + dealerhand + " and SCORE: " + calcScore(dealerhand));
        System.out.println("YOUR HAND: " + playerhand + " and SCORE: " + calcScore(playerhand));
        System.out.println("YOU LOSE");
      }
      
      else if ((calcScore(playerhand) > calcScore(dealerhand))) {
        System.out.println("DEALER HAND: " + dealerhand + " and SCORE: " + calcScore(dealerhand));
        System.out.println("YOUR HAND: " + playerhand + " and SCORE: " + calcScore(playerhand));
        System.out.println("YOU WIN");
      }
      
      else if ((calcScore(playerhand) == calcScore(dealerhand))) {
        System.out.println("DEALER HAND: " + dealerhand + " and SCORE: " + calcScore(dealerhand));
        System.out.println("YOUR HAND: " + playerhand + " and SCORE: " + calcScore(playerhand));
        System.out.println("PUSH");
        
      }
    }
    
    
    
    
    
    
    
  }
  
}


    
    
      
      
      
    
      
      



    
