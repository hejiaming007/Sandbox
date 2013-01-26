package base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;

public class Base64Helloworld {

	public Base64Helloworld() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ByteArrayOutputStream out = new ByteArrayOutputStream();
 
		byte[] encodedBytes = new byte[]{};
		ClassLoader.getSystemResourceAsStream("base64/Zombatar_1.jpg").read(encodedBytes);
		//File f = new File("C:/Users/Administrator.PC-20110804EUAZ/Desktop/Zombatar_1.jpg");
		
		
//		byte[] encodedBytes = getBytesFromFile(f);
		
		encodedBytes = Base64.encodeBase64(encodedBytes);
		String string = new String(encodedBytes);
		
		System.out.println("File to String via Base64:" + string);
		
		
		byte[] decodedBytes = string.getBytes();
		decodedBytes = Base64.decodeBase64(decodedBytes);
//		System.out.println(new String(outputData));
		
		FileOutputStream fos = new FileOutputStream("C:/Users/Administrator.PC-20110804EUAZ/Desktop/Zombatar_2.jpg");
		fos.write(decodedBytes);
	}
	
	
	public static byte[] getBytesFromFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    // Get the size of the file
	    long length = file.length();

	    // You cannot create an array using a long type.
	    // It needs to be an int type.
	    // Before converting to an int type, check
	    // to ensure that file is not larger than Integer.MAX_VALUE.
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }

	    // Create the byte array to hold the data
	    byte[] bytes = new byte[(int)length];

	    // Read in the bytes
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    // Ensure all the bytes have been read in
	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    // Close the input stream and return bytes
	    is.close();
	    return bytes;
	}

}
