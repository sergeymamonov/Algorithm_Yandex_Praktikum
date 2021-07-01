import sys


def main():
    common_weight, piece_weight, detail_weight = map(int, sys.stdin.readline().rstrip().split())
    result = 0
    while common_weight > piece_weight:
        quantity = common_weight // piece_weight
        result += quantity
        chip_weight = quantity * (piece_weight - detail_weight)
        common_weight = common_weight - quantity * piece_weight + chip_weight
        print(f"Масса сплава = {common_weight}\tКоличество деталей = {quantity}")

    print(result)


if __name__ == "__main__":
    main()
