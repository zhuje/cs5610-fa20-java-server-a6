package com.example.cs5610f20serverjavajannunzi.models;

import javax.persistence.*;

@Entity // Marks this as a JAVA entity we want to convert into a SQL entity
@Table(name="widgets") // Creates a table called 'widgets' in SQL
public class Widget {

    // Annotate the attribute 'id' to get SQL to recognize it as a primary key
    // and to generate a random unique identifier value for the attribute 'id'.
    // @Id -- this will become our primary key (identifier for an instance object)
    // @GenerateValue() -- tells SQL to automatically generate a primary key value for us
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String type;
    private String topicId;
    private Integer widgetOrder;
    private String text;
    private String src;
    private String url;
    private String href;
    private Integer size;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;




    public Widget(Integer id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Widget(Integer id, String name, String type, String topicId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.topicId = topicId;
    }

    public Widget() {
    }


    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }






    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }













}


