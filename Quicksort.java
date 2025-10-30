import java.util.Collections;

public class Quicksort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    record.add(unsorted);
    record.next();

    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    // base case
    if (unsorted.size() <= 1) {
      return unsorted;
    }

    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    Card pivot = unsorted.removeFirst();  // edit this!
    
    while (!unsorted.isEmpty()) {
      Card card = unsorted.removeFirst();
      if (card.compareTo(pivot) < 0) {
        smaller.add(card);
      } else {
         bigger.add(card);
      }
    }

    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************

    // recursive calls
    CardPile sortedSmaller = sort(smaller, record);
    CardPile sortedBigger = sort(bigger, record);

    result.append(sortedSmaller);
    result.add(pivot);
    result.append(sortedBigger);

    // record the sorted result
    record.add(result);
    record.next();
    
    // return the sorted result here
    return result;
  }

  public static void main(String args[]) {
    SortRecorder recorder = new SortRecorder();

    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    cards = cards.split(cards.get(39));
    Collections.shuffle(cards);

    cards = Quicksort.sort(cards, recorder);    

    System.out.println(cards);

    recorder.display("Card Sort Demo: Quicksort");
  }
}
