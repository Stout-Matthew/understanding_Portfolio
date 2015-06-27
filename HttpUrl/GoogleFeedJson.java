package HttpUrl;


import java.util.*;

import javax.swing.event.HyperlinkEvent;
import javax.swing.text.html.HTML;

import org.w3c.dom.html.HTMLLinkElement;

public class GoogleFeedJson {

	public String feedUrl;
	public List entries;
	public String link;
	public Date publishedDate;
	public String title;
	public String description;
	public String author;
	public String content;

	public GoogleFeedJson(Object obj){
		
		HashMap hash = (HashMap)obj;		
		
		//the url feed
		this.feedUrl = (String)hash.get("feedUrl");
		// the feed title
		this.title = (String)hash.get("title");
		
		// url 
		this.link = (String)hash.get("link");
		
		// feed description
		this.description = (String)hash.get("description");
		
		// 
		this.author = (String)hash.get("author");
		
		//
		this.content = (String) hash.get("content");
		
		this.entries = (ArrayList) hash.get("entries");
		
		
		for(Object e : entries){
			HashMap val = (HashMap)e;
		
			//
			System.out.println(val.get("title"));
		}
		
	}
	
	public String getAuthor(){ return author; }
	
	public String getTitle(){ return title;	}
	
	public String getDescription(){ return description;	}
	
	public Date getpublishedDate(){ return publishedDate; }
	
	public String getContent(){ return content; }
	
}
