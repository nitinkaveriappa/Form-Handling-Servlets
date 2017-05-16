import java.io.Serializable;

public class StudentBean implements Serializable {
	
	//Student Attributes
	private int Student_id;
	private String Student_name;
	private String Student_address;
	private String Student_city;
	private String Student_state;
	private int Student_zipcode;
	private String Student_phone;
	private String Student_email;
	private String Student_url;
	private String Student_date;
	private String Student_likes;
	private String Student_interest;
	private String Student_comments;
	private String Student_months;
	private String Student_years;
	private String Student_recommend;
	
	public StudentBean() {
		
	}
	public int getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}
	public String getStudent_address() {
		return Student_address;
	}
	public void setStudent_address(String student_address) {
		Student_address = student_address;
	}
	public String getStudent_city() {
		return Student_city;
	}
	public void setStudent_city(String student_city) {
		Student_city = student_city;
	}
	public String getStudent_state() {
		return Student_state;
	}
	public void setStudent_state(String student_state) {
		Student_state = student_state;
	}
	public String getStudent_phone() {
		return Student_phone;
	}
	public void setStudent_phone(String student_phone) {
		Student_phone = student_phone;
	}
	public int getStudent_zipcode() {
		return Student_zipcode;
	}
	public void setStudent_zipcode(int student_zipcode) {
		Student_zipcode = student_zipcode;
	}
	public String getStudent_email() {
		return Student_email;
	}
	public void setStudent_email(String student_email) {
		Student_email = student_email;
	}
	public String getStudent_url() {
		return Student_url;
	}
	public void setStudent_url(String student_url) {
		Student_url = student_url;
	}
	public String getStudent_likes() {
		return Student_likes;
	}
	public void setStudent_likes(String student_likes) {
		Student_likes = student_likes;
	}
	public String getStudent_recommend() {
		return Student_recommend;
	}
	public void setStudent_recommend(String student_recommend) {
		Student_recommend = student_recommend;
	}
	public String getStudent_years() {
		return Student_years;
	}
	public void setStudent_years(String student_years) {
		Student_years = student_years;
	}
	public String getStudent_months() {
		return Student_months;
	}
	public void setStudent_months(String student_months) {
		Student_months = student_months;
	}
	public String getStudent_comments() {
		return Student_comments;
	}
	public void setStudent_comments(String student_comments) {
		Student_comments = student_comments;
	}
	public String getStudent_interest() {
		return Student_interest;
	}
	public void setStudent_interest(String student_interest) {
		Student_interest = student_interest;
	}
	public String getStudent_date() {
		return Student_date;
	}
	public void setStudent_date(String student_date) {
		Student_date = student_date;
	}
}
