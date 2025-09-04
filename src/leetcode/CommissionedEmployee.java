package leetcode;

public interface CommissionedEmployee {
    void addSalesReceipt(Employee e, SalesReceipt sr);
    Employee findById(String id);
    void save(Employee e);
}
