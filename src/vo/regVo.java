package vo;

public class regVo {

	private int id;
	private String firstname;
	private String lastname;
	
	public regVo(int i,String fname,String lname){
		this.id=i;
		this.firstname=fname;
		this.lastname=lname;
		
	}
	public  regVo(String fname,String lname){
		
		this.firstname=fname;
		this.lastname=lname;
		
	}
	public regVo(){
		
		
	}
	@Override
	public String toString() {
		return "regVo [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
