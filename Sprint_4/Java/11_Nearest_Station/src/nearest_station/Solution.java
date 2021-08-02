package nearest_station;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static final int R_SQUARE = 400;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int exitQuantity = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        ArrayList<Exit> exits = new ArrayList<>();
        for (int i = 0; i < exitQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            exits.add(new Exit(x, y));
        }
        int stationQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Station> stations = new ArrayList<>();
        for (int i = 0; i < stationQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            stations.add(new Station(x, y));
        }
        HashMap<Integer, Integer> result = new HashMap<>();
        int stationNumber = 1;
        for (Station station : stations) {
            for (Exit exit : exits) {
                if (square(station.getX() - exit.getX()) + square(station.getY() - exit.getY()) < R_SQUARE) {
                    if (result.containsKey(stationNumber)) {
                        result.put(stationNumber, result.get(stationNumber) + 1);
                    } else {
                        result.put(stationNumber, 1);
                    }
                }
            }
            stationNumber++;
        }

    }

    private static int square(int a) {
        return a * a;
    }
}

class Station {
    int x;
    int y;

    public Station(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Exit {
    int x;
    int y;

    public Exit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}



