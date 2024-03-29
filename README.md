# Pharmacy-Recommendation-project

[카카오 주소 검색 API](https://developers.kakao.com/docs/latest/ko/local/dev-guide)와 [공공 데이터(약국 현황 정보)](https://www.data.go.kr/data/15065023/fileData.do)를 활용하여
약국 추천 서비스를 구현한다.

[카카오 키워드 장소 검색 API](https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-category)를 이용하면 약국 외 다른 도메인으로 적용 가능하다.

## 요구사항 분석

- 약국 찾기 서비스 요구사항
  - 약국 현황 데이터를 관리하고 있다고 가정하고, 약국 현황 데이터는 `위도`, `경도`로 위치 정보 데이터를 가지고 있다.
  - 해당 서비스로 주소 정보를 입력하여 요청하면 위치 기준에서 가까운 약국 3곳을 추출 한다.
  - 주소는 도로명 주소 또는 지번을 입력하여 요청 받는다.
    - 정확한 주소를 입력 받기 위해 [Kakao 우편번호 서비스](https://postcode.map.daum.net/guide)를 사용한다.
  - 주소는 정확한 상세 주소(동, 호수)를 제외한 주소를 이용하여 추천한다.
    - ex) 서울 성북구 종암로 10길
  - 입력 받은 주소를 `위도`, `경도`로 변환 하여 기존 약국 데이터와 비교 및 가까운 약국을 찾는다.
    - 지구는 평면이 아니기 때문에 구면에서 두 점 사이의 최단 거리를 구하는 공식이 필요하다.
    - `위도` `경도` 좌표 사이의 거리를 [haversine formula](https://en.wikipedia.org/wiki/Haversine_formula)로 계산
    - 지구는 완전한 구형이 아니므로 오차가 존재한다. 
  - 입력한 주소 정보에서 `반경(10km)` 내에 있는 약국만 추천한다.
  - 추출한 약국 데이터는 길안내 URL 및 로드뷰 URL로 제공한다.
    - ex)
    
    길안내 URL: <https://map.kakao.com/?urlX=523954.0&urlY=1084098.0&name=%EC%9A%B0%EB%A6%AC%ED%9A%8C%EC%82%AC>
    
    로드뷰 URL: <https://map.kakao.com/link/roadview/37.402056,127.108212>
    
  - 길안내 URL은 고객에게 제공 되기 때문에 가독성을 위해 shorten url로 제공 한다.
  - shorten url에 사용 되는 key값은 인코딩하여 제공 한다.
    - ex) <http://localhost:8080/dir/nqxtX>
    - base62를 통한 인코딩
  - shorten url의 유효 기간은 30일로 제한 한다.
  
## 약국 추천 Use Case

![img.png](img/usecase.png)
## Direction Shorten Url Process
![img.png](img/shortenUrl.png)

## 기능

 - Spring Data JPA를 이용한 CRUD 메서드 구현하기
 - Spock를 이용한 테스트 코드 작성하기
 - Testcontainers를 이용하여 독립 테스트 환경 구축하기
 - 카카오 주소검색 API 연동하여 주소를 위도, 경도로 변환하기
 - 추천 결과를 카카오 지도 URL로 연동하여 제공하기
 - 공공 데이터를 활용하여 개발하기 (약국 현황 데이터)
 - Handlebars를 이용한 간단한 View 만들기
 - 도커를 사용하여 다중 컨테이너 애플리케이션 만들기
 - 애플리케이션을 클라우드 서비스에 배포하기
 - Spring retry를 이용한 재처리 구현하기 (카카오 API의 네트워크 오류 등에 대한 재처리)
 - base62를 이용한 shorten url 개발하기 (길안내 URL)
 - redis를 이용하여 성능 최적화하기




