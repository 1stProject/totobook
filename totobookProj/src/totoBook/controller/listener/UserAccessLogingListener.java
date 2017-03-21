package totoBook.controller.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import totoBook.domain.Member;

@WebListener
public class UserAccessLogingListener implements HttpSessionAttributeListener {

	private static final String SESSION_ATTRIBUTE_NAME = "loginUser";

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	if(SESSION_ATTRIBUTE_NAME.equals(se.getName())){
    		Member member = (Member)se.getValue();
    		System.out.println(member.getName() + " is login.");
    	}
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	if(SESSION_ATTRIBUTE_NAME.equals(se.getName())){
    		Member member = (Member)se.getValue();
    		System.out.println(member.getName() + " is logout.");
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 

    }
	
}
