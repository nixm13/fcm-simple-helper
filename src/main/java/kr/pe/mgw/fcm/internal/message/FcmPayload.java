package kr.pe.mgw.fcm.internal.message;

import com.google.gson.annotations.SerializedName;

/**
 * <pre>
 * Firebase Cloud Message IOS Payload
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
public class FcmPayload {

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("android_channel_id")
	private String androidChannelId;

	@SerializedName("icon")
	private String icon;

	@SerializedName("sound")
	private String sound;

	@SerializedName("tag")
	private String tag;

	@SerializedName("badge")
	private String badge;

	@SerializedName("color")
	private String color;

	@SerializedName("click_action")
	private String clickAction;

	@SerializedName("subtitle")
	private String subtitle;

	@SerializedName("body_loc_key")
	private String bodyLocKey;

	@SerializedName("body_loc_args")
	private String bodyLocArgs;

	@SerializedName("title_loc_key")
	private String titleLocKey;

	@SerializedName("title_loc_args")
	private String titleLocArgs;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAndroidChannelId() {
		return androidChannelId;
	}

	public void setAndroidChannelId(String androidChannelId) {
		this.androidChannelId = androidChannelId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getClickAction() {
		return clickAction;
	}

	public void setClickAction(String clickAction) {
		this.clickAction = clickAction;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getBodyLocKey() {
		return bodyLocKey;
	}

	public void setBodyLocKey(String bodyLocKey) {
		this.bodyLocKey = bodyLocKey;
	}

	public String getBodyLocArgs() {
		return bodyLocArgs;
	}

	public void setBodyLocArgs(String bodyLocArgs) {
		this.bodyLocArgs = bodyLocArgs;
	}

	public String getTitleLocKey() {
		return titleLocKey;
	}

	public void setTitleLocKey(String titleLocKey) {
		this.titleLocKey = titleLocKey;
	}

	public String getTitleLocArgs() {
		return titleLocArgs;
	}

	public void setTitleLocArgs(String titleLocArgs) {
		this.titleLocArgs = titleLocArgs;
	}

}
