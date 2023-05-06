package sdbms;

public class Student {
private String id;
private int age;
private String name;
private int marks;
static int count=1;
public Student(int age,String name, int marks){
	this.id="3PD18EE0"+count;
	this.age=age;
	this.name=name;
	this.marks=marks;
	count++;
}
public void setname(String name) {
	this.name=name;
}
public void setage(int age) {
	this.age=age;
}
public void setmarks(int marks) {
	this.marks=marks;
}
public String getid() {
	return id;
}
public int getage() {
	return age;
	
}
public String getname() {
	return name;
}
public int getmarks() {
	return marks;
}
public String toString() {
	return "id:"+id+" age:"+age+" name:"+name+" marks:"+marks;
}

}
