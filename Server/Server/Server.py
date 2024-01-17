import socket
import threading
#Details of the server
HEADER = 64
PORT = 5050
SERVER = socket.gethostbyname(socket.gethostname())
ADDR = (SERVER, PORT)
FORMAT = "utf-8"
DISCONNECT_MESSAGE = "!DISCONNECT"
#connect to the socket and bind to the address
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(ADDR)
#Function for handling the client connection when desired
def handle_client(conn, addr):
    #let the user know that the client has established a connection
    print(f"[NEW CONNECTION] {addr} connected.")
    connected = True
    while connected:
        #receive the header specified earlier
        msg_length = conn.recv(HEADER).decode(FORMAT)
        #if the message exists
        if msg_length:
            #receive and decode the message
            msg_length = int(msg_length)
            msg = conn.recv(msg_length).decode(FORMAT)
            #print out the message received
            #print(f"[{addr}] {msg}")
            #if the client sends a disconnect message
        if msg == DISCONNECT_MESSAGE:
            connected = False
            break
        #if the input is valid
        try:
            finalBing = ""
            #perform the bing bong operation
            for i in range(len(msg)):
                #if the character is a vowel, add bong
                if msg[i] == "a" or msg[i] == "e" or msg[i] == "i" or msg[i] == "o" or msg[i] == "u":
                    finalBing += "Bong "
                elif msg[i] == " ":
                 finalBing += "\n"
                #otherwise add bing
                else:
                    finalBing += "Bing "
        #send the result to the client
            conn.send(f"{finalBing}".encode(FORMAT))
        #print out the message sent
        #print(f"[{addr}] {finalBing}")
        #if the calculation is complete, terminate the server and client
        #if len(str(digitSum)) == 1:
        # conn.send("!DISCONNECT".encode(FORMAT))
        # connected = False
        # break
        #if the input is invalid, terminate the server and client

        except:
            print(f"[{addr}] {msg} is invalid")
            conn.send("!DISCONNECT".encode(FORMAT))
            connected = False
            break
    



    conn.close()
def start():
    #start up the server and allow connections
    server.listen()
    print(f"[LISTENING] Server is listening on {SERVER}")
    #accept the connections and display connections when they happen, along with starting their threads.
while True:
    conn, addr = server.accept()
    thread = threading.Thread(target=handle_client, args=(conn,addr))
    thread.start()
    print(f"[ACTIVE CONNECTIONS] {threading.active_count() - 1}")
print("[STARTING] server is starting... ")
start()