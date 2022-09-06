#include "Card.h"
#include <queue>
#include <iostream>
#include <string>
using namespace std;

//queues of cards used for player 1 and player 2
queue<Card> p1;
queue<Card> p2;

/*simpleSetRand and simpleRand are functions with their shared variable provided in the lab.
simpleSetRand sets the seed with a number passed in by the user and simpleRand creates a "random" number
based on that seed.*/
short int currentNumber;
void simpleSetRand(int passedInNum)
{
	currentNumber = passedInNum;
}
int simpleRand()
{
	return currentNumber = ((currentNumber + 1) * (currentNumber + 1))% 17;
}


/*below is the shuffle function. This function takes in a queue. It then creates a temporary vector of cards.
it empties the queue into the vector and uses simpleRand to randomly swap cards around in the vector.*/
void shuffle(queue<Card> & deck)
{
	vector<Card> tempDeck;
	while (!deck.empty())
	{
		Card tempCard = Card(deck.front().getValue());
		deck.pop();
		tempDeck.push_back(tempCard);
	}

	for (int i = 0; i < tempDeck.size(); i++)
	{
		for (int j = i + 1; j < tempDeck.size(); j++)
		{
			if (simpleRand() % 2 == 0)
			{
				Card swap = tempDeck[i];
				tempDeck[i] = tempDeck[j];
				tempDeck[j] = swap;
			}
		}
	}
	for (int i = 0; i < tempDeck.size(); i++)
	{
		deck.push(tempDeck[i]);
	}
}

