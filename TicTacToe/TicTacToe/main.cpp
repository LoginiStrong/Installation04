#include <iostream> 
using namespace std;

int main()
{
    
    int turn = 0;
    bool win = false;
    char board[3][3] = { { ' ', ' ', ' ' },
                         { ' ', ' ', ' ' },
                         { ' ', ' ', ' ' } };
    char player = 'X';
    int row, col;

    //variables used for the psuedo for loops regarding gotos
    int i = 0;
    int j = 0;

        goto draw;
        play: 
            cout << "Player " << player
                << ", enter row (0-2) and column (0-2): ";
            cin >> row >> col;

            if (board[row][col] != ' ' || row < 0 || row > 2 || col < 0 || col > 2) 
            {
                cout << "Invalid move. Try again.\n";
                goto play;
            }
            else
            {
                turn++;
            }
        
        board[row][col] = player;
        goto check;
    //progress label is used to return to the end of the playing state of the game      
    progress:
        // checks for a winner
        if (win == true) {
            goto draw;
            won:
                cout << "Player " << player << " wins!\n";
                exit(0);
        }

        // switch players
        if (player == 'X')
        {
            player = 'O';
        }
        else
        {
            player = 'X';
        }
    
    // check for a draw 
    if (turn == 9 && win == false) 
    {
        cout << "Draw!\n";
        exit(0);
    }

    //draws board
    draw://i part of goto nested for loop for drawing
    cout << endl;
        if (i != 3)
        {
            cout << "| ";
            innerDraw://j part of goto nested for loop
            
                cout << board[i][j] << " | ";
                j++;
                if (j == 3)
                { 
                    j = 0;
                    i++;
                    goto draw;
                }
                else
                    goto innerDraw;
        }
        else if (win == true)
        {
            goto won;
        }
        else
        {
            i = 0;
            goto play;
        }

        // checks if it's a winning play
    check:
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player)
            win = true;
        if (board[1][0] == player && board[1][1] == player && board[1][2] == player)
            win = true;
        if (board[2][0] == player && board[2][1] == player && board[2][2] == player)
            win = true;
        if (board[0][0] == player && board[1][0] == player && board[2][0] == player)
            win = true;
        if (board[0][1] == player && board[1][1] == player && board[2][1] == player)
            win = true;
        if (board[0][2] == player && board[1][2] == player && board[2][2] == player)
            win = true;
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            win = true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            win = true;
            goto progress;
}