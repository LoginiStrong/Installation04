import socket
#client information
HEADER = 64
PORT = 5050
FORMAT = "utf-8"
DISCONNECT_MESSAGE = "!DISCONNECT"
SERVER = "192.168.1.174"
ADDR = (SERVER, PORT)
#client socket connection to the address of the server
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(ADDR)

def send(msg):
    #message given by the function to encode
    message = msg.encode(FORMAT)
    #send the message with added header blank space to completely fill the packet
    msg_length = len(message)
    send_length = str(msg_length).encode(FORMAT)
    send_length += b' ' * (HEADER - len(send_length))
    #send the header and message together
    client.send(send_length)
    client.send(message)
    #receive any messages sent back from the server
    recMsg = client.recv(2048).decode(FORMAT)
    #print out the message and send it back to the server
    #print(recMsg)
    outMsg = "Colin "
    counter = 5
    #perform the Beep Boop operation
    for i in range(len(recMsg)):
        if counter == 1:
            outMsg += ""
        counter -= 1
        if counter == 0:
            counter = 5
    #message given by the function to encode
    outEnc = outMsg.encode(FORMAT)
    #send the message with added header blank space to completely fill the packet
    enc_length = len(outEnc)
    encSend_length = str(enc_length).encode(FORMAT)
    encSend_length += b' ' * (HEADER - len(encSend_length))
    #send the header and message together
    client.send(encSend_length)
    client.send(outEnc)
recMsg2 = client.recv(2048).decode(FORMAT)
print(recMsg2)
send(DISCONNECT_MESSAGE)
inputBing = str(input("Type ANYTHING: "))
send(inputBing)
