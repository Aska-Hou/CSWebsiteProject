package domain;

public class Manager {

    private int manager_id;
    private String password;
    private String name;

    public Manager(){

    }

    public Manager(int manager_id, String password, String name) {
        this.manager_id = manager_id;
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + manager_id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
