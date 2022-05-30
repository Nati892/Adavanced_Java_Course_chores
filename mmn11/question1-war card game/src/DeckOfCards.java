import java.security.SecureRandom;
import java.util.ArrayList;


public class DeckOfCards
{
	/*
	 * Top of deck is the highest index bottom is index 0. and the strongest card is
	 * ACE, then King , Queen etc.
	 */

	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBER_OF_CARDS = 52;
	private static final int BOTTOM_OF_DECK = 0;
	private ArrayList<Card> _deck = new ArrayList<Card>();

	/**
	 *  Constructor of deck, can be either full or empty 
	 * @param is_full a boolean specifying whether to get full new deck or an empty deck
	 */
	public DeckOfCards(boolean is_full)
	{
		if (is_full)
		{
			String[] faces = { "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
					"Queen", "King", "Ace" };
			String[] suits = { "Hearts", "Diamond", "Clubs", "Spades" };
			// fills deck with all cards
			for (int i = 0; i < NUMBER_OF_CARDS; i++)
			{
				this._deck.add(new Card(faces[i % 13], suits[i / 13], i % 13));
			}
		}

	}

/**
 * clears the deck from all of the cards
 */
	public void clearDeck()
	{
		this._deck.clear();
	}

	/**
	 * adds given card at the top of the deck
	 * @param card-card to add at the top of the deck
	 */
	public void addCardAtTop(Card card)
	{
		this._deck.add(card);

	}

	/**
	 * adds card from the bottom of the deck 
	 * @param card , the Card to add at the bottom
	 */
	public void addCardAtBottom(Card card)
	{
		this._deck.add(BOTTOM_OF_DECK, card);

	}

	/**
	 * gets a card at specific index if the card exits, if does not exist then
	 * returns null
	 * 
	 * @param index the index of card in deck
	 * @return	Card at the specified position by index, null if no suck index exists
	 */
	public Card getCard(int index)
	{
		if (index < this._deck.size())
			return this._deck.get(index);
		else
			return null;

	}

	/**
	 * returns a reference to the card at the top
	 * 
	 * @return Card reference at the top of the deck
	 */
	public Card dealCard()
	{

		if (_deck.size() > 0)
		{
			return getCard(_deck.size() - 1);

		} else
		{
			return null;

		}

	}

	/**
	 * removes and returns the card at the top, if the deck is not empty
	 * 
	 * @return Card that has been removed
	 */
	public Card removeCardFromTop()
	{
		Card temp = getCard(_deck.size() - 1);
		if (_deck.size() > 0)
			_deck.remove(_deck.size() - 1);
		return temp;
	}

	/**
	 *
	 * @return Card type-the top card in the deck
	 */
	public Card getCardFromTop()
	{
		if (_deck.size() > 0)
			return this.getCard(this._deck.size() - 1);
		else
			return null;
	}

	/**
	 * shuffles the deck
	 */
	public void shuffle()
	{
		for (int first = 0; first < _deck.size(); first++)
		{
			int second = randomNumbers.nextInt(_deck.size());// randomizes a card to swap with
			Card temp = _deck.get(first);
			_deck.set(first, _deck.get(second));
			_deck.set(second, temp);
		}

	}

	/**
	 * this function moves all cards from the given deck to this deck
	 * 
	 * @param DeckToMov-the deck from which to move all cards
	 */
	public void add_Deck(DeckOfCards DeckToMove)
	{
		while (DeckToMove.size() > 0)
		{
			this.addCardAtBottom(DeckToMove.removeCardFromTop());
		}
	}

	/**
	 * 
	 * @return integer of how many cards are in deck
	 */
	public int size()
	{
		return this._deck.size();

	}

	public String toString()
	{
		return this._deck.toString();
	}

}
