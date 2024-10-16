#Decoder program: this program reads a file that consists lines which have a number and a word associated to it
#It groups these things into a list of tuples, sorts them least to greates by number, and performs
#a simple algorithm to print out a message base on a pyramid step
#By Logan Strong

tuples = [ ]
with open("coding_qual_input.txt", "r") as file: #file we're reading from
    
    lines = file.readlines()

    for x in lines: #creates tuples out of the list of lines using a for loop
        keys = x.split()
        add_tup = (keys[0], keys[1])
        tuples.append(keys)

    tuples.sort() #sorts the tuples based on the numerical values in ascending order
    
    index = 0 #index of tuple in the array
    layer = 0 #whoch layer of the pyramid we are at (used to calculate the last element in that layer)
    length = len(tuples)

    while index < length: #adds to our index that layer which we are at so we can grab the furthest step element and print it
        message = tuples[index]
        print(message[1])
        layer += 1
        index += layer

file.close()