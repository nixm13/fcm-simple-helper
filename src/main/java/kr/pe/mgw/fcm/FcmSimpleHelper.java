package kr.pe.mgw.fcm;

import java.io.IOException;
import java.nio.charset.Charset;

import kr.pe.mgw.fcm.internal.message.FcmRequestMessage;
import kr.pe.mgw.fcm.internal.message.FcmResponseMessage;


/**
 * <pre>
 * Firebase Cloud Message를 보내기 위한 HTTP 통신 모듈
 * <a href="https://firebase.google.com/docs/cloud-messaging/http-server-ref?hl=ko" target="_blank">FCM HTTP API 참조하기</a>
 * </pre>
 * <pre>
 * <b>History:</b>
 * Moon Gwi Woo, 1.0, 2020-05-11 초기작성
 * </pre>
 * @author Moon Gwi Woo
 * @version 1.0
 * @since 1.0
 */
public abstract class FcmSimpleHelper {

	//FCM Send url
	protected final String FCM_SEND_URL = "https://fcm.googleapis.com/fcm/send";

	protected final String REQUEST_HEADER_KEY_CONTENT_TYPE = "Content-Type";

	protected final String REQUEST_HEADER_KEY_AUTHORIZATION = "Authorization";

	protected final String CONTENT_TYPE = "application/json; charset=utf-8";

	protected final Charset CHARSET = Charset.forName("UTF-8");

	// Firebase Console Server Key
	protected final String serverKey;


	public FcmSimpleHelper(String serverKey) {
		this.serverKey = serverKey;
	}

	/**
	 * <pre>
	 * FCM 메세지 전송
	 * </pre>
	 * @return 전송 응답
	 * @param message FcmRequestMessage 전송 메세지
	 * @throws IOException response bind json data
	 * @see FcmRequestMessage request message
	 */
	public abstract FcmResponseMessage send(FcmRequestMessage message) throws IOException;

}
