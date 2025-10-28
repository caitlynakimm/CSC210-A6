import java.util.ArrayDeque;
import java.util.Collections;

public class MergeSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************

    for (Card card: unsorted) {
      CardPile singleton = new CardPile();
      singleton.add(card);
      queue.add(singleton);
    }

    record.next();
    for (CardPile pile: queue) { // add all piles
      record.add(pile);
    }

    while (queue.size() > 1) {
      //removes first two linked lists from queue
      CardPile listOne = queue.removeFirst();
      CardPile listTwo = queue.removeFirst();

      CardPile mergedList = mergeLists(listOne, listTwo);

      queue.add(mergedList);

      record.next();
      for (CardPile pile: queue) { // add all piles
        record.add(pile);
      }
    }

    // return the sorted result here
    return queue.remove();
  }

  public static CardPile mergeLists(CardPile listOne, CardPile listTwo) {
    CardPile tempList = new CardPile();

    while (!listOne.isEmpty() && !listTwo.isEmpty()) {
      if (listOne.getFirst().compareTo(listTwo.getFirst()) < 0) {
        tempList.add(listOne.removeFirst());
      } else {
        tempList.add(listTwo.removeFirst());
      }
    }

    while (!listOne.isEmpty()) {
      tempList.insertAfter(listOne, tempList.getLast());
    }

    while (!listTwo.isEmpty()) {
      tempList.insertAfter(listTwo, tempList.getLast());
    }

    return tempList;
  }

  public static void main(String args[]) {
    SortRecorder recorder = new SortRecorder();

    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    cards = cards.split(cards.get(39));
    Collections.shuffle(cards);

    cards = MergeSort.sort(cards, recorder);    

    System.out.println(cards);

    recorder.display("Card Sort Demo: MergeSort");
  }
}
