#
'''
print("ge;;")
print(2)
print(3)

print("이름 : %s" %"홍길동")
print("이름 : %s \n %s 세" %("홍길동", 20))
print("%x %o %d" %(10, 10, 10))

#str.format
print(" 이름 {0:c} 나이 {1}".format(100,2))
print("이름 : {name}, 나이 : {age}".format(name="asd", age = 20))
print("{0:<10}".format("좌측정렬"))
print("{0:^10}".format("중앙정렬"))
print("{0:*^10}".format("중앙정렬"))

print("{{ {0:.1f} }}".format(98.5))

dogs = {}
dogs[1] = 'dh'
print(dogs)


def rev(a) :
    length = len(a)
    b = ''
    for i in range (len(a)-1, -1, -1) :
        b += a[i]
    print(b)
    if(a == b) :
        print("입력하신 단어는 회문(Palindrome)입니다.")

def rcp(b1, b2) :
    if(b1 == "가위") :
        if( b2 == "바위") :
            print("바위가 이겼습니다!")
        else :
            print("가위가 이겼습니다!")

    elif(b1 == "바위") :
        if( b2 == "보") :
            print("보가 이겼습니다!")
        else :
            print("바위가 이겼습니다!")

    else :
        if( b2 == "바위") :
            print("바위가 이겼습니다!")
        else :
            print("보가 이겼습니다!")

p1 = input()
p2 = input()
a1 = input()
a2 = input()
rcp(a1, a2)

class score :
    def __init__(self, lan, mat, eng):
        self.lan = lan
        self.mat = mat
        self.eng = eng
        
    def sum(self):
        print("국어, 영어, 수학의 총점: {0}".format(self.lan + self.mat + self.eng))
        
        
a = list(map(int, input().split(", ")))
b = score(a[0], a[1], a[2])
b.sum()


class Student:
    def __init__(self, name, gender, height):
        self.__name = name
        self.__gender = gender
        self.__height = height
    
    @property
    def name(self):
        return self.__name
    
    @property
    def gender(self):
        return self.__gender
    
    @property
    def height(self):
        return self.__height
    
    @height.setter
    def height(self, height):
        self.__height = height

    #객체 출력 시 사용
    def __repr__(self):
        return "{0}(name: {1}, gender: {2}, height: {3})"\
            .format(self.__class__.__name__, self.name, self.gender, self.height)


students = [
    Student("홍길동", "남", 176.5),
    Student("이순신", "남", 188.5),
    Student("유관순", "여", 158.4),
    Student("강감찬", "남", 182.2)
]

for student in students:
    print(students)
    
print("name으로 오름차순 정렬 후 ==>")
for student in sorted(students, key = lambda x: x.name):
    print(student)

print("name으로 내림차순 정렬 후 ==>")
for student in sorted(students, key = lambda x: x.name, reverse=True):
    print(student)

'''
#

class Student :
    def __init__(self, name):
        self.name = name
	
    def __repr__(self):
        return "이름: {0}".format(self.name)
        
class GraduateStudent(Student) :
    def __init__(self, name, major):
        self.major = major
        super().__init__(name)
    
    def __repr__(self):
        return "이름: {0}, 전공: {1}".format(self.name, self.major)
    
a = Student("홍길동")
b = GraduateStudent("이순신", "컴퓨터")

print(a)
print(b)
