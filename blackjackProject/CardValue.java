public class CardValue{

  protected String face;
  protected int numeric;
  
  public CardValue(String faceVal){
    face = faceVal;
    numeric = findNumericVal(faceVal);
  }
  
  public static int findNumericVal(String f){
    
    if (f.equals("A")){
      return 11;
    }
    if (f.equals("J") || f.equals("K") || f.equals("Q")){
      return 10;
    }
        else{
      return Integer.parseInt(f);
    }
  }
  
  public String getFace(){
    return face;
  }
  
  public int getNumeric(){
    return numeric;
  }
  
  public static void main(String[] args){
    CardValue c = new CardValue("K");
    System.out.println(c.numeric);
    CardValue d = new CardValue("A");
    System.out.println(d.numeric);
    CardValue e = new CardValue("4");
    System.out.println(e.numeric);
    
  }
  

  }

  

