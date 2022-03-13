package java8features.base64Examples;

import java.util.*;

public class Base64EncryptionExample {
	String data;
	public byte[] getEncodedData(String data) {
		System.out.println("Initial Data: " + data);
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encodedData = encoder.encode(data.getBytes());
		return encodedData;
	}
	
	public String getDecodedData(byte[] encodedDataArray) {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decodedByteArray = decoder.decode(encodedDataArray);
		String decodedData = new String(decodedByteArray);
//		decoder.decode
		return decodedData;
	}

	public static void main(String[] args) {
		Base64EncryptionExample obj = new Base64EncryptionExample();
		
		obj.data = "this data will be encoded. Some other data for testing purposes";
		
		byte [] encodedData = obj.getEncodedData(obj.data);
		System.out.println("Encoded data: " + new String(encodedData));
		System.out.println("In Byte Array form: " + Arrays.toString(encodedData));
		String decodedData = obj.getDecodedData(encodedData);
		System.out.println("Decoded data: " + decodedData);

	}

	

}
