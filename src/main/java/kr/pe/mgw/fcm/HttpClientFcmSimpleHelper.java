package kr.pe.mgw.fcm;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import com.google.gson.Gson;

import kr.pe.mgw.fcm.internal.message.FcmRequestMessage;
import kr.pe.mgw.fcm.internal.message.FcmResponseMessage;

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
public class HttpClientFcmSimpleHelper extends FcmSimpleHelper {

	private CloseableHttpClient client;

	public HttpClientFcmSimpleHelper(String serverKey) {
		super(serverKey);
	}

	@Override
	public FcmResponseMessage send(FcmRequestMessage message) throws IOException {

		if(client == null) {
			client = HttpClients.createDefault();
		}

		RequestConfig config = RequestConfig.custom().setConnectTimeout(4000).setSocketTimeout(4000).build();

		Gson gson = new Gson();
		String json = gson.toJson(message);

	    HttpEntity entity = new StringEntity(json, CHARSET);

	    HttpPost post = new HttpPost(FCM_SEND_URL);

	    post.setConfig(config);
	    post.addHeader(new BasicHeader(REQUEST_HEADER_KEY_CONTENT_TYPE, CONTENT_TYPE));
	    post.addHeader(new BasicHeader(REQUEST_HEADER_KEY_AUTHORIZATION, "key=" + serverKey));
	    post.setEntity(entity);

	    ResponseHandler<String> responseHandler = new BasicResponseHandler();
	    String resBody = client.execute(post, responseHandler);

	    FcmResponseMessage resultMessage = gson.fromJson(resBody, FcmResponseMessage.class);

		return resultMessage;
	}
}
