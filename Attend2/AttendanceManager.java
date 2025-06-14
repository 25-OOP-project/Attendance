package Attend2;

import java.util.*;
import java.util.stream.Collectors;

public class AttendanceManager {
    // 출석 정보를 관리하는 핵심 클래스.
    // 출석 기록 추가, 출석률 계산, 날짜별 출석 상태 조회 등의 비즈니스 로직을 담당.
    // 내부에 List<AttendanceRecord>를 가지고 있어 실제 출석 데이터를 저장하고 관리함.

    private List<AttendanceRecord> records = new ArrayList<>();

    // 출석 기록 추가
    public void addRecord(AttendanceRecord record) {
        records.add(record);
    }

    // 특정 강의의 출석 기록 모두 가져오기
    public List<AttendanceRecord> getRecordsByLecture(String lectureName) {
        return records.stream()
                .filter(r -> r.getLectureName().equals(lectureName))
                .collect(Collectors.toList());
    }

    // 강의별 날짜별 출석 상태 Map으로 반환 (날짜 -> 상태)
    public Map<String, String> getAttendanceByDate(String lectureName) {
        Map<String, String> map = new TreeMap<>(); // TreeMap으로 날짜 정렬 가능
        for (AttendanceRecord r : getRecordsByLecture(lectureName)) {
            map.put(r.getDate(), r.getStatus());
        }
        return map;
    }

    // 출석률 계산 (출석/전체 비율, 출석만 '출석' 상태로 간주)
    public double getAttendanceRate(String lectureName) {
        List<AttendanceRecord> lectureRecords = getRecordsByLecture(lectureName);
        if (lectureRecords.isEmpty())
            return 0.0;

        long attendedCount = lectureRecords.stream()
                .filter(r -> r.getStatus().equals("출석"))
                .count();

        return (double) attendedCount / lectureRecords.size();
    }

    // 전체 출석 기록 리스트 반환 (필요시)
    public List<AttendanceRecord> getAllRecords() {
        return records;
    }

    // 기록 초기화 (필요시)
    public void clearRecords() {
        records.clear();
    }
}
