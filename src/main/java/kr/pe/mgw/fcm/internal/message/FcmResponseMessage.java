package kr.pe.mgw.fcm.internal.message;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * <pre>
 *   Firebase Cloud Message 응답  데이터
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
public class FcmResponseMessage {

	@SerializedName("multicast_id")
	private String multicastId;

	@SerializedName("success")
	private int success;

	@SerializedName("failure")
	private int failure;

	@SerializedName("canonical_ids")
	private String canonicalIds;

	@SerializedName("results")
	private List<FcmResponseObjectStatus> results;


	public String getMulticastId() {
		return multicastId;
	}

	public void setMulticastId(String multicastId) {
		this.multicastId = multicastId;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFailure() {
		return failure;
	}

	public void setFailure(int failure) {
		this.failure = failure;
	}

	public String getCanonicalIds() {
		return canonicalIds;
	}

	public void setCanonicalIds(String canonicalIds) {
		this.canonicalIds = canonicalIds;
	}

	public List<FcmResponseObjectStatus> getResults() {
		return results;
	}

	public void setResults(List<FcmResponseObjectStatus> results) {
		this.results = results;
	}


}
