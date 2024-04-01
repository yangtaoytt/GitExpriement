package problem3_1;

import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


class Book // 书籍类，包括了书名、作者、出版社、刊号、出版日期、页数和摘要。
{
    private String name;  //书名
    private String author;  //作者
    private String publics;  //出版社
    private String number;  //期刊号
    private String date;  //出版日期
    private String pages;  //页数
    private String abs;  //摘要

    public void setName(String name) {
        this.name = name;
    } //set方法

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublics(String publics) {
        this.publics = publics;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    //getter方法
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublics() {
        return publics;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getPages() {
        return pages;
    }

    public String getAbs() {
        return abs;
    }
}
