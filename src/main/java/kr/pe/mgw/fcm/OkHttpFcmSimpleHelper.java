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
 * okhttp 통신 모듈을 사용
 * </pre>
 * <pre>
 * <b>History:</b>
 * Moon Gwi Woo, 1.0, 2020-05-11 초기작성
 * </pre>
 * @author Moon Gwi Woo
 * @version 1.0
 * @since 1.0
 */
public class OkHttpFcmSimpleHelper extends FcmSimpleHelper {

	private OkHttpClient client;

	public OkHttpFcmSimpleHelper(String serverKey) {
		super(serverKey);
	}

	@Override
	public FcmResponseMessage send(FcmRequestMessage message) throws IOException {

		if(client == null) {
			HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
			interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
			client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
		}

		Gson gson = new Gson();

		String json = gson.toJson(message);
		byte[] bytes = json.getBytes(CHARSET);

		MediaType mediaType = MediaType.parse(CONTENT_TYPE);
		RequestBody body = RequestBody.create(mediaType, bytes);
		Request request = new Request.Builder()
				.addHeader(REQUEST_HEADER_KEY_CONTENT_TYPE, CONTENT_TYPE)
				.addHeader(REQUEST_HEADER_KEY_AUTHORIZATION, "key=" + serverKey)
				.url(FCM_SEND_URL)
				.post(body)
				.build();

		Response response = client.newCall(request).execute();
		String resBody = response.body().string();
		FcmResponseMessage resultMessage = gson.fromJson(resBody, FcmResponseMessage.class);

		return resultMessage;
	}
}
