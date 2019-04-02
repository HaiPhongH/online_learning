/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HaiPh
 */
public class Course {
    private int id;
    private String courseName;
    private float price;
    private String courseTitle;
    private String date;
    private String author;
    private String listCourse;
    private float rating;
    private String image;
   

    public Course() {
    }

    public Course(String courseName, float price, String courseTitle, String date, String author, String listCourse, float rating, String image) {
        this.courseName = courseName;
        this.price = price;
        this.courseTitle = courseTitle;
        this.date = date;
        this.author = author;
        this.listCourse = listCourse;
        this.rating = rating;
        this.image = image;
    }

    public int getId() {
        return id;
    }
    
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getListCourse() {
        return listCourse;
    }

    public void setListCourse(String listCourse) {
        this.listCourse = listCourse;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    @Override
    public String toString() {
        return "{\"id\":" + "\"" + this.id + "\","
               + "\"name\":" + "\"" + this.courseName + "\","
               + "\"price\":" +  this.price + ","
               + "\"title\":" + "\"" + this.courseTitle + "\","
               + "\"date\":" + "\"" + this.date + "\","
               + "\"author\":" + "\"" + this.author + "\","
               + "\"list\":" + "\"" + this.listCourse + "\","
               + "\"rating\":" + "\"" + this.rating + "\","
               + "\"image\":" + "\"" + this.image + "\"}";
    }
}
