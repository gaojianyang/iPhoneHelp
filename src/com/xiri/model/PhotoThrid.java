package com.xiri.model;

public class PhotoThrid {
private int img_id;
private String title;
private int number;
public PhotoThrid() {
	super();
}
public PhotoThrid(int img_id, String title, int number) {
	super();
	this.img_id = img_id;
	this.title = title;
	this.number = number;
}
public int getImg_id() {
	return img_id;
}
public void setImg_id(int img_id) {
	this.img_id = img_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}

}
