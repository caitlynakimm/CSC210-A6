import java.util.Collections;
import java.util.ListIterator;

public class SelectionSort {
  
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
