import java.util.Collections;
import java.util.ListIterator;

/**
 * Repeatedly finds minimum element from unsorted portion,
 * moves it to end of sorted portion while including visual recording
 */
public class SelectionSort {
  
  /**
   * Iterates through unsorted pile to find smallest card, moves it
   * to sorted pile, and repeats till all cards are sorted
   * 
   * @param unsorted CardPile to be sorted
   * @param record SortRecorder for visualizing each step of sorting process
   * @return new CardPile with cards in sorted order
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
    // ***********************************************************

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

      record.next();
      record.add(unsorted);
      record.next();
      record.add(sorted);
    }

    // return the sorted result here
    return sorted;
  }

  /**
   * Creates deck of cards, shuffles them, sorts them using SelectionSort,
   * and shows sorting process visuals
   * 
   * @param args command line arguments
   */
  public static void main(String args[]) {
    SortRecorder recorder = new SortRecorder();

    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    cards = cards.split(cards.get(39));
    Collections.shuffle(cards);

    cards = SelectionSort.sort(cards, recorder);    

    System.out.println(cards);

    recorder.display("Card Sort Demo: SelectionSort");
  }
}
