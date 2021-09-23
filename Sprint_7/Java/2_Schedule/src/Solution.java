import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        ArrayList<Lesson> lessons = getLessons();

        lessonSort(lessons);

        int countLesson = getCountLessonAndSchedule(lessons);

        System.out.println(countLesson);
        System.out.println(stringBuffer);
    }

    private static ArrayList<Lesson> getLessons() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lessonsQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Lesson> lessons = new ArrayList<>();
        StringTokenizer stringTokenizer;
        for (int i = 0; i < lessonsQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String[] startTime = stringTokenizer.nextToken().split("\\.");
            String[] endTime = stringTokenizer.nextToken().split("\\.");

            int startHours;
            int startMinutes;
            int endHours;
            int endMinutes;

            if (startTime.length == 2) {
                startHours = Integer.parseInt(startTime[0]);
                startMinutes = Integer.parseInt(startTime[1]);
            } else {
                startHours = Integer.parseInt(startTime[0]);
                startMinutes = 0;
            }

            if (endTime.length == 2) {
                endHours = Integer.parseInt(endTime[0]);
                endMinutes = Integer.parseInt(endTime[1]);
            } else {
                endHours = Integer.parseInt(endTime[0]);
                endMinutes = 0;
            }

            lessons.add(new Lesson(startHours, startMinutes, endHours, endMinutes));
        }
        return lessons;
    }

    private static void lessonSort(ArrayList<Lesson> lessons) {
        lessons.sort(new Comparator<Lesson>() {
            @Override
            public int compare(Lesson lesson1, Lesson lesson2) {
                if (lesson1.getEndHours() == lesson2.getEndHours()) {
                    if (lesson1.getEndMinutes() == lesson2.getEndMinutes()) {
                        if (lesson1.getStartHours() == lesson2.getStartHours()) {
                            return lesson1.getStartMinutes() - lesson2.getStartMinutes();
                        } else {
                            return lesson1.getStartHours() - lesson2.getStartHours();
                        }
                    } else {
                        return lesson1.getEndMinutes() - lesson2.getEndMinutes();
                    }
                } else {
                    return lesson1.getEndHours() - lesson2.getEndHours();
                }
            }
        });
    }

    private static int getCountLessonAndSchedule(ArrayList<Lesson> lessons) {
        Lesson currentLesson = lessons.get(0);
        appendTime(currentLesson);
        int countLesson = 1;

        for (int i = 1; i < lessons.size(); i++) {
            Lesson lesson = lessons.get(i);
            if (lesson.getStartHours() >= currentLesson.getEndHours() && lesson.getStartMinutes() >= currentLesson.getEndMinutes()) {
                countLesson++;
                currentLesson = lesson;
                appendTime(currentLesson);
            }
        }
        return countLesson;
    }

    private static void appendTime(Lesson lesson) {
        if (lesson.getStartMinutes() > 0 && lesson.getEndMinutes() > 0) {
            stringBuffer.append(lesson.getStartHours()).append(".").append(lesson.getStartMinutes()).append(" ").append(lesson.getEndHours()).append(".").append(lesson.getEndMinutes());
        } else if (lesson.getStartMinutes() > 0) {
            stringBuffer.append(lesson.getStartHours()).append(".").append(lesson.getStartMinutes()).append(" ").append(lesson.getEndHours());
        } else if (lesson.getEndMinutes() > 0) {
            stringBuffer.append(lesson.getStartHours()).append(" ").append(lesson.getEndHours()).append(".").append(lesson.getEndMinutes());

        } else {
            stringBuffer.append(lesson.getStartHours()).append(" ").append(lesson.getEndHours());
        }
        stringBuffer.append("\n");
    }
}

class Lesson {
    int startHours;
    int startMinutes;
    int endHours;
    int endMinutes;

    public Lesson(int startHours, int startMinutes, int endHours, int endMinutes) {
        this.startHours = startHours;
        this.startMinutes = startMinutes;
        this.endHours = endHours;
        this.endMinutes = endMinutes;
    }

    public int getStartHours() {
        return startHours;
    }

    public int getStartMinutes() {
        return startMinutes;
    }

    public int getEndHours() {
        return endHours;
    }

    public int getEndMinutes() {
        return endMinutes;
    }
}
