/***********************************************************
	main.cpp - Server
	author: Stevie Payan
	date: 12/01/23
	assignment: Project - part 2

	This code is the server. It uses winsock to create the socket and
	bind the ip and port to the socket. It recieves a random number
	from the client and determines if it's even or odd. Depending
	on if the number is even or odd the server will send the client
	a different list of colors. The server will then recieve
	a choosen color from the client and send a fortune based
	on the color.

************************************************************/


#include <iostream>
#include <ws2tcpip.h> // access network sockets
#include <string>
#pragma comment (lib, "ws2_32.lib")

using namespace std;


void main()
{
	// initialize winsock -----------------------------------------
	WSADATA wsData; // data start up
	WORD ver = MAKEWORD(2, 2); // requesting version 2.2

	// initializing winsock
	int wsOK = WSAStartup(ver, &wsData);
	if (wsOK != 0)
	{
		cout << "can't initialize winsock, quitting\n";
		return;
	}

	// create socket ---------------------------------------------
	// SOCKE_STREAM - TCP
	SOCKET listening = socket(AF_INET, SOCK_STREAM, 0);

	// testing for listening
	if (listening == INVALID_SOCKET)
	{
		cerr << "can't create socket, quitting\n";
		return;
	}

	// bind ip and port to socket ---------------------------------
	sockaddr_in hint;
	hint.sin_family = AF_INET;
	hint.sin_port = htons(54000); // host to network short - 54000 is port num
	hint.sin_addr.S_un.S_addr = INADDR_ANY;	// any addr

	// binding
	bind(listening, (sockaddr*)&hint, sizeof(hint));

	// tell winsock socket is listening ----------------------------
	listen(listening, SOMAXCONN); // how you're going to listen

	// wait for connect --------------------------------------------
	sockaddr_in client;
	int clientSize = sizeof(client);

	SOCKET clientSocket = accept(listening, (sockaddr*)&client, &clientSize);
	char host[NI_MAXHOST];		//client remote name
	char service[NI_MAXHOST];	// service port, the client connection is on

	// make sure no left overs in the array
	ZeroMemory(host, NI_MAXHOST);
	ZeroMemory(service, NI_MAXHOST);

	// check for name info
	if (getnameinfo((sockaddr*)&client, sizeof(client), host, NI_MAXHOST, service, NI_MAXSERV, 0) == 0)
	{
		cout << host << " connected on TCP port " << service << endl;
	}
	// if you can't get the name display something else
	else
	{
		inet_ntop(AF_INET, &client.sin_addr, host, NI_MAXHOST);
		// ip address and port instead
		cout << host << " connected on TCP port " << ntohs(client.sin_port) << endl;
	}

	cout << "Fortune Teller Started on Server\n";

	//close listening socket -------------------------
	closesocket(listening);

	// staring protocol code
	char buf[4096]{};		// what is sent back and forth from the server to the client
	char clientNumS[20];	// a char variable to recieve the random number from the client

	// recieve the random number from the client
	recv(clientSocket, clientNumS, sizeof(clientNumS), 0);
	int clientNum = stoi(clientNumS);	// convert number to compare

	// send color choices based on the number (even or odd)
	if (clientNum % 2 == 0)
	{
		char colors[] = "maroon, cyan, or coral";
		send(clientSocket, colors, sizeof(colors), 0);
	}
	else
	{
		char colors[] = "periwinkle, celadon, or scarlet";
		send(clientSocket, colors, sizeof(colors), 0);
	}

	// loop for sending fortunes
	while (strcmp(buf, "done") != 0)
	{

		ZeroMemory(buf, 4096);

		// wait for data from client
		int bytesRecieved = recv(clientSocket, buf, 4096, 0);

		// erorr handling
		if (bytesRecieved == SOCKET_ERROR)
		{
			cerr << "error int recieve, quit\n";
		}
		if (bytesRecieved == 0)
		{
			cout << "client disconnected\n";
			break;
		}

		cout << "Recieved Favorite color: " << buf << endl;

		// defining fortunes for each color
		const char* maroon = "You might eat a bug or you might crash a wedding - hard to say";
		const char* coral = "You will be slapped by a stranger next week";
		const char* cyan = "The last fortune cookie you read is true";
		const char* periwinkle = "The bees are planning something, and only you can save us";
		const char* celadon = "You will soon be invloved in a dance battle and there will be an unexpected prize... you won't win";
		const char* scarlet = "The snail will find you eventually... don't let it touch you";

		// put the correct fortune into the buf depending on the color
		if (strcmp(buf, "maroon") == 0)
		{
			strcpy_s(buf, maroon);
		}
		else if (strcmp(buf, "coral") == 0)
		{
			strcpy_s(buf, coral);
		}
		else if (strcmp(buf, "cyan") == 0)
		{
			strcpy_s(buf, cyan);
		}
		else if (strcmp(buf, "celadon") == 0)
		{
			strcpy_s(buf, celadon);
		}
		else if (strcmp(buf, "periwinkle") == 0)
		{
			strcpy_s(buf, periwinkle);
		}
		else if (strcmp(buf, "scarlet") == 0)
		{
			strcpy_s(buf, scarlet);
		}
		else if (strcmp(buf, "done") == 0)
		{
			cout << "Fortune Game Ended";
			break;
		}
		else
		{
			// if the input wasn't a color option, loop back to the top and display error message
			cout << "Please try again with proper input\n";
			continue;
		}

		cout << "Sending the Fortune: " << buf << endl;
		// send the fortune
		send(clientSocket, buf, bytesRecieved + 1, 0);

	}

	// close and cleanup
	closesocket(clientSocket);
	WSACleanup();

}