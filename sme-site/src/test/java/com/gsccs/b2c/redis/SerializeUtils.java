package com.gsccs.b2c.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtils {

	public static byte[] serialize(Object object) {
		ObjectOutputStream os = null;
		ByteArrayOutputStream bs = null;
		try {
			bs = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bs);
			os.writeObject(object);
			byte[] bytes = bs.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Object unserialize(byte[] bytes) {
		try {

			ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
			ObjectInputStream os = new ObjectInputStream(bs);

			return os.readObject();
		} catch (Exception e) {

		}
		return null;
	}

}
