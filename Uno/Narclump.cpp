#include "Narclump.h"

Narclump::Narclump(int playerNumber) : AI(playerNumber)
{

}

void Narclump::onOtherPlayerMove(int playerNumber, Card justPlayed, Color choosenCardColor)
{

}

void Narclump::onOtherPlayerDraw(int playerNumber)
{

}

//function for my AI making a move
int Narclump::makeMove(Card justPlayed, Color choosenCardColor, bool justDrew, vector<int> scores, vector<int> cardAmountsByPlayer, vector<Card> cardsInHand, int direction)
{
	//creates a vector of cards that are playable
	vector<Card> cards = getPlayableCardsInHand(justPlayed, choosenCardColor, cardsInHand);

	//card object I will use to choose what card I'd like to play
	Card c;

	bool mustPlay = false;//boolean use for tracking if I must play my wilds I've held onto

	//Loops through the cardAmountsByPlayer vector
	for (int i = 0; i < cardAmountsByPlayer.size(); i++)
	{
		if (cardAmountsByPlayer[i] == 3)//If any player (including me) has 3 cards left drop my wilds
		{
			mustPlay = true;
		}
		else
		{
			mustPlay = false;
		}
	}

	//beginning of color decider
	int red = 0, yellow = 0, green = 0, blue = 0; //Variables that wild hold the points a color is worth to decide what color is most optimal to change to

	/*What this for loop does is look at the point value of every card and adds that value to the color
	variable the card"s color corresponds to.*/
	for (int i = 0; i < cardsInHand.size(); i++)
	{
		if (cardsInHand[i].getColor() == RED)
		{
			red += cardsInHand[i].getPoints();
		}
		else if (cardsInHand[i].getColor() == YELLOW)
		{
			yellow += cardsInHand[i].getPoints();
		}
		else if (cardsInHand[i].getColor() == GREEN)
		{
			green += cardsInHand[i].getPoints();
		}
		else if (cardsInHand[i].getColor() == BLUE)
		{
			blue += cardsInHand[i].getPoints();
		}
	}

	
	/*These if statements look to see which of our color point variables is greater than the rest
	and it will change my savedColor to that color so that when a wild or D4 is played it changes to 
	the most optimal color*/
	if (red >= yellow && red >= green && red >= blue)
	{
		savedColor = RED;
	}

	else if (yellow >= red && yellow >= green && yellow >= blue)
	{
		savedColor = YELLOW;
	}

	else if (green >= yellow && green >= red && green >= blue)
	{
		savedColor = GREEN;
	}

	else if (blue >= yellow && blue >= green && blue >= red)
	{
		savedColor = BLUE;
	}
	//end of color decider


	//if I have no playable cards I must draw
	if (cards.size() == 0)
	{
		return -1; //draw
	}


	//basic more value play that
	//for loop that is going to look at all my playable cards and decide what to play
	for (int i = 0; i < cards.size(); i++)
	{
		if (i == 0)
		{
			c = cards[i];//making c = to the first cards so I can compare it to future indexes of the vector
		}

		else if (cards[i].getPoints() > c.getPoints()) //picks the card worth the greatest amount of points
		{
			c = cards[i];
		}

		else if (cards[i].getPoints() == c.getPoints()) //this is a large else if statment for if the points are equal
		{
			if (cards[i].getColor() == BLACK && cards[i].getNumber() == 1) //first off, if it a playable D4 PLAY IT NOW!!!!!! 
			{
				c = cards[i];
			}

			//If its a wild play it if I dont have many playable cards or other players are close to winning
			else if (cards[i].getColor() == BLACK && cards[i].getNumber() == 0 && (cards.size() < 5 || mustPlay == true)) 
			{
				c = cards[i];
			}

			else if (cards[i].getNumber() == 11) //else play a D2
			{
				c = cards[i];
			}

			else if (cards[i].getNumber() == 10) //else play a skip
			{
				c = cards[i];
			}

			else if (cards[i].getNumber() == 12) //else play a reverse
			{
				c = cards[i];
			}
		}
	}
	
	//searches for the card I've chosen in my hand to find the playable index
	for (int i = 0; i < cardsInHand.size(); i++)
	{
		if (c == cardsInHand[i])
		{
			return i;//returns index where the card is at
		}
	}

	return -1;//in case break
}

string Narclump::getName()
{
	return "Narclump";//My AI's name
}


Color Narclump::getNewColor()
{
	return savedColor;//for choosing changed color
}