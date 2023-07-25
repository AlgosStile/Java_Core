package dz_4;

class Customer {
    private final String fullName;
    private final int age;
    private final String phone;

    public Customer(String fullName, int age, String phone) {
        this.fullName = fullName;
        this.age = age;
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Object getFullName() {
        return fullName;
    }
}