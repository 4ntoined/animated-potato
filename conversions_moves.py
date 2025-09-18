import numpy as np

if __name__ == "__main__":
    moves_array = np.load("saved_movedex.npy")
    #print(moves_array["pwr"][2])
    outfile = open("moves_2.csv","x")
    for i in range(len(moves_array)):
        linedata = moves_array[i]
        index = str(int(linedata["index"]))
        name = str(linedata["name"])
        power = str(int(linedata["pwr"]))
        accuracy = str(int(linedata["pwr"]))
        pp = str(int(linedata["pp"]))
        category = str(int(linedata["special?"]))
        contact = str(int(linedata["contact?"]))
        type0 = str(int(linedata["type"]))
        priority = str(int(linedata["priority"]))
        range0 = str(int(linedata["range"]))
        description = str(linedata["desc"]).replace("\n","[NEWLINE]")
        notes = str(linedata["notes"])
        linestring = index + "|" + name + "|" + power + "|" + accuracy + "|" + pp + "|" + category + "|" + contact + "|" + type0 + "|" + priority + "|" + range0 + "|" + description + "|" + notes + "\n"
        outfile.write(linestring)
        pass
    #print(len(moves_array))
    outfile.close()
    pass
else:
    pass