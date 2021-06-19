import sys


def main():
    line = sys.stdin.readline().rstrip()
    numbers = line.split()
    is_even = int(numbers[0]) % 2
    for number in numbers:
        if int(number) % 2 != is_even:
            print("FAIL")
            return
    print("WIN")


if __name__ == '__main__':
    main()
