# fcm-simple-helper

FCM 서버 메세지 전송
HTTP 방식

-----

##### 사용법

1. FcmHelper 객체 생성 serverKey 필수.
2. FcmRequestMessage 전송 객체 생성 및 FcmPayload 와 Map 을 활용하여 전송 데이터 구성 : [FCM API](https://firebase.google.com/docs/cloud-messaging/http-server-ref?hl=ko) 참고
3. send(FcmRequestMessage) 푸쉬 전송
4. FcmResponseMessage 응답 객체 와 FcmResponseObjectStatus 상태 객체를 활용하여 전송 후 동작 제어 : [FCM API](https://firebase.google.com/docs/cloud-messaging/http-server-ref?hl=ko) 참고


```

String serverKey = [Firebase Server Key];

String to = [token];

FcmSimpleHelper fcmHelper = new DefaultFcmSimpleHelper(serverKey); // HttpURLConnection 사용
// FcmSimpleHelper fcmHelper = new OkHttpFcmSimpleHelper(serverKey); // Okhttp3 사용 (Squareup)
// FcmSimpleHelper fcmHelper = new HttpClientFcmSimpleHelper(serverKey); // HttpClient 사용 (Apache)

FcmRequestMessage request = new FcmRequestMessage();
FcmPayload notification = new FcmPayload();
HashMap<String, Object> data = new HashMap<>();

notification.setTitle("title");
notification.setBody("body");
notification.setSound("default");

data.put("title", "title");
data.put("body", "body");

request.setTo(to);
request.setNotification(notification);
request.setData(data);

FcmResponseMessage response = fcmHelper.send(request);

Gson gson = new GsonBuilder().setPrettyPrinting().create();

System.out.println(gson.toJson(response));


```

## Maven Dependency
```
<repositories>
    <repository>
        <id>public</id>
        <url>https://mvn.moongwiwoo.pe.kr/repository/maven-public/</url>
        <releases>
            <enabled>true</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>

    ...

<dependency>
    <groupId>kr.pe.mgw.fcm</groupId>
    <artifactId>fcm-simple-helper</artifactId>
    <version>1.0.0</version>
</dependency>

```

## License
> Licensed under the Apache License, Version 2.0 (the "License");
> you may not use this file except in compliance with the License.
> You may obtain a copy of the License at
>
> http://www.apache.org/licenses/LICENSE-2.0
>
> Unless required by applicable law or agreed to in writing, software
> distributed under the License is distributed on an "AS IS" BASIS,
> WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
> See the License for the specific language governing permissions and
> limitations under the License.
