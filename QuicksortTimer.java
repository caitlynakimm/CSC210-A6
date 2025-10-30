public class QuicksortTimer {
    public static void main(String args[]) {
    
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }

      sort(cards);
      
    }
  }

  public static CardPile sort(CardPile unsorted) {

    // base case
    if (unsorted.size() <= 1) {
      return unsorted;
    }

    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    Card pivot = unsorted.removeFirst();  // edit this!
    
    while (!unsorted.isEmpty()) {
      Card card = unsorted.removeFirst();
      if (card.compareTo(pivot) < 0) {
        smaller.add(card);
      } else {
         bigger.add(card);
      }
    }

    // This will hold the assembled result
    CardPile result = new CardPile();

    // recursive calls
    CardPile sortedSmaller = sort(smaller);
    CardPile sortedBigger = sort(bigger);

    result.append(sortedSmaller);
    result.add(pivot);
    result.append(sortedBigger);
    
    // return the sorted result here
    return result;
  }
}
