package Attend2;

class ManagerContainer {
    private LectureManager lectureManager;
    private AttendanceManager attendanceManager;
    private MemoManager memoManager;
    private ScheduleManager scheduleManager;

    public ManagerContainer() {
        lectureManager = new LectureManager();
        attendanceManager = new AttendanceManager();
        memoManager = new MemoManager();
        scheduleManager = new ScheduleManager();
    }

    public LectureManager getLectureManager() {
        return lectureManager;
    }

    public AttendanceManager getAttendanceManager() {
        return attendanceManager;
    }

    public MemoManager getMemoManager() {
        return memoManager;
    }

    public ScheduleManager getScheduleManager() {
        return scheduleManager;
    }
}
