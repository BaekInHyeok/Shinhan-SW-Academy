package com.shinhan.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	public String user_id;
	public String user_pw;
	public static int total_user = 0;
	
    public MySessionListener() {
        System.out.println("MysessionListener 생성");
    }
    
    public MySessionListener(String user_id, String user_pw) {
    	this.user_id=user_id;
    	this.user_pw=user_pw;
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	total_user++;
    	System.out.println("MysessionListener... sessionCreated : "+total_user);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	total_user--;
    	System.out.println("MysessionListener... session destroyed : "+total_user);
    	
    }
	
}
