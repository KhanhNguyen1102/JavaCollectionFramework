package studentManager.managerService;



public interface ManagerService<T> {
    void print();
    void add(T t);
    int findByID(int id);
    void deleteByID(int id);
    void updateByID(int id,T t);
    void sortMinToMax();
    void sortMaxToMin();
    double totalScore();
}
