/***********************************************************
	main.cpp - Client
	author: Stevie Payan
	date: 12/01/23
	assignment: server/client

	This code is the client. It uses winsock to create the socket and
	connect to the ip address and port of the server. It sends a 
	random number using the current time. Then recieves a list of
	colors to choose from and sends a choosen color to the server.
	It recieves a fortune then can either get another fortune 
	or end the program.

************************************************************/


#include <iostream>
#include <ws2tcpip.h> // access network sockets
#include <string>
#pragma comment (lib, "ws2_32.lib")

using namespace std;

void main()
{

	string ipAddress = "127.0.0.1";			// server ip address
	int port = 54000;						// listening port on server

	// initialize winsock
	WSADATA data; // data start up
	WORD ver = MAKEWORD(2, 2); // requesting version 2.2

	// initializing winsock
	int wsResult = WSAStartup(ver, &data);

	// if it can't initialize
	if (wsResult != 0)
	{
		cerr << "can't initialize winsock, quitting\n" << wsResult;
		return;
	}
	// create socket
	SOCKET sock = socket(AF_INET, SOCK_STREAM, 0);

	// testing 
	if (sock == INVALID_SOCKET)
	{
		cerr << "can't create socket, quitting\n";
		WSACleanup();
		return;
	}

	// fill in a hint structure
	sockaddr_in hint;
	hint.sin_family = AF_INET;
	hint.sin_port = htons(port); // host to network short - 54000 is port num
	inet_pton(AF_INET, ipAddress.c_str(), &hint.sin_addr); // have to covert to string


	// connect to server - make sure it connects
	int connResult = connect(sock, (sockaddr*)&hint, sizeof(hint));
	if (connResult == SOCKET_ERROR)
	{
		cerr << "can't connect\n";
		closesocket(sock);
		WSACleanup();
		return;
	}
	// let the user know it started
	cout << "Fortune Teller Started\nConnecting to " << ipAddress << " :" << port;

	// start of protocol code
	// variables
	char buf[4096]{};		// what gets sent back and forth from client to the server
	string userInput;		// the input from the user 
	char clientNum[20];		// the random number generated
	char colors[300];		// the colors

	// generate a random number
	srand(time(nullptr));
	int randomNum = rand();
	
	// convert number and send to the server
	sprintf_s(clientNum, "%d", randomNum);
	send(sock, clientNum, sizeof(clientNum), 0);
	ZeroMemory(buf, 4096);
	// recieve the list of colors to use
	recv(sock, colors, sizeof(colors), 0);
	

	// bytes recieved - the number of bytes getting sent back by the server
	// sendResult - the number of bytes getting sent to the server
	// loop to go through the fortunes until the client ends it
	while(strcmp(buf, "done") != 0)
	{
		cout << "\nI will tell you your fortune. Pick your favorite color: " << colors << "\nIf you would like to exit, type done\n >> ";
		getline(cin, userInput); // use getline to get the full line of text at once

		// make sure user typed something
		if (userInput.size() > 0)
		{
			// send the color choice to the server
			int sendResult = send(sock, userInput.c_str(), 100, 0);

			if (sendResult != SOCKET_ERROR)
			{
				// if the user ends it
				if (strcmp(userInput.c_str(), "done") == 0)
				{
					cout << "\nThanks for getting your fortune!\n";
					break;
				}
				// if the user input is not one of the choosen colors - send error message and loop back
				if (strcmp(userInput.c_str(), "maroon") != 0 && strcmp(userInput.c_str(), "cyan") != 0 && strcmp(userInput.c_str(), "coral") != 0 && strcmp(userInput.c_str(), "periwinkle") != 0 && strcmp(userInput.c_str(), "celadon") != 0 && strcmp(userInput.c_str(), "scarlet") != 0)
				{
					cout << "please try again with proper input from one of the color options\n";
					continue;
				}

				// wait for response
				ZeroMemory(buf, 4096);
				int bytesRecieved = recv(sock, buf, sizeof(buf) - 1, 0);
				// make sure the server sent something
				if (bytesRecieved > 0)
				{
					// make sure it was a letter
					if (strcmp(buf, "-1") == 0)
					{
						cerr << "\nServer returned Not A letter error, Exiting Client Application\n";
						break;
					}

					// outputting contents of buf which is the fortune recieved from server
					cout << "Your fortune: " << buf << endl;

				}
			}
		}
	} 

	// close down
	closesocket(sock);
	WSACleanup();

}