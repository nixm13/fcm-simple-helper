package kr.pe.mgw.fcm;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.pe.mgw.fcm.internal.message.FcmRequestMessage;
import kr.pe.mgw.fcm.internal.message.FcmResponseMessage;

public class FcmSimpleHelperTest {

	String serverKey;

	FcmRequestMessage reqMsg;

	@Before
	public void setUp() throws Exception {
		serverKey = "AAAApwW7JXY:APA91bEebfh1GKIjdWQhd_TLB4vsO9gluvc-A2pNPvMq8SGsP_Wy1Xc-OD67O-j4RYtbUCRoqhPi7oxZb6zTg77n4oShGEyab7AS7nX5YPgn3a-GjVE9OeijW5xn6Utk_jhk0c0bO9KJ";
		reqMsg = new FcmRequestMessage();
		reqMsg.setTo("aaa");
	}

	@After
	public void tearDown() throws Exception {
	}


	private void checkSendTest(FcmSimpleHelper helper) throws IOException {
		FcmResponseMessage resultMessage1 = helper.send(reqMsg);
		FcmResponseMessage resultMessage2 = helper.send(reqMsg);
		FcmResponseMessage resultMessage3 = helper.send(reqMsg);
		FcmResponseMessage resultMessage4 = helper.send(reqMsg);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json1 = gson.toJson(resultMessage1);
        String json2 = gson.toJson(resultMessage2);
        String json3 = gson.toJson(resultMessage3);
        String json4 = gson.toJson(resultMessage4);

		System.out.println("json1:::\n" + json1);
		System.out.println("json2:::\n" + json2);
		System.out.println("json3:::\n" + json3);
		System.out.println("json4:::\n" + json4);

		assertNotNull(json1);
		assertNotNull(json2);
		assertNotNull(json3);
		assertNotNull(json4);
	}

	@Test
//	@Ignore
	public void sendTest() throws IOException {
		checkSendTest(new OkHttpFcmSimpleHelper(serverKey));
		checkSendTest(new DefaultFcmSimpleHelper(serverKey));
		checkSendTest(new HttpClientFcmSimpleHelper(serverKey));
	}

}
