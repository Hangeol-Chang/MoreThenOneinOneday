import tkinter as tk
from tkinter import ttk

class Sub :
    def __init__(self, que) :
        self.window = tk.Tk()

        self.que = que

        self.window.title('TEST')
        self.window.geometry('640x400+100+100')
        # self.window.resizeable(False, False)

        bt = tk.Button(self.window, text='bt', command=lambda : self.set_que(self.ev))
        bt.pack()

    def get_que(self) :
        if len(self.que) > 0 :
            return self.que.pop(0)
        else : return None

    def ev(self, main) :
        main.sum()
        
    def set_que(self, e) :
        print('set que')
        self.que.append(e)

    def run(self) :
        self.window.mainloop()