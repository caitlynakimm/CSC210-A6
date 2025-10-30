import java.util.ArrayDeque;

public class MergeSortTimer {
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

    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();

    for (Card card: unsorted) {
      CardPile singleton = new CardPile();
      singleton.add(card);
      queue.add(singleton);
    }

    while (queue.size() > 1) {
      //removes first two linked lists from queue
      CardPile listOne = queue.removeFirst();
      CardPile listTwo = queue.removeFirst();

      CardPile mergedList = mergeLists(listOne, listTwo);

      queue.add(mergedList);

    }

    // return the sorted result here
    return queue.remove();
  }

  private static CardPile mergeLists(CardPile listOne, CardPile listTwo) {
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
}
