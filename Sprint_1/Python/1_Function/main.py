import sys


def main():
    line = sys.stdin.readline().rstrip()
    value_1, value_2, value_3, value_4 = line.split()
    a = int(value_1)
    x = int(value_2)
    b = int(value_3)
    c = int(value_4)
    result = a * x * x + b * x + c
    print(result)


if __name__ == '__main__':
    main()
