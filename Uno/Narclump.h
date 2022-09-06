#pragma once
#include "AI.h"

class Narclump : public AI
{
private:
	Color savedColor = RED;//variable that holds the color I want to use when changing colors
public:
	Narclump(int playerNumber);

	void onOtherPlayerMove(int playerNumber, Card justPlayed, Color choosenCardColor);

	void onOtherPlayerDraw(int playerNumber);

	int makeMove(Card justPlayed, Color choosenCardColor, bool justDrew, vector<int> scores, vector<int> cardAmountsByPlayer, vector<Card> cardsInHand, int direction);

	string getName();

	Color getNewColor();
};