//the main that runs the program
int main()
{
	int seed; //seed that user enters and we use to set our "random" number generator
	cout << "What seed would you like?: ";
	cin >> seed;
	simpleSetRand(seed);

	//adding two of each card that is 0-12 to each players deck (queue)
	for (int i = 0; i < 13; i++)
	{
		Card card = Card(i);
		p1.push(card);
		p1.push(card);
		p2.push(card);
		p2.push(card);
	}
	
	//shuffling the queues multiple times for extra randomness
	for (int i = 0; i < 5; i++)
	{
		shuffle(p1);
		shuffle(p2);
	}

	vector<Card> warVec;//vector of cards used during the war if and edge cases (same card scenarios)
	while (!p1.empty() && !p2.empty())//while no one has on (all decks arent empty) it continues
	{

		if ((p1.front()).getValue() > (p2.front()).getValue())//if player one's value is greater they get the card
		{
			Card moveP1 = Card((p1.front()).getValue());
			Card moveP2 = Card((p2.front()).getValue());
			p1.pop();
			p2.pop();
			p1.push(moveP1);
			p1.push(moveP2);
			cout << moveP1.getValue() << " vs " << moveP2.getValue() << "\n";
		}

		else if ((p2.front()).getValue() > (p1.front()).getValue())//if player two's value is greater they get the card
		{
			Card moveP2 = Card((p2.front()).getValue());
			Card moveP1 = Card((p1.front()).getValue());
			p1.pop();
			p2.pop();
			p2.push(moveP2);
			p2.push(moveP1);
			cout << moveP1.getValue() << " vs " << moveP2.getValue() << "\n";
		}

		//if both the players values are the same and have sufficient amount of cards to play war with this case will run
		else if (((p1.front()).getValue() == (p2.front()).getValue()) && p1.size() >= 4 && p2.size() >= 4)
		{		
			//temporary variables for the face down cards
			int p1Num1;
			int p1Num2;
			int p2Num1;
			int p2Num2;
			do
			{
				for (int i = 0; i < 3; i++)//loop that puts the cards into a vector so the winner can get all the cards in case of multiple war
				{
					if (i == 0)
					{
						cout << p1.front().getValue() << " vs " << p2.front().getValue() << endl;
						cout << "WAR!!!\n";
					}
					else if (i == 1)
					{
						p1Num1 = p1.front().getValue();
						p2Num1 = p2.front().getValue();
					}
					else if (i == 2)
					{
						p1Num2 = p1.front().getValue();
						p2Num2 = p2.front().getValue();
					}
					warVec.push_back(p1.front());
					warVec.push_back(p2.front());
					p1.pop();
					p2.pop();
				}

				cout << "facedown player1: " << p1Num1 << "\n";
				cout << "facedown player1: " << p1Num2 << "\n";
				cout << "facedown player2: " << p2Num1 << "\n";
				cout << "facedown player2: " << p2Num2 << "\n";
				if ((p1.front()).getValue() > (p2.front()).getValue())//if player one's value is greater they get all the cards from the vector
				{
					Card moveP1 = Card((p1.front()).getValue());
					Card moveP2 = Card((p2.front()).getValue());
					p1.pop();
					p2.pop();
					p1.push(moveP1);
					p1.push(moveP2);
					for (int i = 0; i < warVec.size(); i++)
					{
						Card temp = warVec[i];
						p1.push(temp);
					}
					warVec.erase(warVec.begin(), warVec.end());
					warVec.shrink_to_fit();
					cout << "--" << moveP1.getValue() << " vs " << moveP2.getValue() << "--" << "\n";
				}
				else if ((p2.front()).getValue() > (p1.front()).getValue())//if player two's value is greater they get all the cards from the vector
				{
					Card moveP2 = Card((p2.front()).getValue());
					Card moveP1 = Card((p1.front()).getValue());
					p1.pop();
					p2.pop();
					p2.push(moveP1);
					p2.push(moveP2);
					for (int i = 0; i < warVec.size(); i++)
					{
						Card temp = warVec[i];
						p2.push(temp);
					}
					warVec.erase(warVec.begin(), warVec.end());
					warVec.shrink_to_fit();
					cout << "--" << moveP1.getValue() << " vs " << moveP2.getValue() << "--" << "\n";
				
				}
			} while (((p1.front()).getValue() == (p2.front()).getValue()) && p1.size() >4 && p2.size() > 4);//do while in case of multiple wars
		}

		/*else if that is the ultimate edgecase in the case that a players deck is smaller than 4 (it performs the previous if else statements
		but doesn't punish a player who can't go into war*/
		else if (((p1.front()).getValue() == (p2.front()).getValue()) && (p1.size() < 4 || p2.size() < 4))
		{
			if ((p1.front()).getValue() > (p2.front()).getValue())
			{
				Card moveP1 = Card((p1.front()).getValue());
				Card moveP2 = Card((p2.front()).getValue());
				p1.pop();
				p2.pop();
				p1.push(moveP1);
				p1.push(moveP2);
				cout << moveP1.getValue() << " vs " << moveP2.getValue() << "\n";
			}
			else if ((p2.front()).getValue() > (p1.front()).getValue())
			{
				Card moveP2 = Card((p2.front()).getValue());
				Card moveP1 = Card((p1.front()).getValue());
				p1.pop();
				p2.pop();
				p2.push(moveP2);
				p2.push(moveP1);
				cout << moveP1.getValue() << " vs " << moveP2.getValue() << "\n";
			}
			else if ((p2.front()).getValue() == (p1.front()).getValue())
			{
				
					cout << p1.front().getValue() << " vs " << p2.front().getValue() << "\n";
					Card tie = Card((p1.front()).getValue());
					p1.pop();
					p1.push(tie);
					if (p1.front().getValue() > p2.front().getValue())
					{
						Card moveP2 = Card((p2.front()).getValue());
						Card moveP1 = Card((p1.front()).getValue());
						p1.pop();
						p2.pop();
						p1.push(moveP2);
						p1.push(moveP1);
						for (int i = 0; i < warVec.size(); i++)
						{
							Card temp = warVec[i];
							p1.push(temp);
						}
						cout << moveP1.getValue() << " vs " << moveP2.getValue() << "\n";
					}
					else if (p2.front().getValue() > p1.front().getValue())
					{
						Card moveP2 = Card((p2.front()).getValue());
						Card moveP1 = Card((p1.front()).getValue());
						p1.pop();
						p2.pop();
						p2.push(moveP2);
						p2.push(moveP1);
						for (int i = 0; i < warVec.size(); i++)
						{
							Card temp = warVec[i];
							p2.push(temp);
						}
						cout << moveP1.getValue() << " vs " << moveP2.getValue() << "\n";
					}
				
			}
		}
	}
	
	//declares the opposite players as the winner
	if (p1.empty())
	{
		cout << "Player 2 Wins!!!";
	}
	else if (p2.empty())
	{
		cout << "Player 1 Wins!!!";
	}
}