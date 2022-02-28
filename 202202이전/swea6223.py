class circle():
    def __init__(self, radius):
        self.__radius = radius
        self.__face = 3.14 * 2 * radius
	
    def __repr__(self):
        return "원의 면적 : {0}".format(self.__face)


a = circle(2)
print(a)