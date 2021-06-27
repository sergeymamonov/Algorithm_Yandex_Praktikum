import sys


def main():
    rows_quantity = int(sys.stdin.readline().rstrip())
    columns_quantity = int(sys.stdin.readline().rstrip())
    matrix = []
    for _ in range(rows_quantity):
        row = list(map(int, sys.stdin.readline().rstrip().split()))
        matrix.append(row)

    location_row = int(sys.stdin.readline().rstrip())
    location_column = int(sys.stdin.readline().rstrip())
    result = []
    if location_row < rows_quantity - 1:
        result.append(matrix[location_row + 1][location_column])
    if location_row > 0:
        result.append(matrix[location_row - 1][location_column])
    if location_column < columns_quantity - 1:
        result.append(matrix[location_row][location_column + 1])
    if location_column > 0:
        result.append(matrix[location_row][location_column - 1])

    result.sort()

    print(*result)


if __name__ == "__main__":
    main()
