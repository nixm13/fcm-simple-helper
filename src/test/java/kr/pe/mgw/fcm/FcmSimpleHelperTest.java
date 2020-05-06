package kr.pe.mgw.fcm;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import kr.pe.mgw.fcm.internal.message.FcmRequestMessage;
import kr.pe.mgw.fcm.internal.message.FcmResponseMessage;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class FcmSimpleHelperTest {

	String serverKey;

	@Before
	public void setUp() throws Exception {
		serverKey = "AAAApwW7JXY:APA91bEebfh1GKIjdWQhd_TLB4vsO9gluvc-A2pNPvMq8SGsP_Wy1Xc-OD67O-j4RYtbUCRoqhPi7oxZb6zTg77n4oShGEyab7AS7nX5YPgn3a-GjVE9OeijW5xn6Utk_jhk0c0bO9KJ";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void overrideSendTest() throws IOException {

		FcmSimpleHelper helper = new FcmSimpleHelper(serverKey) {

			@Override
			protected FcmResponseMessage send(FcmRequestMessage message) throws IOException {
				MediaType mediaType = MediaType.parse(CONTENT_TYPE);

				HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
				interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
				OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

				Gson gson = new Gson();

				String json = gson.toJson(message);

				RequestBody body = RequestBody.create(mediaType, json);

				Request request = new Request.Builder()
						.addHeader(REQUEST_HEADER_KEY_CONTENT_TYPE, CONTENT_TYPE)
						.addHeader(REQUEST_HEADER_KEY_AUTHORIZATION, "key=" + serverKey)
						.url(FCM_SEND_URL)
						.post(body)
						.build();

				Response response = client.newCall(request).execute();
				String resBody = response.body().string();

				return gson.fromJson(resBody, FcmResponseMessage.class);
			}
		};

		FcmRequestMessage reqMsg = new FcmRequestMessage();
		helper.send(reqMsg);
	}

}
