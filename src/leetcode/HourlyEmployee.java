package leetcode;

public interface HourlyEmployee {
    void addTimeCard(Employee e, Timecard tc);
    Employee findById(String id);
    void save(Employee e);
}
