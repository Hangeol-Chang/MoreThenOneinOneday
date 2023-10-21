
import sub.su as su
import multiprocessing as mp
import time

class Main :
    def __init__(self) :
        pass

    def sum(self) :
        print("123123")



if __name__ == "__main__" :
    m = Main()
    # que = mp.Array('c', 0)

    subm = su.Sub([])

    s_process = mp.Process(target=subm.run, args=())
    s_process.start()
    print("뭐임?")

    while True :
        event = s.get_que()
        if event :
            print(event)
        else : 
            print("NONE")

        time.sleep(1)