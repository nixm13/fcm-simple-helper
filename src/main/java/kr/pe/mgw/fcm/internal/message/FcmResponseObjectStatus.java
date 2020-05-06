package kr.pe.mgw.fcm.internal.message;

import com.google.gson.annotations.SerializedName;

/**
 * <pre>
 *   Firebase Cloud Message 응답 개체 상태 데이터
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
public class FcmResponseObjectStatus {

	@SerializedName("message_id")
	private String messageId;

	@SerializedName("registration_id")
	private String registrationId;

	@SerializedName("error")
	private String error;


	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


}
