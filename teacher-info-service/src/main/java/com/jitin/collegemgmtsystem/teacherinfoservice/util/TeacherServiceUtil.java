package com.jitin.collegemgmtsystem.teacherinfoservice.util;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class TeacherServiceUtil {
private TeacherServiceUtil() {
		
	}
	public static <T> HttpEntity<T> getHttpEntity(T inputParams, MediaType mediaType) {		
		HttpHeaders headers = new HttpHeaders();
		/*String credentials = userId + ":" + password;
		byte[] bytesOfCredentials = credentials.getBytes();
		byte[] encodedBytesOfCredentials = Base64.encodeBase64(bytesOfCredentials);
		String encodedCredentials = new String(encodedBytesOfCredentials);
		headers.add("Authorization", "Authorization Type" + " " + encodedCredentials);
		headers.set("ABC_USER", "Username");
		headers.set("AUTH_TOKEN", "Token Value");*/
		headers.setAccept(Arrays.asList(mediaType));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(inputParams, headers);
	}
}
