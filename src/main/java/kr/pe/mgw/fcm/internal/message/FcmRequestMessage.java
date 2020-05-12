package kr.pe.mgw.fcm.internal.message;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
 * <pre>
 * Firebase Cloud Message를 보내기 위한 전송 데이터
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
public class FcmRequestMessage {

	// 대상
	@SerializedName("to")
	private String to;

	@SerializedName("registration_ids")
	private List<String> registrationIds;

	@SerializedName("condition")
	private String condition;

	@SerializedName("notification_key")
	private String notificationKey;

	// 옵션
	@SerializedName("collapse_key")
	private String collapseKey;

	@SerializedName("priority")
	private String priority;

	@SerializedName("content_available")
	private String contentAvailable;

	@SerializedName("mutable_content")
	private String mutableContent;

	@SerializedName("delay_while_idle")
	private String delayWhileIdle;

	@SerializedName("time_to_live")
	private String timeToLive;

	@SerializedName("restricted_package_name")
	private String restrictedPackageName;

	@SerializedName("dry_run")
	private String dryRun;

	// 페이로드
	@SerializedName("data")
	private Map<String, Object> data;

	@SerializedName("notification")
	private FcmPayload notification;


	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public List<String> getRegistrationIds() {
		return registrationIds;
	}

	public void setRegistrationIds(List<String> registrationIds) {
		this.registrationIds = registrationIds;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getNotificationKey() {
		return notificationKey;
	}

	public void setNotificationKey(String notificationKey) {
		this.notificationKey = notificationKey;
	}

	public String getCollapseKey() {
		return collapseKey;
	}

	public void setCollapseKey(String collapseKey) {
		this.collapseKey = collapseKey;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getContentAvailable() {
		return contentAvailable;
	}

	public void setContentAvailable(String contentAvailable) {
		this.contentAvailable = contentAvailable;
	}

	public String getMutableContent() {
		return mutableContent;
	}

	public void setMutableContent(String mutableContent) {
		this.mutableContent = mutableContent;
	}

	public String getDelayWhileIdle() {
		return delayWhileIdle;
	}

	public void setDelayWhileIdle(String delayWhileIdle) {
		this.delayWhileIdle = delayWhileIdle;
	}

	public String getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(String timeToLive) {
		this.timeToLive = timeToLive;
	}

	public String getRestrictedPackageName() {
		return restrictedPackageName;
	}

	public void setRestrictedPackageName(String restrictedPackageName) {
		this.restrictedPackageName = restrictedPackageName;
	}

	public String getDryRun() {
		return dryRun;
	}

	public void setDryRun(String dryRun) {
		this.dryRun = dryRun;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public FcmPayload getNotification() {
		return notification;
	}

	public void setNotification(FcmPayload notification) {
		this.notification = notification;
	}

}
