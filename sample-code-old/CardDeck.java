public class Constant {
  public static final String[] types = new String[]{"CLUB", "SPADE", "HEART", "DIAMOND", "JOKER"};
}

class Card {
  private String type;
  private int value;
  private String label;

  public Card(String type, int value) throws Exception {
    // validation of card type
    if (!type.equals(Constant.types[0]) &&
        !type.equals(Constant.types[1]) &&
        !type.equals(Constant.types[2]) &&
        !type.equals(Constant.types[3]) &&
        !type.equals(Constant.types[4])) {
      throw new Exception("Invalid card type: " + type);
    }
    this.type = type;
    
    // validation of card value
    if (!(value >= 1 && value <= 13) && value != 99 && value != 100) {
      throw new Exception("Invalid card value: " + value);
    }
    this.value = value;

    // Special handling of Ace, Jack, Queen and King
    if (value == 1) {
      this.label = "Ace " + type;
    } else if (value == 11) {
      this.label = "Jack " + type;
    } else if (value == 12) {
      this.label = "Queen " + type;
    } else if (value == 13) {
      this.label = "King " + type;
    } else if (value == 99) {
      this.label = "Baby Joker";
    } else if (value == 100) {
      this.label = "Daddy Joker";
    } else {
      this.label = String.valueOf(value) + " " + type;
    }
  }
  
  // return the card label in String form
  public String getLabel() {
    return label;
  }
}

class CardDeck {
  private Card[] deck;
  private int cardUsed;

String[] types = new String[]{"CLUB", "SPADE", "HEART", "DIAMOND", "JOKER"};
  public CardDeck(boolean includeJokers) throws Exception {
    if (includeJokers) {
        deck = new Card[52];
    } else {
        deck = new Card[54];
    }
    
    // Generate cards,
    // "Ace CLUB", "Ace SPADE", "Ace HEART", "Ace DIAMOND", "2 CLUB", "2 SPADE", "2 HEART", "2 DIAMOND", ... etc
    for (int i = 0; i < 13; i++) {
      for (int j = 0; j < 4; j++) {
          deck[i * 4 + j] = new Card(Constant.types[j], i+1);
      }
    }
      
    if (includeJokers) {
      deck[52] = new Card("JOKER", 99);
      deck[53] = new Card("JOKER", 100);
    }
  }
  
  // getter
  public Card[] getDeck() {
    return deck;
  }
  
  // public Card[] deal(int num) {}
  // public Card[] shuffleRemaining() {}

  // Index based shuffling     
  public Card[] shuffleAll() {
    for (int i = deck.length - 1; i > 0; i-- ) {
        int rand = (int)(Math.random()*(i+1));
        Card temp = deck[i];
        deck[i] = deck[rand];
        deck[rand] = temp;
    }
      
    return deck;
  }
  
}
