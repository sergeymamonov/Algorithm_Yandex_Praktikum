import sys


def main():
    brick_sizes = []
    for _ in range(3):
        brick_sizes.append(int(sys.stdin.readline().rstrip()))

    hole_sizes = []
    for _ in range(2):
        hole_sizes.append(int(sys.stdin.readline().rstrip()))

    brick_sizes.sort()
    hole_sizes.sort()

    if brick_sizes[0] <= hole_sizes[0] and brick_sizes[1] <= hole_sizes[1]:
        print("YES")
    else:
        print("NO")


if __name__ == "__main__":
    main()
