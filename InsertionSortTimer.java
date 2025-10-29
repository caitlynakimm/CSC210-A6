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
        //cards.add(deck[i*52/Integer.parseInt(args[0])]);
      }

      sort(cards);
      
    }
  }

  public static CardPile sort(CardPile unsorted) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:

    // ***********************************************************

    while (!unsorted.isEmpty()){
      Card randomCard = unsorted.removeFirst();
      ListIterator<Card> scanner = sorted.listIterator(sorted.size());

      record.next();
      record.add(unsorted);

      if (sorted.isEmpty()) {
        sorted.addFirst(randomCard);

        record.next();
        record.add(sorted);
      } else {
        Card firstCard = sorted.getFirst();
        if (randomCard.compareTo(firstCard) < 0) {
          sorted.addFirst(randomCard);

          record.next();
          record.add(sorted);
        } else {
            while (scanner.hasPrevious()) {
              Card current = scanner.previous();

              if (randomCard.compareTo(current) >= 0) {
                sorted.insertAfter(randomCard, current);

                record.next();
                record.add(sorted);
                break; //exit loop right after inserting randomCard into sorted list
              }
            }
        }

      }
    }

    // return the sorted result here
    return sorted;
  }
}
