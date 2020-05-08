package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
//@Table(name = "employees")
public class Employee {

    private int id;
    private String Name;
    private String email;

    public Employee() {

    }

    public Employee(String Name,  String email) {
        
        this.email = email;
    }

    @Id
    @GeneratedValue
   // @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

   // @Column(name = "name", nullable = false)
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }


  //  @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", email=" + email + "]";
	}
}