package Attend2;

import java.io.*;
import java.util.*;

public class FileIO {

    private static final String FILE_NAME = "lectures.dat";

    // 강의 목록 저장
    public static void saveLectures(List<Lecture> lectures) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lectures);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 강의 목록 불러오기
    public static List<Lecture> loadLectures() {
        List<Lecture> lectures = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return lectures; // 파일 없으면 빈 리스트 반환
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            lectures = (List<Lecture>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lectures;
    }
}
