package studentManager.model;

public class Student extends Person{
    private double averageScore;

    public Student(String name, int age, double score) {
        super(name, age);
        this.averageScore = score;
    }

    public Student(double score) {
        this.averageScore = score;
    }

    public Student(String name, int age) {
        super(name, age);
    }



    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                " id = " + getId() +
                ", name='" + getName() + '\'' +
                ", age =" + getAge() +
                ", score=" + averageScore +
                '}';
    }
}
