class Rectangle():
    def __init__(self, w, d):
        self.__w = w
        self.__d = d
        self.__face = w*d

    def __repr__(self):
        return "사각형의 면적: {0}".format(self.__face)

aa = Rectangle(4,5)
print(aa)