import java.util.ListIterator;

/**
 * Timed version of Selection Sort algorithm for runtime measure
 */
public class SelectionSortTimer {

    /**
     * Creates random cards and measures sorting time
     * @param args command line arguments (first argument specifies number of cards)
     */
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

  /**
   * Sorts a CardPile using Selection Sort algorithm without recording
   * @param unsorted CardPile to be sorted
   * @return new CardPile with sorted cards
   */
  public static CardPile sort(CardPile unsorted) {

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();

    while (!unsorted.isEmpty()) {
      ListIterator<Card> scanner = unsorted.listIterator();
      Card smallestCard = scanner.next();

      while (scanner.hasNext()) {
        Card current = scanner.next();
        if (smallestCard.compareTo(current) > 0) {
          smallestCard = current;
        }
      }

      unsorted.remove(smallestCard);
      sorted.add(smallestCard);

    }

    // return the sorted result here
    return sorted;
  }
}
