import java.util.ListIterator;

public class InsertionSortTimer {
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
    // Here is the result list you will be creating
    CardPile sorted = new CardPile();

    while (!unsorted.isEmpty()){
      Card randomCard = unsorted.removeFirst();

      if (sorted.isEmpty()) {
        sorted.addFirst(randomCard);

      } else {
        ListIterator<Card> scanner = sorted.listIterator(sorted.size());
        boolean inserted = false;

        while (scanner.hasPrevious()) {
          Card current = scanner.previous();

          if (randomCard.compareTo(current) >= 0) {
            if (scanner.hasNext()) {
              scanner.next();
            }
            scanner.add(randomCard);
            inserted = true;
            
            break; //exit loop right after inserting randomCard into sorted list
          }
        }

        if (!inserted) {
          sorted.addFirst(randomCard);
        }
      }

    }


    // return the sorted result here
    return sorted;
  }
}
