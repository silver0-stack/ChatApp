# ChatApp

모바일프로그래밍(2021-2학기) 기말고사 대체 과제로 개발한 Java 기반 안드로이드 채팅 앱(프로토타입)입니다.  
이 레포 README는 유튜브 쇼츠(전체 시연)와 README 내의 짧은 움직이는 미리보기(GIF/WebP)를 조합해 방문자가 클릭 없이도 동작 느낌을 볼 수 있게 구성했습니다.

## 📽 시연 영상 (README 내 직접 재생)

<video src="./demo.mp4" controls width="340">
  브라우저가 video 태그를 지원하지 않습니다.
</video>


위 영상은 전체 시연을 담은 mp4이며, 클릭 없이 바로 재생 가능합니다.

유튜브(전체 시연): https://youtube.com/shorts/D46P0icO_LI?feature=share

---

## 한 줄 요약
모바일프로그래밍 기말 과제: Java 기반 로컬 키워드 챗봇형 채팅 앱 (네트워크 미구현, 로컬 키워드 응답)

## 개요
- 역할: 개인(학기 과제)  
- 기간: 2021년 2학기  
- 기술스택: Java, Android SDK, AndroidX, RecyclerView, ConstraintLayout, Material Components, CircleImageView  
- 패키지: `com.example.chatapp`  
- 앱 표시명: `ChatApp`

## 주요 기능
- RecyclerView + Adapter 기반 채팅 UI(좌/우 메시지 구분)  
- 입력 검증 및 기본 예외 처리  
- 키워드 기반 로컬 챗봇 응답(서버 연동 없음)  
  - 예: "안녕" → "안녕하세요😀 당신의 친구, 예안입니다."  
  - "이름", "몇살", "어디" 등 하드코딩 응답


## 사용 방법 (빌드 및 실행)
1. Android Studio로 프로젝트 열기 또는 루트에서 Gradle Wrapper 사용  
   - macOS / Linux:
     ```bash
     ./gradlew assembleDebug
     ```
   - Windows:
     ```bash
     gradlew.bat assembleDebug
     ```
2. 빌드 후 APK: `app/build/outputs/apk/debug/app-debug.apk`  
3. 에뮬레이터 또는 실제 기기에 설치하여 채팅 화면 확인

## 주요 파일/구조
- `app/src/main/java/com/example/chatapp/MainActivity.java` — 채팅 UI, 메시지 입력 및 키워드 응답 로직  
- `app/src/main/java/com/example/chatapp/Adapter.java` — RecyclerView 어댑터, 좌/우 뷰홀더  
- `app/src/main/java/com/example/chatapp/DataItem.java` — 메시지 모델  
- `app/src/main/res/values/strings.xml` — 앱 이름: `ChatApp`  
- `app/src/main/AndroidManifest.xml` — (참고: INTERNET 권한 미선언)

## 한계 및 확장 제안
- 현재는 로컬 키워드 기반 프로토타입입니다(서버 연동·실시간 동기화 미구현).  
- 확장 아이디어: Firebase Realtime DB/Firestore 연동, WebSocket(Socket.IO) 기반 서버와 연동, 챗봇 응답을 외부 AI 서비스로 연결.
