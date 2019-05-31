package Service;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class CreateXml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{

			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("class");
			Element userElement = root.addElement("user").addAttribute("userName", "user4");
			
			userElement.addElement("name").addText("user4");
			
			userElement.addElement("Email").addText("user4@gmail");
			
			userElement.addElement("passWord").addText("user4");
			
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer;
        
        writer = new XMLWriter(System.out, format);
        writer.write(doc);
        
        XMLWriter filewriter = new XMLWriter(new FileOutputStream("C://new.xml"), format);
        
        
        filewriter.write(doc);
        
		}catch(Exception e){e.printStackTrace();}

	}

}