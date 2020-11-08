package com.example.cs5610f20serverjavajannunzi.services;

import com.example.cs5610f20serverjavajannunzi.models.Widget;
import com.example.cs5610f20serverjavajannunzi.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

// @Service -- marks this as a service (our local JAVA interface that talks
// to the SQL database)
@Service
public class WidgetService {

    // @Autowired allows the server to automatically
    // instantiate 'WidgetRepository widgetRepository'
    // allows this application to automatically log in
    // to SQL schema with the given username and password in
    // the configuration.
    // This object 'widgetRepository' is what allows us to
    // relay commands to the SQL database.
    @Autowired
    WidgetRepository widgetRepository;

    public List<Widget> findWidgetsForTopic(String tid) {
        return widgetRepository.findWidgetsForTopic(tid);
//        List<Widget> ws = new ArrayList<Widget>();
//        for(Widget w: widgets) {
//            if(w.getTopicId().equals(tid)) {
//                ws.add(w);
//            }
//        }
//        return ws;
    }
    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }
    public Widget findWidgetById(Integer widgetId) {
        return widgetRepository.findById(widgetId).get();
//        for(Widget w: widgets) {
//            if(w.getId().equals(widgetId))
//                return w;
//        }
//        return null;
    }
    public Widget createWidget(Widget widget) {
        return widgetRepository.save(widget);
//        widget.setId(123);
//        widgets.add(widget);
//        return widget;
    }
    public void deleteWidget(Integer wid) {
        widgetRepository.deleteById(wid);
    }


    public Widget updateWidget(Integer widgetId, Widget newWidget) {

        Optional widgetO = widgetRepository.findById(widgetId); // get widget from database by (widgetId)
        if(widgetO.isPresent()) { // if the widgetId exists in our database
            Widget widget = (Widget) widgetO.get(); // the the Widget underneath the 'Optional' Wrapper
            widget.setName(newWidget.getName()); // update widget name
            widget.setType(newWidget.getType()); // update widget type
            widget.setSize(newWidget.getSize());
            widget.setText(newWidget.getText());
            widget.setSrc(newWidget.getSrc());
            widget.setValue(newWidget.getValue()); // for list value is type of list (ordered vs. unordered)
            return widgetRepository.save(widget); // return updated widget back to server with .save(widget)
        } else {
            return null;
        }
//        for(Widget w: widgets) {
//            if(w.getId().equals(widgetId)) {
//                w.setName(newWidget.getName());
//                w.setType(newWidget.getType());
//                return 1;
//            }
//        }
//        return 0;
    }


    public List<Widget> updateWidgetOrder(List<Widget> newWidgetOrder,String topicId){

        // delete widgets from the 'newWidgetOrder' by deleting
        // all widgets by given 'topicId'
        List<Widget> deleteWidgets = widgetRepository.findWidgetsForTopic(topicId);
        for (Widget w : deleteWidgets) {
            widgetRepository.delete(w);
        }

        // replace with 'newWidgetOrder'
        for (Widget w : newWidgetOrder) {
            widgetRepository.save(w);
        }

        // return the widgets from the given topic to be
        // re-rendered in client (already contains new order of widgets)
        return findWidgetsForTopic(topicId);
    }









}
