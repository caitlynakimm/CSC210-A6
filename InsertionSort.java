import java.util.Collections;
import java.util.ListIterator;

public class InsertionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
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

      record.next();
      record.add(unsorted);

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

    cards = InsertionSort.sort(cards, recorder);    

    System.out.println(cards);

    recorder.display("Card Sort Demo: InsertionSort");
  }
}
