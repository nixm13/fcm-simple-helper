package kr.pe.mgw.fcm;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
public class DefaultFcmSimpleHelper extends FcmSimpleHelper {

	public DefaultFcmSimpleHelper(String serverKey) {
		super(serverKey);
	}

	@Override
	public FcmResponseMessage send(FcmRequestMessage message) throws IOException {

        HttpURLConnection conn = null;
        DataOutputStream wr = null;
        BufferedReader in  = null;

        try {
        	URL obj = new URL(FCM_SEND_URL);

        	if(conn == null) {
        		conn = (HttpURLConnection) obj.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty(REQUEST_HEADER_KEY_CONTENT_TYPE, CONTENT_TYPE);
	            conn.setRequestProperty(REQUEST_HEADER_KEY_AUTHORIZATION, "key=" + serverKey);
	            conn.setConnectTimeout(10000);
	            conn.setReadTimeout(10000);
	            conn.setDoOutput(true);
        	}

            Gson gson = new Gson();
            String json = gson.toJson(message);

            wr = new DataOutputStream(conn.getOutputStream());
            wr.write(json.getBytes(CHARSET));
            wr.flush();
            wr.close();

//            int responseCode = conn.getResponseCode();

    		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();

			FcmResponseMessage resultMessage = gson.fromJson(response.toString(), FcmResponseMessage.class);

			return resultMessage;

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
        	if(wr != null) { try { wr.close(); } catch (IOException e1) { e1.printStackTrace(); } }
        	if(in != null) { try { in.close(); } catch (IOException e1) { e1.printStackTrace(); } }
        	if(conn != null) { conn.disconnect(); }
		}

	}
}
