package kr.pe.mgw.fcm;

import java.io.IOException;

import com.google.gson.Gson;

import kr.pe.mgw.fcm.internal.message.FcmRequestMessage;
import kr.pe.mgw.fcm.internal.message.FcmResponseMessage;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * <pre>
 *   Firebase Cloud Message를 보내기 위한 HTTP 통신 모듈
 *   <a href="https://firebase.google.com/docs/cloud-messaging/http-server-ref?hl=ko" target="_blank">FCM HTTP API 참조하기</a>
 * </pre>
 * <pre>
 * <b>History:</b>
 * 		Moon Gwi Woo, 1.0, 2019-09-07 초기작성
 * </pre>
 * @author Moon Gwi Woo
 * @version 1.0
 * @since 1.0
 */
public class FcmHelper {

	/**
	 * FCM Send url
	 */
	private final String FCM_SEND_URL = "https://fcm.googleapis.com/fcm/send";

	private final String REQUEST_HEADER_KEY_CONTENT_TYPE = "Content-Type";

	private final String REQUEST_HEADER_KEY_AUTHORIZATION = "Authorization";

	private final String CONTENT_TYPE = "application/json";



	/**
	 * Firebase Console Server Key
	 */
	private final String serverKey;


	/**
	 * FCM Send Message
	 */
	private FcmRequestMessage fcmMessage;


	public FcmHelper(String serverKey) {
		this(serverKey, null);
	}

	public FcmHelper(String serverKey, FcmRequestMessage fcmMessage) {
		this.serverKey = serverKey;
		this.fcmMessage = fcmMessage;
	}

	/**
	 * <pre>
	 * FCM 메세지 전송
	 * </pre>
	 * @return 전송 응답
	 * @throws Exception response bind json data and null message object
	 */
	public FcmResponseMessage send() throws Exception {
		if(fcmMessage != null) {
			return this.send(fcmMessage);
		} else {
			throw new NullPointerException("FcmRequestMessage is Null");
		}
	}

	/**
	 * <pre>
	 * FCM 메세지 전송
	 * </pre>
	 * @return 전송 응답
	 * @param requestMessage FcmRequestMessage 전송 메세지
	 * @throws IOException response bind json data
	 * @see FcmRequestMessage request message
	 */
	public FcmResponseMessage send(FcmRequestMessage requestMessage) throws IOException {
		MediaType mediaType = MediaType.parse(CONTENT_TYPE);

		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

		Gson gson = new Gson();

		String json = gson.toJson(requestMessage);

		RequestBody body = RequestBody.create(mediaType, json);

		Request request = new Request.Builder()
				.addHeader(REQUEST_HEADER_KEY_CONTENT_TYPE, CONTENT_TYPE)
				.addHeader(REQUEST_HEADER_KEY_AUTHORIZATION, "key=" + serverKey)
				.url(FCM_SEND_URL)
				.post(body)
				.build();

		Response response = client.newCall(request).execute();
		String resBody = response.body().string();

		FcmResponseMessage message = gson.fromJson(resBody, FcmResponseMessage.class);

		return message;
	}

	public FcmRequestMessage getFcmMessage() {
		return fcmMessage;
	}

	public void setFcmMessage(FcmRequestMessage fcmMessage) {
		this.fcmMessage = fcmMessage;
	}

}
