package understand_portfolio;

import org.quickconnectfamily.json.*;
import java.io.*;
import java.util.HashMap;
import org.json.simple.JSONObject;

public class json_understand_one {
/**************
 * this class has test and example code for both JSON and QCJSON that I found and that I
 * creates. it will be used in my week one Portfolio example
 * it is not meant to be amazing but demonstrate a basic understanding of QCJSON and JSON.simple
**************/
	

	class do_nothing_obj implements Serializable
	{
/*************************************************************
 *  I created this object internally because I wanted to 
 * 	use it for testing but did not feel justified in making it 
 *  its own class
 *************************************************************/	
		public String name, college;public int age;public boolean is_graduated;
		
		public do_nothing_obj(String name, String coll, int age, boolean grad){
			this.name = name;
			this.college = coll;
			this.age = age;
			this.is_graduated = grad;
				
		}
	
	public do_nothing_obj(HashMap aMapRepresentation){
	// constructor to handle a hashmap
	// the object I am returning appears to need to have a contructor that deals with hashmaps
		this.name = (String)aMapRepresentation.get("name");

		this.college = (String)aMapRepresentation.get("college");
		//numbers are stored as longs or doubles.
		Long asLong = (Long)aMapRepresentation.get("age");
		this.age = asLong.intValue();
		if((Boolean)aMapRepresentation.get("is_graduated")){
			this.is_graduated = true;
		}
		else{
			this.is_graduated = false;
		}
	}
	
	
/**************************
 *  create a string that I 
 *  will use to compare strings 
 *  later
 **************************/
		public void to_String(){
			System.out.print(this.name + " attended " + college + " when they were " + age + " old\n");
		 	if(!is_graduated){
		 		System.out.println("And they are STILL in attendance");
			 }
		}
	}

	public void my_JSON_simple_example_1(){
/***************************************	
* this is an example of me using 
* JSON.simple to create a very simple object 
* there is no importing or converting as of 
* yet, I just wanted to be able to create 
* one correctly
* plus JSon.simple is not part of the scope 
* of this class, this is for my understanding 
* specifically.
*****************************************/
/* DECLARE LOCAL VARIABLES     */	
		String[] obj_name_KV = {"Obj_Name","James T Fallon"};	

	// instantiate the new object
		JSONObject test_obj=new JSONObject();
		
	// I am adding all the attributes I want in my object as a Key=value pair
	// passing strings in as an array, there is no need for this. they could be literal
	// but I could put this in a loop but then I would have to use a list or collection and
	// I have no intention of doing that for this test.
		test_obj.put(obj_name_KV[0],obj_name_KV[1]);
	// passing in an integer
		test_obj.put("obj_id_number",new Integer(100));	
	// passing in a bool
		test_obj.put("is_valid_object",new Boolean(true));
	// strings can be sent as just strings, no need to convert them
	// this seems interesting
		test_obj.put("Nick_Name","Jimmy");
	// display the serialized object
		System.out.print(test_obj);
	}
		
	public void online_example_json_simple(){
/*
 * ************************************************************
 * online_example_json_simple 
 * this is a block of code I found online 
 * that helped me to understand how to create a Json object. 
 * while we are not using Json.simple in this class
 * I still found it helpful to learn 	
 **************************************************************
 */
		//import org.json.simple.JSONObject;
		  JSONObject obj=new JSONObject();
		  obj.put("name","foo");
		  obj.put("num",new Integer(100));
		  obj.put("balance",new Double(1000.21));
		  obj.put("is_vip",new Boolean(true));
		  obj.put("nickname",null);
		  System.out.print(obj);
	}
	
	public void qcJson_Example_Simple_1(String filename) throws IOException{	
/***********************************************************
 * this method will show how to output a json object as 
 * a string to a file stream. my second step will be to use
 * a socket of some kind for the output. this will be done
 * in a later method
 * *********************************************************/

		
	// instantiate the input and output streams for use
		FileOutputStream fout = new FileOutputStream(filename);
		FileInputStream fin = new FileInputStream(filename);
		
	// use the previous output/input stream to create my Json output/input objects
	// these objects take a serializable object and convert it to bits, or something
	// and then send them to the destination OR convert bits into a hashmap to use to
	// create an object 
	// its weird but I follow the examples :)
		JSONOutputStream jsonOut = new JSONOutputStream(fout);	
		JSONInputStream jsonIn = new JSONInputStream(fin);
		
	// instantiate the string I am going to output
		do_nothing_obj do_none = new do_nothing_obj("Nick Krupa","BYU-I",28,false);
		do_none.to_String();
		
		
	//	attempt to output the object as a serialized string to the 
	//	stream I created previously, using the JSONoutput 
		try {
			jsonOut.writeObject(do_none);
			System.out.println("attempt to send object out was a success!!");		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	// now I will attempt to read that same object into a new
	// object of the same type!!!
		
		try {
			System.out.println("");
			System.out.println("now I am reading from the file and creating a new object with the exact same information");		
			System.out.println("");		
			
			HashMap String_from_file = (HashMap) jsonIn.readObject();
			
			do_nothing_obj readObject = new do_nothing_obj(String_from_file);
			readObject.to_String();
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
/*generic main method that I will change the code in to demonstrate different types of 
 * coding stuff
 */
		
		//create a filename to pass into a JSON string
		String dir = "C:\\Users\\matthew\\workspace\\understand_portfolio\\src\\understand_portfolio";
		String filename = dir + "\\testFile.txt";
		
		
		json_understand_one obj = new json_understand_one();
		
		try {
			obj.qcJson_Example_Simple_1(filename);
		} catch (IOException e) {
			System.out.println("the file: " + filename + " Does not exist in this location");
			e.printStackTrace();
		}
		
		
		
	}

}












