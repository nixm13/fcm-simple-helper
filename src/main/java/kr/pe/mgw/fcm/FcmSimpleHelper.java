package kr.pe.mgw.fcm;

import java.io.IOException;

import kr.pe.mgw.fcm.internal.message.FcmRequestMessage;
import kr.pe.mgw.fcm.internal.message.FcmResponseMessage;

@SuppressWarnings("unused")
public abstract class FcmSimpleHelper {

	protected final String FCM_SEND_URL = "https://fcm.googleapis.com/fcm/send";

	protected final String REQUEST_HEADER_KEY_CONTENT_TYPE = "Content-Type";

	protected final String REQUEST_HEADER_KEY_AUTHORIZATION = "Authorization";

	protected final String CONTENT_TYPE = "application/json";

	protected final String serverKey;

	private FcmRequestMessage message;

	public FcmSimpleHelper(String serverKey) {
		this.serverKey = serverKey;
	}

	public FcmRequestMessage getMessage() {
		return message;
	}

	public void setMessage(FcmRequestMessage message) {
		this.message = message;
	}

	protected FcmResponseMessage send() throws IOException {
		if(message != null) {
			return this.send(message);
		} else {
			throw new NullPointerException("FcmRequestMessage is Null");
		}
	}

	protected abstract FcmResponseMessage send(FcmRequestMessage message) throws IOException;

}
